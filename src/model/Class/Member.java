package model.Class;

import model.Enum.JenisKelamin;

import java.util.Date;

public class Member {
    private String nama;
    private JenisKelamin kelamin;
    private String fotoMember;
    private Date tanggalLahir;
    private Date tanggalBuat;
    private Date tanggalExp;
    private int nomorMember;

    public Member() {
    }

    public Member(String nama, JenisKelamin kelamin, String fotoMember, Date tanggalLahir, Date tanggalBuat, Date tanggalExp) {
        this.nama = nama;
        this.kelamin = kelamin;
        this.fotoMember = fotoMember;
        this.tanggalLahir = tanggalLahir;
        this.tanggalBuat = tanggalBuat;
        this.tanggalExp = tanggalExp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public JenisKelamin getKelamin() {
        return kelamin;
    }

    public void setKelamin(JenisKelamin kelamin) {
        this.kelamin = kelamin;
    }

    public String getFotoMember() {
        return fotoMember;
    }

    public void setFotoMember(String fotoMember) {
        this.fotoMember = fotoMember;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public Date getTanggalBuat() {
        return tanggalBuat;
    }

    public void setTanggalBuat(Date tanggalBuat) {
        this.tanggalBuat = tanggalBuat;
    }

    public Date getTanggalExp() {
        return tanggalExp;
    }

    public void setTanggalExp(Date tanggalExp) {
        this.tanggalExp = tanggalExp;
    }
}
