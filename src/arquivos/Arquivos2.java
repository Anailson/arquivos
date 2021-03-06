package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Anailson - Lendo arquivos de textos
 */
public class Arquivos2 {

	public static void main(String[] args) throws IOException {
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setEmail("pessoa1@gmail.com");
		pessoa1.setIdade(50);
		pessoa1.setNome("Usuario Teste Lista ");
			

		Pessoa pessoa2 = new Pessoa();
		pessoa2.setEmail("pessoa2@gmail.com");
		pessoa2.setIdade(30);
		pessoa2.setNome("Pessoa 2 Teste Lista ");
		

		Pessoa pessoa3 = new Pessoa();
		pessoa3.setEmail("pessoa3@gmail.com");
		pessoa3.setIdade(15);
		pessoa3.setNome("Usuario3 Teste Lista ");
		
		//A LISTA PODE VIR DE ALGUM BANCO DE DADOS OU FONTE DE DADOS
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		
		
		File arquivo = new File("C:\\eclipse-workspace\\modulo-arquivos\\src\\arquivos\\listapessoas-arquivo.txt");
		
		if (!arquivo.exists()) {//caso n?o tenha o arquivo [teste-arquivo.tx] o mesmo ser? criado
			arquivo.createNewFile();
		}
		
		FileWriter escrever_no_arquivo = new FileWriter(arquivo);
		
		for (Pessoa p : pessoas) {
			escrever_no_arquivo.write(p.getNome() +
					";" + p.getEmail() + ";" +
					p.getIdade()+ "\n");
		}
		
		escrever_no_arquivo.flush();
		escrever_no_arquivo.close();

	}

}
