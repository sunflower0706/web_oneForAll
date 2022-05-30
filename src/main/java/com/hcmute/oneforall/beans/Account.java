package com.hcmute.oneforall.beans;

import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @Column(name = "idTK")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "ho")
    private String ho;

    @Column(name = "ten")
    private String ten;

    @Column(name = "gioi_tinh")
    private boolean gioi_tinh;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ngay_sinh")
    private Date ngay_sinh;

    @Column(name = "email")
    private String email;

    @Column(name = "mat_khau")
    private String mat_khau;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "avt")
    private String avt;

    @Column(name = "phan_quyen")
    private boolean phan_quyen;

    @OneToMany(mappedBy = "account")
    private Set<Rating> ratings;

    public Account(){}

    public Account(String email, String mat_khau){
        this.email = email;
        this.mat_khau = mat_khau;
    }

    public Account(int id, String ho, String ten, boolean gioi_tinh, Date ngay_sinh, String email, String mat_khau, String sdt, String avt, boolean phan_quyen){
        this.id = id;
        this.ho = ho;
        this.ten = ten;
        this.gioi_tinh = gioi_tinh;
        this.ngay_sinh = ngay_sinh;
        this.email = email;
        this.mat_khau = mat_khau;
        this.sdt = sdt;
        this.avt = avt;
        this.phan_quyen = phan_quyen;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getHo() {
        return ho;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTen() {
        return ten;
    }

    public void setGioi_tinh(boolean gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public boolean isGioi_tinh() {
        return gioi_tinh;
    }

    public void setNgay_sinh(Date ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public Date getNgay_sinh() {
        return ngay_sinh;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setMat_khau(String mat_khau) {
        this.mat_khau = mat_khau;
    }

    public String getMat_khau() {
        return mat_khau;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getSdt() {
        return sdt;
    }

    public void setAvt(String avt) {
        this.avt = avt;
    }

    public String getAvt() {
        return avt;
    }

    public void setPhan_quyen(boolean phan_quyen) {
        this.phan_quyen = phan_quyen;
    }

    public boolean isPhan_quyen() {
        return phan_quyen;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", ho='" + ho + '\'' +
                ", ten='" + ten + '\'' +
                ", gioi_tinh=" + gioi_tinh +
                ", ngay_sinh=" + ngay_sinh +
                ", email='" + email + '\'' +
                ", mat_khau='" + mat_khau + '\'' +
                ", sdt='" + sdt + '\'' +
                ", avt='" + avt + '\'' +
                ", phan_quyen=" + phan_quyen +
                '}';
    }
}
