package modelos;

/**
 *
 * @author frank
 */
public class Cntcarga {

    private int id_cntcarga;
    private int cantidad;
    private int estado;

    public Cntcarga(int id_cntcarga, int cantidad, int estado) {
        this.id_cntcarga = id_cntcarga;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public int getIdcant_carga() {
        return id_cntcarga;
    }

    public void setIdcant_carga(int id_cntcarga) {
        this.id_cntcarga = id_cntcarga;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
 
}
