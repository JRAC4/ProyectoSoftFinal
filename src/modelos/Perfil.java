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
public class Perfil {

    private int id_perfil;
    private String descripcion;
    private int estado ;
 
    public Perfil(int id_perfil, String descripcion, int estado ) {
        this.id_perfil = id_perfil;
        this.descripcion = descripcion;
        this.estado = estado; 
    }
 

    public int getId_perfil() {
        return id_perfil;
    }

    public void setIdarea(int id_perfil) {
        this.id_perfil = id_perfil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
