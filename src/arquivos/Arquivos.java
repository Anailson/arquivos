package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Anailson - Lendo arquivos de textos
 */
public class Arquivos {

	public static void main(String[] args) throws IOException {
		
		File arquivo = new File("C:\\eclipse-workspace\\modulo-arquivos\\src\\arquivos\\teste-arquivo.txt");
		
		if (!arquivo.exists()) {//caso não tenha o arquivo [teste-arquivo.tx] o mesmo será criado
			arquivo.createNewFile();
		}
		
		FileWriter escrever_no_arquivo = new FileWriter(arquivo);
		
		for (int i = 0; i <=10; i++) {
			escrever_no_arquivo.write("Texto da minha linha" + i + "\n");
		}
		
		//escrever_no_arquivo.write("Meu texto do arquivo");
		//escrever_no_arquivo.write("\n");
		//escrever_no_arquivo.write("Minha segunda linha");
		
		
		escrever_no_arquivo.flush();
		escrever_no_arquivo.close();

	}

}
