package cn.smartGym.pojo;

import java.util.Date;

public class User extends UserKey {
    private String username;

    private Boolean gender;

    private Boolean campus;

    private Byte college;

    private Long phone;

    private Boolean status;

    private Byte authority;

    private Date created;

    private Date updated;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Boolean getCampus() {
        return campus;
    }

    public void setCampus(Boolean campus) {
        this.campus = campus;
    }

    public Byte getCollege() {
        return college;
    }

    public void setCollege(Byte college) {
        this.college = college;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Byte getAuthority() {
        return authority;
    }

    public void setAuthority(Byte authority) {
        this.authority = authority;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}