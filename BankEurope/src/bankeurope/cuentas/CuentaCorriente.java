package bankeurope.cuentas;

public class CuentaCorriente extends CuentaBancaria {

    // Constructor que llama al constructor de la clase padre
    public CuentaCorriente(String numeroCuenta, int saldoInicial) {
        super(numeroCuenta, saldoInicial);
    }

    // Implementación del metrodo abstracto CalcularInteres
    @Override
    public void calcularInteres() {
        System.out.println("Cuenta Corriente no genera intereses.");
    }
}
