/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package priomvc.controller;

import priomvc.DAO.DaoBarang;
import priomvc.DAOImplement.ImplementBarang;
import priomvc.model.Barang;
import priomvc.model.TableModelBarang;
import priomvc.view.Form;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Firman Wisambudi
 */
public class ControllerBarang {
    
    Form frame;
    ImplementBarang implMahasiswa;
    List<Barang> lb;

    public ControllerBarang(Form frame) {
        this.frame = frame;
        implMahasiswa = new DaoBarang();
        lb = implMahasiswa.getALL();
    }

    //mengosongkan field
    public void reset() {
        frame.getTxtID().setText("");
        frame.getBarang().setText("");
        frame.getHB().setText("");
        frame.getHJ().setText("");
        frame.getStok().setText("");
        
    }

    //menampilkan data ke dalam tabel
    public void isiTable() {
        lb = implMahasiswa.getALL();
        TableModelBarang tmb = new TableModelBarang(lb);
        frame.getTabelData().setModel(tmb);
    }

    //merupakan fungsi untuk menampilkan data yang dipilih dari tabel
    public void isiField(int row) {
        frame.getTxtID().setText(lb.get(row).getId().toString());
        frame.getBarang().setText(lb.get(row).getBarang());
        frame.getHB().setText(lb.get(row).getHargaBeli().toString());
        frame.getHJ().setText(lb.get(row).getHargaJual().toString());
        frame.getStok().setText(lb.get(row).getStok().toString());
    }

    //merupakan fungsi untuk insert data berdasarkan inputan user dari textfield di frame
    public void insert() {
        
      if (!frame.getHB().getText().trim().isEmpty()& !frame.getBarang().getText().trim().isEmpty()) {
          
        Barang b = new Barang();
        b.setBarang(frame.getBarang().getText());
        b.setHargaBeli(Integer.parseInt(frame.getHB().getText()));
        b.setHargaJual(Integer.parseInt(frame.getHJ().getText()));
        b.setStok(Integer.parseInt(frame.getStok().getText()));

        implMahasiswa.insert(b);
        JOptionPane.showMessageDialog(null, "Simpan Data sukses");
        
        } else {
            JOptionPane.showMessageDialog(frame, "Data Tidak Boleh Kosong");
        }
    }

    //berfungsi untuk update data berdasarkan inputan user dari textfield di frame
    public void update() {
   if (!frame.getHB().getText().trim().isEmpty()) {
             
        Barang b = new Barang();
        b.setBarang(frame.getBarang().getText());
        b.setHargaBeli(Integer.parseInt(frame.getHB().getText()));
        b.setHargaJual(Integer.parseInt(frame.getHJ().getText()));
        b.setStok(Integer.parseInt(frame.getStok().getText()));
        b.setId(Integer.parseInt(frame.getTxtID().getText()));
        implMahasiswa.update(b);
        
        JOptionPane.showMessageDialog(null, "Update Data  sukses");
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih data yang akan di ubah");
        }
    }

    //berfungsi menghapus data yang dipilih
    public void delete() {
        if (!frame.getHB().getText().trim().isEmpty()) {
            int id = Integer.parseInt(frame.getTxtID().getText());
            implMahasiswa.delete(id);
            
            JOptionPane.showMessageDialog(null, "Hapus Data  sukses");
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih data yang akan di hapus");
        }
    }

    public void isiTableCariNama() {
        lb = implMahasiswa.getCariNama(frame.getTxtCariBarang().getText());
        TableModelBarang tmb = new TableModelBarang(lb);
        frame.getTabelData().setModel(tmb);
    }

    public void carinama() {
        if (!frame.getTxtCariBarang().getText().trim().isEmpty()) {
            implMahasiswa.getCariNama(frame.getTxtCariBarang().getText());
            isiTableCariNama();
        } else {
            JOptionPane.showMessageDialog(frame, "SILAHKAN PILIH DATA");
        }
    }
}
