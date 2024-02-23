import java.util.ArrayList;
import java.util.Scanner;

public class Inicio {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        ArrayList<Nacional> listaNacionales = new ArrayList<>();
        ArrayList<Importado> listaImportados = new ArrayList<>();


        Local miLocal = new Local("Mi Tienda");

        System.out.println("¡Bienvenido al local '" + miLocal.nombreLocal + "'!");

        char agregarEmpleado;
        do {
            System.out.print("¿Desea agregar un empleado? (S/N): ");
            agregarEmpleado = entrada.next().charAt(0);
            if (agregarEmpleado == 'S' || agregarEmpleado == 's') {
                agregarEmpleado(miLocal, entrada);
            }
        } while (agregarEmpleado == 'S' || agregarEmpleado == 's');


        int opcion;

        do {
            System.out.println(" --------- M E N Ú --------- +" +
                    "\n 1. Registrar producto nacional " +
                    "\n 2. Registrar producto importado" +
                    "\n 3. Listar productos nacionales" +
                    "\n 4. Listar productos importados" +
                    "\n 5. Buscar producto nacional" +
                    "\n 6. Buscar producto importado" +
                    "\n 7. Lista de empleados " +
                    "\n 0. S A L I R");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    registrarProductoNacional(listaNacionales, entrada);
                    break;
                case 2:
                    registrarProductoImportado(listaImportados, entrada);
                    break;
                case 3:
                    listarProductosNacionales(listaNacionales);
                    break;
                case 4:
                    listarProductosImportados(listaImportados);
                    break;
                case 5:
                    buscarProductoNacional(listaNacionales, entrada);
                    break;
                case 6:
                    buscarProductoImportado(listaImportados, entrada);
                    break;
                case 7:
                    miLocal.listarEmpleados();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione nuevamente.");
            }
        } while (opcion != 0);
    }

    public static void agregarEmpleado(Local local, Scanner entrada) {
        System.out.print("Ingrese nombre del empleado: ");
        String nombreEmpleado = entrada.next();
        System.out.print("Ingrese código del empleado: ");
        int codigoEmpleado = entrada.nextInt();
        System.out.println("Ingrese la función del empkeado: ");
        String funcionEmpleado = entrada.next();

        Empleado empleado = new Empleado(nombreEmpleado, codigoEmpleado, funcionEmpleado);
        local.agregarEmpleado(empleado);
        System.out.println("Empleado agregado correctamente.");
    }
    public static void registrarProductoNacional(ArrayList<Nacional> listaNacionales, Scanner entrada) {
        System.out.print("Ingrese nombre del producto: ");
        String nombre = entrada.next();
        System.out.print("Ingrese código del producto: ");
        int codigo = entrada.nextInt();
        System.out.print("Ingrese registro DIAN del producto: ");
        String registroDIAN = entrada.next();

        Nacional productoNacional = new Nacional(nombre, codigo, registroDIAN);
        listaNacionales.add(productoNacional);
        System.out.println("Producto nacional registrado exitosamente.");
    }

    public static void registrarProductoImportado(ArrayList<Importado> listaImportados, Scanner entrada) {
        System.out.print("Ingrese nombre del producto: ");
        String nombre = entrada.next();
        System.out.print("Ingrese código del producto: ");
        int codigo = entrada.nextInt();
        System.out.print("Ingrese licencia de importación del producto: ");
        String licenciaImportacion = entrada.next();

        Importado productoImportado = new Importado(nombre, codigo, licenciaImportacion);
        listaImportados.add(productoImportado);
        System.out.println("Producto importado registrado exitosamente.");
    }

    public static void listarProductosNacionales(ArrayList<Nacional> listaNacionales) {
        if (listaNacionales.isEmpty()) {
            System.out.println("No hay productos nacionales registrados.");
        } else {
            System.out.println("Listado de productos nacionales:");
            for (Nacional producto : listaNacionales) {
                System.out.println("Nombre: " + producto.nombre + ", Código: " + producto.getCodigo() + ", Registro DIAN: " + producto.RegistroDias);
            }
        }
    }

    public static void listarProductosImportados(ArrayList<Importado> listaImportados) {
        if (listaImportados.isEmpty()) {
            System.out.println("No hay productos importados registrados.");
        } else {
            System.out.println("Listado de productos importados:");
            for (Importado producto : listaImportados) {
                System.out.println("Nombre: " + producto.nombre + ", Código: " + producto.getCodigo() + ", Licencia de importación: " + producto.LicenciaImportacion);
            }
        }
    }

    public static void buscarProductoNacional(ArrayList<Nacional> listaNacionales, Scanner entrada) {
        System.out.print("Ingrese el código del producto nacional a buscar: ");
        int codigoBuscar = entrada.nextInt();
        boolean encontrado = false;
        for (Nacional producto : listaNacionales) {
            if (producto.getCodigo() == codigoBuscar) {
                System.out.println("Producto nacional encontrado:");
                System.out.println("Nombre: " + producto.nombre + ", Código: " + producto.getCodigo() + ", Registro DIAN: " + producto.RegistroDias);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Producto nacional no encontrado.");
        }
    }

    public static void buscarProductoImportado(ArrayList<Importado> listaImportados, Scanner entrada) {
        System.out.print("Ingrese el código del producto importado a buscar: ");
        int codigoBuscar = entrada.nextInt();
        boolean encontrado = false;
        for (Importado producto : listaImportados) {
            if (producto.getCodigo() == codigoBuscar) {
                System.out.println("Producto importado encontrado:");
                System.out.println("Nombre: " + producto.nombre + ", Código: " + producto.getCodigo() + ", Licencia de importación: " + producto.LicenciaImportacion);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Producto importado no encontrado.");
        }
    }
}