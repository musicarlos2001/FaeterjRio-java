package br.com.desktop;

/** Método para abrir um arquivo e trata-lo para extrair os e-mails
 * necessário especificar os caminhos dos arquivos

 * @author Carlos Alves

 * @param  caminho dos arquivos de entrada e saída

 

 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class LeituraArquivo {
	private String path = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		



		
		
		String aux2="";
		try {
			FileReader leitura = new FileReader("C:/Desenvolvimento/ArqLeitura.txt"); // //c:/a/texto.txt
			BufferedReader bL = new BufferedReader(leitura);
			ArrayList<String> lista = new ArrayList<String>();
			while (true) {
				String l = bL.readLine();
				//String[] teste = l.split(","); //ler emails 
				if (l == null){
					break;
				}
				//System.out.println("antes:"+l);
				l=l.replaceAll("<", " ");
				l=l.replaceAll(">", " ");
				l=l.replaceAll(",", " ");
				l=l.replaceAll("com.br", "com.br ");
				l=l.replaceAll("com","com ");
				l=l.replaceAll("com .", "com ");
				
			//	System.out.println("depois"+l);
				
				
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
			FileWriter escrita = new FileWriter("C:/Desenvolvimento/ArqGM1.txt",false);//não apaga o arquivo
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


