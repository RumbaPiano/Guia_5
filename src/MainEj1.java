import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.util.Scanner;

public class MainEj1 {
    public static void main(String[] args) {
        String ruta="D:\\Documentos\\Facultad\\Curso Java\\Proyectos\\Guia_5\\ListaDeProductos.txt";
        Path archivo1 = Paths.get(ruta);
        try{
            FileReader fr = new FileReader(ruta);
            BufferedReader bf = new BufferedReader(fr);
            int lineas= (int) bf.lines().count();
            Producto[] prod = new Producto[lineas];
            int iter=0;
            try {
                for(String linea : Files.readAllLines(archivo1)) {
                    String[] datos = linea.split(";");
                    prod[iter] = new Producto(datos[0],Integer.parseInt(datos[1]),Double.parseDouble(datos[2]));
                    iter++;
                }
                System.out.println("Lista de productos:\n");
                for(int i=0;i<lineas;i++){
                    System.out.println(prod[i].getNombre() +"|Cod:"+ prod[i].getCodigo() +"|$"+ prod[i].getPrecio());
                }
                //Scanner leer = new Scanner(System.in);

                //Se crea un carrito nuevo
                Carrito carrito1 = new Carrito();

                //Se agregan items al carrito
                carrito1.agregarItem(prod[0],2);
                carrito1.agregarItem(prod[1],2);
                carrito1.agregarItem(prod[7],2);

                System.out.println("\nSe agregaron los siguientes productos a su carrito:\n");
                for(ItemCarrito item : carrito1.getItems()){
                    System.out.println(item.getProducto().getNombre()+" * "+item.getCantidad()+" = $"+item.getPrecioTotal());
                }
                System.out.println("Total = $"+carrito1.getPrecioTotal()+" en "+carrito1.getCantidadTotal()+" unidades");

                //Se aplican descuentos

                DescuentoPorCantidad desc1 = new DescuentoPorCantidad("descuento por 6 u",15,6);
                DescuentoPorMonto desc2 = new DescuentoPorMonto("descuento compra mayor a $2000",10,2000);
                double precioFinal;
                if(desc1.aplicaDescuento(carrito1.getCantidadTotal())){
                    precioFinal= desc1.aplicarDescuento(carrito1.getPrecioTotal());
                    System.out.println("Se aplico "+desc1.getNombre()+" de "+desc1.getPorcentajeDescuento()+"%");
                }else if(desc2.aplicaDescuento(carrito1.getPrecioTotal())){
                    precioFinal= desc2.aplicarDescuento(carrito1.getPrecioTotal());
                    System.out.println("Se aplico "+desc2.getNombre()+" de "+desc1.getPorcentajeDescuento()+"%");
                }else{
                    precioFinal= carrito1.getPrecioTotal();
                    System.out.println("No se aplicaron descuentos");
                }
                System.out.println("El precio final es = $"+precioFinal);

            }catch(IOException IOE) {
                System.out.println("No se pudo leer el archivo de productos!");
            }
        }catch(FileNotFoundException FNFE){
            System.out.println("No se pudo abrir el archivo para leer la cantidad de productos!");
        }
    }
}
