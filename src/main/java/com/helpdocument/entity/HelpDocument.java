package com.helpdocument.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Auther: liyuanchi
 * Mail: liyuanchi@meituan.com
 * DateTime: 2018/1/16 17:23
 * Project: cip-growth-onestop
 * Description: 帮助文档
 */
public class HelpDocument implements Serializable {
    /**
     * 文档ID
     */
    private int id;

    /**
     * 文档标题
     */
    private String title;

    /**
     * 文档链接
     */
    private String url;

    /**
     * 文档作者
     */
    private String author;

    /**
     * 文档类型：1-贡献值
     */
    private int type;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 添加时间
     */
    private Date addTime;

    /**
     * 文档状态：0-失效、1-正常
     */
    private int status;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        return "HelpDocument{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", author='" + author + '\'' +
                ", status=" + status +
                ", updateTime=" + updateTime +
                ", addTime=" + addTime +
                '}';
    }
}
