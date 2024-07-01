package com.swpu.tjx.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 用户账号表
 * @TableName user
 */
@TableName(value ="user")
public class User implements Serializable {
    /**
     * 用户id
     */
    @TableId
    private Long userId;

    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 
     */
    private String userPassword;

    /**
     * 用户头像连接
     */
    private String userImage;

    /**
     * 用于判断登录账号身份 0：评委 1：教师 2：管理
     */
    private Integer status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 用户账号
     */
    public String getUserAccount() {
        return userAccount;
    }

    /**
     * 用户账号
     */
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    /**
     * 
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * 用户头像连接
     */
    public String getUserImage() {
        return userImage;
    }

    /**
     * 用户头像连接
     */
    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    /**
     * 用于判断登录账号身份 0：评委 1：教师 2：管理
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 用于判断登录账号身份 0：评委 1：教师 2：管理
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserAccount() == null ? other.getUserAccount() == null : this.getUserAccount().equals(other.getUserAccount()))
            && (this.getUserPassword() == null ? other.getUserPassword() == null : this.getUserPassword().equals(other.getUserPassword()))
            && (this.getUserImage() == null ? other.getUserImage() == null : this.getUserImage().equals(other.getUserImage()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserAccount() == null) ? 0 : getUserAccount().hashCode());
        result = prime * result + ((getUserPassword() == null) ? 0 : getUserPassword().hashCode());
        result = prime * result + ((getUserImage() == null) ? 0 : getUserImage().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userAccount=").append(userAccount);
        sb.append(", userPassword=").append(userPassword);
        sb.append(", userImage=").append(userImage);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}