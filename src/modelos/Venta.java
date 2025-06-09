
package modelos;

public class Venta {
    private int id;
    private int cliente;
    private String nombre_cli;
    private String vendedor;
    private double total;
    private String fecha;
    private int cantidad;
    private int descripcion;
    private String serie;
    private String documento;
    private String hora;
    private int igv;
    private double subtotal;
    private String leyenda;
    private int totalexonerado;
    private int totalgravado;
    private String tipoFac;
    private String estado;
    private int idsede;
    private int idUsuario;
    
    public Venta(){
        
    }

    public Venta(int idUsuario,int id, int cliente, String nombre_cli, String vendedor, double total, String fecha, int cantidad, int descripcion, String serie, String documento, String hora, int igv, double subtotal, String leyenda, int totalexonerado, int totalgravado, String tipoFac, String estado, int idsede) {
        this.id = id;
        this.cliente = cliente;
        this.nombre_cli = nombre_cli;
        this.vendedor = vendedor;
        this.total = total;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.serie = serie;
        this.documento = documento;
        this.hora = hora;
        this.igv = igv;
        this.subtotal = subtotal;
        this.leyenda = leyenda;
        this.totalexonerado = totalexonerado;
        this.totalgravado = totalgravado;
        this.tipoFac = tipoFac;
        this.estado = estado;
        this.idsede = idsede;
        this.idUsuario=idUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public String getNombre_cli() {
        return nombre_cli;
    }

    public void setNombre_cli(String nombre_cli) {
        this.nombre_cli = nombre_cli;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(int descripcion) {
        this.descripcion = descripcion;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getIgv() {
        return igv;
    }

    public void setIgv(int igv) {
        this.igv = igv;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getLeyenda() {
        return leyenda;
    }

    public void setLeyenda(String leyenda) {
        this.leyenda = leyenda;
    }

    public int getTotalexonerado() {
        return totalexonerado;
    }

    public void setTotalexonerado(int totalexonerado) {
        this.totalexonerado = totalexonerado;
    }

    public int getTotalgravado() {
        return totalgravado;
    }

    public void setTotalgravado(int totalgravado) {
        this.totalgravado = totalgravado;
    }

    public String getTipoFac() {
        return tipoFac;
    }

    public void setTipoFac(String tipoFac) {
        this.tipoFac = tipoFac;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdsede() {
        return idsede;
    }

    public void setIdsede(int idsede) {
        this.idsede = idsede;
    }

    

    
}
