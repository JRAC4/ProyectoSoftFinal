package modelos;

/**
 *
 * @author frank
 */
public class GrupoIgv {

    private int id_grupo_igv;
    private String codigo, descripcion;
    private double igv;
    private int estado_view;

    public GrupoIgv(int id_grupo_igv, String codigo, String descripcion,
            double igv,int estado_view) {
        this.id_grupo_igv = id_grupo_igv;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.igv = igv;
        this.estado_view = estado_view;
    }

    public int getId_grupo_igv() {
        return id_grupo_igv;
    }

    public void setId_grupo_igv(int id_grupo_igv) {
        this.id_grupo_igv = id_grupo_igv;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public int getEstado_view() {
        return estado_view;
    }

    public void setEstado_view(int estado_view) {
        this.estado_view = estado_view;
    }

}
