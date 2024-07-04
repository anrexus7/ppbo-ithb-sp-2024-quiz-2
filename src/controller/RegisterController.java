package controller;

import model.Class.DatabaseHandler;
import model.Class.Member;
import model.Enum.JenisKelamin;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class RegisterController {
    public static boolean validatingAllInput(String nama, Object lahir, Object buat, Object kelamin, File fotoMember){
        if(nama.isEmpty() || lahir == null || buat == null || kelamin == null || fotoMember == null){
            return false;
        }else{
            return true;
        }
    }

    public static boolean registering(String nama, Object lahir, Object buat, String kelamin, File fotoMember) {
        Member tempData;
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime((Date) buat);
        calendar.add(Calendar.DAY_OF_YEAR, 720);

        Date expDate = calendar.getTime();

        if(kelamin.equals(JenisKelamin.PRIA.toString())){
            tempData = new Member(nama, JenisKelamin.PRIA,fotoMember.getAbsolutePath(), (Date) lahir, (Date) buat, expDate);
        }else{
            tempData = new Member(nama, JenisKelamin.WANITA,fotoMember.getAbsolutePath(), (Date) lahir, (Date) buat, expDate);
        }

        String query = "INSERT INTO members VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            System.out.println("hihi");
            PreparedStatement stmt = conn.con.prepareStatement(query);
            TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

            stmt.setString(1,null);
            stmt.setString(2, tempData.getNama());
            stmt.setString(3, tempData.getKelamin().toString());
            stmt.setString(4, tempData.getFotoMember());
            stmt.setDate(5,  new java.sql.Date(tempData.getTanggalLahir().getTime()));
            stmt.setDate(6, new java.sql.Date(tempData.getTanggalBuat().getTime()));
            stmt.setDate(7, new java.sql.Date(tempData.getTanggalExp().getTime()) );

            stmt.executeUpdate();
            conn.disconnect();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            conn.disconnect();
            return (false);
        }
    }
}
