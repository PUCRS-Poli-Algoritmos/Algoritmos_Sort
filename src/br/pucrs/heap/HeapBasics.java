package br.pucrs.heap;

public class HeapBasics {
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

	public void resetCounters() {
		setIteracoes(0);
		setInstrucoes(0);
		initClock();
	}
	
	public void buildMaxHeap(long v[]) { 

		incrInstrucoes(5);

		for (int i = v.length/2 - 1; i >= 0; i--){

			incrIteracoes(1);
			incrInstrucoes(7);

			maxHeapify(v, i , v. length ); 
		}
	} 

	public void maxHeapify(long v [], int pos, int n) { 
		long aux;
		int max = 2 * pos + 1, right = max + 1;

		incrIteracoes(1);

		if (max < n) { 
			incrInstrucoes(5);
			if ( right < n && v[max] < v[right]){
				max = right;
				incrInstrucoes(1);
			}

			incrInstrucoes(3);
			if (v[max] > v[pos]) {
				incrInstrucoes(8);

				aux = v[pos];
				v[pos] = v[max];
				v[max] = aux;
				maxHeapify(v, max, n); 
			} 
		} 
	} 
}
