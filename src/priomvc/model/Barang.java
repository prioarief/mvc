/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package priomvc.model;


/**
 *
 * @author Firman Wisambudi
 */
public class Barang {
    
    private Integer id;
    private String barang;
    private Integer harga_jual;
    private Integer harga_beli;
    private Integer stok;
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getBarang()
    {
        return barang;
    }
    
    public void setBarang(String barang)
    {
        this.barang = barang;
    }
    
    public Integer getHargaJual()
    {
        return harga_jual;
    }
    
    public void setHargaJual(Integer harga_jual)
    {
        this.harga_jual = harga_jual;
    }
    
    public Integer getHargaBeli()
    {
        return harga_beli;
    }
    
    public void setHargaBeli(Integer harga_beli)
    {
        this.harga_beli = harga_beli;
    }
    
    public Integer getStok()
    {
        return stok;
    }
    
    public void setStok(Integer stok)
    {
        this.stok = stok;
    }

    

}