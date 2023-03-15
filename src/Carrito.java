import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<ItemCarrito> items;

    public Carrito() {
        this.items = new ArrayList<ItemCarrito>();
    }
    public void agregarItem(Producto producto, int cantidad) {
        items.add(new ItemCarrito(producto, cantidad));
    }
    public void eliminarItem(int indice) {
        items.remove(indice);
    }
    public List<ItemCarrito> getItems(){
        return items;
    }
    public double getPrecioTotal(){
        double sumaTotal=0;
        for(ItemCarrito item : items){
            sumaTotal=sumaTotal+item.getPrecioTotal();
        }
        return sumaTotal;
    }

    public int getCantidadTotal(){
        int cantidadTotal=0;
        for(ItemCarrito item : items){
            cantidadTotal=cantidadTotal+item.getCantidad();
        }
        return cantidadTotal;
    }
}

