package com.lxg.test;

    class Memento {
    private Integer sid;
    private String sno;
    private String name;
    private String sex;
    private Integer age;
    private String grade;
    private String dorm;

    public Memento(Integer sid, String sno, String name, String sex, Integer age, String grade, String dorm) {
        this.sid = sid;
        this.sno = sno;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.grade = grade;
        this.dorm = dorm;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDorm() {
        return dorm;
    }

    public void setDorm(String dorm) {
        this.dorm = dorm;
    }
}
