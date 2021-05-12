package arquivosapachepoi;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import arquivos.Pessoa;

public class ApachePoi {

	public static void main(String[] args) throws Exception {

		File file = new File("C:\\eclipse-workspace\\modulo-arquivos\\src\\arquivosapachepoi\\arquivo_excel.xls");

		if (!file.exists()) {
			file.createNewFile();
		}

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

		// A LISTA PODE VIR DE ALGUM BANCO DE DADOS OU FONTE DE DADOS
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);

		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); // vai ser usado para escrever a planilha
		HSSFSheet linhasPessoa = hssfWorkbook.createSheet("Planilha de pessoas JDev Treinamento");// criar a planilha

		int numeroLinha = 0;

		for (Pessoa p : pessoas) {
			Row linha = linhasPessoa.createRow(numeroLinha++);// criando a linha na planilha

			int celula = 0;

			Cell celNome = linha.createCell(celula++); // celular1
			celNome.setCellValue(p.getNome());

			Cell celemail = linha.createCell(celula++);// celular 2
			celemail.setCellValue(p.getEmail());

			Cell celIdade = linha.createCell(celula++); // celular 3
			celIdade.setCellValue(p.getIdade());

		} // termino de monta a planilha

		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida); // escreve planilha em arquivo
		saida.flush();
		saida.close();
		
		
		System.out.println("Planilha Criada!");

	}

}
