package com.lh.site.entity;

import java.util.Date;

public class ShoppingCart {
    private Long id;

    private Long studentInfoId;

    private Long courseId;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentInfoId() {
        return studentInfoId;
    }

    public void setStudentInfoId(Long studentInfoId) {
        this.studentInfoId = studentInfoId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}