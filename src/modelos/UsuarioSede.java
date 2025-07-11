package modelos;


public class UsuarioSede {

    private int id_usuario_sede, id_usuario, id_sede;

    public UsuarioSede(int id_usuario_sede, int id_usuario, int id_sede) {
        this.id_usuario_sede = id_usuario_sede;
        this.id_usuario = id_usuario;
        this.id_sede = id_sede;
    }

    public int getId_usuario_sede() {
        return id_usuario_sede;
    }

    public void setId_usuario_sede(int id_usuario_sede) {
        this.id_usuario_sede = id_usuario_sede;
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
