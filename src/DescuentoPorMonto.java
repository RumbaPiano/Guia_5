public class DescuentoPorMonto extends Descuento{
    private double montoMinimo;

    public DescuentoPorMonto(String nombre, double porcentajeDescuento, int montoMinimo){
        super (nombre, porcentajeDescuento);
        this.montoMinimo=montoMinimo;
    }

    public double getMontoMinimo() {
        return montoMinimo;
    }
    public boolean aplicaDescuento(double monto){
        return monto>=montoMinimo;
    }
}
