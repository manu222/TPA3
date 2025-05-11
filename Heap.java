public class Heap {
    // Atributos
    private int[] contenedor;
    private int elementos;
    private int profundidad;

    // Constructor por defecto que inicializa un Heap vacío
    public Heap() {
        this.contenedor = null;
        this.elementos = 0;
        this.profundidad = 0;
    }

    // Constructor que inicializa un Heap con una profundidad específica
    public Heap(int profundidad) {
        this.profundidad = profundidad;
        int tamaño = (int) Math.pow(2, profundidad) - 1;
        this.contenedor = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            contenedor[i] = -1;
        }
        this.elementos = 0;
    }

    // Devuelve el valor de la raíz del Heap
    public int raiz() {
        if (!esVacio()) {
            return contenedor[0];
        }
        return -1;
    }

    // Inserta un valor en el Heap y lo reorganiza para mantener la propiedad del Heap
    public boolean insertar(int valor) {
        if (valor <= 0 || elementos >= contenedor.length) {
            return false;
        }
        contenedor[elementos] = valor;
        int i = elementos;
        while (i > 0 && contenedor[(i - 1) / 2] > contenedor[i]) {
            int padre = (i - 1) / 2;
            int temp = contenedor[padre];
            contenedor[padre] = contenedor[i];
            contenedor[i] = temp;
            i = padre;
        }
        elementos++;
        return true;
    }

    // Extrae y devuelve la raíz del Heap, reorganizando el Heap después
    public int extraer() {
        if (esVacio()) return -1;
        int raiz = contenedor[0];
        contenedor[0] = contenedor[elementos - 1];
        contenedor[elementos - 1] = -1;
        elementos--;
        heapify(0);
        return raiz;
    }

    // Reorganiza el Heap desde un índice específico para mantener la propiedad del Heap
    private void heapify(int i) {
        int menor = i;
        int izq = 2 * i + 1;
        int der = 2 * i + 2;

        if (izq < elementos && contenedor[izq] < contenedor[menor]) {
            menor = izq;
        }
        if (der < elementos && contenedor[der] < contenedor[menor]) {
            menor = der;
        }

        if (menor != i) {
            int temp = contenedor[i];
            contenedor[i] = contenedor[menor];
            contenedor[menor] = temp;
            heapify(menor);
        }
    }

    // Verifica si el Heap está vacío
    public boolean esVacio() {
        return elementos == 0;
    }

    // Devuelve el subárbol izquierdo del Heap
    public Heap hijoIzquierdo() {
        Heap hijo = new Heap(this.profundidad - 1);
        int inicio = 1;
        int fin = Math.min(contenedor.length, 1 + (int) Math.pow(2, this.profundidad - 1) - 1);
        for (int i = inicio; i < fin; i++) {
            if (contenedor[i] > 0) hijo.insertar(contenedor[i]);
        }
        return hijo;
    }

    // Devuelve el subárbol derecho del Heap
    public Heap hijoDerecho() {
        Heap hijo = new Heap(this.profundidad - 1);
        int inicio = 1 + (int) Math.pow(2, this.profundidad - 1) - 1;
        int fin = Math.min(contenedor.length, inicio + (int) Math.pow(2, this.profundidad - 1) - 1);
        for (int i = inicio; i < fin; i++) {
            if (contenedor[i] > 0) hijo.insertar(contenedor[i]);
        }
        return hijo;
    }

    // Realiza un recorrido en preorden del Heap
    public void preOrden() {
        preOrden(0);
        System.out.println();
    }

    // Método auxiliar para el recorrido en preorden
    private void preOrden(int i) {
        if (i >= contenedor.length || contenedor[i] <= 0) return;
        System.out.print(contenedor[i] + " ");
        preOrden(2 * i + 1);
        preOrden(2 * i + 2);
    }

    // Realiza un recorrido en postorden del Heap
    public void postOrden() {
        postOrden(0);
        System.out.println();
    }

    // Método auxiliar para el recorrido en postorden
    private void postOrden(int i) {
        if (i >= contenedor.length || contenedor[i] <= 0) return;
        postOrden(2 * i + 1);
        postOrden(2 * i + 2);
        System.out.print(contenedor[i] + " ");
    }

    // Realiza un recorrido en inorden del Heap
    public void inOrden() {
        inOrden(0);
        System.out.println();
    }

    // Método auxiliar para el recorrido en inorden
    private void inOrden(int i) {
        if (i >= contenedor.length || contenedor[i] <= 0) return;
        inOrden(2 * i + 1);
        System.out.print(contenedor[i] + " ");
        inOrden(2 * i + 2);
    }

    // Devuelve el número de elementos en el Heap
    public int getElementos() {
        return elementos;
    }

    // Devuelve la profundidad del Heap
    public int getProfundidad() {
        return profundidad;
    }

    // Devuelve el contenedor del Heap
    public int[] getContenedor() {
        return contenedor;
    }
}
