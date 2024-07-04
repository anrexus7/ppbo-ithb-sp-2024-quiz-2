package controller;

import model.Class.DatabaseHandler;
import model.Class.Member;
import model.Enum.JenisKelamin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class GetDataMember {
    public static int getMemberNumber() {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        String query = "SELECT idMember FROM Members ORDER BY tanggalBuat DESC LIMIT 1";
        int i=0;

        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                i = rs.getInt("user_id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return i;
    }

    public static Member getData(int id) {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        String query = "SELECT * FROM Members WHERE idMember = '" + id + "'";
        Member user = new Member();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                user.setNama(rs.getString("nama"));
                switch (rs.getString("jenisKelamin")) {
                    case "PRIA":
                        user.setKelamin(JenisKelamin.PRIA);
                        break;
                    case "WANITA":
                        user.setKelamin(JenisKelamin.WANITA);
                        break;
                }
                user.setFotoMember(rs.getString("fotoMember"));
                user.setTanggalLahir(rs.getDate("tanggalLahir"));
                user.setTanggalBuat(rs.getDate("tanggalBuat"));
                user.setTanggalExp(rs.getDate("tanggalExp"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return (user);
    }
}
