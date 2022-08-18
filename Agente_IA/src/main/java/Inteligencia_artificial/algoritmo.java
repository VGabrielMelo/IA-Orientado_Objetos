package Inteligencia_artificial;



import Ambiente.piso;
import Agente.Aspirador;
import Funcao.PosicaoXY;

public class algoritmo {

	public static void main(String[] args) throws InterruptedException	 {
		
		piso piso = new piso(4);	
		piso.exibirpiso();
		
		Aspirador aspirador = new Aspirador(piso);
		aspirador.setPosicao(new PosicaoXY(3,3));

		while(aspirador.isAindaLimpando()) {
			aspirador.zerarPilha();
			aspirador.movimentar(); 
			piso.exibirpiso();
			Thread.sleep(1000);
		}
	}

}
