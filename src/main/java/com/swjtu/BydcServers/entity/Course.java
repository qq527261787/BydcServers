package com.swjtu.BydcServers.entity;

import java.util.Date;

public class Course {
    private Integer id;

    private Boolean enable;

    private String code;

    private String name;

    private Integer score;

    private String startsemester;

    private String startcollege;

    private Date freezetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getStartsemester() {
        return startsemester;
    }

    public void setStartsemester(String startsemester) {
        this.startsemester = startsemester == null ? null : startsemester.trim();
    }

    public String getStartcollege() {
        return startcollege;
    }

    public void setStartcollege(String startcollege) {
        this.startcollege = startcollege == null ? null : startcollege.trim();
    }

    public Date getFreezetime() {
        return freezetime;
    }

    public void setFreezetime(Date freezetime) {
        this.freezetime = freezetime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", enable=").append(enable);
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", score=").append(score);
        sb.append(", startsemester=").append(startsemester);
        sb.append(", startcollege=").append(startcollege);
        sb.append(", freezetime=").append(freezetime);
        sb.append("]");
        return sb.toString();
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
        Course other = (Course) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEnable() == null ? other.getEnable() == null : this.getEnable().equals(other.getEnable()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getStartsemester() == null ? other.getStartsemester() == null : this.getStartsemester().equals(other.getStartsemester()))
            && (this.getStartcollege() == null ? other.getStartcollege() == null : this.getStartcollege().equals(other.getStartcollege()))
            && (this.getFreezetime() == null ? other.getFreezetime() == null : this.getFreezetime().equals(other.getFreezetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEnable() == null) ? 0 : getEnable().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getStartsemester() == null) ? 0 : getStartsemester().hashCode());
        result = prime * result + ((getStartcollege() == null) ? 0 : getStartcollege().hashCode());
        result = prime * result + ((getFreezetime() == null) ? 0 : getFreezetime().hashCode());
        return result;
    }
}