package business;

import java.util.Arrays;

public class GrafoDirecionado {
	
	private int qtdVertices, limiteArestas;
	private int[][] grafo;
	
	// - 0 1 2 3 4 5 6 7 8 9
	// 0 - - - - - - - - - - 
	// 1 - - - - - - - - - -
	// 2 - 1 - - 1 - - - - -
	// 3 - - 1 - 1 - - - - -
	// 4 - 1 - - - - - - - -
	// 5 - - - - - - - - - -
	// 6 - - - - - - - - - -
	// 7 - - - - - - - - - -
	// 8 - - - - - - - - - -
	// 9 - - - - - - - - - -
	
	public GrafoDirecionado(int qtdVertices, int limiteArestas) {
		if (limiteArestas > qtdVertices) {
			System.out.println("O numero maximo de arestas por vertice não pode ser maior que o numero de vertices");
			return;
		}
		
		this.qtdVertices = qtdVertices;
		this.limiteArestas = limiteArestas;
		
		this.grafo = new int[qtdVertices][qtdVertices];
		
		gerarGrafo(this.grafo);
	}
	
	public void gerarGrafo(int[][] grafo) {
		
		for (int i = 0; i < qtdVertices; i++) {
			for (int j = 0; j < qtdVertices; j++) {
				grafo[i][j] = 0;
			}
		}
		
		for (int i = 0; i < qtdVertices; i++) {
			for (int j = 0; j < limiteArestas; j++) {
				for(;;) {
					int randomVertice = (int)(Math.random() * (qtdVertices));
					
					if (grafo[i][randomVertice] != 1 && randomVertice != i) {
						grafo[i][randomVertice] = 1;
						break;
					}
				}
			}
		}
	}
	
	public void print() {
		for (int i = 0; i < qtdVertices; i++) {
			System.out.println(i + ": " + Arrays.toString(getVizinhanca(i)));
		}
	}
	
	public int[] getVizinhanca(int vertice) {
		int[] vizinhanca = new int[limiteArestas]; int j = 0;
		for (int i = 0; i < qtdVertices; i++) {
			if (this.grafo[vertice][i] == 1) {
				vizinhanca[j] = i;
				j++;
			}
		}
		return vizinhanca;
	}
}
