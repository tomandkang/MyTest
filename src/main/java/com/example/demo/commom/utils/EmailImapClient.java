package com.example.demo.commom.utils;

import com.example.demo.commom.model.BaseEmail;
import com.example.demo.commom.model.EmailResponse;
import com.example.demo.commom.model.UploadResponse;
import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.IMAPStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.mail.search.AndTerm;
import javax.mail.search.ComparisonTerm;
import javax.mail.search.SearchTerm;
import javax.mail.search.SentDateTerm;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * @author young
 * @version 1.0
 * @date 2022/8/14 09:32
 * @description 收取邮件信息通过 imap 协议进行处理
 */
@Slf4j
public class EmailImapClient extends BaseEmail {
    private static final long serialVersionUID = 2976821746081145906L;

    String FILE_DIRECTORY = "/opt/tmp/";

    public EmailImapClient(String username, String password, Date startTime, Date endTime) {
        super(username, password, startTime, endTime);
    }

    protected IMAPFolder folder = null;
    protected IMAPStore store = null;

    public EmailImapClient init() throws Exception {
        String host = EmailHelper.getImapHost(getUsername());
        // 判断是需要走那个方式
        // sina
        Properties prop = System.getProperties();
        if (EmailHelper.imap4(getUsername())) {
            prop.put("mail.store.protocol", "imap");
            prop.put("mail.imap.host", host);
            prop.put("mail.smtp.auth", "true");
            // 网易 imap 协议规范
            // name，version，vendor，support-utils 等。
            Map<String, String> iam = new HashMap<>(4);
            iam.put("name", "yks-new-crm");
            iam.put("version", "1.0.0");
            iam.put("vendor", "yks-new-crm");
            iam.put("support-email", "xuqimumaoyi@163.com");
            Session session = Session.getInstance(prop);
            // 使用 imap 会话机制，连接服务器
            store = (IMAPStore) session.getStore("imap");
            store.connect(getUsername(), getPassword());
            store.id(iam);
            // 收件箱
            folder = (IMAPFolder) store.getFolder("INBOX");
            folder.open(Folder.READ_WRITE);
        } else {
            // prop.setProperty("mail.debug", "true");
            prop.setProperty("mail.store.protocol", "imaps");
            prop.setProperty("mail.smtp.host", host);
            // 1、创建session
            Session session = Session.getInstance(prop);
            // 2、通过session得到Store对象
            store = (IMAPStore) session.getStore();
            // 3、连上邮件服务器
            store.connect(host, getUsername(), getPassword());
            // 4、获得邮箱内的邮件夹
            folder = (IMAPFolder) store.getFolder("inbox");
            // 读写
            folder.open(Folder.READ_WRITE);
        }
        return this;
    }

    public EmailResponse pull() throws Exception {
        if (!StringUtils.hasText(getUsername())
                && !StringUtils.hasText(getPassword())
                && getStartTime() != null
                && getEndTime() != null) {
            throw new Exception("初始化邮件参数不能为空！");
        }
        if (folder == null) {
            throw new Exception("not init");
        }
        // 获得邮件夹 Folder 内的该时间段内所有邮件 Message 对象
        // 目前测试结果，无法根据时间实时拿到最新的邮件
        // 通过数量的形式则可以 public synchronized Message[] getMessages(int start, int end)
        SearchTerm termGe = new SentDateTerm(ComparisonTerm.GE, getStartTime());
        SearchTerm termLe = new SentDateTerm(ComparisonTerm.LE, getEndTime());
        SearchTerm termGeAndLt = new AndTerm(termGe, termLe);
        // 根据条件过滤
        Message[] messages = folder.search(termGeAndLt);
        // 解析所有邮件
        EmailResponse emailResponse = new EmailResponse();
        emailResponse.setPullTotal(messages.length);
        emailResponse.setMailTotal(folder.getMessageCount());
        // 总空间默认10G
        emailResponse.setTotalCapacity("10000000000");
        // 已使用空间
        emailResponse.setUsageCapacity(String.valueOf(folder.getMessageCount() * 100 * 1024));
        List<EmailResponse.Email> emails = new ArrayList<>();
        for (Message message : messages) {
            MimeMessage msg = (MimeMessage) message;
            EmailResponse.Email email = new EmailResponse.Email();
            email.setSubject(EmailHelper.getSubject(msg));
            email.setFrom(EmailHelper.getFrom(msg));
            email.setReceiveAddress(EmailHelper.getReceiveAddress(msg, null));
            email.setSendDate(EmailHelper.getSentDate(msg));
            email.setSeen(EmailHelper.isSeen(msg));
            email.setPriority(EmailHelper.getPriority(msg));
            email.setReplySign(EmailHelper.isReplySign(msg));
            email.setMessageId(EmailHelper.getMessageId(msg));
            email.setUid(EmailHelper.getUID(getUsername(),
                    EmailHelper.getFrom(msg),
                    EmailHelper.getSentDate(msg) + "",
                    EmailHelper.getMessageId(msg)));
            email.setContainAttachment(EmailHelper.isContainAttachment(msg));
            List<String> fileUrls = EmailHelper.saveAttachment(msg,FILE_DIRECTORY);
            // 如果文件列表不为空，则执行上传操作，获取连接
            if (!CollectionUtils.isEmpty(fileUrls)) {
                List<String> fileLink = new ArrayList<>();
                fileUrls.forEach(s -> {
                    UploadResponse upload = HttpClientUtil.upload(s);
                    fileLink.addAll(upload.getData().stream().map(UploadResponse.DataDTO::getAwsPath).collect(Collectors.toList()));
                });
                email.setFiles(fileLink);
            }
            email.setSize(msg.getSize() * 1024 + "kb");
            StringBuffer content = new StringBuffer(30);
            EmailHelper.getMailTextContent(msg, content);
            email.setContent(String.valueOf(content));
            // 设置当前邮件状态为已读
            msg.setFlag(Flags.Flag.SEEN, true);
            emails.add(email);
        }
        emailResponse.setEmails(emails);
        // 5、关闭
        folder.close(true);
        store.close();
        return emailResponse;
    }
}
