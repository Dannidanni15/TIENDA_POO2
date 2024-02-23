import java.util.ArrayList;

public class Local {
    String nombreLocal;
    ArrayList<Empleado> empleados;

    public Local(String nombreLocal) {
        this.nombreLocal = nombreLocal;
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void listarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados contratados en este local.");
        } else {
            System.out.println("Empleados del local '" + nombreLocal + "':");
            for (Empleado empleado : empleados) {
                System.out.println("Nombre: " + empleado.NombreEmpleado + ", Código: " + empleado.CodigoEmpleado + ", Función: " + empleado.FuncionEmpleado);
            }
        }
    }
}
