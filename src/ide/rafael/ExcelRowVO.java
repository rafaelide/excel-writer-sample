package ide.rafael;

import java.util.HashMap;
import java.util.Map;

public class ExcelRowVO {
	Map<ExcelColumn, String> cellMap;
	
	public ExcelRowVO() {
		cellMap = new HashMap<>();
	}
	
	public void addCell(ExcelColumn c, String value) {
		cellMap.put(c, value);
	}
	
	
	public void removeCell(ExcelColumn c) {
		cellMap.remove(c);
	}
	
	public Map<ExcelColumn, String> getCells() {
		return this.cellMap;
	}
}
