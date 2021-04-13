package br.pucrs.sorts;

import java.util.Random;

import br.pucrs.heap.HeapBasics;
import br.pucrs.util.ContagemRes;

public class Sorts {

	private long iteracoes = 0;
	private long instrucoes = 0;
	private long tempoIni = 0, tempoFim = 0;

	public long getInstrucoes() {
		return instrucoes;
	}

	public void setInstrucoes(long instrucoes) {
		this.instrucoes = instrucoes;
	}

	public long getIteracoes() {
		return iteracoes;
	}

	public void setIteracoes(long iteracoes) {
		this.iteracoes = iteracoes;
	}

	public void incrIteracoes(int incr) {
		setIteracoes(getIteracoes() + incr);
	}

	public void incrInstrucoes(int instr) {
		setInstrucoes(getInstrucoes() + instr);
	}

	public void initClock() {
		tempoIni = tempoFim = System.nanoTime();
	}

	public double getClockSec() {
		double res;

		tempoFim = System.nanoTime();
		res =  ((double)tempoFim - (double)tempoIni) / (double)1_000_000_000.0;

		return res;
	}

	private void resetCounters() {
		setIteracoes(0);
		setInstrucoes(0);
		initClock();
	}

	public long[] geraVetor(int nroElem, int lim){
		int dummy;
		long [] res = null;
		int cont = 0;
		Random rnd = new Random(System.nanoTime() * System.currentTimeMillis());

		if (nroElem >= 0) {

			res = new long[nroElem];

			while (cont < nroElem) {
				dummy = rnd.nextInt(lim)+1;
				dummy = rnd.nextInt(lim)+1;
				
				dummy = rnd.nextInt(lim)+1;
				res[cont++] = (long) dummy;
			}
		}
		return res;
	}

	public long[] geraVetorInv(int nroElem){
		long [] res = null;
		
		if (nroElem > 0) {

			res = new long[nroElem];

			for (int i = nroElem -1; i >= 0; i--)
				res[i] = (long) nroElem - i;
		}
		return res;
	}


	// Insira os métodos de sort aqui.

	public ContagemRes heapSort(long [] vet) {
		ContagemRes res = new ContagemRes();
		HeapBasics hBasics = new HeapBasics();
		long [] v = vet.clone();
		long aux;
		int n;

		resetCounters();

		hBasics.buildMaxHeap(v); 
		n = v.length; 

		incrInstrucoes(11);

		for (int i = v.length - 1; i > 0; i--) { 

			incrIteracoes(1);
			incrInstrucoes(15);

			aux = v[0];
			v[0] = v[i];
			v[i] = aux;
			hBasics.maxHeapify(v, 0, --n);
		}

		res.setTime(getClockSec());
		res.setIteracoes(getIteracoes());
		res.setInstrucoes(getInstrucoes());
		res.setResult(v);
		return res;
	}



	public ContagemRes quickSort(long[] vet) {
		ContagemRes res = new ContagemRes();
		long [] v = vet.clone();

		resetCounters();
		incrInstrucoes(7);

		quickSort(v, 0, v.length-1);

		res.setTime(getClockSec());
		res.setResult(v);
		res.setIteracoes(getIteracoes());
		res.setInstrucoes(getInstrucoes());
		return res;
	}

	private void quickSort(long[] v, int left, int right) {
		incrIteracoes(1);
		incrInstrucoes(1);


		if (right > left) {
			incrInstrucoes(7);

			int pivotIndex = left;  
			int pivotNewIndex = partition(v, left, right, pivotIndex);
			quickSort(v, left, pivotNewIndex-1);
			quickSort(v, pivotNewIndex+1, right);
		}  
	}

	private int partition(long [] array, int left, int right, int pivotIndex) {
		long aux;

		long pivotValue = array[pivotIndex];

		aux = array[pivotIndex];
		array[pivotIndex] = array[right];
		array[right] = aux;

		int storeIndex = left;
		incrInstrucoes(11);

		for (int i = left; i <= right-1; i++){
			incrIteracoes(1);
			incrInstrucoes(5);

			if (array[i] < pivotValue) {
				incrInstrucoes(9);

				aux = array[storeIndex];
				array[storeIndex] = array[i];
				array[i] = aux;

				storeIndex = storeIndex + 1;
			}
		}

		aux = array[right];
		array[right] = array[storeIndex];
		array[storeIndex] = aux;
		incrInstrucoes(8);

		return storeIndex;
	}

	public ContagemRes insertSort(long [] vet) {
		ContagemRes res = new ContagemRes();
		long [] v = vet.clone();

		resetCounters();

		insertSortAux(v);

		res.setTime(getClockSec());
		res.setResult(v);
		res.setIteracoes(getIteracoes());
		res.setInstrucoes(getInstrucoes());
		return res;
	}


	void insertSortAux(long[] v) {
		int i = 0;
		incrInstrucoes(1);
		while (i < v.length) {
			incrIteracoes(1);
			incrInstrucoes(6);
			findPos(v, i, v[i]);
			i = i + 1;
		}
	}

	void findPos(long[] a, int tam, long value) {
		int i = tam - 1;
		incrInstrucoes(2);
		while (i >= 0 && a[i] > value) {
			incrInstrucoes(10);
			incrIteracoes(1);
			a[i + 1] = a[i];
			i = i - 1;
		}
		incrInstrucoes(3);
		a[i + 1] = value;
	}

	public ContagemRes bubbleSort0(long [] vet) {
		ContagemRes res = new ContagemRes();
		long[] v = vet.clone();

		resetCounters();
		bubbleSort0Aux(v);

		res.setTime(getClockSec());
		res.setResult(v);
		res.setIteracoes(getIteracoes());
		return res;
	}

	private void bubbleSort0Aux(long [] vet) {
		long aux; 
		int i;
		for (int j = 0; j < vet.length - 1; j++) {
			for (i = 0; i < vet.length - 1; i++) {
				incrIteracoes(1);
				if (vet[ i ] > vet[ i + 1 ]) {
					aux = vet[i];
					vet[ i ] = vet[ i + 1 ];
					vet[i + 1] = aux;
				}		         
			}

			if (i == 0)
				incrIteracoes(1);
		}
	}

	public ContagemRes bubbleSort1(long [] vet) {
		ContagemRes res = new ContagemRes();
		long[] v = vet.clone();

		resetCounters();
		bubbleSort1Aux(v);

		res.setTime(getClockSec());
		res.setResult(v);
		res.setIteracoes(getIteracoes());
		return res;
	}

	private void bubbleSort1Aux(long [] vet) {
		boolean swapped;
		long aux;
		int i;
		do {
			swapped = false;
			for (i = 0; i < vet.length - 1; i++) {
				incrIteracoes(1);
				if (vet[ i ] > vet[ i + 1 ]) {
					aux = vet[i];
					vet[ i ] = vet[ i + 1 ];
					vet[i + 1] = aux;
					swapped = true;
				}		         
			}

			if (i == 0)
				incrIteracoes(1);


		} while (swapped);
	}

	public ContagemRes bubbleSort2(long [] vet) {
		ContagemRes res = new ContagemRes();
		long [] v = vet.clone();

		resetCounters();
		bubbleSort2Aux(v);

		res.setTime(getClockSec());
		res.setResult(v);
		res.setIteracoes(getIteracoes());
		res.setInstrucoes(getInstrucoes());
		return res;
	}

	private void bubbleSort2Aux(long [] vet) {
		boolean swapped;
		long aux; 
		int i, fim = vet.length - 1;
		incrInstrucoes(3);
		do {
			swapped = false;
			incrInstrucoes(2);

			for (i = 0; i < fim; i++) {
				incrIteracoes(1);
				incrInstrucoes(7);

				if (vet[ i ] > vet[ i + 1 ]) {
					incrInstrucoes(11);
					aux = vet[i];
					vet[ i ] = vet[ i + 1 ];
					vet[i + 1] = aux;
					swapped = true;
				}
			}

			fim--;
			incrInstrucoes(3);
			if (i == 0)
				incrIteracoes(1);

		} while (swapped);
	}

	public ContagemRes mergeSort(long [] vet)
	{
		ContagemRes res = new ContagemRes();
		long [] v = vet.clone();

		resetCounters();
		mergeSort(v, 0, v.length-1);

		res.setTime(getClockSec());
		res.setResult(v);
		res.setIteracoes(getIteracoes());
		res.setInstrucoes(getInstrucoes());
		return res;
	}

	private void mergeSort(long [] v, int inicio, int fim)
	{
		incrIteracoes(1);
		incrInstrucoes(1);
		if (inicio < fim)
		{
			int meio = (inicio + fim) / 2;
			mergeSort(v, inicio, meio);
			mergeSort(v, meio+1, fim);
			merge(v, inicio, meio, fim);
			incrInstrucoes(7);
		}
	}

	private void merge(long [] v, int inicio, int meio, int fim) {
		int nL = meio-inicio+1; int nR = fim-meio;
		long [] L = new long[nL]; long [] R = new long[nR];

		System.arraycopy(v, inicio, L, 0, nL);
		incrIteracoes(nL);

		System.arraycopy(v, meio+1, R, 0, nR);
		incrIteracoes(nR);

		incrInstrucoes(10);

		incrInstrucoes(1);
		int iL = 0; int iR = 0;
		for (int k=inicio; k<=fim; k++) {

			incrIteracoes(1);
			incrInstrucoes(4);

			if (iR < nR) {
				incrInstrucoes(1);
				if (iL < nL) {
					incrInstrucoes(7);
					if (L[iL] < R[iR]) v[k] = L[iL++];
					else v[k] = R[iR++];
				}
				else {
					v[k] = R[iR++];
					incrInstrucoes(5);
				}
			}
			else {
				v[k] = L[iL++];
				incrInstrucoes(5);
			}
		}
	}
}
