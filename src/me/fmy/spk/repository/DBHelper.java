/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.fmy.spk.repository;

import java.sql.SQLException;
import java.util.ArrayList;
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
                String fullname     = result.getString("fullname");
                String startWork    = result.getString("start_work");
                String address      = result.getString("address");
                String phone        = result.getString("phone");
                String dob          = result.getString("dob");
                String gender       = result.getString("gender");
                String marital      = result.getString("marital");
                String status       = result.getString("status");
                int dept            = result.getInt("dept");
                String position     = result.getString("position");
                String createdAt    = result.getString("created_at");
                String updatedAt    = result.getString("updated_at");
                
                Karyawan kry = new Karyawan();
                kry.setId(id);
                kry.setFullname(fullname);
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
                        + "created_at,"
                        + "updated_at) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            stmt.setInt(10, kry.getDept());
            stmt.setString(11, kry.getPosition());
            stmt.setString(12, kry.getCreatedAt());
            stmt.setString(13, kry.getUpdatedAt());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
