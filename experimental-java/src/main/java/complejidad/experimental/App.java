package complejidad.experimental;

import java.util.Random;
import java.util.Arrays;
public class App {
    public static void main(String[] args) {
        int tam=100000;
        int[] arregloBurbuja = generarDatos(tam);
        int[] arregloSeleccion = Arrays.copyOf(arregloBurbuja,tam);

        System.out.println("Ordenando con Burbuja...");
        double tiempoBurbuja = medirTiempo(() -> ordenarBurbuja(arregloBurbuja));
        System.out.println("Tiempo Burbuja: " + tiempoBurbuja + " segundos");

        System.out.println("\nOrdenando con Selección...");
        double tiempoSeleccion = medirTiempo(() -> ordenarSeleccion(arregloSeleccion));
        System.out.println("Tiempo Selección: " + tiempoSeleccion + " segundos");
    }

    public static int[] generarDatos(int tam) {
        int[] datos = new int[tam];
        Random random = new Random();
        for (int i = 0; i < tam; i++) {
            datos[i] = random.nextInt( 100_000);
        }
        return datos;
    }

    public static double medirTiempo(Runnable tarea) {
        long inicio = System.nanoTime();
        tarea.run();
        long fin = System.nanoTime();
        return (fin - inicio) / 1_000_000_000.0;
    }

    public static void ordenarBurbuja(int[] arreglo) {
        int n = arreglo.length;
        int aux;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arreglo[i] > arreglo[j]) {
                    aux = arreglo[j];
                    arreglo[j] = arreglo[i];
                    arreglo[i] = aux;
                }
            }
        }
    }

    public static void ordenarSeleccion(int[] arreglo) {
        int n = arreglo.length;
        int aux, minIndex;
        for (int i = 0; i < n; i++) {
            minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arreglo[j] < arreglo[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                aux = arreglo[minIndex];
                arreglo[minIndex] = arreglo[i];
                arreglo[i] = aux;
            }
        }
    }
}
