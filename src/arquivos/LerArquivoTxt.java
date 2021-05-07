package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LerArquivoTxt {

	public static void main(String[] args) throws FileNotFoundException {

		FileInputStream entradaArquivo = new FileInputStream(
				new File("C:\\eclipse-workspace\\modulo-arquivos\\src\\arquivos\\listapessoas-arquivo.txt"));

		Scanner lerArquivo = new Scanner(entradaArquivo, "UTF-8");

		while (lerArquivo.hasNext()) {

			String linha = lerArquivo.nextLine(); // pegando a linha

			if (linha != null && !linha.isEmpty()) {
				System.out.println(linha);
			}

		}

	}

}
