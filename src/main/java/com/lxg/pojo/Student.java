package com.lxg.pojo;

public class Student {

    private Integer sid;


    private String sno;


    private String name;


    private String sex;


    private Integer age;


    private String grade;


    private String dorm;


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
        this.sno = sno == null ? null : sno.trim();
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }


    public String getSex() {
        return sex;
    }


    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
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
        this.grade = grade == null ? null : grade.trim();
    }


    public String getDorm() {
        return dorm;
    }


    public void setDorm(String dorm) {
        this.dorm = dorm == null ? null : dorm.trim();
    }

    public Student() {

    }

    public Student(Integer sid, String sno, String name, String sex, Integer age, String grade, String dorm) {
        this.sid = sid;
        this.sno = sno;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.grade = grade;
        this.dorm = dorm;
    }

    @Override
    public String toString() {
        return "编号：" + sid +
                "    学号：'" + sno +
                "    姓名：" + name +
                "    性别：" + sex  +
                "    年龄：" + age +
                "    班级：" + grade +
                "    宿舍：" + dorm;
    }
}