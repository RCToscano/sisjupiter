package br.com.sisjupiter.auxiliar;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GeradorExcel {

	
	public static void main(String[] args) throws InvalidFormatException, IOException {
		
		List<String> diagnosticoView = new ArrayList<String>();
		diagnosticoView.add("1");
		diagnosticoView.add("2");
		
		List<List<String>> listaTotal = new ArrayList<>();
		listaTotal.add(diagnosticoView);

		List<String> diagnosticoView1 = new ArrayList<String>();
		diagnosticoView1.add("3");
		diagnosticoView1.add("4");
		
		listaTotal.add(diagnosticoView1);

		for(int i = 0; i < listaTotal.size(); i++) {
			System.out.println("Teste"+listaTotal.get(i));
			for (int j = 0; j < listaTotal.get(i).size(); j++) {
				System.out.println("Lista"+listaTotal.get(i).get(j));
			}
		}
		
		
		//		gerarExcel("C:\\temp\\poi-generated-file.xlsx", "Diagnostico", new ColunasExcel().getColunasDiagnostico(), new String[1]);
	}

	public static void gerarExcel(HttpServletResponse res, String nomeArquivo, String nomeAba, String[] colunas, List<List<String>> valores)
			throws IOException, InvalidFormatException {
		// Create a Workbook
		Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

		/*
		 * CreationHelper helps us create instances for various things like DataFormat,
		 * Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way
		 */
		CreationHelper createHelper = workbook.getCreationHelper();

		// Create a Sheet
		Sheet sheet = workbook.createSheet(nomeAba);

		// Create a Font for styling header cells
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 12);
		headerFont.setColor(IndexedColors.RED.getIndex());

		// Create a CellStyle with the font
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		// Create a Row
		Row headerRow = sheet.createRow(0);

		// Creating cells
		for (int i = 0; i < colunas.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(colunas[i]);
			cell.setCellStyle(headerCellStyle);
		}


		// Create Other rows and cells with employees data
		int rowNum = 1;
		for(int i = 0; i < valores.size(); i++) {
			Row row = sheet.createRow(rowNum++);
			
			for (int j = 0; j < valores.get(i).size(); j++) {
				row.createCell(j).setCellValue(valores.get(i).get(j));
			}
		}

		// Resize all columns to fit the content size
		for (int i = 0; i < colunas.length; i++) {
			sheet.autoSizeColumn(i);
		}
		
		//Gera o download do arquivo
		res.setContentType("application/vnd.ms-excel");
		res.setHeader("Content-Disposition", "attachment; filename="+nomeArquivo);
		OutputStream out = res.getOutputStream();
		workbook.write(out);
		out.close();

		//Gera o arquivo fisico
//		FileOutputStream fileOut = new FileOutputStream(nomeArquivo);
//		workbook.write(fileOut);
//		fileOut.close();

		// Closing the workbook
		workbook.close();
	}

}
