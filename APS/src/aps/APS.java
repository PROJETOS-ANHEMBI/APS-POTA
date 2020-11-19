package aps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class APS {

    // Obj random, para gerar valores aleatórios nos vetores
    public static Random random;

    public static int[] vetorPrincipal;

    // Vetores 5, 10, 50, 100, 1.000 e 10.000
    public static int[] vetor1;
    public static int[] vetor2;
    public static int[] vetor3;
    public static int[] vetor4;
    public static int[] vetor5;
    public static int[] vetor6;

    public static void main(String[] args) {

        // Instancia o obj random, e cria os vetores
        random = new Random();
        GerarVetores();

        for (int i = 1; i <= 6; i++) {

            switch (i) {
                case 1:
                    vetorPrincipal = vetor1;
                    break;
                case 2:
                    vetorPrincipal = vetor2;
                    break;
                case 3:
                    vetorPrincipal = vetor3;
                    break;
                case 4:
                    vetorPrincipal = vetor4;
                    break;
                case 5:
                    vetorPrincipal = vetor5;
                    break;
                case 6:
                    vetorPrincipal = vetor6;
                    break;
            }

            print("--- Vetor Não Ordenado: \n", vetorPrincipal, "\n");

            vetorPrincipal = vetor1;
            BUBBLE_SORT(vetor1);
            print("- Vetor Ordenado por BUBBLE SORT: \n", vetorPrincipal, "\n");

            SELECTION_SORT(vetor1);
            vetorPrincipal = vetor1;
            print("- Vetor Ordenado por SELECTION SORT: \n", vetorPrincipal, "\n");

            INSERTION_SORT(vetor1);
            vetorPrincipal = vetor1;
            print("- Vetor Ordenado por INSERTION SORT: \n", vetorPrincipal, "\n");

            HEAP_SORT(vetor1);
            vetorPrincipal = vetor1;
            print("- Vetor Ordenado por HEAP SORT: \n", vetorPrincipal, "\n");

            MERGE_SORT(vetor1, 0, vetorPrincipal.length - 1);
            vetorPrincipal = vetor1;
            print("- Vetor Ordenado por MERGE SORT: \n", vetorPrincipal, "\n");

            QUICK_SORT(vetor1, 0, vetorPrincipal.length - 1);
            vetorPrincipal = vetor1;
            print("- Vetor Ordenado por QUICK SORT: \n", vetorPrincipal, "\n");

            COUNT_SORT(vetor1);
            vetorPrincipal = vetor1;
            print("- Vetor Ordenado por COUNT SORT: \n", vetorPrincipal, "\n");

            // BUCKET_SORT(); --------------------------------- pendente
            // vetorPrincipal = vetor1;
            // print("Vetor Ordenado por BUCKET SORT: \n", vetorPrincipal, "\n");
            
            RADIX_SORT(vetor1);
            vetorPrincipal = vetor1;
            print("- Vetor Ordenado por RADIX SORT: \n", vetorPrincipal, "\n\n");

        }

    }

    // Gera os vetores com 5, 10, 50, 100, 1.000 e 10.000 de Length
    public static void GerarVetores() {
        vetor1 = GerarVetor(5);
        vetor2 = GerarVetor(10);
        vetor3 = GerarVetor(50);
        vetor4 = GerarVetor(100);
        vetor5 = GerarVetor(1000);
        vetor6 = GerarVetor(10000);
    }

    // Gera um novo vetor com um Length passado por parametro
    public static int[] GerarVetor(int maxLength) {
        // Instancia o vetor com o Length recebido
        int[] vetor = new int[maxLength];
        // Adiciona valores aleatórios ao vetor
        for (int i = 0; i < maxLength; i++) {
            vetor[i] = random.nextInt(1001);
        }
        return vetor;
    }

    // Faz print dos elementos de um vetor
    public static void print(String msgInicio, int vector[], String msgFinal) {
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
