import lectura.DatasetFactory;
import modelos.Cita;
import modelos.Paciente;
import modelos.Inventario;
import ordenamiento.*;

public class Benchmark {

    public static void main(String[] args) {

        String R1 = "src/resources/citas_100.csv";
        String R2 = "src/resources/citas_100_casi_ordenadas.csv";
        String R3 = "src/resources/pacientes_500.csv";
        String R4 = "src/resources/inventario_500_inverso.csv";

        System.out.println("=== Citas aleatorio ===");
        ejecutarBenchmark(DatasetFactory.cargarCitas(R1));

        System.out.println("\n=== Citas casi ordenado ===");
        ejecutarBenchmark(DatasetFactory.cargarCitas(R2));

        System.out.println("\n=== Pacientes duplicados ===");
        ejecutarBenchmark(DatasetFactory.cargarPacientes(R3));

        System.out.println("\n=== Inventario inverso ===");
        ejecutarBenchmark(DatasetFactory.cargarInventario(R4));
    }

    private static <T> void ejecutarBenchmark(T[] data) {

        SortStats b = BubbleSort.sort(data.clone(), new Comparadores.CompararPorId<>());
        System.out.println("Burbuja; " + b.comparisons + ";" + b.swaps + ";" + b.timeMs);

        SortStats s = SelectionSort.sort(data.clone(), new Comparadores.CompararPorId<>());
        System.out.println("Seleccion; " + s.comparisons + ";" + s.swaps + ";" + s.timeMs);

        SortStats i = InsertionSort.sort(data.clone(), new Comparadores.CompararPorId<>());
        System.out.println("Insercion; " + i.comparisons + ";" + i.swaps + ";" + i.timeMs);
    }
}
