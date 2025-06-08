package bankeurope.cuentas.digitales;

import bankeurope.cuentas.CuentaBancaria; // Importamos la clase padre

public class CuentaDigital extends CuentaBancaria {

    public CuentaDigital(String numeroCuenta, int saldoInicial) {
        super(numeroCuenta, saldoInicial);
    }

    @Override
    public void calcularInteres() {
        double interes = saldo * 0.01; // 1% de interés
        System.out.println("Interés en Cuenta Digital: " + interes + " pesos.");
    }
}
