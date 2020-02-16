/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package priomvc.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Firman Wisambudi
 */
public class TableModelBarang  extends AbstractTableModel{
    
    List<Barang> lb;

    public TableModelBarang(List<Barang> lb) {
        this.lb = lb;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }


    public int getRowCount() {
        return lb.size();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Barang";
            case 2:
                return "Harga Beli";
            case 3:
                return "Harga Jual";
            case 4:
                return "Stok";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return lb.get(row).getId();
            case 1:
                return lb.get(row).getBarang();
            case 2:
                return lb.get(row).getHargaJual();
            case 3:
                return lb.get(row).getHargaBeli();
            case 4:
                return lb.get(row).getStok();
            default:
                return null;
        }
    }
}
