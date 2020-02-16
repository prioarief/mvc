 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package priomvc.DAO;

import priomvc.koneksi.koneksi;
import priomvc.model.Barang;
import priomvc.DAOImplement.ImplementBarang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Firman Wisambudi
 */
public class DaoBarang implements ImplementBarang{
    
    Connection connection;
    final String insert = "INSERT INTO barang (barang, harga_beli,harga_jual, stok) VALUES (?, ?, ?,?);";
    final String update = "UPDATE barang set barang=?, harga_beli=?, harga_jual=?, stok=? where id=? ;";
    final String delete = "DELETE FROM barang where id=? ;";
    final String select = "SELECT * FROM barang;";
    final String caribarang = "SELECT * FROM barang where barang like ?";
    
    public DaoBarang() {
        connection = koneksi.connection();
    }

    public void insert(Barang b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, b.getBarang());
            statement.setInt(2, b.getHargaBeli());
            statement.setInt(3, b.getHargaJual());
            statement.setInt(4, b.getStok());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                b.setId(rs.getInt(1));
            }
            
        } catch (SQLException ex) {
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
            }
        }
    }

    public void update(Barang b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, b.getBarang());
            statement.setInt(2, b.getHargaBeli());
            statement.setInt(3, b.getHargaJual());
            statement.setInt(4, b.getStok());
            statement.setInt(5, b.getId());
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public List<Barang> getALL() {
        List<Barang> lb = null;
        try {
            lb = new ArrayList<Barang>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Barang b = new Barang();
                b.setId(rs.getInt("id"));
                b.setBarang(rs.getString("barang"));
                b.setHargaBeli(rs.getInt("harga_beli"));
                b.setHargaJual(rs.getInt("harga_jual"));
                b.setStok(rs.getInt("stok"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoBarang.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lb;
    }

    public List<Barang> getCariNama(String nama) {
        List<Barang> lb = null;
        try {
            lb = new ArrayList<Barang>();
            PreparedStatement st = connection.prepareStatement(caribarang);
            st.setString(1, "%" + nama + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Barang b = new Barang();
                b.setId(rs.getInt("id"));
                b.setBarang(rs.getString("barang"));
                b.setHargaBeli(rs.getInt("harga_beli"));
                b.setHargaJual(rs.getInt("harga_jual"));
                b.setStok(rs.getInt("stok"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }
}
