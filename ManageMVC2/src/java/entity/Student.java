/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author TNO
 */
public class Student {
    private int id;
    private String name;
    private Date dob;
    private String adress;
    private String course;
    private String teachingQuality;

    public Student() {
    }

    public Student(int id, String name, Date dob, String adress, String course, String teachingQuality) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.adress = adress;
        this.course = course;
        this.teachingQuality = teachingQuality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTeachingQuality() {
        return teachingQuality;
    }

    public void setTeachingQuality(String teachingQuality) {
        this.teachingQuality = teachingQuality;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", dob=" + dob + ", adress=" + adress + ", course=" + course + ", teachingQuality=" + teachingQuality + '}';
    }
    
    
}
