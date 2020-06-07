package com.company.project.core.bean.auto;

public class StudentExampleBean {
    private Integer id;

    private String name;

    private String major;

    private Integer level;

    private String club;

    public StudentExampleBean(Integer id, String name, String major, Integer level, String club) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.level = level;
        this.club = club;
    }

    public StudentExampleBean() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club == null ? null : club.trim();
    }
}