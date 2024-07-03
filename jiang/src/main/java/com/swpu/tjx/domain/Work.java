package com.swpu.tjx.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * 参赛作品信息表
 * @TableName work
 */
@TableName(value ="work")
public class Work implements Serializable {
    /**
     * 作品id号
     */
    @TableId
    private Long workId;

    /**
     * 作品名称
     */
    private String workName;

    /**
     * 参赛组别
     */
    private String workGroup;

    /**
     * 参赛学校
     */
    private String workSchool;

    /**
     * 参赛团队
     */
    private String workTeam;

    /**
     * 参赛资格
     */
    private String workEligibility;

    /**
     * 参赛报名表存储地址
     */
    private String workEntry;

    /**
     * 参赛表信息公示文件地址
     */
    private String workPublicity;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 上传时间
     */
    private LocalDate creatTime;
    /**
     * 拥有者
     */
    private Long userId;
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 作品id号
     */
    public Long getWorkId() {
        return workId;
    }

    /**
     * 作品id号
     */
    public void setWorkId(Long workId) {
        this.workId = workId;
    }

    /**
     * 作品名称
     */
    public String getWorkName() {
        return workName;
    }

    /**
     * 作品名称
     */
    public void setWorkName(String workName) {
        this.workName = workName;
    }

    /**
     * 参赛组别
     */
    public String getWorkGroup() {
        return workGroup;
    }

    /**
     * 参赛组别
     */
    public void setWorkGroup(String workGroup) {
        this.workGroup = workGroup;
    }

    /**
     * 参赛学校
     */
    public String getWorkSchool() {
        return workSchool;
    }

    /**
     * 参赛学校
     */
    public void setWorkSchool(String workSchool) {
        this.workSchool = workSchool;
    }

    /**
     * 参赛团队
     */
    public String getWorkTeam() {
        return workTeam;
    }

    /**
     * 参赛团队
     */
    public void setWorkTeam(String workTeam) {
        this.workTeam = workTeam;
    }

    /**
     * 参赛资格
     */
    public String getWorkEligibility() {
        return workEligibility;
    }

    /**
     * 参赛资格
     */
    public void setWorkEligibility(String workEligibility) {
        this.workEligibility = workEligibility;
    }

    /**
     * 参赛报名表存储地址
     */
    public String getWorkEntry() {
        return workEntry;
    }

    /**
     * 参赛报名表存储地址
     */
    public void setWorkEntry(String workEntry) {
        this.workEntry = workEntry;
    }

    /**
     * 参赛表信息公示文件地址
     */
    public String getWorkPublicity() {
        return workPublicity;
    }

    /**
     * 参赛表信息公示文件地址
     */
    public void setWorkPublicity(String workPublicity) {
        this.workPublicity = workPublicity;
    }

    /**
     * 联系方式
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 联系方式
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 上传时间
     */
    public LocalDate getCreatTime() {
        return creatTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 上传时间
     */
    public void setCreatTime(LocalDate creatTime) {
        this.creatTime = creatTime;
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
        Work other = (Work) that;
        return (this.getWorkId() == null ? other.getWorkId() == null : this.getWorkId().equals(other.getWorkId()))
            && (this.getWorkName() == null ? other.getWorkName() == null : this.getWorkName().equals(other.getWorkName()))
            && (this.getWorkGroup() == null ? other.getWorkGroup() == null : this.getWorkGroup().equals(other.getWorkGroup()))
            && (this.getWorkSchool() == null ? other.getWorkSchool() == null : this.getWorkSchool().equals(other.getWorkSchool()))
            && (this.getWorkTeam() == null ? other.getWorkTeam() == null : this.getWorkTeam().equals(other.getWorkTeam()))
            && (this.getWorkEligibility() == null ? other.getWorkEligibility() == null : this.getWorkEligibility().equals(other.getWorkEligibility()))
            && (this.getWorkEntry() == null ? other.getWorkEntry() == null : this.getWorkEntry().equals(other.getWorkEntry()))
            && (this.getWorkPublicity() == null ? other.getWorkPublicity() == null : this.getWorkPublicity().equals(other.getWorkPublicity()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getCreatTime() == null ? other.getCreatTime() == null : this.getCreatTime().equals(other.getCreatTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWorkId() == null) ? 0 : getWorkId().hashCode());
        result = prime * result + ((getWorkName() == null) ? 0 : getWorkName().hashCode());
        result = prime * result + ((getWorkGroup() == null) ? 0 : getWorkGroup().hashCode());
        result = prime * result + ((getWorkSchool() == null) ? 0 : getWorkSchool().hashCode());
        result = prime * result + ((getWorkTeam() == null) ? 0 : getWorkTeam().hashCode());
        result = prime * result + ((getWorkEligibility() == null) ? 0 : getWorkEligibility().hashCode());
        result = prime * result + ((getWorkEntry() == null) ? 0 : getWorkEntry().hashCode());
        result = prime * result + ((getWorkPublicity() == null) ? 0 : getWorkPublicity().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getCreatTime() == null) ? 0 : getCreatTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", workId=").append(workId);
        sb.append(", workName=").append(workName);
        sb.append(", workGroup=").append(workGroup);
        sb.append(", workSchool=").append(workSchool);
        sb.append(", workTeam=").append(workTeam);
        sb.append(", workEligibility=").append(workEligibility);
        sb.append(", workEntry=").append(workEntry);
        sb.append(", workPublicity=").append(workPublicity);
        sb.append(", phone=").append(phone);
        sb.append(", creatTime=").append(creatTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}