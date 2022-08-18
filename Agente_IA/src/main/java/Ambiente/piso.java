package Ambiente;

import Agente.Aspirador;
import Funcao.PosicaoXY;

public class piso {
    
    private int tamanhopiso;
	
	private String[][] piso;
	
	private Aspirador aspirador;
	
	/* Valores
	 * S - Sujo
	 * L - Limpo
	 * *A* - Agente
	 */
	
	public piso(int tamanhopiso) {
		this.tamanhopiso = tamanhopiso;
		this.construirNovoPiso();
	}
	
	// Construir o piso
	private void construirNovoPiso() {
		piso = new String[this.tamanhopiso][this.tamanhopiso];
		for (int i = 0; i < this.tamanhopiso; i++) {
			for (int j = 0; j < this.tamanhopiso; j++) {
				this.piso[i][j] = "S";
			}
		}
	}
	
	public void exibirpiso() {
		atualizarPosicaoAgente();
		for (int i = 0; i < tamanhopiso; i++) {
			for (int j = 0; j < tamanhopiso; j++) {
				if (piso[i][j].equals("*A*")) {
					System.out.print("|" + piso[i][j] + "|");
				} else {
					System.out.print("| " + piso[i][j] + " |");
				}
				
			}
			System.out.println("");
		}
		System.out.println("");
	}

	private void atualizarPosicaoAgente() {
		if (this.aspirador != null) {
			PosicaoXY posAgente = this.aspirador.getPosicao();
			piso[posAgente.getPosX()][posAgente.getPosY()] = "*A*";
		}
	}

	public int getTamanhopiso() {
		
		return this.tamanhopiso;
	}

	public String retornarValorPosicaoLabirinto(PosicaoXY posicao) {
		return this.piso[posicao.getPosX()][posicao.getPosY()];
	}

	public void setAgente(Aspirador aspirador) {
		this.aspirador = aspirador;
	}

	public void limpar() {
		PosicaoXY posicao = this.aspirador.getPosicao();
		piso[posicao.getPosX()][posicao.getPosY()] = "L";
	}
	

}
