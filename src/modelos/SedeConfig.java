package modelos;


public class SedeConfig {

    private int id_sedeconfig, id_sede, modelo_codbar;
    private String sede;

    public SedeConfig(int id_sedeconfig, int id_sede, int modelo_codbar,String sede) {
        this.id_sedeconfig = id_sedeconfig;
        this.id_sede = id_sede;
        this.modelo_codbar = modelo_codbar;
        this.sede = sede;
    }

    public int getId_sedeconfig() {
        return id_sedeconfig;
    }

    public void setId_sedeconfig(int id_sedeconfig) {
        this.id_sedeconfig = id_sedeconfig;
    }

    public int getId_sede() {
        return id_sede;
    }

    public void setId_sede(int id_sede) {
        this.id_sede = id_sede;
    }

    public int getModelo_codbar() {
        return modelo_codbar;
    }

    public void setModelo_codbar(int modelo_codbar) {
        this.modelo_codbar = modelo_codbar;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

}
