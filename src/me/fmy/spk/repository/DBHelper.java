/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.fmy.spk.repository;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.fmy.spk.models.Karyawan;

/**
 *
 * @author Femmy
 */
public class DBHelper {
    
    public ArrayList<Karyawan> getKaryawan(){
        ArrayList<Karyawan> returns = new ArrayList<>();
        java.sql.Connection conn = new DBConn().connect();
        String sql = "SELECT * FROM mskaryawan ORDER BY id ASC";
        java.sql.Statement stmt;
        try {
            stmt = conn.createStatement();
            java.sql.ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                int id              = result.getInt("id");
                String NIP          = result.getString("NIP");
                String fullname     = result.getString("fullname");
                String startWork    = result.getString("start_work");
                String address      = result.getString("address");
                String phone        = result.getString("phone");
                String dob          = result.getString("dob");
                String gender       = result.getString("gender");
                String marital      = result.getString("marital");
                String status       = result.getString("status");
                String dept         = result.getString("dept");
                String position     = result.getString("position");
                String createdAt    = result.getString("created_at");
                String updatedAt    = result.getString("updated_at");
                
                Karyawan kry = new Karyawan();
                kry.setId(id);
                kry.setNIP(NIP);
                kry.setFullname(fullname);
                kry.setAddress(address);
                kry.setStartWork(startWork);
                kry.setPhone(phone);
                kry.setDOB(dob);
                kry.setGender(gender);
                kry.setMarital(marital);
                kry.setStatus(status);
                kry.setDept(dept);
                kry.setPosition(position);
                kry.setCreatedAt(createdAt);
                kry.setUpdatedAt(updatedAt);
                returns.add(kry);
            }
        }catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returns;
    }
    
    public Karyawan getKrywnByID(int id){
        Karyawan kry = null;
        java.sql.Connection conn = new DBConn().connect();
        String sql = "SELECT * FROM mskaryawan WHERE id = '"+id+"'";
        System.out.println(sql);
        java.sql.Statement stmt;
        try {
            stmt = conn.createStatement();
            java.sql.ResultSet result = stmt.executeQuery(sql);
            result.next();
            kry = new Karyawan();
            kry.setId(id);
            kry.setNIP(result.getString("nip"));
            kry.setFullname(result.getString("fullname"));
            kry.setStartWork(result.getString("start_work"));
            kry.setAddress(result.getString("address"));
            kry.setPhone(result.getString("phone"));
            kry.setDOB(result.getString("dob"));
            kry.setGender(result.getString("gender"));
            kry.setMarital(result.getString("marital"));
            kry.setStatus(result.getString("status"));
            kry.setDept(result.getString("dept"));
            kry.setPosition(result.getString("position"));
            kry.setGajiPokok(result.getInt("gaji_pokok"));
            kry.setTnjTransport(result.getInt("tnj_transport"));
            kry.setTnjLain(result.getInt("tnj_lain"));
        } catch (SQLException ex){
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kry;
    }
    
    public Karyawan getKrywn(String NIP){
        Karyawan kry = null;
        java.sql.Connection conn = new DBConn().connect();
        String sql = "SELECT * FROM mskaryawan WHERE NIP = '"+NIP+"'";
        java.sql.Statement stmt;
        try {
            stmt = conn.createStatement();
            java.sql.ResultSet result = stmt.executeQuery(sql);
            result.next();
            kry = new Karyawan();
            kry.setId(result.getInt("id"));
            kry.setNIP(result.getString("nip"));
            kry.setFullname(result.getString("fullname"));
            kry.setStartWork(result.getString("start_work"));
            kry.setAddress(result.getString("address"));
            kry.setPhone(result.getString("phone"));
            kry.setDOB(result.getString("dob"));
            kry.setGender(result.getString("gender"));
            kry.setMarital(result.getString("marital"));
            kry.setStatus(result.getString("status"));
            kry.setDept(result.getString("dept"));
            kry.setPosition(result.getString("position"));
            kry.setGajiPokok(result.getInt("gaji_pokok"));
            kry.setTnjTransport(result.getInt("tnj_transport"));
            kry.setTnjLain(result.getInt("tnj_lain"));
        } catch (SQLException ex){
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kry;
    }
    
    public void insertKaryawan(Karyawan kry){
        java.sql.Connection conn = new DBConn().connect();
        try {
            String sql = "insert into mskaryawan("
                        + "nip,"
                        + "fullname,"
                        + "start_work,"
                        + "address,"
                        + "phone,"
                        + "dob, "
                        + "gender, "
                        + "marital,"
                        + "status,"
                        + "dept, "
                        + "position,"
                        + "gaji_pokok,"
                        + "tnj_transport,"
                        + "tnj_lain,"
                        + "created_at,"
                        + "updated_at) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, kry.getNIP());
            stmt.setString(2, kry.getFullname());
            stmt.setString(3, kry.getStartWork());
            stmt.setString(4, kry.getAddress());
            stmt.setString(5, kry.getPhone());
            stmt.setString(6, kry.getDOB());
            stmt.setString(7, kry.getGender());
            stmt.setString(8, kry.getMarital());
            stmt.setString(9, kry.getStatus());
            stmt.setString(10, kry.getDept());
            stmt.setString(11, kry.getPosition());
            stmt.setInt(12, kry.getGajiPokok());
            stmt.setInt(13, kry.getTnjTransport());
            stmt.setInt(14, kry.getTnjLain());
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            stmt.setString(15, dateFormat.format(date));
            stmt.setString(16, dateFormat.format(date));
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateKaryawan(Karyawan kry){
        java.sql.Connection conn = new DBConn().connect();
        try {
            String sql = "UPDATE mskaryawan "
                            + "SET nip=?, "
                            + "fullname=?, "
                            + "start_work=?, "
                            + "address=?, "
                            + "phone=?, "
                            + "dob=?, "
                            + "gender=?, "
                            + "marital=?, "
                            + "status=?, "
                            + "dept=?, "
                            + "position=?, "
                            + "gaji_pokok=?, "
                            + "tnj_transport=?, "
                            + "tnj_lain=?, "
                            + "updated_at=? "
                        + "WHERE id='"+String.valueOf(kry.getId())+"'";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, kry.getNIP());
            stmt.setString(2, kry.getFullname());
            stmt.setString(3, kry.getStartWork());
            stmt.setString(4, kry.getAddress());
            stmt.setString(5, kry.getPhone());
            stmt.setString(6, kry.getDOB());
            stmt.setString(7, kry.getGender());
            stmt.setString(8, kry.getMarital());
            stmt.setString(9, kry.getStatus());
            stmt.setString(10, kry.getDept());
            stmt.setString(11, kry.getPosition());
            stmt.setInt(12, kry.getGajiPokok());
            stmt.setInt(13, kry.getTnjTransport());
            stmt.setInt(14, kry.getTnjLain());
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            stmt.setString(15, dateFormat.format(date));
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteKaryawan(String nip){
        java.sql.Connection conn = new DBConn().connect();
        try {
            String sql = "DELETE FROM mskaryawan WHERE nip=?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nip);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
