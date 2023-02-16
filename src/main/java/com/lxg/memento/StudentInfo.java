package com.lxg.memento;

public class StudentInfo {
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

    public Memento saveMemento() {
        return new Memento(sid, sno, name, sex, age, grade, dorm);
    }

    public void restoreMemento(Memento memento) {
        this.sid = memento.getSid();
        this.sno = memento.getSno();
        this.name = memento.getName();
        this.sex = memento.getSex();
        this.age = memento.getAge();
        this.grade = memento.getGrade();
        this.dorm = getDorm();
    }

    private StudentInfo() {
    }
    private static StudentInfo studentInfo = null;
    public static StudentInfo getInstance(){
        if(studentInfo==null){
            studentInfo = new StudentInfo();
        }
        return studentInfo;
    }
}
