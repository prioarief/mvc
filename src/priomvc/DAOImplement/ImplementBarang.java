/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package priomvc.DAOImplement;

import priomvc.model.Barang;
import java.util.List;
/**
 *
 * @author Firman Wisambudi
 */
public interface ImplementBarang {
    
    public void insert(Barang b);

    public void update(Barang b);

    public void delete(int id);

    public List<Barang> getALL();

    public List<Barang> getCariNama(String nama);
}
