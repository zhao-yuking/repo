package com.swpu.tjx.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 参赛的材料信息表
 * @TableName materials
 */
@TableName(value ="materials")
public class Materials implements Serializable {
    /**
     * 材料id
     */
    @TableId
    private Long materialsId;

    /**
     * 第一个团队视频
     */
    private String team1;

    /**
     * 第二个团队视频
     */
    private String team2;

    /**
     * 第三个团队视频
     */
    private String team3;

    /**
     * 第四个团队视频
     */
    private String team4;

    /**
     * 教案文件地址
     */
    private String teachingThing;

    /**
     * 教学实施报告地址
     */
    private String teachingReport;

    /**
     * 专业人才培养方案地址
     */
    private String personProgram;

    /**
     * 课程标准信息地址
     */
    private String classInformation;

    /**
     * 教材选用说明
     */
    private String textbook;

    /**
     * 所属参赛id组名
     */
    private Long workId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 材料id
     */
    public Long getMaterialsId() {
        return materialsId;
    }

    /**
     * 材料id
     */
    public void setMaterialsId(Long materialsId) {
        this.materialsId = materialsId;
    }

    /**
     * 第一个团队视频
     */
    public String getTeam1() {
        return team1;
    }

    /**
     * 第一个团队视频
     */
    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    /**
     * 第二个团队视频
     */
    public String getTeam2() {
        return team2;
    }

    /**
     * 第二个团队视频
     */
    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    /**
     * 第三个团队视频
     */
    public String getTeam3() {
        return team3;
    }

    /**
     * 第三个团队视频
     */
    public void setTeam3(String team3) {
        this.team3 = team3;
    }

    /**
     * 第四个团队视频
     */
    public String getTeam4() {
        return team4;
    }

    /**
     * 第四个团队视频
     */
    public void setTeam4(String team4) {
        this.team4 = team4;
    }

    /**
     * 教案文件地址
     */
    public String getTeachingThing() {
        return teachingThing;
    }

    /**
     * 教案文件地址
     */
    public void setTeachingThing(String teachingThing) {
        this.teachingThing = teachingThing;
    }

    /**
     * 教学实施报告地址
     */
    public String getTeachingReport() {
        return teachingReport;
    }

    /**
     * 教学实施报告地址
     */
    public void setTeachingReport(String teachingReport) {
        this.teachingReport = teachingReport;
    }

    /**
     * 专业人才培养方案地址
     */
    public String getPersonProgram() {
        return personProgram;
    }

    /**
     * 专业人才培养方案地址
     */
    public void setPersonProgram(String personProgram) {
        this.personProgram = personProgram;
    }

    /**
     * 课程标准信息地址
     */
    public String getClassInformation() {
        return classInformation;
    }

    /**
     * 课程标准信息地址
     */
    public void setClassInformation(String classInformation) {
        this.classInformation = classInformation;
    }

    /**
     * 教材选用说明
     */
    public String getTextbook() {
        return textbook;
    }

    /**
     * 教材选用说明
     */
    public void setTextbook(String textbook) {
        this.textbook = textbook;
    }

    /**
     * 所属参赛id组名
     */
    public Long getWorkId() {
        return workId;
    }

    /**
     * 所属参赛id组名
     */
    public void setWorkId(Long workId) {
        this.workId = workId;
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
        Materials other = (Materials) that;
        return (this.getMaterialsId() == null ? other.getMaterialsId() == null : this.getMaterialsId().equals(other.getMaterialsId()))
            && (this.getTeam1() == null ? other.getTeam1() == null : this.getTeam1().equals(other.getTeam1()))
            && (this.getTeam2() == null ? other.getTeam2() == null : this.getTeam2().equals(other.getTeam2()))
            && (this.getTeam3() == null ? other.getTeam3() == null : this.getTeam3().equals(other.getTeam3()))
            && (this.getTeam4() == null ? other.getTeam4() == null : this.getTeam4().equals(other.getTeam4()))
            && (this.getTeachingThing() == null ? other.getTeachingThing() == null : this.getTeachingThing().equals(other.getTeachingThing()))
            && (this.getTeachingReport() == null ? other.getTeachingReport() == null : this.getTeachingReport().equals(other.getTeachingReport()))
            && (this.getPersonProgram() == null ? other.getPersonProgram() == null : this.getPersonProgram().equals(other.getPersonProgram()))
            && (this.getClassInformation() == null ? other.getClassInformation() == null : this.getClassInformation().equals(other.getClassInformation()))
            && (this.getTextbook() == null ? other.getTextbook() == null : this.getTextbook().equals(other.getTextbook()))
            && (this.getWorkId() == null ? other.getWorkId() == null : this.getWorkId().equals(other.getWorkId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMaterialsId() == null) ? 0 : getMaterialsId().hashCode());
        result = prime * result + ((getTeam1() == null) ? 0 : getTeam1().hashCode());
        result = prime * result + ((getTeam2() == null) ? 0 : getTeam2().hashCode());
        result = prime * result + ((getTeam3() == null) ? 0 : getTeam3().hashCode());
        result = prime * result + ((getTeam4() == null) ? 0 : getTeam4().hashCode());
        result = prime * result + ((getTeachingThing() == null) ? 0 : getTeachingThing().hashCode());
        result = prime * result + ((getTeachingReport() == null) ? 0 : getTeachingReport().hashCode());
        result = prime * result + ((getPersonProgram() == null) ? 0 : getPersonProgram().hashCode());
        result = prime * result + ((getClassInformation() == null) ? 0 : getClassInformation().hashCode());
        result = prime * result + ((getTextbook() == null) ? 0 : getTextbook().hashCode());
        result = prime * result + ((getWorkId() == null) ? 0 : getWorkId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", materialsId=").append(materialsId);
        sb.append(", team1=").append(team1);
        sb.append(", team2=").append(team2);
        sb.append(", team3=").append(team3);
        sb.append(", team4=").append(team4);
        sb.append(", teachingThing=").append(teachingThing);
        sb.append(", teachingReport=").append(teachingReport);
        sb.append(", personProgram=").append(personProgram);
        sb.append(", classInformation=").append(classInformation);
        sb.append(", textbook=").append(textbook);
        sb.append(", workId=").append(workId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}