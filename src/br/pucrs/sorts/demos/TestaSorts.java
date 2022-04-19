package br.pucrs.sorts.demos;

import java.util.Locale;

import br.pucrs.sorts.Sorts;
import br.pucrs.util.ContagemRes;

public class TestaSorts {

	private static int ELEMENTOS = 100_000;
	private static int ITERACOES = 5;

	public static void exibe(long[] v, long limite){
		for (int i = 1; i <= v.length; i++)
			if (i % limite == 0)
				System.out.println(v[i-1] + " ");
			else
				System.out.print(v[i-1] + " ");
		System.out.println("");
	}

	public static void exibe(double[] v, int limite){
		for (int i = 1; i <= v.length; i++)
			if (i % limite == 0)
				System.out.println(v[i-1] + " ");
			else
				System.out.print(v[i-1] + " ");

		System.out.println("\n");
	}

	public static void iteraTestes(int SORT_LIM, int TAM_VETOR) {

		Sorts srt = new Sorts();
		long [] vet, vetAux;
		long [] resIterHeap = new long[SORT_LIM];
		long [] resIterQuick = new long[SORT_LIM];
		long [] resIterMerge = new long[SORT_LIM];
		long [] resIterInsert = new long[SORT_LIM];
		long [] resIterBubble0 = new long[SORT_LIM];
		long [] resIterBubble1 = new long[SORT_LIM];
		long [] resIterBubble2 = new long[SORT_LIM];
		long [] resIterBubble2PIOR = new long[SORT_LIM];

		long [] resInstrHeap = new long[SORT_LIM];
		long [] resInstrQuick = new long[SORT_LIM];
		long [] resInstrMerge = new long[SORT_LIM];
		long [] resInstrInsert = new long[SORT_LIM];
		long [] resInstrBubble0 = new long[SORT_LIM];
		long [] resInstrBubble1 = new long[SORT_LIM];
		long [] resInstrBubble2 = new long[SORT_LIM];
		long [] resInstrBubble2PIOR = new long[SORT_LIM];

		double [] resClockHeap = new double[SORT_LIM];
		double [] resClockQuick = new double[SORT_LIM];
		double [] resClockMerge = new double[SORT_LIM];
		double [] resClockInsert = new double[SORT_LIM];
		double [] resClockBubble0 = new double[SORT_LIM];
		double [] resClockBubble1 = new double[SORT_LIM];
		double [] resClockBubble2 = new double[SORT_LIM];
		double [] resClockBubble2PIOR = new double[SORT_LIM];


		ContagemRes sResHeap;
		ContagemRes sResInsert, sResQuick, sResMerge, sResBubble0, sResBubble1, sResBubble2, sResBubble2PIOR;
		int pos;

		System.out.println("\nIniciando Agora!");
		for (pos = 0; pos < SORT_LIM; pos ++) {
			System.out.print("#");
			vet = srt.geraVetor(TAM_VETOR, TAM_VETOR / 2);
			vetAux = srt.geraVetorInv(TAM_VETOR);

			// sResHeap = srt.heapSort(vet);
			// System.out.print(".");
			// sResQuick = srt.quickSort(vet);
			// System.out.print(".");
			sResMerge = srt.mergeSort(vet);
			System.out.print(".");
			sResInsert = srt.insertSort(vet);
			System.out.print(".");
			sResBubble0 = srt.bubbleSort0(vet);
			System.out.print(".");
			sResBubble1 = srt.bubbleSort1(vet);
			System.out.print(".");
			sResBubble2 = srt.bubbleSort2(vet);
			System.out.print(".");
			sResBubble2PIOR = srt.bubbleSort2(vetAux);
			System.out.print(".");

			//			resIterHeap[pos] = sResHeap.getIteracoes();
			// resIterQuick[pos] = sResQuick.getIteracoes();
			resIterMerge[pos] = sResMerge.getIteracoes();
			resIterInsert[pos] = sResInsert.getIteracoes();
			resIterBubble0[pos] = sResBubble0.getIteracoes();
			resIterBubble1[pos] = sResBubble1.getIteracoes();
			resIterBubble2[pos] = sResBubble2.getIteracoes();
			resIterBubble2PIOR[pos] = sResBubble2PIOR.getIteracoes();

			//			resInstrHeap[pos] = sResHeap.getInstrucoes();
			// resInstrQuick[pos] = sResQuick.getInstrucoes();
			resInstrMerge[pos] = sResMerge.getInstrucoes();
			resInstrInsert[pos] = sResInsert.getInstrucoes();
			resInstrBubble2[pos] = sResBubble2.getInstrucoes();
			resInstrBubble2PIOR[pos] = sResBubble2PIOR.getInstrucoes();

			//			resClockHeap[pos] = sResHeap.getTime();
			// resClockQuick[pos] = sResQuick.getTime();
			resClockMerge[pos] = sResMerge.getTime();
			resClockInsert[pos] = sResInsert.getTime();
			resClockBubble0[pos] = sResBubble0.getTime();
			resClockBubble1[pos] = sResBubble1.getTime();
			resClockBubble2[pos] = sResBubble2.getTime();
			resClockBubble2PIOR[pos] = sResBubble2PIOR.getTime();

		}
		System.out.println("\nFeito!");

		System.out.println("\nBubble Sort v0 - dois laços fixos");
		System.out.println("Nro iter pela classe complexidade - n ^ 2: " +
				TAM_VETOR * TAM_VETOR);
		System.out.println("Nro iteracoes:");
		exibe(resIterBubble0, 20);
		System.out.println("Tempo em segundos:");
		exibe(resClockBubble0, 20);
	
		System.out.println("\n\nBubble Sort v1 - sempre até o final do vetor, mas testando se ordenado");
		System.out.println("Nro iter pela classe complexidade - Melhor Caso - n: " +
				TAM_VETOR +
				"\nNro iter pela classe complexidade - Pior Caso - n ^ 2: " +
				TAM_VETOR * TAM_VETOR);
		System.out.println("Nro iteracoes:");
		exibe(resIterBubble1, 20);
		System.out.println("Tempo em segundos:");
		exibe(resClockBubble1, 20);

		System.out.println("\nBubble Sort v2 - decrementando o final do vetor e testando se ordenado");
		System.out.println("Nro iter pela classe complexidade - Melhor Caso - n: " +
				TAM_VETOR +
				"\nNro iter pela classe complexidade - Pior Caso - n ^ 2: " +
				TAM_VETOR * TAM_VETOR);
		System.out.println("Nro iteracoes:");
		exibe(resIterBubble2, 20);
		System.out.println("Nro instrucoes:");
		exibe(resInstrBubble2, 20);
		System.out.println("Tempo em segundos:");
		exibe(resClockBubble2, 20);

		System.out.println("\nBubble Sort v2 - decrementando o final do vetor e testando se ordenado - PIOR CASO");
		System.out.println("Nro iter pela classe complexidade - Melhor Caso - n: " +
				TAM_VETOR +
				"\nNro iter pela classe complexidade - Pior Caso - n ^ 2: " +
				TAM_VETOR * TAM_VETOR);
		System.out.println("Nro iteracoes:");
		exibe(resIterBubble2PIOR, 20);
		System.out.println("Nro instrucoes:");
		exibe(resInstrBubble2PIOR, 20);
		System.out.println("Tempo em segundos:");
		exibe(resClockBubble2PIOR, 20);

		System.out.println("\nInsert Sort");
		System.out.println("Nro iter pela classe complexidade - Melhor Caso - n : " +
				TAM_VETOR  +
				"\nNro iter pela classe complexidade - Pior Caso - n^2: " +
				TAM_VETOR * TAM_VETOR);
		System.out.println("Nro iteracoes:");
		exibe(resIterInsert, 20);
		System.out.println("Nro instrucoes:");
		exibe(resInstrInsert, 20);
		System.out.println("Tempo em segundos:");
		exibe(resClockInsert, 20);

		System.out.println("\nMerge Sort");
		System.out.println("Nro iter pela classe complexidade - Melhor Caso - n log n: " +
				TAM_VETOR * (Math.log10(TAM_VETOR)/Math.log10(2)) +
				"\nNro iter pela classe complexidade - Pior Caso - n log n: " +
				TAM_VETOR * (Math.log10(TAM_VETOR)/Math.log10(2)));
		System.out.println("Nro iteracoes:");
		exibe(resIterMerge, 20);
		System.out.println("Nro instrucoes:");
		exibe(resInstrMerge, 20);
		System.out.println("Tempo em segundos:");
		exibe(resClockMerge, 20);

		// System.out.println("\nQuick Sort");
		// System.out.println("Nro iter pela classe complexidade - Melhor Caso - n log n: " +
		// 		TAM_VETOR * (Math.log10(TAM_VETOR)/Math.log10(2)) +
		// 		"\nNro iter pela classe complexidade - Pior Caso - n^2: " +
		// 		TAM_VETOR * TAM_VETOR);
		// exibe(resIterQuick, 20);
		// System.out.println("Nro instrucoes:");
		// exibe(resInstrQuick, 20);
		// System.out.println("Tempo em segundos:");
		// exibe(resClockQuick, 20);

		//		System.out.println("\n Heap Sort");
		//		System.out.println("Nro iter pela classe complexidade - n log n: " +
		//		                    TAM_VETOR * (Math.log10(TAM_VETOR)/Math.log10(2)));
		//		exibe(resIterHeap, 20);
		//		System.out.println("Nro instrucoes:");
		//		exibe(resInstrHeap, 20);
		//		System.out.println("Tempo em segundos:");
		//		exibe(resClockHeap, 20);
	}

	public static void main(String argc[]) {

		//		ITERACOES = 1;
		//		ELEMENTOS = 4;
		//		System.out.println("********* Nro de Iterações - " + ITERACOES + " execuções de " + ELEMENTOS + " elementos");
		//		iteraTestes(ITERACOES, ELEMENTOS);
		//
		//		ITERACOES = 1;
		//		ELEMENTOS = 5;
		//		System.out.println("********* Nro de Iterações - " + ITERACOES + " execuções de " + ELEMENTOS + " elementos");
		//		iteraTestes(ITERACOES, ELEMENTOS);
		//
		//		ITERACOES = 1;
		//		ELEMENTOS = 6;
		//		System.out.println("********* Nro de Iterações - " + ITERACOES + " execuções de " + ELEMENTOS + " elementos");
		//		iteraTestes(ITERACOES, ELEMENTOS);
		//
		//		ITERACOES = 1;
		//		ELEMENTOS = 7;
		//		System.out.println("********* Nro de Iterações - " + ITERACOES + " execuções de " + ELEMENTOS + " elementos");
		//		iteraTestes(ITERACOES, ELEMENTOS);
		//
		//		ITERACOES = 1;
		//		ELEMENTOS = 8;
		//		System.out.println("********* Nro de Iterações - " + ITERACOES + " execuções de " + ELEMENTOS + " elementos");
		//		iteraTestes(ITERACOES, ELEMENTOS);

		ITERACOES = 1;
		ELEMENTOS = 10;
		System.out.printf(Locale.FRANCE,"********* Nro de Iterações - %,8d execuções de %,8d elementos\n", ITERACOES, ELEMENTOS);
		iteraTestes(ITERACOES, ELEMENTOS);

		ITERACOES = 1;
		ELEMENTOS = 10_000;
		System.out.printf(Locale.FRANCE,"********* Nro de Iterações - %,8d execuções de %,8d elementos\n", ITERACOES, ELEMENTOS);
		iteraTestes(ITERACOES, ELEMENTOS);

		ITERACOES = 1;
		ELEMENTOS = 100_000;
		System.out.printf(Locale.US,"********* Nro de Iterações - %,8d execuções de %,8d elementos\n", ITERACOES, ELEMENTOS);
		iteraTestes(ITERACOES, ELEMENTOS);

		ITERACOES = 1;
		ELEMENTOS = 200_000;
		System.out.printf(Locale.FRENCH,"********* Nro de Iterações - %,8d execuções de %,8d elementos\n", ITERACOES, ELEMENTOS);
		iteraTestes(ITERACOES, ELEMENTOS);

		ITERACOES = 1;
		ELEMENTOS = 500_000;
		System.out.printf(Locale.FRENCH,"********* Nro de Iterações - %,8d execuções de %,8d elementos\n", ITERACOES, ELEMENTOS);
		iteraTestes(ITERACOES, ELEMENTOS);
	}
}
