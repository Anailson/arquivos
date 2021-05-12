package arquivosapachepoi;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import arquivos.Pessoa;

public class ApachePoiLeitura {

	public static void main(String[] args) throws Exception {

		FileInputStream entrada = new FileInputStream(
				new File("C:\\eclipse-workspace\\modulo-arquivos\\src\\arquivosapachepoi\\arquivo_excel.xls"));

		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);// prepara a entrada do arquivo excel para ler
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0);// pega a primeira planilha do nosso arquivo excel
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		while (linhaIterator.hasNext()) {//enquanto tiver linha no arquivo excel
			
			Row linha = linhaIterator.next();//dados da pessoa na linha
			
			Iterator<Cell> celulas = linha.iterator();
			
			Pessoa pessoa = new Pessoa();
			
			while (celulas.hasNext()) {//percorre as celulas
				
				Cell cell = celulas.next();
				
				switch (cell.getColumnIndex()) {
				case 0:
					pessoa.setNome(cell.getStringCellValue());
					break;
				case 1:
					pessoa.setEmail(cell.getStringCellValue());
					break;
				case 2:
					pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
					break;
				
				}//fim celular das linhas
				
				pessoas.add(pessoa);
			}
			
		}//processa arquivo
		
		entrada.close();//terminou de ler o arquivo
		for (Pessoa pessoa : pessoas) {//poderia gravar no banco de dados,email etc
			System.out.println(pessoa);
		}

	}

}
