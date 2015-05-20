package br.com.desktop.tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import br.com.desktop.Leitura;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.Font;
import java.awt.Color;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;

public class telaPrincipal {

	private JFrame frame;
	private JTextField entradaField;
	private JTextField saidaField;
	
	//Leitura tratamento = new Leitura(); 
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaPrincipal window = new telaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public telaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.BLUE);
		frame.getContentPane().setFont(new Font("Symbol", Font.PLAIN, 14));
		frame.setBounds(100, 100, 450, 312);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTratamentoDeArquivos = new JLabel("Tratamento de Arquivos");
		lblTratamentoDeArquivos.setForeground(Color.BLUE);
		lblTratamentoDeArquivos.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTratamentoDeArquivos.setBounds(143, 33, 229, 23);
		frame.getContentPane().add(lblTratamentoDeArquivos);
		
		entradaField = new JTextField();
		entradaField.setBounds(27, 93, 385, 28);
		frame.getContentPane().add(entradaField);
		entradaField.setColumns(10);
		
		JLabel lblCaminhoDoArquivo = new JLabel("Caminho do Arquivo de Entrada");
		lblCaminhoDoArquivo.setBounds(132, 67, 223, 15);
		frame.getContentPane().add(lblCaminhoDoArquivo);
		
		JLabel lblCaminhoDoArquivo_1 = new JLabel("Caminho e Nome do Arquivo de Sa\u00EDda");
		lblCaminhoDoArquivo_1.setBounds(132, 168, 240, 14);
		frame.getContentPane().add(lblCaminhoDoArquivo_1);
		
		saidaField = new JTextField();
		saidaField.setBounds(27, 193, 385, 23);
		frame.getContentPane().add(saidaField);
		saidaField.setColumns(10);
		
		JButton btnSubmeter = new JButton("Submeter");
		btnSubmeter.setForeground(Color.RED);
		btnSubmeter.setAction(action);
		btnSubmeter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnSubmeter.setBounds(174, 227, 89, 23);
		frame.getContentPane().add(btnSubmeter);
		
		JLabel lblExCdesenvolvimentoarqleituratxt = new JLabel("Ex: C:/Desenvolvimento/arqLeitura.txt  ");
		lblExCdesenvolvimentoarqleituratxt.setBounds(37, 123, 375, 14);
		frame.getContentPane().add(lblExCdesenvolvimentoarqleituratxt);
		
		JLabel lblNewLabel = new JLabel("(o arquivo e pasta especificados devem existir no pc)");
		lblNewLabel.setBounds(37, 132, 275, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JList list = new JList();
		list.setBounds(27, 322, 1, 1);
		frame.getContentPane().add(list);
		
	}
	



	
public String Tratamento(String pathEntrada, String pathSaida) {
	
	
	String aux2="";
	try {
		
		FileReader leitura = new FileReader(pathEntrada); // //c:/a/texto.txt
		BufferedReader bL = new BufferedReader(leitura);
		
		
		
		ArrayList<String> lista = new ArrayList<String>();
		while (true) {
			String l = bL.readLine();
			
			if (l == null){
				break;
			}
			
			l=l.replaceAll("<", " ");
			l=l.replaceAll(">", " ");
			l=l.replaceAll(",", " ");
			l=l.replaceAll("com.br", "com.br ");
			l=l.replaceAll("com","com ");
			l=l.replaceAll("com .", "com ");
			
	
			
			
			String[] texto = l.split(" ");
			int tam = texto.length;
			
			for(int i=0;i<tam;i++){
				if(texto[i].contains("@")){
					lista.add(texto[i]);	
					
				}
				}
			}

		bL.close();
		leitura.close();
		FileWriter escrita = new FileWriter(pathSaida,false);//não apaga o arquivo
		BufferedWriter bE = new BufferedWriter(escrita);
		
		Collections.sort(lista);
		for(String aux:lista){
			bE.write(aux+",");
		    aux2=aux2+aux+", ";
		}
		//System.out.println(aux2);
		
		
		System.out.println("Sucesso");
		bE.close();
		escrita.close();
} catch (Exception e) {
	e.printStackTrace();
}
	return aux2;

	
}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Carregar");
			putValue(SHORT_DESCRIPTION, "Carrega arquivo de entrada e saída");
		}
		public void actionPerformed(ActionEvent e) {
			String path1 = entradaField.getText();
			String path2 = saidaField.getText();
			String saida = Tratamento(path1,path2);
			
			//saida=saida.replaceAll(",", "\n");
			//comboBox.setText(saida);
			
			//System.out.println("Vamos logo");
			
		}
	}
}

