package br.ufpe.cin.jogosestrategia;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class View extends JFrame {

	private JPanel contentPane;
	private JTextField m00;
	private JTextField m01;
	private JTextField m10;
	private JTextField m11;
	
	private JLabel resultadoL00;
	private JLabel resultadoL01;
	private JLabel resultadoC00;
	private JLabel resultadoC01;
	private JLabel lblValor;
	private JLabel lblError;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Cria a janela.
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJogosDeEstratgia = new JLabel("JOGOS DE ESTRAT\u00C9GIA");
		lblJogosDeEstratgia.setForeground(Color.WHITE);
		lblJogosDeEstratgia.setFont(new Font("OCR A Extended", Font.PLAIN, 36));
		lblJogosDeEstratgia.setBackground(Color.WHITE);
		lblJogosDeEstratgia.setHorizontalAlignment(SwingConstants.CENTER);
		lblJogosDeEstratgia.setBounds(199, 70, 556, 59);
		contentPane.add(lblJogosDeEstratgia);
		
		m00 = new JTextField();
		m00.setCaretColor(Color.WHITE);
		m00.setBorder(null);
		m00.setToolTipText("");
		m00.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		m00.setHorizontalAlignment(SwingConstants.CENTER);
		m00.setOpaque(false);
		m00.setForeground(Color.WHITE);
		m00.setBounds(124, 244, 138, 86);
		m00.setColumns(10);
		contentPane.add(m00);
		
		m01 = new JTextField();
		m01.setCaretColor(Color.WHITE);
		m01.setBorder(null);
		m01.setToolTipText("");
		m01.setHorizontalAlignment(SwingConstants.CENTER);
		m01.setOpaque(false);
		m01.setForeground(Color.WHITE);
		m01.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		m01.setColumns(10);
		m01.setBounds(272, 244, 143, 86);
		contentPane.add(m01);
		
		m10 = new JTextField();
		m10.setCaretColor(Color.WHITE);
		m10.setBorder(null);
		m10.setToolTipText("");
		m10.setHorizontalAlignment(SwingConstants.CENTER);
		m10.setOpaque(false);
		m10.setForeground(Color.WHITE);
		m10.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		m10.setColumns(10);
		m10.setBounds(124, 341, 138, 86);
		contentPane.add(m10);
		
		m11 = new JTextField();
		m11.setCaretColor(Color.WHITE);
		m11.setBorder(null);
		m11.setToolTipText("");
		m11.setHorizontalAlignment(SwingConstants.CENTER);
		m11.setOpaque(false);
		m11.setForeground(Color.WHITE);
		m11.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		m11.setColumns(10);
		m11.setBounds(272, 341, 143, 86);
		contentPane.add(m11);
		
		JLabel lblMatrizDeCompensao = new JLabel("Matriz de compensa\u00E7\u00E3o");
		lblMatrizDeCompensao.setForeground(Color.WHITE);
		lblMatrizDeCompensao.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblMatrizDeCompensao.setBounds(95, 197, 189, 23);
		contentPane.add(lblMatrizDeCompensao);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			///após alguem clicar no botao, irá chamar a função calcularJogo.
			public void actionPerformed(ActionEvent arg0) {
				try{
					calcularJogo(gerarMatriz());
				} catch(NumberFormatException e){
					lblError.setVisible(true);
					resultadoL00.setText("...");
					resultadoL01.setText("...");
					resultadoC00.setText("...");
					resultadoC01.setText("..."); 
				}
			}
		});
		btnNewButton.setBounds(184, 456, 161, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblResultados = new JLabel("Resultados");
		lblResultados.setForeground(Color.WHITE);
		lblResultados.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblResultados.setBounds(561, 192, 143, 23);
		contentPane.add(lblResultados);
		
		JLabel lblMelhorJogadaL = new JLabel("Melhor jogada - L");
		lblMelhorJogadaL.setHorizontalAlignment(SwingConstants.CENTER);
		lblMelhorJogadaL.setForeground(Color.WHITE);
		lblMelhorJogadaL.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMelhorJogadaL.setBounds(561, 244, 268, 23);
		contentPane.add(lblMelhorJogadaL);
		
		JLabel lblMelhorJogadaC = new JLabel("Melhor jogada - C");
		lblMelhorJogadaC.setHorizontalAlignment(SwingConstants.CENTER);
		lblMelhorJogadaC.setForeground(Color.WHITE);
		lblMelhorJogadaC.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMelhorJogadaC.setBounds(561, 310, 268, 32);
		contentPane.add(lblMelhorJogadaC);
		
		lblValor = new JLabel("Valor:");
		lblValor.setForeground(Color.WHITE);
		lblValor.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblValor.setBounds(561, 380, 213, 32);
		contentPane.add(lblValor);
		
		resultadoL00 = new JLabel("...");
		resultadoL00.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 15));
		resultadoL00.setForeground(Color.WHITE);
		resultadoL00.setBounds(601, 276, 138, 32);
		contentPane.add(resultadoL00);
		
		resultadoL01 = new JLabel("...");
		resultadoL01.setForeground(Color.WHITE);
		resultadoL01.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 15));
		resultadoL01.setBounds(714, 276, 161, 32);
		contentPane.add(resultadoL01);
		
		resultadoC00 = new JLabel("...");
		resultadoC00.setForeground(Color.WHITE);
		resultadoC00.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 15));
		resultadoC00.setBounds(601, 347, 138, 32);
		contentPane.add(resultadoC00);
		
		resultadoC01 = new JLabel("...");
		resultadoC01.setForeground(Color.WHITE);
		resultadoC01.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 15));
		resultadoC01.setBounds(720, 347, 109, 32);
		contentPane.add(resultadoC01);
		
		JLabel label = new JLabel("background");
		Image img = new ImageIcon(this.getClass().getResource("/background.png")).getImage();
		
		lblError = new JLabel("Valores inv\u00E1lidos!");
		lblError.setVisible(false);
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblError.setForeground(Color.RED);
		lblError.setBounds(184, 490, 161, 14);
		contentPane.add(lblError);
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, 0, getWidth(), getHeight());
		contentPane.add(label);
	}
	
	//retorna o jogo gerado pela matriz de compensaçao e passa para a funçao exibir resultados.
	public void calcularJogo(double[][] matrizCompesacao){
		JogoEstrategia jogo = JogoEstrategia.calcular(matrizCompesacao);
		exibirResultados(jogo);
	}
	
	public double[][] gerarMatriz(){
		double[][] matrizCompensacao = new double[2][2];

		matrizCompensacao[0][0] = Double.parseDouble(m00.getText());
		matrizCompensacao[0][1] = Double.parseDouble(m01.getText());
		matrizCompensacao[1][0] = Double.parseDouble(m10.getText());
		matrizCompensacao[1][1] = Double.parseDouble(m11.getText());
		
		return matrizCompensacao;
	}
	
	public void exibirResultados(JogoEstrategia jogo){
		DecimalFormat df = new DecimalFormat("0.0");
		resultadoL00.setText("L1: "+df.format(jogo.getEstrategiaP()[0]*100)+"%");
		resultadoL01.setText("L2: "+df.format(jogo.getEstrategiaP()[1]*100)+"%");
		resultadoC00.setText("C1: "+df.format(jogo.getEstrategiaQ()[0]*100)+"%");
		resultadoC01.setText("C2: "+df.format(jogo.getEstrategiaQ()[1]*100)+"%"); 
		lblValor.setText("Valor: "+df.format(jogo.getValorEsperado()));
		lblError.setVisible(false);
	}
}
