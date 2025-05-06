public class Heap {
    private int[] contenedor;
    private int elementos;
    private int profundidad;

    public Heap() {
        this.contenedor = null;
        this.elementos = 0;
        this.profundidad = 0;
    }

    public Heap(int profundidad) {
        this.profundidad = profundidad;
        int tamaño = (int) Math.pow(2, profundidad) - 1;
        this.contenedor = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            contenedor[i] = -1;
        }
        this.elementos = 0;
    }

    public int raiz() {
        if (!esVacio()) {
            return contenedor[0];
        }
        return -1;
    }

    public boolean insertar(int valor) {
        if (valor <= 0 || elementos >= contenedor.length) {
            return false;
        }
        contenedor[elementos] = valor;
        int i = elementos;
        while (i > 0) {
            int padre = (i - 1) / 2;
            if (contenedor[padre] > contenedor[i]) {
                int temp = contenedor[padre];
                contenedor[padre] = contenedor[i];
                contenedor[i] = temp;
                i = padre;
            } else {
                break;
            }
        }
        elementos++;
        return true;
    }

    public int extraer() {
        if (esVacio()) return -1;
        int raiz = contenedor[0];
        contenedor[0] = contenedor[elementos - 1];
        contenedor[elementos - 1] = -1;
        elementos--;
        heapify(0);
        return raiz;
    }

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

    public boolean esVacio() {
        return elementos == 0;
    }

    public Heap hijoIzquierdo() {
        Heap hijo = new Heap(this.profundidad - 1);
        int inicio = 1;
        int fin = Math.min(contenedor.length, 1 + (int) Math.pow(2, this.profundidad - 1) - 1);
        for (int i = inicio; i < fin; i++) {
            if (contenedor[i] > 0) hijo.insertar(contenedor[i]);
        }
        return hijo;
    }

    public Heap hijoDerecho() {
        Heap hijo = new Heap(this.profundidad - 1);
        int inicio = 1 + (int) Math.pow(2, this.profundidad - 1) - 1;
        int fin = Math.min(contenedor.length, inicio + (int) Math.pow(2, this.profundidad - 1) - 1);
        for (int i = inicio; i < fin; i++) {
            if (contenedor[i] > 0) hijo.insertar(contenedor[i]);
        }
        return hijo;
    }

    public void preOrden() {
        preOrden(0);
        System.out.println();
    }

    private void preOrden(int i) {
        if (i >= contenedor.length || contenedor[i] <= 0) return;
        System.out.print(contenedor[i] + " ");
        preOrden(2 * i + 1);
        preOrden(2 * i + 2);
    }

    public void postOrden() {
        postOrden(0);
        System.out.println();
    }

    private void postOrden(int i) {
        if (i >= contenedor.length || contenedor[i] <= 0) return;
        postOrden(2 * i + 1);
        postOrden(2 * i + 2);
        System.out.print(contenedor[i] + " ");
    }

    public void inOrden() {
        inOrden(0);
        System.out.println();
    }

    private void inOrden(int i) {
        if (i >= contenedor.length || contenedor[i] <= 0) return;
        inOrden(2 * i + 1);
        System.out.print(contenedor[i] + " ");
        inOrden(2 * i + 2);
    }

    public int getElementos() {
        return elementos;
    }

    public int getProfundidad() {
        return profundidad;
    }

    public int[] getContenedor() {
        return contenedor;
    }
}
