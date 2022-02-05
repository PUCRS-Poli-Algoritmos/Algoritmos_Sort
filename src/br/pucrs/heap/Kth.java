package br.pucrs.heap;

import br.pucrs.sorts.Sorts;
import br.pucrs.util.ContagemRes;

public class Kth {
	public static final int TAM_VET = 100_000_000;
	
	public static void main(String [] argc) {
		Kth myKth = new Kth();
		long [] vet1 = {20, 70, 1, 5, 12, 7, 45, 23, 102, 4, 1, 18, 35};
		Sorts srt = new Sorts();
		ContagemRes sResHeap;
		long[] vet2;
		long kTh;
		long nanoInicio, nanoFinal;
		
		for (int i = 0; i < vet1.length; i++)
			System.out.print(vet1[i] + " ");
		System.out.println("");
		
		System.out.println("1 maior -> " + myKth.kthMaior(vet1, 1));
		System.out.println("2 maior -> " + myKth.kthMaior(vet1, 2));
		System.out.println("3 maior -> " + myKth.kthMaior(vet1, 3));
		System.out.println("4 maior -> " + myKth.kthMaior(vet1, 4));
		System.out.println("5 maior -> " + myKth.kthMaior(vet1, 5));
		System.out.println("6 maior -> " + myKth.kthMaior(vet1, 6));
		System.out.println("7 maior -> " + myKth.kthMaior(vet1, 7));
		System.out.println("8 maior -> " + myKth.kthMaior(vet1, 8));
		System.out.println("9 maior -> " + myKth.kthMaior(vet1, 9));
		System.out.println("10 maior -> " + myKth.kthMaior(vet1, 10));
		System.out.println("11 maior -> " + myKth.kthMaior(vet1, 11));
		System.out.println("12 maior -> " + myKth.kthMaior(vet1, 12));
		System.out.println("13 maior -> " + myKth.kthMaior(vet1, 13));
		try{
			System.out.println("14 maior -> " + myKth.kthMaior(vet1, 14));
		}
		catch(Exception ex){
			System.out.println("Excp: " + ex.getMessage());
		}

		System.out.println("--------------------------------------------------");
		System.out.println("Medindo tempo: Vetor de " + TAM_VET + " elementos.");
		
		vet2 = srt.geraVetor(TAM_VET, TAM_VET/2);

		nanoInicio = System.nanoTime();
		kTh = myKth.kthMaior(vet2, 10);
		nanoFinal = System.nanoTime();
		System.out.println("Com kTh");
		System.out.println("Posicao k: " + 10 + " kTh: " + kTh + " Tempo (em seg.): " +  ((double)nanoFinal - (double)nanoInicio) / (double)1000000000.0);
		
		sResHeap = srt.heapSort(vet2);
		System.out.println("Com Sort");
		System.out.println("Posicao k: " + 10 + " kTh: " + sResHeap.getResult()[TAM_VET - 10] + " Tempo (em seg.): " +  sResHeap.getTime());
		System.out.println("");

		nanoInicio = System.nanoTime();
		kTh = myKth.kthMaior(vet2, 100);
		nanoFinal = System.nanoTime();
		System.out.println("Com kTh");
		System.out.println("Posicao k: " + 100 + " kTh: " + kTh + " Tempo (em seg.): " +  ((double)nanoFinal - (double)nanoInicio) / (double)1000000000.0);
		
		sResHeap = srt.heapSort(vet2);
		System.out.println("Com Sort");
		System.out.println("Posicao k: " + 100 + " kTh: " + sResHeap.getResult()[TAM_VET - 100] + " Tempo (em seg.): " +  sResHeap.getTime());
		System.out.println("");
		
		nanoInicio = System.nanoTime();
		kTh = myKth.kthMaior(vet2, TAM_VET / 2);
		nanoFinal = System.nanoTime();
		System.out.println("Com kTh");
		System.out.println("Posicao k: " + TAM_VET/2 + " kTh: " + kTh + " Tempo (em seg.): " +  ((double)nanoFinal - (double)nanoInicio) / (double)1000000000.0);
		
		sResHeap = srt.heapSort(vet2);
		System.out.println("Com Sort");
		System.out.println("Posicao k: " + (vet2.length - (TAM_VET/2)) + " kTh: " + sResHeap.getResult()[TAM_VET/2] + " Tempo (em seg.): " +  sResHeap.getTime());
		System.out.println("");

		nanoInicio = System.nanoTime();
		kTh = myKth.kthMaior(vet2, TAM_VET -10);
		nanoFinal = System.nanoTime();
		System.out.println("Com kTh");
		System.out.println("Posicao k: " + (TAM_VET - 10)  + " kTh: " + kTh + " Tempo (em seg.): " +  ((double)nanoFinal - (double)nanoInicio) / (double)1000000000.0);
		
		sResHeap = srt.heapSort(vet2);
		System.out.println("Com Sort");
		System.out.println("Posicao k: " + (TAM_VET-10) + " kTh: " + sResHeap.getResult()[10] + " Tempo (em seg.): " +  sResHeap.getTime());
		System.out.println("");

	}
	
	public long kthMaior(long [] vet, int k) {
		long res = -1;
		long [] v = vet.clone();
		long aux;
		int n;

		if (k > vet.length || k < 0)
			throw new IllegalArgumentException("Tamanho: " + vet.length + ", Kth:" + k);
		
		buildMaxHeap(v); 
		n = v.length; 

		for (int i = v.length - 1, cont = 1; cont < k; i--, cont++) { 
			aux = v[0];
			v[0] = v[i];
			v[i] = aux;
			maxHeapify(v, 0, --n);
		}

		res = v[0];
		return res;
	}

	private void buildMaxHeap(long v[]) { 
		for (int i = v.length/2 - 1; i >= 0; i--){
			maxHeapify(v, i , v. length ); 
		}
	} 

	private void maxHeapify(long v [], int pai, int n) { 
		long aux;
		int posFilhoMaior = 2 * pai + 1, posFilhoDireita = posFilhoMaior + 1;

		if (posFilhoMaior < n) { 
			if ( posFilhoDireita < n && v[posFilhoMaior] < v[posFilhoDireita]){
				posFilhoMaior = posFilhoDireita;
			}

			if (v[posFilhoMaior] > v[pai]) {
				aux = v[pai];
				v[pai] = v[posFilhoMaior];
				v[posFilhoMaior] = aux;
				maxHeapify(v, posFilhoMaior, n); 
			} 
		} 
	} 
}
