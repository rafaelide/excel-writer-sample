package ide.rafael;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelWriter {
	
	public void writeExcel(List<ExcelRowVO> rows, String excelFilePath) throws IOException {
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet();
		
		writeSheet(rows, sheet);
		
		try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
			workbook.write(outputStream);
		}
	}

	private void writeSheet(List<ExcelRowVO> rowMaps, Sheet sheet) {
		int rowCount = 0;		
		for (ExcelRowVO rowVO : rowMaps) {
			Row row = sheet.createRow(++rowCount);
			writeRow(rowVO, row);
		}
	}
	
	private void writeRow(ExcelRowVO vo, Row row) {		
		vo.getCells().forEach((k,v) -> {
			Cell cell = row.createCell(k.getPosition());
			cell.setCellValue(v);
		});
	}	

}
