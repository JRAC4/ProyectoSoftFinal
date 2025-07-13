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
public class ProductoView {

    private int id_producto, id_categoria;
    private String descripcion, codigo;
    private double precio;
    private int estado;
    private String ubicacion;
    private int id_usuario, id_sede, id_marca, id_igv;
     private String codigo_agrupacion;  
    private double igv_agrupacion;
    private int stock;
    private String descripcion_categoria, marca_descripcion, igv_descripcion;

    public ProductoView(int id_producto, int id_categoria, String descripcion, String codigo, double precio,
            int estado, String ubicacion, int id_usuario, int id_sede, int id_marca, int id_igv, String codigo_agrupacion,
            double igv_agrupacion, int stock, String descripcion_categoria, String marca_descripcion, String igv_descripcion) {
        this.id_producto = id_producto;
        this.id_categoria = id_categoria;
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.precio = precio;
        this.estado = estado;
        this.ubicacion = ubicacion;
        this.id_usuario = id_usuario;
        this.id_sede = id_sede;
        this.id_marca = id_marca;
        this.id_igv = id_igv;
        this.codigo_agrupacion = codigo_agrupacion;
        this.igv_agrupacion = igv_agrupacion;
        this.stock = stock;
        this.descripcion_categoria = descripcion_categoria;
        this.marca_descripcion = marca_descripcion;
        this.igv_descripcion = igv_descripcion;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_sede() {
        return id_sede;
    }

    public void setId_sede(int id_sede) {
        this.id_sede = id_sede;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public int getId_igv() {
        return id_igv;
    }

    public void setId_igv(int id_igv) {
        this.id_igv = id_igv;
    }

    public String getCodigo_agrupacion() {
        return codigo_agrupacion;
    }

    public void setCodigo_agrupacion(String codigo_agrupacion) {
        this.codigo_agrupacion = codigo_agrupacion;
    }

    public double getIgv_agrupacion() {
        return igv_agrupacion;
    }

    public void setIgv_agrupacion(double igv_agrupacion) {
        this.igv_agrupacion = igv_agrupacion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion_categoria() {
        return descripcion_categoria;
    }

    public void setDescripcion_categoria(String descripcion_categoria) {
        this.descripcion_categoria = descripcion_categoria;
    }

    public String getMarca_descripcion() {
        return marca_descripcion;
    }

    public void setMarca_descripcion(String marca_descripcion) {
        this.marca_descripcion = marca_descripcion;
    }

    public String getIgv_descripcion() {
        return igv_descripcion;
    }

    public void setIgv_descripcion(String igv_descripcion) {
        this.igv_descripcion = igv_descripcion;
    }


   
}
