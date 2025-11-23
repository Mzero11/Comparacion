package lectura;

import modelos.Cita;
import modelos.Inventario;
import modelos.Paciente;

import java.util.*;

public class DatasetFactory {

    public static Cita[] cargarCitas(String ruta) {
        List<String[]> filas = CSVLoader.leerCSV(ruta);
        Cita[] arr = new Cita[filas.size()];
        int i = 0;

        for (String[] f : filas) {
            // Garantiza que existan al menos 4 columnas
            String id = f.length > 0 ? f[0] : "";
            String nombre = f.length > 1 ? f[1] : "";
            String fecha = f.length > 2 ? f[2] : "";
            String motivo = f.length > 3 ? f[3] : ""; // antes explotaba

            arr[i++] = new Cita(id, nombre, fecha, motivo);
        }

        return arr;
    }

    public static Paciente[] cargarPacientes(String ruta) {
        List<String[]> filas = CSVLoader.leerCSV(ruta);
        Paciente[] arr = new Paciente[filas.size()];
        int i = 0;

        for (String[] f : filas) {
            String id = f.length > 0 ? f[0] : "";
            String nombre = f.length > 1 ? f[1] : "";
            int edad = f.length > 2 ? Integer.parseInt(f[2]) : 0;

            arr[i++] = new Paciente(id, nombre, edad);
        }

        return arr;
    }

    public static Inventario[] cargarInventario(String ruta) {
        List<String[]> filas = CSVLoader.leerCSV(ruta);
        Inventario[] arr = new Inventario[filas.size()];
        int i = 0;

        for (String[] f : filas) {
            String id = f.length > 0 ? f[0] : "";
            String prod = f.length > 1 ? f[1] : "";
            int cant = f.length > 2 ? Integer.parseInt(f[2]) : 0;

            arr[i++] = new Inventario(id, prod, cant);
        }

        return arr;
    }
}
