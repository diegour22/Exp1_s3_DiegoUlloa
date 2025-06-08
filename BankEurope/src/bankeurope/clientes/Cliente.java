package bankeurope.clientes;

import bankeurope.cuentas.CuentaBancaria;

// Clase Cliente que implementa la interfaz InfoCliente
public class Cliente implements InfoCliente {
    private String nombre;
    private String rut;
    private CuentaBancaria cuenta;

    // Constructor con validación de formato RUT y cuenta
    public Cliente(String nombre, String rut, CuentaBancaria cuenta) {
        // Validar RUT: debe tener el formato chileno con puntos y guion (ej: 12.345.678-9)
        if (!rut.matches("\\d{1,2}\\.\\d{3}\\.\\d{3}-[\\dkK]")) {
            throw new IllegalArgumentException("RUT inválido. Formato esperado: XX.XXX.XXX-X");
        }

        this.nombre = nombre;
        this.rut = rut;
        this.cuenta = cuenta;
    }

    // Getter para acceder al RUT desde otras clases
    public String getRut() {
        return rut;
    }

    // Getter para acceder a la cuenta desde otras clases
    public CuentaBancaria getCuenta() {
        return cuenta;
    }

    // Implementación del metodo obligatorio para la interfaz
    @Override
    public void mostrarInformacionCliente() {
        System.out.println("Nombre: " + nombre);
        System.out.println("RUT: " + rut);
        System.out.println("Número de cuenta: " + cuenta.getNumeroCuenta());
        System.out.println("Saldo actual: " + cuenta.getSaldo());
        cuenta.calcularInteres(); // Polimorfismo: cada tipo de cuenta ejecuta su propio metodo
    }
}
