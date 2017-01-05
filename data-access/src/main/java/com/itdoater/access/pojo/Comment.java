package com.itdoater.access.pojo;

import java.util.Date;

/**
 * Created by jt_hu on 2017/1/5.
 */
public class Comment {

    private String email;
    private String content;
    private Integer goodStars;
    private Integer badStars;
    private Date createdAt;
    private Integer postId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getGoodStars() {
        return goodStars;
    }

    public void setGoodStars(Integer goodStars) {
        this.goodStars = goodStars;
    }

    public Integer getBadStars() {
        return badStars;
    }

    public void setBadStars(Integer badStars) {
        this.badStars = badStars;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }
}
