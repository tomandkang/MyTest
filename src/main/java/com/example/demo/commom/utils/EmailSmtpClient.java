package com.example.demo.commom.utils;



import com.example.demo.commom.myHandler.model.BaseEmail;
import lombok.extern.slf4j.Slf4j;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author young
 * @version 1.0
 * @date 2022/8/15 11:08
 * @description 发送邮件通过 smtp 协议进行处理
 */
@Slf4j
public class EmailSmtpClient extends BaseEmail {
    private static final long serialVersionUID = 1999651413439372783L;

    public EmailSmtpClient(String username, String password) {
        super(username, password);
    }

    protected Session session = null;
    protected MimeMessage mimeMessage = null;
    protected MimeMultipart mimeMultipart = new MimeMultipart();


    /**
     * 初始化邮箱发送连接
     *
     * @return
     */
    public EmailSmtpClient init() throws Exception {
        // 创建一个有具体连接信息的Properties对象
        Properties prop = new Properties();
        prop.setProperty("mail.store.protocol", "imaps");
        prop.setProperty("mail.smtp.host", EmailHelper.getSmtpHost(getUsername()));
        // 需要身份验证
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        Map<String, String> iam = new HashMap<>(4);
        iam.put("name", "yks-new-crm");
        iam.put("version", "1.0.0");
        iam.put("vendor", "yks-new-crm");
        iam.put("support-email", "yks-xzfw@youkeshu.com");
        session = Session.getInstance(prop);
        session.setDebug(true);
        mimeMessage = new MimeMessage(session);
        return this;
    }

    /**
     * 设置收件人
     *
     * @param recipients
     */
    public EmailSmtpClient to(String... recipients) throws MessagingException {
        setRecipients(Message.RecipientType.TO, recipients);
        return this;
    }

    /**
     * 抄送人
     *
     * @param recipients
     * @return
     * @throws MessagingException
     */
    public EmailSmtpClient cc(String... recipients) throws MessagingException {
        setRecipients(Message.RecipientType.CC, recipients);
        return this;
    }

    /**
     * 邮件主题
     *
     * @param subject
     */
    public EmailSmtpClient subject(String subject) throws MessagingException {
        mimeMessage.setSubject(subject);
        return this;
    }


    /**
     * 邮件内容
     *
     * @param content 内容
     * @param html    格式 : true : text/html;charset=UTF-8 false: 文本
     * @return
     */
    public EmailSmtpClient content(String content, boolean html) throws MessagingException {
        BodyPart contentBp = new MimeBodyPart();
        if (html) {
            contentBp.setContent(content, "text/html;charset=UTF-8");
        } else {
            contentBp.setText(content);
        }
        mimeMultipart.addBodyPart(contentBp);
        mimeMessage.setContent(mimeMultipart);
        return this;
    }

    /**
     * 文件附件
     *
     * @param files 附件路径 [/opt/tmp/xxxx.jpg]
     * @return
     * @throws UnsupportedEncodingException
     * @throws MessagingException
     */
    public EmailSmtpClient files(List<String> files) throws UnsupportedEncodingException, MessagingException {
        for (String file : files) {
            BodyPart fileBp = new MimeBodyPart();
            FileDataSource fileDataSource = new FileDataSource(file);
            fileBp.setDataHandler(new DataHandler(fileDataSource));
            // 解决附件名称乱码
            fileBp.setFileName(MimeUtility.encodeText(fileDataSource.getName(), "utf-8", null));
            // 添加附件
            mimeMultipart.addBodyPart(fileBp);
        }
        return this;
    }

    /**
     * 设置收件人或抄送人
     *
     * @param type
     * @param recipients
     * @throws MessagingException
     */
    private void setRecipients(Message.RecipientType type, String[] recipients) throws MessagingException {
        InternetAddress[] addresses = new InternetAddress[recipients.length];
        List<InternetAddress> v = new ArrayList<>();
        InternetAddress ma;
        for (String recipient : recipients) {
            ma = new InternetAddress();
            ma.setAddress(recipient);
            v.add(ma);
        }
        v.toArray(addresses);
        mimeMessage.setRecipients(type, addresses);
    }

    /**
     * 发送邮件
     *
     * @throws MessagingException
     */
    public void send() throws MessagingException {
        // 发件人
        InternetAddress internetAddress = new InternetAddress(getUsername());
        mimeMessage.setFrom(internetAddress);
        // 设置邮件内容
        mimeMessage.setContent(mimeMultipart);
        // 保存邮件设置
        mimeMessage.saveChanges();
        //获取Transport对象
        Transport transport = session.getTransport();
        transport.connect(getUsername(), getPassword());
        // 发送邮件
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
    }


}
