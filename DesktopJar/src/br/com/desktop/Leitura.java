package br.com.desktop;
//abduhabah
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JTextField;

public class Leitura {
	
	String pathEntrada;
	String pathSaida;
	
	public void Tratamento(JTextField textField, JTextField textField2) {
	
		
	String aux2="";
	try {
		
		
		
		textField.setText(pathEntrada);
		textField.setText(pathSaida);
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

	
}
}
