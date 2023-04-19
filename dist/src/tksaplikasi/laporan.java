/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tksaplikasi;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import koneksi.koneksi;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import java.util.Date;
/**
 *
 * @author asus
 */
public class laporan extends javax.swing.JFrame {
private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    /**
     * Creates new form laporan
     */
    public laporan() {
        initComponents();
        datatablemobil();
        datatablepelanggan();
        datatablemobilkeluar();
        datatablemobilkembali();
        datatablepegawai();
        kosong();
    }
protected void kosong(){
    tgldarikeluar.setDate(null);
    tglsampaikeluar.setDate(null);
    tgldarikembali.setDate(null);
    tglsampaikembali.setDate(null);
    }
    
    private void datatablemobil(){
Object[] Baris ={"Nomor Plat","Merk Mobil","Tipe Mobil","Harga Sewa","Tahun","Keterangan"};
    tabmode = new 
    DefaultTableModel(null, Baris);
    
    
    try {
    String sql = "SELECT * FROM data_mobil ORDER by no_plat";
    Statement stat = conn.createStatement();
    ResultSet hasil = stat.executeQuery(sql);
    while (hasil.next()){
        tabmode.addRow(new Object[]{
        hasil.getString(1),
        hasil.getString(2),
        hasil.getString(3),
        hasil.getString(4),
        hasil.getString(5),
        hasil.getString(6)
    });
    }
    tabellaporanmobil.setModel(tabmode);
    } catch (Exception e) {
    JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
    }
    }
    
     private void datatablepelanggan(){
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
    tabellaporanpelanggan.setModel(tabmode);
    } catch (Exception e) {
    JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
    }
    }
      private void datatablemobilkeluar() {
  Object[] Baris ={"No Transaksi","NIK","Nama","No.Telepon","Nomor Plat","Merk Mobil","Tipe Mobil","Tahun","Tanggal"};
    tabmode = new 
    DefaultTableModel(null, Baris);
    
    
    try {
    String sql = "SELECT * FROM mobilkeluar order by no_transaksi";
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
        hasil.getString(9)
       
    });
    }
    tabellaporanmobilkeluar.setModel(tabmode);
    } catch (Exception e) {
    JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
    }
    } 
      private void datatablemobilkembali() {
    Object[] Baris ={"No Transaksi","Nomor Plat","Merk Mobil","Tipe Mobil","Tahun","Tanggal","Harga","Lama Sewa(hari)","Total"};
    tabmode = new 
    DefaultTableModel(null, Baris);
    try {
    String sql = "SELECT * FROM mobilkembali ORDER by no_transaksi";
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
        hasil.getString(9)
    });
    }
tabellaporanmobilkembali.setModel(tabmode);
    } catch (Exception e) {
    JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
    }
    }
          private void datatablepegawai() {
    Object[] Baris ={"Nik Pegawai","Nama pegawai","Alamat","No.Telepon","Bagian"};
    tabmode = new 
    DefaultTableModel(null, Baris);
    try {
    String sql = "SELECT * FROM data_pegawai ORDER by nik";
    Statement stat = conn.createStatement();
    ResultSet hasil = stat.executeQuery(sql);
    while (hasil.next()){
        tabmode.addRow(new Object[]{
        hasil.getString(1),
        hasil.getString(2),
        hasil.getString(3),
        hasil.getString(4),
        hasil.getString(5)
       
    });
    }
tabeldatapegawai.setModel(tabmode);
    } catch (Exception e) {
    JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
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

        jInternalFrame1 = new javax.swing.JInternalFrame();
        tablaporan = new javax.swing.JTabbedPane();
        panelbarang = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabellaporanmobil = new javax.swing.JTable();
        brefreshmobil = new javax.swing.JButton();
        bprintmobil = new javax.swing.JButton();
        bexitmobil = new javax.swing.JButton();
        panelsupplier = new javax.swing.JPanel();
        brefreshpelanggan = new javax.swing.JButton();
        bprintpelanggan = new javax.swing.JButton();
        bexitpelanggan = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabellaporanpelanggan = new javax.swing.JTable();
        panelpenjualan = new javax.swing.JPanel();
        brefreshmobilkeluar = new javax.swing.JButton();
        bprintkeluar = new javax.swing.JButton();
        bexitmobilkeluar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabellaporanmobilkeluar = new javax.swing.JTable();
        tgldarikeluar = new com.toedter.calendar.JDateChooser();
        tglsampaikeluar = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bprintperiodekeluar = new javax.swing.JButton();
        panelpembelian = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabellaporanmobilkembali = new javax.swing.JTable();
        tgldarikembali = new com.toedter.calendar.JDateChooser();
        tglsampaikembali = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bprintperiodekembali = new javax.swing.JButton();
        brefreshmobilkembali = new javax.swing.JButton();
        bprintmobilkembali = new javax.swing.JButton();
        bexitmobilkembali = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabeldatapegawai = new javax.swing.JTable();
        bprintpegawai = new javax.swing.JButton();
        brefreshpegawai = new javax.swing.JButton();
        bexitpegawai = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1050, 650));
        setResizable(false);
        getContentPane().setLayout(null);

        jInternalFrame1.setIconifiable(true);
        jInternalFrame1.setMaximizable(true);
        jInternalFrame1.setResizable(true);
        jInternalFrame1.setPreferredSize(new java.awt.Dimension(1000, 530));
        jInternalFrame1.setVisible(true);

        tablaporan.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tablaporanAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        panelbarang.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                panelbarangAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        tabellaporanmobil.setModel(new javax.swing.table.DefaultTableModel(
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
        tabellaporanmobil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabellaporanmobilMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabellaporanmobil);

        brefreshmobil.setBackground(new java.awt.Color(255, 255, 255));
        brefreshmobil.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        brefreshmobil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/refresh.png"))); // NOI18N
        brefreshmobil.setText("REFRESH");
        brefreshmobil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        brefreshmobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brefreshmobilActionPerformed(evt);
            }
        });

        bprintmobil.setBackground(new java.awt.Color(255, 255, 255));
        bprintmobil.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bprintmobil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/ikonprint.png"))); // NOI18N
        bprintmobil.setText("PRINT");
        bprintmobil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bprintmobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bprintmobilActionPerformed(evt);
            }
        });

        bexitmobil.setBackground(new java.awt.Color(255, 255, 255));
        bexitmobil.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bexitmobil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/exit.png"))); // NOI18N
        bexitmobil.setText("EXIT");
        bexitmobil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bexitmobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bexitmobilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelbarangLayout = new javax.swing.GroupLayout(panelbarang);
        panelbarang.setLayout(panelbarangLayout);
        panelbarangLayout.setHorizontalGroup(
            panelbarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelbarangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelbarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelbarangLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(panelbarangLayout.createSequentialGroup()
                        .addComponent(brefreshmobil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bprintmobil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 624, Short.MAX_VALUE)
                        .addComponent(bexitmobil)
                        .addGap(42, 42, 42))))
        );
        panelbarangLayout.setVerticalGroup(
            panelbarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelbarangLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addGroup(panelbarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brefreshmobil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bprintmobil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bexitmobil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(242, 242, 242))
        );

        tablaporan.addTab("Laporan Data Mobil", panelbarang);

        brefreshpelanggan.setBackground(new java.awt.Color(255, 255, 255));
        brefreshpelanggan.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        brefreshpelanggan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/refresh.png"))); // NOI18N
        brefreshpelanggan.setText("REFRESH");
        brefreshpelanggan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        brefreshpelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brefreshpelangganActionPerformed(evt);
            }
        });

        bprintpelanggan.setBackground(new java.awt.Color(255, 255, 255));
        bprintpelanggan.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bprintpelanggan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/ikonprint.png"))); // NOI18N
        bprintpelanggan.setText("PRINT");
        bprintpelanggan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bprintpelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bprintpelangganActionPerformed(evt);
            }
        });

        bexitpelanggan.setBackground(new java.awt.Color(255, 255, 255));
        bexitpelanggan.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bexitpelanggan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/exit.png"))); // NOI18N
        bexitpelanggan.setText("EXIT");
        bexitpelanggan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bexitpelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bexitpelangganActionPerformed(evt);
            }
        });

        tabellaporanpelanggan.setModel(new javax.swing.table.DefaultTableModel(
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
        tabellaporanpelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabellaporanpelangganMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabellaporanpelanggan);

        javax.swing.GroupLayout panelsupplierLayout = new javax.swing.GroupLayout(panelsupplier);
        panelsupplier.setLayout(panelsupplierLayout);
        panelsupplierLayout.setHorizontalGroup(
            panelsupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsupplierLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelsupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelsupplierLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 947, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelsupplierLayout.createSequentialGroup()
                        .addComponent(brefreshpelanggan)
                        .addGap(15, 15, 15)
                        .addComponent(bprintpelanggan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bexitpelanggan)
                        .addGap(50, 50, 50))))
        );
        panelsupplierLayout.setVerticalGroup(
            panelsupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsupplierLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(panelsupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bexitpelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bprintpelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(brefreshpelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(320, 320, 320))
        );

        tablaporan.addTab("Laporan Transaksi Pelanggan", panelsupplier);

        brefreshmobilkeluar.setBackground(new java.awt.Color(255, 255, 255));
        brefreshmobilkeluar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        brefreshmobilkeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/refresh.png"))); // NOI18N
        brefreshmobilkeluar.setText("REFRESH");
        brefreshmobilkeluar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        brefreshmobilkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brefreshmobilkeluarActionPerformed(evt);
            }
        });

        bprintkeluar.setBackground(new java.awt.Color(255, 255, 255));
        bprintkeluar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bprintkeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/ikonprint.png"))); // NOI18N
        bprintkeluar.setText("PRINT");
        bprintkeluar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bprintkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bprintkeluarActionPerformed(evt);
            }
        });

        bexitmobilkeluar.setBackground(new java.awt.Color(255, 255, 255));
        bexitmobilkeluar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bexitmobilkeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/exit.png"))); // NOI18N
        bexitmobilkeluar.setText("EXIT");
        bexitmobilkeluar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bexitmobilkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bexitmobilkeluarActionPerformed(evt);
            }
        });

        tabellaporanmobilkeluar.setModel(new javax.swing.table.DefaultTableModel(
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
        tabellaporanmobilkeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabellaporanmobilkeluarMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabellaporanmobilkeluar);

        tgldarikeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tgldarikeluarMouseClicked(evt);
            }
        });

        tglsampaikeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tglsampaikeluarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tglsampaikeluarMouseEntered(evt);
            }
        });
        tglsampaikeluar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tglsampaikeluarPropertyChange(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Dari :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Sampai :");

        bprintperiodekeluar.setBackground(new java.awt.Color(255, 255, 255));
        bprintperiodekeluar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bprintperiodekeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/ikonprint.png"))); // NOI18N
        bprintperiodekeluar.setText("PRINT PERIODE");
        bprintperiodekeluar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bprintperiodekeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bprintperiodekeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelpenjualanLayout = new javax.swing.GroupLayout(panelpenjualan);
        panelpenjualan.setLayout(panelpenjualanLayout);
        panelpenjualanLayout.setHorizontalGroup(
            panelpenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(panelpenjualanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(brefreshmobilkeluar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bprintkeluar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bexitmobilkeluar)
                .addGap(138, 138, 138))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelpenjualanLayout.createSequentialGroup()
                .addContainerGap(524, Short.MAX_VALUE)
                .addGroup(panelpenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(27, 27, 27)
                .addGroup(panelpenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tgldarikeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelpenjualanLayout.createSequentialGroup()
                        .addComponent(tglsampaikeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bprintperiodekeluar)))
                .addGap(79, 79, 79))
        );
        panelpenjualanLayout.setVerticalGroup(
            panelpenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelpenjualanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelpenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tgldarikeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelpenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelpenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(tglsampaikeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(bprintperiodekeluar))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(panelpenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brefreshmobilkeluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bprintkeluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bexitmobilkeluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(89, 89, 89))
        );

        tablaporan.addTab("Laporan Mobil keluar", panelpenjualan);

        panelpembelian.setPreferredSize(new java.awt.Dimension(980, 530));

        tabellaporanmobilkembali.setModel(new javax.swing.table.DefaultTableModel(
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
        tabellaporanmobilkembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabellaporanmobilkembaliMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabellaporanmobilkembali);

        tgldarikembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tgldarikembaliMouseClicked(evt);
            }
        });

        tglsampaikembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tglsampaikembaliMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tglsampaikembaliMouseEntered(evt);
            }
        });
        tglsampaikembali.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tglsampaikembaliPropertyChange(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Dari :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Sampai :");

        bprintperiodekembali.setBackground(new java.awt.Color(255, 255, 255));
        bprintperiodekembali.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bprintperiodekembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/ikonprint.png"))); // NOI18N
        bprintperiodekembali.setText("PRINT PERIODE");
        bprintperiodekembali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bprintperiodekembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bprintperiodekembaliActionPerformed(evt);
            }
        });

        brefreshmobilkembali.setBackground(new java.awt.Color(255, 255, 255));
        brefreshmobilkembali.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        brefreshmobilkembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/refresh.png"))); // NOI18N
        brefreshmobilkembali.setText("REFRESH");
        brefreshmobilkembali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        brefreshmobilkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brefreshmobilkembaliActionPerformed(evt);
            }
        });

        bprintmobilkembali.setBackground(new java.awt.Color(255, 255, 255));
        bprintmobilkembali.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bprintmobilkembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/ikonprint.png"))); // NOI18N
        bprintmobilkembali.setText("PRINT");
        bprintmobilkembali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bprintmobilkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bprintmobilkembaliActionPerformed(evt);
            }
        });

        bexitmobilkembali.setBackground(new java.awt.Color(255, 255, 255));
        bexitmobilkembali.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bexitmobilkembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/exit.png"))); // NOI18N
        bexitmobilkembali.setText("EXIT");
        bexitmobilkembali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bexitmobilkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bexitmobilkembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelpembelianLayout = new javax.swing.GroupLayout(panelpembelian);
        panelpembelian.setLayout(panelpembelianLayout);
        panelpembelianLayout.setHorizontalGroup(
            panelpembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelpembelianLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelpembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGroup(panelpembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelpembelianLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(tgldarikembali, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelpembelianLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tglsampaikembali, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bprintperiodekembali)))
                .addGap(55, 55, 55))
            .addGroup(panelpembelianLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelpembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelpembelianLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 947, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelpembelianLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(brefreshmobilkembali)
                        .addGap(18, 18, 18)
                        .addComponent(bprintmobilkembali)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bexitmobilkembali)
                        .addGap(140, 140, 140))))
        );
        panelpembelianLayout.setVerticalGroup(
            panelpembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelpembelianLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelpembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelpembelianLayout.createSequentialGroup()
                        .addGroup(panelpembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelpembelianLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelpembelianLayout.createSequentialGroup()
                                .addComponent(tgldarikembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)))
                        .addGroup(panelpembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tglsampaikembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addComponent(bprintperiodekembali))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(panelpembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brefreshmobilkembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bprintmobilkembali)
                    .addComponent(bexitmobilkembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(274, 274, 274))
        );

        tablaporan.addTab("Laporan Mobil Kembali", panelpembelian);

        tabeldatapegawai.setModel(new javax.swing.table.DefaultTableModel(
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
        tabeldatapegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabeldatapegawaiMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabeldatapegawai);

        bprintpegawai.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bprintpegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/ikonprint.png"))); // NOI18N
        bprintpegawai.setText("PRINT");
        bprintpegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bprintpegawaiActionPerformed(evt);
            }
        });

        brefreshpegawai.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        brefreshpegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/refresh.png"))); // NOI18N
        brefreshpegawai.setText("REFRESH");
        brefreshpegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brefreshpegawaiActionPerformed(evt);
            }
        });

        bexitpegawai.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bexitpegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/exit.png"))); // NOI18N
        bexitpegawai.setText("EXIT");
        bexitpegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bexitpegawaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(brefreshpegawai)
                .addGap(18, 18, 18)
                .addComponent(bprintpegawai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 606, Short.MAX_VALUE)
                .addComponent(bexitpegawai)
                .addGap(48, 48, 48))
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 971, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bprintpegawai)
                    .addComponent(bexitpegawai)
                    .addComponent(brefreshpegawai))
                .addContainerGap(146, Short.MAX_VALUE))
        );

        tablaporan.addTab("Laporan Data pegawai", jPanel1);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addComponent(tablaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 976, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addComponent(tablaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        getContentPane().add(jInternalFrame1);
        jInternalFrame1.setBounds(20, 70, 1000, 460);

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LAPORAN");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 20, 180, 34);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/BACKGROUND.png"))); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(1050, 651));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1050, 590);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabellaporanmobilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabellaporanmobilMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabellaporanmobilMouseClicked

    private void brefreshmobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brefreshmobilActionPerformed
        // TODO add your handling code here:
        datatablemobil();
        kosong();
        bprintmobil.setEnabled(true);
    }//GEN-LAST:event_brefreshmobilActionPerformed

    private void bprintmobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bprintmobilActionPerformed
        // TODO add your handling code here:

        try{
            String path = "./src/laporan/laporandatamobil.jasper";
            HashMap param = new HashMap();
            //param.put("parameter1", cari.getText());
            JasperPrint print = JasperFillManager.fillReport(path,param,conn);
            JasperViewer.viewReport(print, false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane,"Dokumen Tidak Ada "+ex);
        }
    }//GEN-LAST:event_bprintmobilActionPerformed

    private void bexitmobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bexitmobilActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_bexitmobilActionPerformed

    private void panelbarangAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_panelbarangAncestorAdded
        // TODO add your handling code here:

    }//GEN-LAST:event_panelbarangAncestorAdded

    private void brefreshpelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brefreshpelangganActionPerformed
        // TODO add your handling code here:
        datatablepelanggan();
        kosong();
        bprintpelanggan.setEnabled(true);
    }//GEN-LAST:event_brefreshpelangganActionPerformed

    private void bprintpelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bprintpelangganActionPerformed
        // TODO add your handling code here:
        try{
            String path = "./src/laporan/laporanpelanggan.jasper";
            HashMap param = new HashMap();
            //param.put("parameter1", tcaripelanggan.getText());
            JasperPrint print = JasperFillManager.fillReport(path,param,conn);
            JasperViewer.viewReport(print, false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane,"Dokumen Tidak Ada "+ex);
        }
    }//GEN-LAST:event_bprintpelangganActionPerformed

    private void bexitpelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bexitpelangganActionPerformed
        // TODO add your handling code here
        dispose();
    }//GEN-LAST:event_bexitpelangganActionPerformed

    private void tabellaporanpelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabellaporanpelangganMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabellaporanpelangganMouseClicked

    private void brefreshmobilkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brefreshmobilkeluarActionPerformed
        // TODO add your handling code here:
        datatablemobilkeluar();
        kosong();
        bprintkeluar.setEnabled(true);
    }//GEN-LAST:event_brefreshmobilkeluarActionPerformed

    private void bprintkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bprintkeluarActionPerformed
        // TODO add your handling code here:
        try{
            String path = "./src/laporan/laporanmobilkeluar.jasper";
            HashMap param = new HashMap();
            //param.put("parameter2", tcarikeluar.getText());
            JasperPrint print = JasperFillManager.fillReport(path,param,conn);
            JasperViewer.viewReport(print, false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane,"Dokumen Tidak Ada "+ex);
        }
    }//GEN-LAST:event_bprintkeluarActionPerformed

    private void bexitmobilkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bexitmobilkeluarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_bexitmobilkeluarActionPerformed

    private void tabellaporanmobilkeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabellaporanmobilkeluarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabellaporanmobilkeluarMouseClicked

    private void tgldarikeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tgldarikeluarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tgldarikeluarMouseClicked

    private void tglsampaikeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tglsampaikeluarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tglsampaikeluarMouseClicked

    private void tglsampaikeluarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tglsampaikeluarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tglsampaikeluarMouseEntered

    private void tglsampaikeluarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tglsampaikeluarPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tglsampaikeluarPropertyChange

    private void bprintperiodekeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bprintperiodekeluarActionPerformed
        // TODO add your handling code here:
        try{
            String path = "./src/laporan/laporanperiodemobilkeluar.jasper";
            HashMap param = new HashMap();
            SimpleDateFormat dateFormat = new SimpleDateFormat ("dd-MM-yyy");
            param.put("tgldari", dateFormat.format(tgldarikeluar.getDate()));
            param.put("tglsampai", dateFormat.format(tglsampaikeluar.getDate()));
            JasperPrint print = JasperFillManager.fillReport(path,param,conn);
            JasperViewer.viewReport(print, false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane,"Dokumen Tidak Ada "+ex);
        }
        bprintperiodekeluar.setEnabled(true);
    }//GEN-LAST:event_bprintperiodekeluarActionPerformed

    private void tabellaporanmobilkembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabellaporanmobilkembaliMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabellaporanmobilkembaliMouseClicked

    private void tgldarikembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tgldarikembaliMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tgldarikembaliMouseClicked

    private void tglsampaikembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tglsampaikembaliMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tglsampaikembaliMouseClicked

    private void tglsampaikembaliMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tglsampaikembaliMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tglsampaikembaliMouseEntered

    private void tglsampaikembaliPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tglsampaikembaliPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tglsampaikembaliPropertyChange

    private void bprintperiodekembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bprintperiodekembaliActionPerformed
        // TODO add your handling code here:
        try{
            String path = "./src/laporan/laporanperiodemobilkembali.jasper";
            HashMap param = new HashMap();
            SimpleDateFormat dateFormat = new SimpleDateFormat ("dd-MM-yyy");
            param.put("tgldari", dateFormat.format(tgldarikembali.getDate()));
            param.put("tglsampai", dateFormat.format(tglsampaikembali.getDate()));
            JasperPrint print = JasperFillManager.fillReport(path,param,conn);
            JasperViewer.viewReport(print, false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane,"Dokumen Tidak Ada "+ex);
        }
        bprintperiodekembali.setEnabled(true);
    }//GEN-LAST:event_bprintperiodekembaliActionPerformed

    private void brefreshmobilkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brefreshmobilkembaliActionPerformed
        // TODO add your handling code here:
        datatablemobilkembali();
        kosong();
        bprintmobilkembali.setEnabled(true);
    }//GEN-LAST:event_brefreshmobilkembaliActionPerformed

    private void bprintmobilkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bprintmobilkembaliActionPerformed
        // TODO add your handling code here:
        try{
            String path = "./src/laporan/laporanmobilkembali.jasper";
            HashMap param = new HashMap();
            //param.put("parameter2", tcarikembali.getText());
            JasperPrint print = JasperFillManager.fillReport(path,param,conn);
            JasperViewer.viewReport(print, false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane,"Dokumen Tidak Ada "+ex);
        }
    }//GEN-LAST:event_bprintmobilkembaliActionPerformed

    private void bexitmobilkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bexitmobilkembaliActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_bexitmobilkembaliActionPerformed

    private void tablaporanAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tablaporanAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaporanAncestorAdded

    private void tabeldatapegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabeldatapegawaiMouseClicked
        // TODO add your handling code here
        
    }//GEN-LAST:event_tabeldatapegawaiMouseClicked

    private void bprintpegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bprintpegawaiActionPerformed
        // TODO add your handling code here:
          try{
            String path = "./src/laporan/laporandatapegawai.jasper";
            HashMap param = new HashMap();
            //param.put("parameter2", tcarikembali.getText());
            JasperPrint print = JasperFillManager.fillReport(path,param,conn);
            JasperViewer.viewReport(print, false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane,"Dokumen Tidak Ada "+ex);
        }
    }//GEN-LAST:event_bprintpegawaiActionPerformed

    private void brefreshpegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brefreshpegawaiActionPerformed
        // TODO add your handling code here:
        datatablepegawai();
        kosong();
        bprintpegawai.setEnabled(true);
    }//GEN-LAST:event_brefreshpegawaiActionPerformed

    private void bexitpegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bexitpegawaiActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_bexitpegawaiActionPerformed

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
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new laporan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bexitmobil;
    private javax.swing.JButton bexitmobilkeluar;
    private javax.swing.JButton bexitmobilkembali;
    private javax.swing.JButton bexitpegawai;
    private javax.swing.JButton bexitpelanggan;
    private javax.swing.JButton bprintkeluar;
    private javax.swing.JButton bprintmobil;
    private javax.swing.JButton bprintmobilkembali;
    private javax.swing.JButton bprintpegawai;
    private javax.swing.JButton bprintpelanggan;
    private javax.swing.JButton bprintperiodekeluar;
    private javax.swing.JButton bprintperiodekembali;
    private javax.swing.JButton brefreshmobil;
    private javax.swing.JButton brefreshmobilkeluar;
    private javax.swing.JButton brefreshmobilkembali;
    private javax.swing.JButton brefreshpegawai;
    private javax.swing.JButton brefreshpelanggan;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel panelbarang;
    private javax.swing.JPanel panelpembelian;
    private javax.swing.JPanel panelpenjualan;
    private javax.swing.JPanel panelsupplier;
    private javax.swing.JTable tabeldatapegawai;
    private javax.swing.JTable tabellaporanmobil;
    private javax.swing.JTable tabellaporanmobilkeluar;
    private javax.swing.JTable tabellaporanmobilkembali;
    private javax.swing.JTable tabellaporanpelanggan;
    private javax.swing.JTabbedPane tablaporan;
    private com.toedter.calendar.JDateChooser tgldarikeluar;
    private com.toedter.calendar.JDateChooser tgldarikembali;
    private com.toedter.calendar.JDateChooser tglsampaikeluar;
    private com.toedter.calendar.JDateChooser tglsampaikembali;
    // End of variables declaration//GEN-END:variables
}
