package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivoTxt {

	public static void main(String[] args) throws FileNotFoundException {

		/*
		FileInputStream entradaArquivo = new FileInputStream(
				new File("C:\\eclipse-workspace\\modulo-arquivos\\src\\arquivos\\listapessoas-arquivo.csv"));
		*/
		FileInputStream entradaArquivo = new FileInputStream(
				new File("C:\\eclipse-workspace\\modulo-arquivos\\src\\arquivos\\registros-arquivo.csv"));

		Scanner lerArquivo = new Scanner(entradaArquivo, "UTF-8");
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		while (lerArquivo.hasNext()) {

			String linha = lerArquivo.nextLine(); // pegando a linha

			if (linha != null && !linha.isEmpty()) {

					//String[] dados = linha.split("\\|");
				String[] dados = linha.split("\\;");
					
					Pessoa pessoa = new Pessoa();
					pessoa.setNome(dados[0]);
					pessoa.setEmail(dados[1]);
					pessoa.setIdade(Integer.parseInt(dados[2]));
					
					pessoas.add(pessoa);
			
			}

		}
		for (Pessoa pessoa : pessoas) {//poderia gravar no banco de dados, gravar boletos etc
			System.out.println(pessoa);
		}

	}

}
