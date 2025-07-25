package modelos;

/**
 *
 * @author frank
 */
public class Categoria {

    private int id_categoria;
    private String descripcion;
    private int estado,id_usuario,id_sede;
 
    public Categoria(int id_categoria, String descripcion, int estado, int id_usuario , int id_sede ) {
        this.id_categoria = id_categoria;
        this.descripcion = descripcion;
        this.estado = estado; 
        this.id_usuario = id_usuario; 
        this.id_sede = id_sede; 
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
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
   
}
