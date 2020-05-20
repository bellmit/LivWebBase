package com.liv.api.base.codegenerate;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Table: messages
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Messages implements Serializable {
    /**
     * 主键
     *
     * Nullable:  false
     */
    private Long id;

    /**
     * 名称
     *
     * Nullable:  true
     */
    private String title;

    /**
     * 内容
     *
     * Nullable:  true
     */
    private String content;

    /**
     * 通知用户
     *
     * Nullable:  true
     */
    private String userIds;

    /**
     * 链接
     *
     * Nullable:  true
     */
    private String url;

    /**
     * 消息来源描述
     *
     * Nullable:  true
     */
    private String msgFrom;

    /**
     * 有效期(天)  默认为  0 永不过期
     *
     * Nullable:  true
     */
    private Integer validity;

    /**
     * 消息日期
     *
     * Nullable:  true
     */
    private Date createdate;

    /**
     * 是否过期 1是 0否   默认为 0 否
     *
     * Nullable:  true
     */
    private Integer msgExpire;

    /**
     * 已读用户
     *
     * Nullable:  true
     */
    private Long readUserIds;

    /**
     * 图标
     *
     * Nullable:  true
     */
    private String icons;

    private static final long serialVersionUID = 1L;
}