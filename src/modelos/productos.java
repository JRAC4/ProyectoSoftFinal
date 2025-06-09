/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author jesus
 */
public class productos {
    private int id_cat;
    private String descrip;
    private String codig;
    private String tipo_afec;
    private Double precio;
    private String estado;
    private int stock;
    private int id_marca;
    private int id_fac_cat7_igv;
    private int id_producto;

    public productos(int id_producto,int id_cat, String descrip, String codig, String tipo_afec, Double precio, String estado, int stock, int id_marca, int id_fac_cat7_igv) {
        this.id_cat = id_cat;
        this.descrip = descrip;
        this.codig = codig;
        this.tipo_afec = tipo_afec;
        this.precio = precio;
        this.estado = estado;
        this.stock = stock;
        this.id_marca = id_marca;
        this.id_fac_cat7_igv = id_fac_cat7_igv;
        this.id_producto=id_producto;
    }

    public productos() {
    }
        
    


    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }
    
    
    
    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getCodig() {
        return codig;
    }

    public void setCodig(String codig) {
        this.codig = codig;
    }

    public String getTipo_afec() {
        return tipo_afec;
    }

    public void setTipo_afec(String tipo_afec) {
        this.tipo_afec = tipo_afec;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public int getId_fac_cat7_igv() {
        return id_fac_cat7_igv;
    }

    public void setId_fac_cat7_igv(int id_fac_cat7_igv) {
        this.id_fac_cat7_igv = id_fac_cat7_igv;
    }
    
    
    
}
