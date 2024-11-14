/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class crud {
    private String jdbcURL="jdbc:mysql://localhost:3306/2210010111_pertambangan";
    private String username="root";
    private String password="";
    
    private DefaultTableModel Modelnya;
    private TableColumn Kolomnya;
    
    public crud(){}
            
    public Connection getKoneksiDB() throws SQLException {
        try {
            Driver mysqldriver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(mysqldriver);
            System.out.println("Koneksi DB Berhasil");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return DriverManager.getConnection(jdbcURL, username, password);
    }
    
    public boolean DuplicateKey(String NamaTabel, String PrimaryKey, String isiData){
        boolean hasil=false;
        int jumlah=0;
        try {
            String SQL="SELECT * FROM "+NamaTabel+" WHERE "+PrimaryKey+" ='"+isiData+"'";
            Statement perintah = getKoneksiDB().createStatement();
            ResultSet hasilData = perintah.executeQuery(SQL);
            while(hasilData.next()){
                jumlah++;
            }
            
            if (jumlah==1) { hasil=true;} else { hasil=false;}
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return hasil;
    }

    public String getFieldTabel(String[] FieldTabelnya){
    String hasilnya = "";
    int deteksiIndexAkhir = FieldTabelnya.length - 1;
    try {
        for (int i = 0; i < FieldTabelnya.length; i++) {
            if (i == deteksiIndexAkhir) {
                hasilnya = hasilnya + FieldTabelnya[i];
            } else {
                hasilnya = hasilnya + FieldTabelnya[i] + ",";
            }
        }
    } catch (Exception e) {
        System.out.println(e.toString());
    }
    return "(" + hasilnya + ")";
}

public String getIsiTabel(String[] IsiTabelnya){
    String hasilnya = "";
    int deteksiIndexAkhir = IsiTabelnya.length - 1;
    try {
        for (int i = 0; i < IsiTabelnya.length; i++) {
            // Tambahkan tanda kutip untuk setiap isi data
            if (i == deteksiIndexAkhir) {
                hasilnya = hasilnya + "'" + IsiTabelnya[i] + "'";
            } else {
                hasilnya = hasilnya + "'" + IsiTabelnya[i] + "',";
            }
        }
    } catch (Exception e) {
        System.out.println(e.toString());
    }
    return "(" + hasilnya + ")";
}

    
    public void simpanDinamis(String NamaTabel, String[] Fieldnya, String[] isinya) {
    try {
        Statement perintah = getKoneksiDB().createStatement();  // Tambahkan pembuatan Statement
        String SQLSave = "INSERT INTO " + NamaTabel + " " + getFieldTabel(Fieldnya) +
                         " VALUES " + getIsiTabel(isinya);
        perintah.executeUpdate(SQLSave);
        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
    } catch (Exception e) {
        System.out.println(e.toString());
        
    }

    }
    
     public String getFieldValueEdit(String[] Field, String[] value){
        String hasil = "";
        int deteksi = Field.length-1;
        try {
            for (int i = 0; i < Field.length; i++) {
                if (i==deteksi){
                    hasil = hasil +Field[i]+" ='"+value[i]+"'";
                }else{
                   hasil = hasil +Field[i]+" ='"+value[i]+"',";  
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return hasil;
    }
     
     public void UbahDinamis(String NamaTabel, String PrimaryKey, String IsiPrimary,String[] Field, String[] Value){
        
        try {
           String SQLUbah = "UPDATE "+NamaTabel+" SET "+getFieldValueEdit(Field, Value)+" WHERE "+PrimaryKey+"='"+IsiPrimary+"'";
           Statement perintah = getKoneksiDB().createStatement();
           perintah.executeUpdate(SQLUbah);
           JOptionPane.showMessageDialog(null,"Data Berhasil Diubah");
           perintah.close();
           getKoneksiDB().close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        
    }
 
      public void HapusDinamis(String NamaTabel, String PK, String isi){
        try {
            String SQL="DELETE FROM "+NamaTabel+" WHERE "+PK+"='"+isi+"'";
            Statement perintah = getKoneksiDB().createStatement();
            perintah.executeUpdate(SQL);
            perintah.close();
            JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
      
      
 
}
