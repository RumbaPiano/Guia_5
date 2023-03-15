
public class Producto {
    private String nombre;
    private int codigo;
    private double precio;
    private int cantidad;

    public Producto(String nombre, int codigo, double precio){
        this.nombre=nombre;
        this.codigo=codigo;
        this.precio=precio;
    }
    public String getNombre(){
        return this.nombre;
    }
    public int getCodigo(){
        return this.codigo;
    }
    public double getPrecio(){
        return this.precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
