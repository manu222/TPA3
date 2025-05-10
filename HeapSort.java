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

        // Array de números enteros positivos a ordenar
        int[] datos = {9, 3, 7, 1, 8, 2, 5};

        System.out.print("Array original: ");
        pintar(datos);

        int[] ordenado = heapSort(datos);

        System.out.print("Array ordenado: ");
        pintar(ordenado);
    }
}
