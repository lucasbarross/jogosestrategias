package br.ufpe.cin.jogosestrategia;

public class JogoEstrategia {
	private double[] estrategiaP;
	private double[] estrategiaQ;
	private double valorEsperado;
	
	public JogoEstrategia(double[] estrategiaP, double[] estrategiaQ, double valorEsperado) {
		this.estrategiaP = estrategiaP;
		this.estrategiaQ = estrategiaQ;
		this.valorEsperado = valorEsperado;
	}
	
	public static JogoEstrategia calcular(double[][] m) {
		double[] estrategiaP = new double[2];
		double[] estrategiaQ = new double[2];
		double valorEsperado;
		
		//Até o ultimo else: checa se o jogo é determinado.
		if(m[0][0] <= m[0][1] && m[0][0] >= m[1][0]) {
			estrategiaP[0] = 1;
			estrategiaQ[0] = 1;
			valorEsperado = m[0][0];
		} else if(m[0][1] <= m[0][0] && m[0][1] >= m[1][1]) {
			estrategiaP[0] = 1;
			estrategiaQ[1] = 1;
			valorEsperado = m[0][1];
		}  else if(m[1][0] <= m[1][1] && m[1][0] >= m[0][0]) {
			estrategiaP[1] = 1;
			estrategiaQ[0] = 1;
			valorEsperado = m[1][0];
		}  else if(m[1][1] <= m[1][0] && m[1][1] >= m[0][1]) {
			estrategiaP[1] = 1;
			estrategiaQ[1] = 1;
			valorEsperado = m[1][1];
		} else {
			estrategiaP[0] = (m[1][1] - m[1][0])/(m[0][0]+m[1][1]-m[0][1]-m[1][0]);
			estrategiaP[1] = (m[0][0] - m[0][1])/(m[0][0]+m[1][1]-m[0][1]-m[1][0]);
			estrategiaQ[0] = (m[1][1] - m[0][1])/(m[0][0]+m[1][1]-m[0][1]-m[1][0]);
			estrategiaQ[1] = (m[0][0] - m[1][0])/(m[0][0]+m[1][1]-m[0][1]-m[1][0]);
			valorEsperado = (m[0][0] * m[1][1] - m[0][1] * m[1][0])/(m[0][0]+m[1][1]-m[0][1]-m[1][0]);
		} 
		
		return new JogoEstrategia(estrategiaP, estrategiaQ, valorEsperado);
	}
	
	public double[] getEstrategiaP() {
		return this.estrategiaP;
	}
	public double[] getEstrategiaQ() {
		return this.estrategiaQ;	
	}
	public double getValorEsperado() {
		return this.valorEsperado;	
	}	
}