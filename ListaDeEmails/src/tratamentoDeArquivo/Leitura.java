package tratamentoDeArquivo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//import auxiliar.envio;


public class Leitura {
	
	
	public static void main(String[] args) {
		String aux2="";
		try {
			FileReader leitura = new FileReader("C:/Desenvolvimento/arqLeitura.txt"); // colocar o caminho do arquivo de entrada
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
			FileWriter escrita = new FileWriter("C:/Desenvolvimento/ArqFinal.txt",false);//não apaga o arquivo
			BufferedWriter bE = new BufferedWriter(escrita);
			
			Collections.sort(lista);
			for(String aux:lista){
				bE.write(aux+",");
			    aux2=aux2+aux+", ";
			}
			System.out.println(aux2);
			bE.close();
			escrita.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
				
		
		
		
		String assunto1 = "Testando";
		String mensagem1 = "OO2-Teste-E-mail";
		
		//envio teste = new envio();
		//teste.listaDeEnvio(aux2, assunto1, mensagem1);
		
	}
	
}