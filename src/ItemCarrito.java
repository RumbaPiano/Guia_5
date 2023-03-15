public class ItemCarrito {
    private Producto producto;
    private int cantidad;

    public ItemCarrito(Producto producto, int cantidad){
        this.producto=producto;
        this.cantidad=cantidad;
    }
    public Producto getProducto(){
        return this.producto;
    }
    public int getCantidad(){
        return this.cantidad;
    }
    public double getPrecioTotal(){
        return producto.getPrecio()*cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
