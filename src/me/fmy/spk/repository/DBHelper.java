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
        String sql = "Select * From Karyawan order by id asc";
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
                int gender          = result.getInt("gender");
                int marital         = result.getInt("marital");
                int status          = result.getInt("status");
                int dept            = result.getInt("dept");
                int position        = result.getInt("position");
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
}
