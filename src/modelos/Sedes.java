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
public class Sedes {

    private int id_sede;
    private String descripcion, direccion, celular, ruc;
    private String email_origen, foto;
    private int estado;
    private String serie_boleta,serie_factura;

    public Sedes(int id_sede, String descripcion, String direccion, String celular,
            String ruc, String email_origen, String foto,
            int estado,String serie_boleta,String serie_factura) {
        this.id_sede = id_sede;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.celular = celular;
        this.ruc = ruc;
        this.email_origen = email_origen;
        this.foto = foto;
        this.estado = estado;
        this.serie_boleta = serie_boleta;
        this.serie_factura = serie_factura;
    }

    public int getId_sede() {
        return id_sede;
    }

    public void setId_sede(int id_sede) {
        this.id_sede = id_sede;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getEmail_origen() {
        return email_origen;
    }

    public void setEmail_origen(String email_origen) {
        this.email_origen = email_origen;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getSerie_boleta() {
        return serie_boleta;
    }

    public void setSerie_boleta(String serie_boleta) {
        this.serie_boleta = serie_boleta;
    }

    public String getSerie_factura() {
        return serie_factura;
    }

    public void setSerie_factura(String serie_factura) {
        this.serie_factura = serie_factura;
    }


}
