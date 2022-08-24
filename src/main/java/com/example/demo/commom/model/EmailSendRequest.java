package com.example.demo.commom.model;

import lombok.Data;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.List;

/**
 * @author young
 * @version 1.0
 * @date 2022/8/16 11:16
 * @description 邮件发送实体类
 */
@Data
public class EmailSendRequest implements Serializable {
    private static final long serialVersionUID = 7936449297455595859L;

    /**
     * 邮箱
     */
    private String username;

    /**
     * 授权码
     */
    private String password;

    /**
     * 收件人
     */
    private List<String> to;

    /**
     * 抄收人
     */
    private List<String> cc;

    /**
     * 邮箱标题
     */
    private String subject;

    /**
     * 邮箱内容
     */
    private String content;

    /**
     * 是否 html
     */
    private boolean html;

    /**
     * 附件列表
     */
    private List<String> files;

    /**
     * 校验
     *
     * @return
     */
    public boolean verify() {
        return !StringUtils.hasText(getUsername())
                || !StringUtils.hasText(getPassword())
                || CollectionUtils.isEmpty(getTo())
                || !StringUtils.hasText(getSubject())
                || !StringUtils.hasText(getContent());
    }
}
