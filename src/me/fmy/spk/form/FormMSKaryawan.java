/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.fmy.spk.form;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import me.fmy.spk.models.Karyawan;
import me.fmy.spk.repository.DBHelper;

/**
 *
 * @author WebDev
 */
public class FormMSKaryawan extends javax.swing.JInternalFrame {
    
    DBHelper mDBHelper;
    DefaultTableModel tblModel;
    
    /**
     * Creates new form FormMSKaryawan
     */
    public FormMSKaryawan() {
        initComponents();
        mDBHelper = new DBHelper();
        showData();
        formViewMode();
        jTxtID.setVisible(false);
        //setupComboJabatan();
    }
    
    private void setupComboJabatan(){
        jCMBPos.addItem("Direktur");
        jCMBPos.addItem("Manager");
        jCMBPos.addItem("Supervisor");
        jCMBPos.addItem("Administrator");
        jCMBPos.addItem("Operator");
    }
    
    private void showData(){
        Object[] rows = {"NIP", "NAMA PEGAWAI", "ALAMAT", "TELEPON", "JABATAN", "JENIS KELAMIN"};
        tblModel = new DefaultTableModel(null,rows );
        JTblKaryawan.setModel(tblModel);
        ArrayList<Karyawan> krys = mDBHelper.getKaryawan();
        for(int i=0; i<krys.size(); i++ ){
            Karyawan kry = krys.get(i);
            String[] data = {String.valueOf(kry.getNIP()), kry.getFullname(), kry.getAddress(), kry.getPhone(), kry.getPosition(), kry.getGender()}; 
            tblModel.addRow(data);
        }
    }
    
    private void formInputMode(){
        jTxtIDPegawai.setEnabled(true);
        jTxtAddress.setEnabled(true);
        jTxtEmployeeName.setEnabled(true);
        jTxtPhone.setEnabled(true);
        jTxtGapok.setEnabled(true);
        jTxtTnjTrans.setEnabled(true);
        jTxtTnjLain.setEnabled(true);
        jTxtWorkStart.setEnabled(true);
        jTxtDOB.setEnabled(true);
        jCMBDept.setEnabled(true);
        jCMBPos.setEnabled(true);
        jRBGenderF.setEnabled(true);
        jRBGenderM.setEnabled(true);
        jRBMaritalK.setEnabled(true);
        jRBMaritalL.setEnabled(true);
        jRBMaritalJD.setEnabled(true); 
        jRBStatusT.setEnabled(true);
        jRBStatusK.setEnabled(true);
        jPanelSave.setVisible(true);
        jPanelMainButtonGroup.setVisible(false);
    }
    
    private void formViewMode(){
        jTxtIDPegawai.setEnabled(false);
        jTxtAddress.setEnabled(false);
        jTxtEmployeeName.setEnabled(false);
        jTxtPhone.setEnabled(false);
        jTxtGapok.setEnabled(false);
        jTxtTnjTrans.setEnabled(false);
        jTxtTnjLain.setEnabled(false);
        jTxtWorkStart.setEnabled(false);
        jTxtDOB.setEnabled(false);
        jCMBDept.setEnabled(false);
        jCMBPos.setEnabled(false);
        jRBGenderF.setEnabled(false);
        jRBGenderM.setEnabled(false);
        jRBMaritalK.setEnabled(false);
        jRBMaritalL.setEnabled(false);
        jRBMaritalJD.setEnabled(false);  
        jRBStatusT.setEnabled(false);
        jRBStatusK.setEnabled(false);
        jPanelSave.setVisible(false);
        jPanelMainButtonGroup.setVisible(true);
    }
    
    private void clearForm(){
        jTxtIDPegawai.setText("");
        jTxtAddress.setText("");
        jTxtEmployeeName.setText("");
        jTxtPhone.setText("");
        jTxtGapok.setText("");
        jTxtTnjTrans.setText("");
        jTxtTnjLain.setText("");
        jTxtWorkStart.setText("");
        jTxtDOB.setText("");
        jCMBDept.setSelectedIndex(0);
        jCMBPos.setSelectedIndex(0);
        jRBGenderF.setSelected(false);
        jRBGenderM.setSelected(false);
        jRBMaritalK.setSelected(false);
        jRBMaritalL.setSelected(false);
        jRBMaritalJD.setSelected(false);  
        jRBStatusT.setSelected(false);
        jRBStatusK.setSelected(false);
    }
    
    private void insertKaryawan(){
        String NIP          = jTxtIDPegawai.getText();
        String fullname     = jTxtEmployeeName.getText();
        String phone        = jTxtPhone.getText();
        String address      = jTxtAddress.getText();
        String dept         = jCMBDept.getSelectedItem().toString();
        String pos          = jCMBPos.getSelectedItem().toString();
        String DOB          = jTxtDOB.getText();
        String startwork    = jTxtWorkStart.getText();
        int gajiPokok       = Integer.parseInt(jTxtGapok.getText());
        int tnjTrans        = Integer.parseInt(jTxtTnjTrans.getText());
        int tnjlain         = Integer.parseInt(jTxtTnjLain.getText());
        
        String Gender;
        if(jRBGenderM.isSelected()){
            Gender = "Pria";
        } else if(jRBGenderF.isSelected()){
            Gender = "Wanita";
        } else {
            Gender = "Pria";
        }
        
        String Marital;
        if(jRBMaritalK.isSelected()){
            Marital = "Kawin";
        } else if(jRBMaritalL.isSelected()){
            Marital = "Single";
        } else if(jRBMaritalJD.isSelected()){
            Marital = "Janda / Duda";
        } else {
            Marital = "Single";
        }
        
        String Status;
        if(jRBStatusK.isSelected()){
            Status = "Tetap";
        } else if(jRBStatusT.isSelected()){
            Status = "Kontrak";
        } else {
            Status = "Tetap";
        }
        
        Karyawan kry = new Karyawan();
        kry.setNIP(NIP);
        kry.setFullname(fullname);
        kry.setStartWork(startwork);
        kry.setDOB(DOB);
        kry.setAddress(address);
        kry.setPhone(phone);
        kry.setGender(Gender);
        kry.setMarital(Marital);
        kry.setStatus(Status);
        kry.setDept(dept);
        kry.setPosition(pos);
        kry.setGajiPokok(gajiPokok);
        kry.setTnjTransport(tnjTrans);
        kry.setTnjTransport(tnjlain);
        mDBHelper.insertKaryawan(kry);
        clearForm();
        formViewMode();
        tblModel.fireTableDataChanged();
        showData();
    }
    
    private void updateKaryawan(){
        int id = Integer.parseInt(jTxtID.getText());
        Karyawan kry = mDBHelper.getKrywnByID(id);
        String NIP          = jTxtIDPegawai.getText();
        String fullname     = jTxtEmployeeName.getText();
        String phone        = jTxtPhone.getText();
        String address      = jTxtAddress.getText();
        String dept         = jCMBDept.getSelectedItem().toString();
        String pos          = jCMBPos.getSelectedItem().toString();
        String DOB          = jTxtDOB.getText();
        String startwork    = jTxtWorkStart.getText();
        int gajiPokok       = Integer.parseInt(jTxtGapok.getText());
        int tnjTrans        = Integer.parseInt(jTxtTnjTrans.getText());
        int tnjlain         = Integer.parseInt(jTxtTnjLain.getText());
        
        String Gender;
        if(jRBGenderM.isSelected()){
            Gender = "Pria";
        } else if(jRBGenderF.isSelected()){
            Gender = "Wanita";
        } else {
            Gender = "Pria";
        }
        
        String Marital;
        if(jRBMaritalK.isSelected()){
            Marital = "Kawin";
        } else if(jRBMaritalL.isSelected()){
            Marital = "Single";
        } else if(jRBMaritalJD.isSelected()){
            Marital = "Janda / Duda";
        } else {
            Marital = "Single";
        }
        
        String Status;
        if(jRBStatusK.isSelected()){
            Status = "Tetap";
        } else if(jRBStatusT.isSelected()){
            Status = "Kontrak";
        } else {
            Status = "Tetap";
        }
        
        kry.setNIP(NIP);
        kry.setFullname(fullname);
        kry.setStartWork(startwork);
        kry.setDOB(DOB);
        kry.setAddress(address);
        kry.setPhone(phone);
        kry.setGender(Gender);
        kry.setMarital(Marital);
        kry.setStatus(Status);
        kry.setDept(dept);
        kry.setPosition(pos);
        kry.setGajiPokok(gajiPokok);
        kry.setTnjTransport(tnjTrans);
        kry.setTnjLain(tnjlain);
        mDBHelper.updateKaryawan(kry);
        clearForm();
        formViewMode();
        tblModel.fireTableDataChanged();
        showData();
    }
    
    private void prepareUpdate(){
        int column = 0;
        int row     = JTblKaryawan.getSelectedRow();
        String nip  = JTblKaryawan.getModel().getValueAt(row, column).toString();
        Karyawan kry = mDBHelper.getKrywn(nip);
        if(kry != null){
            jTxtID.setText(String.valueOf(kry.getId()));
            jTxtIDPegawai.setText(kry.getNIP());
            jTxtAddress.setText(kry.getAddress());
            jTxtEmployeeName.setText(kry.getFullname());
            jTxtPhone.setText(kry.getPhone());
            jTxtGapok.setText(String.valueOf(kry.getGajiPokok()));
            jTxtTnjTrans.setText(String.valueOf(kry.getTnjTransport()));
            jTxtTnjLain.setText(String.valueOf(kry.getTnjLain()));
            jTxtWorkStart.setText(kry.getStartWork());
            jTxtDOB.setText(kry.getDOB());
            jCMBDept.setSelectedItem(kry.getDept());
            jCMBPos.setSelectedItem(kry.getPosition());
            
            if(kry.getGender().equals("Pria")){
                jRBGenderM.setSelected(true);
                jRBGenderF.setSelected(false);
            } else {
                jRBGenderF.setSelected(true);
                jRBGenderM.setSelected(false);
            }
            
            if(kry.getMarital().equals("Single")){
                jRBMaritalL.setSelected(true);
                jRBMaritalK.setSelected(false);
                jRBMaritalJD.setSelected(false);
            } else if(kry.getMarital().equals("Kawin")){
                jRBMaritalL.setSelected(false);
                jRBMaritalK.setSelected(true);
                jRBMaritalJD.setSelected(false);
            } else {
                jRBMaritalL.setSelected(false);
                jRBMaritalK.setSelected(false);
                jRBMaritalJD.setSelected(true);
            }
            
            if(kry.getStatus().equals("Kontrak")){
                jRBStatusT.setSelected(false);
                jRBStatusK.setSelected(true);
            } else {
                jRBStatusT.setSelected(true);
                jRBStatusK.setSelected(false);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Karyawan not found.");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTxtIDPegawai = new javax.swing.JTextField();
        jTxtEmployeeName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTxtAddress = new javax.swing.JTextField();
        jTxtPhone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jRBGenderM = new javax.swing.JRadioButton();
        jRBGenderF = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jTxtDOB = new javax.swing.JFormattedTextField();
        jRBMaritalL = new javax.swing.JRadioButton();
        jRBMaritalK = new javax.swing.JRadioButton();
        jRBMaritalJD = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jTxtID = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTblKaryawan = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jCMBPos = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jCMBDept = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jRBStatusT = new javax.swing.JRadioButton();
        jRBStatusK = new javax.swing.JRadioButton();
        jTxtWorkStart = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanelSave = new javax.swing.JPanel();
        jBtnCancel = new javax.swing.JButton();
        jBtnSave = new javax.swing.JButton();
        jPanelMainButtonGroup = new javax.swing.JPanel();
        jBtnAddnew = new javax.swing.JButton();
        jBtnUpdate = new javax.swing.JButton();
        jBtnDelete = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jTxtGapok = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTxtTnjTrans = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTxtTnjLain = new javax.swing.JTextField();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("ID Pegawai");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jTxtIDPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtIDPegawaiActionPerformed(evt);
            }
        });

        jTxtEmployeeName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtEmployeeNameActionPerformed(evt);
            }
        });

        jLabel3.setText("Nama Lengkap");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel4.setText("Alamat");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jTxtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtAddressActionPerformed(evt);
            }
        });

        jTxtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtPhoneActionPerformed(evt);
            }
        });

        jLabel6.setText("No. Telp");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel7.setText("Jenis Kelamin");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jRBGenderM.setText("Laki - Laki");
        jRBGenderM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBGenderMActionPerformed(evt);
            }
        });

        jRBGenderF.setText("Perempuan");
        jRBGenderF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBGenderFActionPerformed(evt);
            }
        });

        jLabel11.setText("Tanggal Lahir");
        jLabel11.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jTxtDOB.setToolTipText("Format : YYYY-MM-DD");
        jTxtDOB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtDOBActionPerformed(evt);
            }
        });

        jRBMaritalL.setText("Lajang");
        jRBMaritalL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBMaritalLActionPerformed(evt);
            }
        });

        jRBMaritalK.setText("Kawin");
        jRBMaritalK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBMaritalKActionPerformed(evt);
            }
        });

        jRBMaritalJD.setText("Janda / Duda");
        jRBMaritalJD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBMaritalJDActionPerformed(evt);
            }
        });

        jLabel9.setText("Stat Perkawinan");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jRBGenderM)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRBGenderF))
                                    .addComponent(jTxtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTxtEmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtIDPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTxtID, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jRBMaritalL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRBMaritalK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRBMaritalJD)))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTxtIDPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTxtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTxtEmployeeName)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTxtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBGenderM)
                    .addComponent(jRBGenderF)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRBMaritalL)
                    .addComponent(jRBMaritalK)
                    .addComponent(jRBMaritalJD))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JTblKaryawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(JTblKaryawan);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Jabatan");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jCMBPos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Direktur", "Manager", "Supervisor", "Administrator", "Operator", " " }));

        jLabel8.setText("Dept.");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jCMBDept.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setText("Status Karyawan");
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jRBStatusT.setText("Tetap");
        jRBStatusT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBStatusTActionPerformed(evt);
            }
        });

        jRBStatusK.setText("Kontrak");
        jRBStatusK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBStatusKActionPerformed(evt);
            }
        });

        jTxtWorkStart.setToolTipText("Format : YYYY-MM-DD");
        jTxtWorkStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtWorkStartActionPerformed(evt);
            }
        });

        jLabel12.setText("Tanggal Bergabung");
        jLabel12.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel10)
                        .addGap(26, 26, 26)
                        .addComponent(jRBStatusT)
                        .addGap(18, 18, 18)
                        .addComponent(jRBStatusK))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCMBDept, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(26, 26, 26)
                                .addComponent(jCMBPos, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(60, 60, 60))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel12)
                .addGap(26, 26, 26)
                .addComponent(jTxtWorkStart, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCMBDept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCMBPos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRBStatusT)
                    .addComponent(jRBStatusK))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtWorkStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanelSave.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBtnCancel.setText("Batal");
        jBtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelActionPerformed(evt);
            }
        });

        jBtnSave.setText("Simpan");
        jBtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSaveLayout = new javax.swing.GroupLayout(jPanelSave);
        jPanelSave.setLayout(jPanelSaveLayout);
        jPanelSaveLayout.setHorizontalGroup(
            jPanelSaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSaveLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jBtnSave)
                .addGap(18, 18, 18)
                .addComponent(jBtnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelSaveLayout.setVerticalGroup(
            jPanelSaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSaveLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnCancel)
                    .addComponent(jBtnSave))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelMainButtonGroup.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBtnAddnew.setText("Tambah");
        jBtnAddnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddnewActionPerformed(evt);
            }
        });

        jBtnUpdate.setText("Ubah");
        jBtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnUpdateActionPerformed(evt);
            }
        });

        jBtnDelete.setText("Hapus");

        jButton5.setText("Keluar");

        javax.swing.GroupLayout jPanelMainButtonGroupLayout = new javax.swing.GroupLayout(jPanelMainButtonGroup);
        jPanelMainButtonGroup.setLayout(jPanelMainButtonGroupLayout);
        jPanelMainButtonGroupLayout.setHorizontalGroup(
            jPanelMainButtonGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainButtonGroupLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jBtnAddnew, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelMainButtonGroupLayout.setVerticalGroup(
            jPanelMainButtonGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainButtonGroupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMainButtonGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAddnew)
                    .addComponent(jBtnUpdate)
                    .addComponent(jBtnDelete)
                    .addComponent(jButton5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setText("Gaji Pokok");
        jLabel13.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jTxtGapok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtGapokActionPerformed(evt);
            }
        });

        jLabel14.setText("Tunjangan Transport");
        jLabel14.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jTxtTnjTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtTnjTransActionPerformed(evt);
            }
        });

        jLabel15.setText("Tunjangan Lain - lain");
        jLabel15.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jTxtTnjLain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtTnjLainActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(34, 34, 34)
                        .addComponent(jTxtTnjLain, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtGapok, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtTnjTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtGapok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtTnjTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtTnjLain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelMainButtonGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPanelSave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelMainButtonGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(579, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtIDPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtIDPegawaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtIDPegawaiActionPerformed

    private void jTxtEmployeeNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtEmployeeNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtEmployeeNameActionPerformed

    private void jTxtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtAddressActionPerformed

    private void jTxtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtPhoneActionPerformed

    private void jRBGenderMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBGenderMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRBGenderMActionPerformed

    private void jRBGenderFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBGenderFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRBGenderFActionPerformed

    private void jRBMaritalLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBMaritalLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRBMaritalLActionPerformed

    private void jRBMaritalKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBMaritalKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRBMaritalKActionPerformed

    private void jRBMaritalJDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBMaritalJDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRBMaritalJDActionPerformed

    private void jRBStatusTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBStatusTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRBStatusTActionPerformed

    private void jRBStatusKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBStatusKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRBStatusKActionPerformed

    private void jBtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelActionPerformed
        clearForm();
        formViewMode();
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnCancelActionPerformed

    private void jBtnAddnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAddnewActionPerformed
        jTxtID.setText("");
        clearForm();
        formInputMode();
        
    }//GEN-LAST:event_jBtnAddnewActionPerformed

    private void jBtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSaveActionPerformed
        if(jTxtID.getText().equals("")){
            insertKaryawan();
        } else {
            updateKaryawan();
        }
        
    }//GEN-LAST:event_jBtnSaveActionPerformed

    private void jTxtDOBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtDOBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtDOBActionPerformed

    private void jTxtWorkStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtWorkStartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtWorkStartActionPerformed

    private void jTxtGapokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtGapokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtGapokActionPerformed

    private void jTxtTnjTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtTnjTransActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtTnjTransActionPerformed

    private void jTxtTnjLainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtTnjLainActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtTnjLainActionPerformed

    private void jBtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnUpdateActionPerformed
        prepareUpdate();
        formInputMode();
    }//GEN-LAST:event_jBtnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTblKaryawan;
    private javax.swing.JButton jBtnAddnew;
    private javax.swing.JButton jBtnCancel;
    private javax.swing.JButton jBtnDelete;
    private javax.swing.JButton jBtnSave;
    private javax.swing.JButton jBtnUpdate;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jCMBDept;
    private javax.swing.JComboBox<String> jCMBPos;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelMainButtonGroup;
    private javax.swing.JPanel jPanelSave;
    private javax.swing.JRadioButton jRBGenderF;
    private javax.swing.JRadioButton jRBGenderM;
    private javax.swing.JRadioButton jRBMaritalJD;
    private javax.swing.JRadioButton jRBMaritalK;
    private javax.swing.JRadioButton jRBMaritalL;
    private javax.swing.JRadioButton jRBStatusK;
    private javax.swing.JRadioButton jRBStatusT;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTxtAddress;
    private javax.swing.JFormattedTextField jTxtDOB;
    private javax.swing.JTextField jTxtEmployeeName;
    private javax.swing.JTextField jTxtGapok;
    private javax.swing.JTextField jTxtID;
    private javax.swing.JTextField jTxtIDPegawai;
    private javax.swing.JTextField jTxtPhone;
    private javax.swing.JTextField jTxtTnjLain;
    private javax.swing.JTextField jTxtTnjTrans;
    private javax.swing.JFormattedTextField jTxtWorkStart;
    // End of variables declaration//GEN-END:variables
}
