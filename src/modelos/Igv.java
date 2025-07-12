/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author frank
 */
public class Igv {

    private int id_igv;
    private String codigo, descripcion,codigo_tributo;
    private int estado_view;

    public Igv(int id_fac_cat7_igv, String codigo, String descripcion,
            String codigo_tributo,int estado_view) {
        this.id_igv = id_fac_cat7_igv;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.codigo_tributo = codigo_tributo;
        this.estado_view = estado_view;
    }

    public int getId_igv() {
        return id_igv;
    }

    public void setId_igv(int id_igv) {
        this.id_igv = id_igv;
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

    public String getCodigo_tributo() {
        return codigo_tributo;
    }

    public void setCodigo_tributo(String codigo_tributo) {
        this.codigo_tributo = codigo_tributo;
    }

    public int getEstado_view() {
        return estado_view;
    }

    public void setEstado_view(int estado_view) {
        this.estado_view = estado_view;
    }

}
