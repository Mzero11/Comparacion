package lectura;

import java.nio.file.*;
import java.util.*;

public class CSVLoader {

    public static List<String[]> leerCSV(String ruta) {
        List<String[]> filas = new ArrayList<>();

        try {
            List<String> lineas = Files.readAllLines(Paths.get(ruta));

            for (int i = 1; i < lineas.size(); i++) {
                String linea = lineas.get(i).trim();
                if (linea.isEmpty()) continue;
                String[] partes = linea.split(";");
                filas.add(partes);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return filas;
    }
}
