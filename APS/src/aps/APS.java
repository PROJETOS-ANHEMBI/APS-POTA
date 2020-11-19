package aps;

import java.util.ArrayList;
import java.util.Random;

public class APS {

    public static int[] vetor;
    public static Random random;

    public static void main(String[] args) {

        // Instancia o obj random, e cria o vetor
        random = new Random();
        GerarVetor(10);

        printVector("\n", vetor, "\n");

        // BUBBLE_SORT(vetor);
        // SELECTION_SORT(vetor);
        // INSERTION_SORT(vetor);
        // HEAP_SORT(vetor);
        // MERGE_SORT(vetor, 0, vetor.length - 1);
        // QUICK_SORT(vetor, 0, vetor.length - 1);
        // COUNT_SORT(vetor);
        // BUCKET_SORT(); --------------------------------- pendente
        // RADIX_SORT(vetor);

        printVector("\n", vetor, "\n");

    }

    // Gera novos vetores com Length dinamico, passado por parametro
    public static void GerarVetor(int maxLength) {
        // Instancia o vetor com o Length recebido
        vetor = new int[maxLength];
        // Adiciona valores aleatórios ao vetor
        for (int i = 0; i < maxLength; i++) {
            vetor[i] = random.nextInt(1001);
        }
    }

    public static void printVector(String msgInicio, int vector[], String msgFinal) {
        System.out.print(msgInicio);
        for (int v : vector) {
            System.out.print(v + " ");
        }
        System.out.print(msgFinal);
    }

    // Bubble Sort
    public static void BUBBLE_SORT(int v[]) {
        int n = v.length;
        boolean trocou = true;
        while (trocou) {
            trocou = false;
            for (int i = 0; i < n - 1; i++) {
                if (v[i] > v[i + 1]) {//Troca
                    int aux = v[i];
                    v[i] = v[i + 1];
                    v[i + 1] = aux;
                    trocou = true;
                }
            }
            n--;
        }
    }

    // Selection Sort
    public static void SELECTION_SORT(int v[]) {
        int n = v.length;
        int indice_menor;
        for (int i = 0; i < n - 1; i++) {
            indice_menor = i;
            for (int j = i; j < n; j++) {
                if (v[j] < v[indice_menor]) {
                    indice_menor = j;
                }
            }
            int aux = v[i];
            v[i] = v[indice_menor];
            v[indice_menor] = aux;
        }

    }

    // Insertion Sort
    public static void INSERTION_SORT(int v[]) {
        int chave, j, i;
        for (i = 1; i < v.length; i++) {
            chave = v[i];
            j = i - 1;
            while (j >= 0 && v[j] > chave) {
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = chave;
        }
    }

    // Heap Sort
    public static void HEAP_SORT(int vet[]) {
        int n = vet.length;
        for (int i = n / 2 - 1; i >= 0; i--) {//criação do heap(organiza o vetor)
            heapFy(vet, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int aux = vet[0];
            vet[0] = vet[i];
            vet[i] = aux;
            heapFy(vet, i, 0);

        }

    }

    public static void heapFy(int vet[], int n, int i) {
        int maior = i;
        int esq = 2 * i + 1;
        int dir = 2 * i + 2;
        if (esq < n && vet[esq] > vet[maior]) {
            maior = esq;
        }
        if (dir < n && vet[dir] > vet[maior]) {
            maior = dir;
        }
        if (maior != i) {
            int aux = vet[i];
            vet[i] = vet[maior];
            vet[maior] = aux;
            heapFy(vet, n, maior);
        }
    }

    // Merge Sort
    public static void MERGE_SORT(int v[], int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            MERGE_SORT(v, inicio, meio);
            MERGE_SORT(v, meio + 1, fim);
            MERGE(v, inicio, meio, fim);
        }
    }

    public static void MERGE(int v[], int inicio, int meio, int fim) {
        int[] auxiliar = new int[v.length];

        for (int i = inicio; i <= meio; i++) {
            auxiliar[i] = v[i];
        }
        for (int i = meio + 1; i <= fim; i++) {
            auxiliar[fim + meio + 1 - i] = v[i];
        }

        int i = inicio;
        int j = fim;
        for (int k = inicio; k <= fim; k++) {
            if (auxiliar[i] <= auxiliar[j]) {
                v[k] = auxiliar[i];
                i++;
            } else {
                v[k] = auxiliar[j];
                j--;
            }
        }
    }

    // Quick Sort
    public static void QUICK_SORT(int v[], int inicio, int fim) {
        if (inicio < fim) {
            int posPivot = Partition(v, inicio, fim);
            QUICK_SORT(v, inicio, posPivot - 1);
            QUICK_SORT(v, posPivot + 1, fim);
        }
    }

    public static int Partition(int v[], int inicio, int fim) {
        // Idenfica qual a mediana
        int meio = (inicio + fim) / 2, medianaIndice = 0;
        int a = v[inicio], b = v[meio], c = v[fim];

        if (a < b) {
            if (b < c) {
                medianaIndice = meio;
            } else {
                if (a < c) {
                    medianaIndice = fim;
                } else {
                    medianaIndice = inicio;
                }
            }
        } else {
            if (c < b) {
                medianaIndice = meio;
            } else {
                if (c < a) {
                    medianaIndice = fim;
                } else {
                    medianaIndice = inicio;
                }
            }
        }

        // Substitui seu valor com o indice "fim", pelo valor do indice da "mediana"
        int aux = v[fim];
        v[fim] = v[medianaIndice];
        v[medianaIndice] = aux;

        // Segue com a verificação padrão do Quick Sort
        int pivot = v[fim], i = inicio;
        for (int j = inicio; j < fim; j++) {
            if (v[j] <= pivot) {
                aux = v[j];
                v[j] = v[i];
                v[i] = aux;
                i++;
            }
        }
        aux = v[i];
        v[i] = v[fim];
        v[fim] = aux;
        return i;
    }

    // Count Sort
    public static void COUNT_SORT(int vetor[]) {
        int max = getMax(vetor); //encontra o maior elemento
        int[] count = new int[max + 1]; //criar vetor contador de tamanho max+1
        for (int i = 0; i < vetor.length; i++) {
            count[i] = 0;
        }
        for (int i = 0; i < vetor.length; i++) {
            count[vetor[i]]++;
        }
        for (int i = 0, indice = 0; i < count.length; i++) {
            for (int k = count[i]; k > 0; k--) {
                vetor[indice++] = i;
            }
        }
    }

    public static int getMax(int vetor[]) {
        int max = 0;
        for (int x : vetor) {
            max = x > max ? x : max;
        }
        return max;
    }

    // Bucket Sort
    public static void BUCKET_SORT() {

    }

    // Radix Sort
    public static void RADIX_SORT(int vetor[]) {
        int digitos = countDigits(getMax(vetor));
        COUNTING_SORT(vetor, digitos); //chama o countingSort
    }

    public static int countDigits(int max) {
        int digitos = 0;
        while (max > 0) {
            digitos++;
            max /= 10;
        }
        return digitos;
    }

    public static void COUNTING_SORT(int vetor[], int digitos) {
        ArrayList<Integer> bucket[] = new ArrayList[10];
        int power;
        for (int i = 0; i < 10; i++) {
            bucket[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < digitos; i++) {
            power = (int) Math.pow(10, i + 1);
            for (int j = 0; j < vetor.length; j++) {
                bucket[(vetor[j] % power) / (power / 10)].add(vetor[j]);
            }
            int indice = 0;
            for (int j = 0; j < bucket.length; j++) {
                while (!bucket[j].isEmpty()) {
                    vetor[indice++] = bucket[j].remove(0);
                }
            }
        }
    }
}
