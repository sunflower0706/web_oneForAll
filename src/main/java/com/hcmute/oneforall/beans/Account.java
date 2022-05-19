package com.hcmute.oneforall.beans;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "Ho")
    private String firstName;

    @Column(name = "Ten")
    private String lastName;

    @Column(name = "GioiTinh")
    private boolean female;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "NgaySinh")
    @Getter
    private Date birth;

    @Column(name = "Email")
    private String email;

    @Column(name = "MatKhau")
    private String password;

    @Column(name = "SDT")
    private String phoneNumber;

    @Column(name = "Avt")
    private String avt;

    @Column(name = "PhanQuyen")
    private boolean role;

    public Account(){}

    public Account(String email, String password){
        this.email = email;
        this.password = password;
    }

    public Account(int id, String firstName, String lastName, boolean female, Date birth, String email, String password, String phoneNumber, String avt, boolean role){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.female = female;
        this.birth = birth;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.avt = avt;
        this.role = role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFemale(boolean female) {
        this.female = female;
    }

    public boolean isFemale() {
        return female;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getBirth() {
        return birth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAvt(String avt) {
        this.avt = avt;
    }

    public String getAvt() {
        return avt;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public boolean isRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", female=" + female +
                ", birth=" + birth +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", avt='" + avt + '\'' +
                ", role=" + role +
                '}';
    }
}
