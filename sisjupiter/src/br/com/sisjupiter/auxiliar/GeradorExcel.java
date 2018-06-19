package br.com.sisjupiter.auxiliar;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GeradorExcel {

	
	public static void main(String[] args) throws InvalidFormatException, IOException {
		
		List<String> abas = new ArrayList<String>();
		abas.add("Relatorio");
		abas.add("Diagnostico");
		
		List<List<String>> colunas = new ArrayList<>();
		
		
		List<String> coluna1 = new ArrayList<>();
		coluna1.add("Coluna1");
		coluna1.add("Coluna2");

		List<String> coluna2 = new ArrayList<>();
		coluna2.add("Coluna2");
		coluna2.add("Coluna3");
		
    	colunas.add(coluna1);
    	colunas.add(coluna2);
		
		
		List<String> diagnosticoView = new ArrayList<String>();
		diagnosticoView.add("1");
		diagnosticoView.add("2");

		List<String> diagnosticoView1 = new ArrayList<String>();
		diagnosticoView1.add("3");
		diagnosticoView1.add("4");
		
		List<List<String>> listaTotal = new ArrayList<>();
		listaTotal.add(diagnosticoView);
		listaTotal.add(diagnosticoView1);
		
		
		
		List<List<String>> listaTotal1 = new ArrayList<>();
		List<String> diagnosticoView2 = new ArrayList<String>();
		diagnosticoView2.add("5");
		diagnosticoView2.add("6");

		List<String> diagnosticoView3 = new ArrayList<String>();
		diagnosticoView3.add("7");
		diagnosticoView3.add("8");
		
		listaTotal1.add(diagnosticoView2);
		listaTotal1.add(diagnosticoView3);
		
		List<List<List<String>>> listaFinal = new ArrayList<>();
		listaFinal.add(listaTotal);
		listaFinal.add(listaTotal1);
		
		
//		for(int i = 0; i < abas.size(); i++) {
//			
//			System.out.println("Aba:"+abas.get(i));
//			System.out.println("Coluna:"+colunas.get(i));
//			
//			for(int j = 0; j < listaFinal.size(); j++) {
//				System.out.println("Teste"+listaFinal.get(i));
//				
//				for (int j2 = 0; j2 < listaFinal.get(i).get(j).size(); j2++) {
//					System.out.println("Lista"+listaFinal.get(i).get(j).get(j2));
//				}
//			}
//			
//			
//			
//			
//		}
		
		gerar2Abas(null, "C:\\temp\\teste.xlsx", abas, colunas, listaFinal);

		
		
//		gerarExcelVarios("C:\\temp\\poi-generated-file.xlsx", "Diagnostico", new ColunasExcel().getColunasDiagnostico(), new String[1]);
	}

	public static void gerar2Abas(HttpServletResponse res, String nomeArquivo, List<String> abas, List<List<String>> colunas, List<List<List<String>>> valores)
			throws IOException, InvalidFormatException {
		// Create a Workbook .xsl
		Workbook workbook = new XSSFWorkbook();

		for(int i = 0; i < abas.size(); i++) {
			
			// Create a Sheet
			Sheet sheet = workbook.createSheet(abas.get(i));
	
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
			
			for(int j = 0; j < colunas.get(i).size(); j++) {
				Cell cell = headerRow.createCell(j);
				cell.setCellValue(colunas.get(i).get(j));
				cell.setCellStyle(headerCellStyle);
			}
	
	
			// Create Other rows and cells with employees data
			int rowNum = 1;
			for(int j = 0; j < valores.get(i).size(); j++) {
				Row row = sheet.createRow(rowNum++);
				
				for (int j2 = 0; j2 < valores.get(i).get(j).size(); j2++) {
					row.createCell(j2).setCellValue(valores.get(i).get(j).get(j2));
				}
			}
	
			// Resize all columns to fit the content size
			for (int j = 0; j < colunas.get(i).size(); j++) {
				sheet.autoSizeColumn(j);
			}
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
	
	public static void gerarExcel(HttpServletResponse res, String nomeArquivo, String nomeAba, List<String> colunas, List<List<String>> valores)
			throws IOException, InvalidFormatException {
		// Create a Workbook .xsl
		Workbook workbook = new XSSFWorkbook();
		
		
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
		for (int i = 0; i < colunas.size(); i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(colunas.get(i));
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
		for (int i = 0; i < colunas.size(); i++) {
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
