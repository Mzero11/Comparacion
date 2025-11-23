package ordenamiento;

import java.util.Comparator;

public class Comparadores {

    public static class CompararPorId<T> implements Comparator<T> {
        @Override
        public int compare(T o1, T o2) {
            try {
                String id1 = (String) o1.getClass().getMethod("getId").invoke(o1);
                String id2 = (String) o2.getClass().getMethod("getId").invoke(o2);

                return id1.compareTo(id2);

            } catch (Exception e) {
                throw new RuntimeException("Error comparando por id", e);
            }
        }
    }
}
