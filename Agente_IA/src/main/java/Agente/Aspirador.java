package Agente;

import Ambiente.piso;
import Funcao.PosicaoXY;

public class Aspirador {
    

	// Movimentar para 4 direções (Cima, baixo, esquerda, direita)
	// Referencia do Labiririnto 
	
	private piso piso;
	private MovimentosAspirador movimento;
	
	private PosicaoXY posXY;
	
	private int pilhaMovimentos;

	public Aspirador(piso piso) {
		this.piso = piso;
		piso.setAgente(this);
		this.posXY = new PosicaoXY();
		this.movimento = MovimentosAspirador.CIMA;
	}
	
	public void movimentar() {
		if (this.pilhaMovimentos >= 4) {
			return;
		}
		PosicaoXY proximoMovimento = retornarMovimento();
		String valor = this.piso.retornarValorPosicaoLabirinto(proximoMovimento);
		
		if (valor.equals("L") || valor.equals("*A*")) {
			proximoMovimento();
			aumentarPilha();
			movimentar();
		} else {
			this.piso.limpar();
			this.posXY = proximoMovimento;
		}
	}
	
	private void aumentarPilha() {
		this.pilhaMovimentos++;
	}

	private void proximoMovimento() {
		switch(this.movimento) {
			case CIMA:
				this.movimento = MovimentosAspirador.BAIXO;
				break;
			case BAIXO:
				this.movimento = MovimentosAspirador.ESQUERDA;
				break;
			case ESQUERDA:
				this.movimento = MovimentosAspirador.DIREITA;
				break;
			case DIREITA:
				this.movimento = MovimentosAspirador.CIMA;
				break;
		}
	}

	public PosicaoXY retornarMovimento() {
		int retornoPosX = this.posXY.getPosX();
		int retornoPosY = this.posXY.getPosY();
		switch(movimento) {
			case CIMA:
				if (retornoPosX > 0) {
					retornoPosX -= 1;
				}
				break;
			case BAIXO:
				if (retornoPosX < this.piso.getTamanhopiso() - 1) {
					retornoPosX += 1;
				}
				break;
			case ESQUERDA:
				if (retornoPosY > 0) {
					retornoPosY -= 1;
				}
				break;
			case DIREITA:
				if (retornoPosY < this.piso.getTamanhopiso() - 1) {
					retornoPosY += 1;
				}
				break;
		}
		return new PosicaoXY(retornoPosX, retornoPosY);
	}

	public PosicaoXY getPosicao() {
		return this.posXY;
	}

	public boolean isAindaLimpando() {
		return pilhaMovimentos < 4;
	}

	public void zerarPilha() {
		this.pilhaMovimentos = 0;
	}

	public void setPosicao(PosicaoXY posicaoXY) {
		this.posXY = posicaoXY;
		
	}
	
}

