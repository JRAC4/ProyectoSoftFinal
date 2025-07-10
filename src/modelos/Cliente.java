/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;


public class Cliente {
    
    private int idcliente;
    private String tipodocu;
    private int numdocum;
    private String direccion;
    private String celular;
    private String email;
    private String nombre;
    private String estado;
    private int id_tipodocum;

    public Cliente(int idcliente, String tipodocu, int numdocum, String direccion, String celular, String email, String nombre, String estado, int id_tipodocum) {
        this.idcliente = idcliente;
        this.tipodocu = tipodocu;
        this.numdocum = numdocum;
        this.direccion = direccion;
        this.celular = celular;
        this.email = email;
        this.nombre = nombre;
        this.estado = estado;
        this.id_tipodocum = id_tipodocum;
    }

    public Cliente() {
    }

    
    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getTipodocu() {
        return tipodocu;
    }

    public void setTipodocu(String tipodocu) {
        this.tipodocu = tipodocu;
    }

    public int getNumdocum() {
        return numdocum;
    }

    public void setNumdocum(int numdocum) {
        this.numdocum = numdocum;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_tipodocum() {
        return id_tipodocum;
    }

    public void setId_tipodocum(int id_tipodocum) {
        this.id_tipodocum = id_tipodocum;
    }
    
    
    
}
