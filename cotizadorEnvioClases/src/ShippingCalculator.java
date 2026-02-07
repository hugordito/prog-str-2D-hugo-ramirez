public class ShippingCalculator {

private final double IVA = 0.16;

public double calcularSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean zonaRemota) {

double subtotal = 0;

//Servicio base
if (tipoServicio == 1) {
subtotal += 50;
} else {
subtotal += 90;
}

//Costo por peso
subtotal += pesoKg * 12;

//Costo por distancia
if (distanciaKm <= 50) {
subtotal += 20;
} else if (distanciaKm <= 200) {
subtotal += 60;
} else {
subtotal += 120;
}

//Zona remota
if (zonaRemota) {
subtotal += subtotal * 0.10;
}

return subtotal;
}

public double calcularIVA(double subtotal) {
return subtotal * IVA;
}

public double calcularTotal(double subtotal, double iva) {
return subtotal + iva;
}

}
