public class HeapSort {

    // Método para realizar el ordenamiento utilizando Heap Sort
    public static int[] heapSort(int[] array) {
        int profundidad = (int) (Math.floor(Math.log(array.length) / Math.log(2)) + 1);
        Heap heap = new Heap(profundidad);

        for (int valor : array) {
            heap.insertar(valor);
        }
        
        int[] ordenado = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            ordenado[i] = heap.extraer();
        }

        return ordenado;
    }

    // Método para imprimir el array
    public static void pintar(int[] array) {
        for (int valor : array) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("PRUEBAS DE HEAPSORT CON DIFERENTES TIPOS DE ARRAYS\n");

        // Caso 1: Array desordenado (caso básico)
        int[] datos1 = {9, 3, 7, 1, 8, 2, 5};
        System.out.println("1. Array desordenado:");
        System.out.print("   Original: ");
        pintar(datos1);
        int[] ordenado1 = heapSort(datos1);
        System.out.print("   Ordenado: ");
        pintar(ordenado1);
        System.out.println();

        // Caso 2: Array ya ordenado
        int[] datos2 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("2. Array ya ordenado:");
        System.out.print("   Original: ");
        pintar(datos2);
        int[] ordenado2 = heapSort(datos2);
        System.out.print("   Ordenado: ");
        pintar(ordenado2);
        System.out.println();

        // Caso 3: Array en orden inverso
        int[] datos3 = {7, 6, 5, 4, 3, 2, 1};
        System.out.println("3. Array en orden inverso:");
        System.out.print("   Original: ");
        pintar(datos3);
        int[] ordenado3 = heapSort(datos3);
        System.out.print("   Ordenado: ");
        pintar(ordenado3);
        System.out.println();

        // Caso 4: Array con elementos repetidos
        int[] datos4 = {5, 2, 5, 3, 2, 8, 5};
        System.out.println("4. Array con elementos repetidos:");
        System.out.print("   Original: ");
        pintar(datos4);
        int[] ordenado4 = heapSort(datos4);
        System.out.print("   Ordenado: ");
        pintar(ordenado4);
        System.out.println();

        // Caso 5: Array con un solo elemento
        int[] datos5 = {42};
        System.out.println("5. Array con un solo elemento:");
        System.out.print("   Original: ");
        pintar(datos5);
        int[] ordenado5 = heapSort(datos5);
        System.out.print("   Ordenado: ");
        pintar(ordenado5);
        System.out.println();

        // Caso 6: Array grande
        int[] datos6 = {25, 17, 36, 2, 8, 19, 42, 30, 11, 13, 5, 27, 22, 39, 14};
        System.out.println("6. Array grande:");
        System.out.print("   Original: ");
        pintar(datos6);
        int[] ordenado6 = heapSort(datos6);
        System.out.print("   Ordenado: ");
        pintar(ordenado6);
        System.out.println();

        // Caso 7: Array vacío
        int[] datos7 = {};
        System.out.println("7. Array vacío:");
        System.out.print("   Original: ");
        pintar(datos7);
        try {
            int[] ordenado7 = heapSort(datos7);
            System.out.print("   Ordenado: ");
            pintar(ordenado7);
        } catch (Exception e) {
            System.out.println("   Error: " + e.getMessage());
        }
        System.out.println();
    }
}
