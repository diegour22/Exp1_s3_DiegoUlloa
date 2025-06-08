package bankeurope.cuentas;

public class CuentaAhorros extends CuentaBancaria {

    public CuentaAhorros(String numeroCuenta, int saldoInicial) {
        super(numeroCuenta, saldoInicial);
    }

    @Override
    public void calcularInteres() {
        double interes = saldo * 0.02;
        System.out.println("Interés en Cuenta de Ahorros: " + interes + " pesos.");
    }
}
