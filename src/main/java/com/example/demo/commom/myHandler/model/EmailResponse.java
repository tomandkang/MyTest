package com.example.demo.commom.myHandler.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author young
 * @version 1.0
 * @date 2022/8/14 09:42
 * @description
 */
@Data
public class EmailResponse implements Serializable {
    private static final long serialVersionUID = -7492478276050419584L;

    /**
     * 返回状态
     * 成功：200
     * 失败：500
     */
    private Integer code;

    /**
     * 返回说明
     */
    private String msg;

    /**
     * 邮件总数
     */
    private Integer mailTotal;

    /**
     * 已使用的容量
     */
    private String usageCapacity;

    /**
     * 邮箱总容量
     */
    private String totalCapacity;

    /**
     * 拉取总数
     */
    private Integer pullTotal;

    /**
     * 邮件列表
     */
    private List<Email> emails;

    @Data
    public static class Email implements Serializable {

        private static final long serialVersionUID = 5675444077449068410L;

        /**
         * 消息 ID
         */
        private String messageId;

        /**
         * uid
         */
        private String uid;

        /**
         * 主题
         */
        private String subject;

        /**
         * 发件人
         */
        private String from;

        /**
         * 收件人
         */
        private List<String> receiveAddress;

        /**
         * 邮件内容
         */
        private String content;

        /**
         * 发送时间
         */
        private Long sendDate;

        /**
         * 是否已读
         */
        private boolean seen;

        /**
         * 邮件优先级
         */
        private String priority;

        /**
         * 是否需要回执
         */
        private boolean replySign;

        /**
         * 邮件大小
         */
        private String size;

        /**
         * 是否包含附件
         */
        private boolean containAttachment;

        /**
         * 邮件附件（下载链接）
         */
        private List<String> files;
    }
}
