import bankeurope.clientes.Cliente;
import bankeurope.cuentas.CuentaAhorros;
import bankeurope.cuentas.CuentaCorriente;
import bankeurope.cuentas.CuentaBancaria;
import bankeurope.cuentas.digitales.CuentaDigital;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n--- Menú Bank Europe ---");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Ver datos de cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Girar");
            System.out.println("5. Consultar saldo");
            System.out.println("6. Calcular interés");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> registrarCliente();
                case 2 -> verDatosCliente();
                case 3 -> depositar();
                case 4 -> girar();
                case 5 -> consultarSaldo();
                case 6 -> calcularInteres();
                case 7 -> System.out.println("¡Gracias por usar el sistema!");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 7);
    }

    private static void registrarCliente() {
        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese RUT: ");
        String rut = sc.nextLine();
        System.out.print("Ingrese número de cuenta (9 dígitos): ");
        String numeroCuenta = sc.nextLine();

        System.out.println("Seleccione tipo de cuenta:");
        System.out.println("1. Cuenta Corriente");
        System.out.println("2. Cuenta de Ahorros");
        System.out.println("3. Cuenta Digital");
        System.out.print("Opción: ");
        int tipo = Integer.parseInt(sc.nextLine());

        CuentaBancaria cuenta;

        switch (tipo) {
            case 1 -> cuenta = new CuentaCorriente(numeroCuenta, 0);
            case 2 -> cuenta = new CuentaAhorros(numeroCuenta, 0);
            case 3 -> cuenta = new CuentaDigital(numeroCuenta, 0);
            default -> {
                System.out.println("Tipo de cuenta inválido.");
                return;
            }
        }

        Cliente nuevoCliente = new Cliente(nombre, rut, cuenta);
        clientes.add(nuevoCliente);
        System.out.println("Cliente registrado correctamente.");
    }

    private static Cliente buscarClientePorRut() {
        System.out.print("Ingrese RUT del cliente: ");
        String rut = sc.nextLine();

        for (Cliente c : clientes) {
            if (c.getRut().equalsIgnoreCase(rut)) {
                return c;
            }
        }

        System.out.println("Cliente no encontrado.");
        return null;
    }

    private static void verDatosCliente() {
        Cliente cliente = buscarClientePorRut();
        if (cliente != null) {
            cliente.mostrarInformacionCliente();
        }
    }

    private static void depositar() {
        Cliente cliente = buscarClientePorRut();
        if (cliente != null) {
            System.out.print("Ingrese monto a depositar: ");
            int monto = Integer.parseInt(sc.nextLine());
            cliente.getCuenta().depositar(monto);
        }
    }

    private static void girar() {
        Cliente cliente = buscarClientePorRut();
        if (cliente != null) {
            System.out.print("Ingrese monto a girar: ");
            int monto = Integer.parseInt(sc.nextLine());
            cliente.getCuenta().girar(monto);
        }
    }

    private static void consultarSaldo() {
        Cliente cliente = buscarClientePorRut();
        if (cliente != null) {
            System.out.println("Saldo actual: " + cliente.getCuenta().getSaldo() + " pesos");
        }
    }

    private static void calcularInteres() {
        Cliente cliente = buscarClientePorRut();
        if (cliente != null) {
            cliente.getCuenta().calcularInteres();
        }
    }
}
