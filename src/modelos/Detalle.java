
package modelos;


public class Detalle {
    private int id_det;
    private int cantidad;
    private String descrip;
    private Double precio;
    private Double igv;
    private Double subTotal;
    private Double total;
    private int id_ven;
    private int id_produc;

    public Detalle(int id_det, int cantidad, String descrip, Double precio, Double igv, Double subTotal, Double total, int id_ven, int id_produc) {
        this.id_det = id_det;
        this.cantidad = cantidad;
        this.descrip = descrip;
        this.precio = precio;
        this.igv = igv;
        this.subTotal = subTotal;
        this.total = total;
        this.id_ven = id_ven;
        this.id_produc = id_produc;
    }

    public Detalle() {
    }
    
    

    public int getId_det() {
        return id_det;
    }

    public void setId_det(int id_det) {
        this.id_det = id_det;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getIgv() {
        return igv;
    }

    public void setIgv(Double igv) {
        this.igv = igv;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getId_ven() {
        return id_ven;
    }

    public void setId_ven(int id_ven) {
        this.id_ven = id_ven;
    }

    public int getId_produc() {
        return id_produc;
    }

    public void setId_produc(int id_produc) {
        this.id_produc = id_produc;
    }
    
    
    
}
