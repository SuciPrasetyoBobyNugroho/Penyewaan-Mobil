/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tksaplikasi;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author asus
 */
public final class formdatapelanggan extends javax.swing.JFrame {
public String  file, no_transaksi, nama, kebutuhan, alamat, no_telp, no_plat, tipe, harga, lama_sewa, total_bayar, dp, total_kekurangan, keterangan ;
private final Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    /**
     * Creates new form formdatapelanggan
     */
    public formdatapelanggan() {
        initComponents();
        autonumber();
        aktif();
        kosong();
        datatable();
    }
 protected void aktif(){
    tnama.requestFocus();
}
     protected void kosong(){
    
    
    tnama.setText("");
    buttonGroup1.clearSelection();
    talamat.setText("");
    ttelepon.setText("");
    tplat.setText("");
    ttipe.setText("");
    tharga.setText("");
    tsewa.setText("");
    tbayar.setText("");
    tdp.setText("");
    tkurang.setText("");
    tketerangan.setText("");
   
    }
      protected void autonumber(){
        String pelanggan="";
        try{
        String sql = "SELECT no_transaksi FROM data_pelanggan order by no_transaksi asc";
        PreparedStatement stat = conn.prepareStatement(sql);
        ResultSet rs=stat.executeQuery(sql);
        while(rs.next()){
        pelanggan=rs.getString("no_transaksi");
        }
        }catch(SQLException sqle){pelanggan="";}  
        if(pelanggan.length() <1){pelanggan="TRK0000";}
        String ur=pelanggan.substring(3);
        int u=Integer.parseInt(ur)+1;
        System.out.println(ur+"=="+u);
        if(u<10)
        {ur="000"+u;}
        else if(u<100)
        {ur="00"+u;}
        else if(u<1000)
        {ur="0"+u;}
        else 
        {ur=""+u;}
        pelanggan  ="TRK"+ur;      
         ttransaksi.setText(pelanggan);
        }
      
      private void datatable() {
  Object[] Baris ={"No Transaksi","Nama","Kebutuhan","Alamat","No. Telepon","No plat","Tipe mobil","Harga","Lama_sewa","Total Bayar","DP","Total kekurangan","Keterangan"};
    tabmode = new 
    DefaultTableModel(null, Baris);
    
    
    try {
    String sql = "SELECT * FROM data_pelanggan order by no_transaksi";
    Statement stat = conn.createStatement();
    ResultSet hasil = stat.executeQuery(sql);
    while (hasil.next()){
        tabmode.addRow(new Object[]{
        hasil.getString(1),
        hasil.getString(2),
        hasil.getString(3),
        hasil.getString(4),
        hasil.getString(5),
        hasil.getString(6),
        hasil.getString(7),
        hasil.getString(8),
        hasil.getString(9),
        hasil.getString(10),
        hasil.getString(11),
        hasil.getString(12),
        hasil.getString(13)
    });
    }
    tabeldatapelanggan.setModel(tabmode);
    } catch (Exception e) {
    JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
    }
    }
      
    public void itemTerpilih2(){
    popupmobil2 Pp = new popupmobil2();
    Pp.mbl = this;
    tplat.setText(no_plat);
    ttipe.setText(tipe);
    tharga.setText(harga);
    
    }  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ttransaksi = new javax.swing.JTextField();
        tnama = new javax.swing.JTextField();
        ttelepon = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        talamat = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        tcari = new javax.swing.JTextField();
        bcari2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabeldatapelanggan = new javax.swing.JTable();
        bsimpan = new javax.swing.JButton();
        bedit = new javax.swing.JButton();
        bclear = new javax.swing.JButton();
        brefresh = new javax.swing.JButton();
        bkeluar = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        rpribadi = new javax.swing.JRadioButton();
        rperusahaan = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tplat = new javax.swing.JTextField();
        tsewa = new javax.swing.JTextField();
        tbayar = new javax.swing.JTextField();
        tdp = new javax.swing.JTextField();
        tkurang = new javax.swing.JTextField();
        ttipe = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        bcari1 = new javax.swing.JButton();
        tketerangan = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tharga = new javax.swing.JTextField();
        bhitung = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        bkwitansi = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1100, 809));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NO TRANSAKSI");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 116, 94, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NAMA PELANGGAN");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 170, 117, 16);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("KEBUTUHAN");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 210, 73, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ALAMAT");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 250, 55, 16);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("NOMOR TELEPON");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 400, 103, 16);

        ttransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttransaksiActionPerformed(evt);
            }
        });
        getContentPane().add(ttransaksi);
        ttransaksi.setBounds(200, 110, 157, 30);

        tnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnamaActionPerformed(evt);
            }
        });
        getContentPane().add(tnama);
        tnama.setBounds(200, 160, 240, 30);

        ttelepon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tteleponActionPerformed(evt);
            }
        });
        getContentPane().add(ttelepon);
        ttelepon.setBounds(200, 390, 175, 30);

        talamat.setColumns(20);
        talamat.setRows(5);
        jScrollPane1.setViewportView(talamat);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(200, 260, 260, 110);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("CARI DATA PELANGGAN");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(560, 470, 150, 16);

        tcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcariActionPerformed(evt);
            }
        });
        getContentPane().add(tcari);
        tcari.setBounds(730, 460, 141, 30);

        bcari2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/cari.png"))); // NOI18N
        bcari2.setText("CARI");
        bcari2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcari2ActionPerformed(evt);
            }
        });
        getContentPane().add(bcari2);
        bcari2.setBounds(880, 460, 90, 29);

        tabeldatapelanggan.setModel(new javax.swing.table.DefaultTableModel(
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
        tabeldatapelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabeldatapelangganMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabeldatapelanggan);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 500, 1020, 111);

        bsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/save.png"))); // NOI18N
        bsimpan.setText("SAVE");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });
        getContentPane().add(bsimpan);
        bsimpan.setBounds(60, 620, 100, 29);

        bedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/edit.png"))); // NOI18N
        bedit.setText("EDIT");
        bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditActionPerformed(evt);
            }
        });
        getContentPane().add(bedit);
        bedit.setBounds(280, 620, 110, 29);

        bclear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/clear.png"))); // NOI18N
        bclear.setText("CLEAR");
        bclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bclearActionPerformed(evt);
            }
        });
        getContentPane().add(bclear);
        bclear.setBounds(170, 620, 100, 29);

        brefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/refresh.png"))); // NOI18N
        brefresh.setText("REFRESH");
        brefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brefreshActionPerformed(evt);
            }
        });
        getContentPane().add(brefresh);
        brefresh.setBounds(400, 620, 110, 29);

        bkeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/exit.png"))); // NOI18N
        bkeluar.setText("EXIT");
        bkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkeluarActionPerformed(evt);
            }
        });
        getContentPane().add(bkeluar);
        bkeluar.setBounds(640, 620, 100, 29);

        bhapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/delete.png"))); // NOI18N
        bhapus.setText("DELETE");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });
        getContentPane().add(bhapus);
        bhapus.setBounds(520, 620, 99, 30);

        buttonGroup1.add(rpribadi);
        rpribadi.setText("PRIBADI");
        rpribadi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rpribadiActionPerformed(evt);
            }
        });
        getContentPane().add(rpribadi);
        rpribadi.setBounds(200, 210, 75, 25);

        buttonGroup1.add(rperusahaan);
        rperusahaan.setText("PERUSAHAAN");
        rperusahaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rperusahaanActionPerformed(evt);
            }
        });
        getContentPane().add(rperusahaan);
        rperusahaan.setBounds(290, 210, 107, 25);

        jLabel8.setFont(new java.awt.Font("Rockwell", 1, 28)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("FORM DATA TRANSAKSI PELANGGAN");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(27, 37, 560, 34);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("NO PLAT");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(540, 100, 80, 16);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("LAMA SEWA");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(540, 230, 90, 16);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("TOTAL HARUS DIBAYAR");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(540, 270, 160, 16);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("PEMBAYARAN");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(540, 310, 100, 16);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("TOTAL KEKURANGAN");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(540, 350, 150, 16);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("KETERANGAN");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(540, 400, 120, 16);
        getContentPane().add(tplat);
        tplat.setBounds(720, 90, 160, 30);
        getContentPane().add(tsewa);
        tsewa.setBounds(720, 220, 50, 30);

        tbayar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbayarMouseClicked(evt);
            }
        });
        tbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbayarActionPerformed(evt);
            }
        });
        getContentPane().add(tbayar);
        tbayar.setBounds(720, 260, 170, 30);
        getContentPane().add(tdp);
        tdp.setBounds(720, 300, 170, 30);
        getContentPane().add(tkurang);
        tkurang.setBounds(720, 340, 170, 30);
        getContentPane().add(ttipe);
        ttipe.setBounds(720, 130, 170, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("TIPE MOBIL");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(540, 140, 90, 16);

        bcari1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/cari.png"))); // NOI18N
        bcari1.setText("CARI");
        bcari1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcari1ActionPerformed(evt);
            }
        });
        getContentPane().add(bcari1);
        bcari1.setBounds(910, 90, 90, 29);
        getContentPane().add(tketerangan);
        tketerangan.setBounds(720, 390, 170, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("HARGA SEWA");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(540, 180, 130, 16);
        getContentPane().add(tharga);
        tharga.setBounds(720, 172, 180, 30);

        bhitung.setBackground(new java.awt.Color(51, 255, 0));
        bhitung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/hitung.png"))); // NOI18N
        bhitung.setText("HITUNG");
        bhitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhitungActionPerformed(evt);
            }
        });
        getContentPane().add(bhitung);
        bhitung.setBounds(910, 340, 110, 29);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("HARI");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(790, 226, 40, 20);

        bkwitansi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/ikonprint.png"))); // NOI18N
        bkwitansi.setText("CETAK KWITANSI");
        bkwitansi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkwitansiActionPerformed(evt);
            }
        });
        getContentPane().add(bkwitansi);
        bkwitansi.setBounds(70, 680, 220, 30);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/BACKGROUND.png"))); // NOI18N
        getContentPane().add(jLabel17);
        jLabel17.setBounds(0, 0, 1100, 810);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ttransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ttransaksiActionPerformed

    private void tnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnamaActionPerformed

    private void tteleponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tteleponActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tteleponActionPerformed

    private void tcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tcariActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        // TODO add your handling code here:
        String  no_transaksi, nama, alamat, no_telp, no_plat, tipe, harga, lama_sewa, total_bayar, dp, total_kekurangan, keterangan;
        
        no_transaksi = ttransaksi.getText();
        nama = tnama.getText();
        alamat = talamat.getText();
        no_telp = ttelepon.getText();
        no_plat = tplat.getText();
        tipe = ttipe.getText();
        harga = tharga.getText();
        lama_sewa = tsewa.getText();
        total_bayar = tbayar.getText();
        dp = tdp.getText();
        total_kekurangan = tkurang.getText();
        keterangan = tketerangan.getText();
        
        if (no_transaksi.equals("")|(nama.equals(""))|(alamat.equals(""))|(no_telp.equals(""))|(no_plat.equals(""))|
           (tipe.equals(""))|(harga.equals(""))|(lama_sewa.equals(""))|(total_bayar.equals(""))|(dp.equals(""))|(total_kekurangan.equals(""))|(keterangan.equals(""))){
            JOptionPane.showMessageDialog(null, "Pengisian Data Tidak Boleh Kosong");
            ttransaksi.requestFocus();
        }else{
        String sql = "insert into data_pelanggan values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, ttransaksi.getText());
            stat.setString(2, tnama.getText());
            String kebutuhan = null;
                    if(rpribadi.isSelected()){
                        kebutuhan = "PRIBADI";
                    }else if(rperusahaan.isSelected()){
                        kebutuhan = "PERUSAHAAN";
                    }
            stat.setString(3, kebutuhan);
            stat.setString(4, talamat.getText());
            stat.setString(5, ttelepon.getText());
            stat.setString(6, tplat.getText());
            stat.setString(7, ttipe.getText());
            stat.setString(8, tharga.getText());
            stat.setString(9, tsewa.getText());
            stat.setString(10, tbayar.getText());
            stat.setString(11, tdp.getText());
            stat.setString(12, tkurang.getText());
            stat.setString(13, tketerangan.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data berhasil disimpan");
            kosong();
            ttransaksi.requestFocus();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Data gagal disimpan" +e);
        }
        datatable();
        autonumber();
        }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void bkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkeluarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_bkeluarActionPerformed

    private void brefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brefreshActionPerformed
        // TODO add your handling code here:
        datatable();
    }//GEN-LAST:event_brefreshActionPerformed

    private void bclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bclearActionPerformed
        // TODO add your handling code here:
        kosong();
        datatable();
        bsimpan.setEnabled(true);
        autonumber();
    }//GEN-LAST:event_bclearActionPerformed

    private void tabeldatapelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabeldatapelangganMouseClicked
        // TODO add your handling code here:
        int bar = tabeldatapelanggan.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();
        String g = tabmode.getValueAt(bar, 6).toString();
        String h = tabmode.getValueAt(bar, 7).toString();
        String i = tabmode.getValueAt(bar, 8).toString();
        String j = tabmode.getValueAt(bar, 9).toString();
        String k = tabmode.getValueAt(bar, 10).toString();
        String l = tabmode.getValueAt(bar, 11).toString();
        String m = tabmode.getValueAt(bar, 12).toString();

        ttransaksi.setText(a);
        tnama.setText(b);
        if("PRIBADI".equals(c)){
                rpribadi.setSelected(true);
            }
            else{
                rperusahaan.setSelected(true);
            }
        talamat.setText(d);
        ttelepon.setText(e);
        tplat.setText(f);
        ttipe.setText(g);
        tharga.setText(h);
        tsewa.setText(i);
        tbayar.setText(j);
        tdp.setText(k);
        tkurang.setText(l);
        tketerangan.setText(m);
        
        bsimpan.setEnabled(false);
    }//GEN-LAST:event_tabeldatapelangganMouseClicked

    private void beditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditActionPerformed
        // TODO add your handling code here:
       try{
            String sql= "update data_pelanggan set nama=?,kebutuhan=?,alamat=?,no_telp=?,no_plat=?,tipe=?,harga=?,lama_sewa=?,total_bayar=?,dp=?,total_kurang=?,keterangan=? where no_transaksi='"+ttransaksi.getText()+"'";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, tnama.getText());
            String kebutuhan = null;
            if(rpribadi.isSelected()){
                kebutuhan = "PRIBADI";
            }else if(rperusahaan.isSelected()){
                kebutuhan = "PERUSAHAAN";
            }
            stat.setString(2, kebutuhan);
            stat.setString(3, talamat.getText());
            stat.setString(4, ttelepon.getText());
            stat.setString(5, tplat.getText());
            stat.setString(6, ttipe.getText());
            stat.setString(7, tharga.getText());
            stat.setString(8, tsewa.getText());
            stat.setString(9, tbayar.getText());
            stat.setString(10, tdp.getText());
            stat.setString(11, tkurang.getText());
            stat.setString(12, tketerangan.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data berhasil diubah");
            kosong();
            ttransaksi.requestFocus();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Data gagal diubah" +e);
        }
        datatable();
        bsimpan.setEnabled(true);
         autonumber();
    }//GEN-LAST:event_beditActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        // TODO add your handling code here:
         int ok = JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus data ini?","Konfirmasi dialog!",JOptionPane.YES_NO_OPTION);
        if (ok==0){
            String sql = "delete from data_pelanggan where no_transaksi ='"+ttransaksi.getText()+"'";
            try{
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                kosong();
                ttransaksi.requestFocus();
            }
            catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Data gagal dihapus"+e);
            }
            datatable();
            bsimpan.setEnabled(true);
            autonumber();
        }
    }//GEN-LAST:event_bhapusActionPerformed

    private void bcari2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcari2ActionPerformed
        // TODO add your handling code here:
         Object[] Baris ={"No Transaksi","Nama","Kebutuhan","Alamat","No. Telepon","No plat","Tipe mobil","Harga","Lama_sewa","Total Bayar","DP","Total kekurangan","Keterangan"};
    tabmode = new 
    DefaultTableModel(null, Baris);
    String cariitem = tcari.getText();
    
    try {
    String sql = "SELECT * FROM data_pelanggan where no_transaksi='"+cariitem+"' "+ "or nama='"+cariitem+"'or kebutuhan='"+cariitem+"'or alamat='"+cariitem+"'or no_telp='"+cariitem+"'or no_plat='"+cariitem+"'or tipe='"+cariitem+"'or harga='"+cariitem+
            "'or lama_sewa='"+cariitem+"'or keterangan='"+cariitem+"'";
    Statement stat = conn.createStatement();
    ResultSet hasil = stat.executeQuery(sql);
    while (hasil.next()){
        tabmode.addRow(new Object[]{
        hasil.getString(1),
        hasil.getString(2),
        hasil.getString(3),
        hasil.getString(4),
        hasil.getString(5),
        hasil.getString(6),
        hasil.getString(7),
        hasil.getString(8),
        hasil.getString(9),
        hasil.getString(10)       
        
    });
    }
    tabeldatapelanggan.setModel(tabmode);
    } catch (Exception e) {
    JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
    }
    }//GEN-LAST:event_bcari2ActionPerformed

    private void rpribadiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rpribadiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rpribadiActionPerformed

    private void rperusahaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rperusahaanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rperusahaanActionPerformed

    private void bcari1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcari1ActionPerformed
        // TODO add your handling code here:
        popupmobil2 Pp = new popupmobil2();
        Pp.mbl = this;
        Pp.setVisible(true);
        Pp.setResizable(false);
    
    }//GEN-LAST:event_bcari1ActionPerformed

    private void tbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbayarActionPerformed
        // TODO add your handling code here;                         
    }//GEN-LAST:event_tbayarActionPerformed

    private void bhitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhitungActionPerformed
        // TODO add your handling code here:
        int x,y,z;
        x = Integer.parseInt(tbayar.getText());
        y = Integer.parseInt(tdp.getText());
        z = x-y;
        tkurang.setText(String.valueOf(z));
    }//GEN-LAST:event_bhitungActionPerformed

    private void tbayarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbayarMouseClicked
        // TODO add your handling code here:
        int x,y,z;
        x = Integer.parseInt(tharga.getText());
        y = Integer.parseInt(tsewa.getText());
        z = x*y;
        String hasil = (Long.toString(z));
        tbayar.setText(hasil); 
    }//GEN-LAST:event_tbayarMouseClicked

    private void bkwitansiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkwitansiActionPerformed
        // TODO add your handling code here:
            try{
            String path = "./src/laporan/notakwitansi.jasper";
            HashMap param = new HashMap();
            param.put("transaksi",ttransaksi.getText());
            JasperPrint print = JasperFillManager.fillReport(path,param,conn);
            JasperViewer.viewReport(print, false);
        }  catch (Exception ex) {
           JOptionPane.showMessageDialog(rootPane,"Dokumen Tidak Ada "+ex);
        }
    }//GEN-LAST:event_bkwitansiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formdatapelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formdatapelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formdatapelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formdatapelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formdatapelanggan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bcari1;
    private javax.swing.JButton bcari2;
    private javax.swing.JButton bclear;
    private javax.swing.JButton bedit;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bhitung;
    private javax.swing.JButton bkeluar;
    private javax.swing.JButton bkwitansi;
    private javax.swing.JButton brefresh;
    private javax.swing.JButton bsimpan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rperusahaan;
    private javax.swing.JRadioButton rpribadi;
    private javax.swing.JTable tabeldatapelanggan;
    private javax.swing.JTextArea talamat;
    private javax.swing.JTextField tbayar;
    private javax.swing.JTextField tcari;
    private javax.swing.JTextField tdp;
    private javax.swing.JTextField tharga;
    private javax.swing.JTextField tketerangan;
    private javax.swing.JTextField tkurang;
    private javax.swing.JTextField tnama;
    private javax.swing.JTextField tplat;
    private javax.swing.JTextField tsewa;
    private javax.swing.JTextField ttelepon;
    private javax.swing.JTextField ttipe;
    private javax.swing.JTextField ttransaksi;
    // End of variables declaration//GEN-END:variables
}