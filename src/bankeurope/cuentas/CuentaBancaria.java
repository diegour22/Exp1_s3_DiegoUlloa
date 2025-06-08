package bankeurope.cuentas; // Indica que esta clase está en el paquete cuentas

// Clase abstracta base para representar una cuenta bancaria
public abstract class CuentaBancaria {
    protected String numeroCuenta;
    protected int saldo;

    // Constructor con parámetros (verifica número de cuenta válido)
    public CuentaBancaria(String numeroCuenta, int saldoInicial) {
        if (!numeroCuenta.matches("\\d{9}")) {
            throw new IllegalArgumentException("Número de cuenta inválido (deben ser 9 dígitos).");
        }
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    // Constructor sin parámetros (opcional para pruebas)
    public CuentaBancaria() {
        this.numeroCuenta = "000000000";
        this.saldo = 0;
    }

    // Métodos accesores (getters)
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    // Metodo para depositar dinero
    public void depositar(int monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito exitoso. Saldo: " + saldo);
        }
    }

    // Metodo para girar dinero
    public void girar(int monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Giro exitoso. Saldo: " + saldo);
        } else {
            System.out.println("Fondos insuficientes o monto inválido.");
        }
    }

    // Mmetodo abstracto obligatorio para subclases
    public abstract void calcularInteres();
}
