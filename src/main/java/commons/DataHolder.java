package commons;

import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataHolder {

	@DataProvider(name = "inputData")
	public Object[][] getTestData(Method method) throws Exception {
		TestDataInfo info = method.getAnnotation(TestDataInfo.class);
		try {
			if (null != info) {
				return getTestData(System.getProperty("user.dir") + FrameworkConstants.inputDataSheetPath,
						info.sheetName());
			}
		} catch (Exception c) {
			c.printStackTrace();
		}
		return null;
	}

	private Object[][] getTestData(String fileName, String sheetName) throws Exception {
		String[][] arrayData = null;
		XSSFWorkbook wb = new XSSFWorkbook(fileName);
		XSSFSheet sheet = wb.getSheet(sheetName);

		int totalCols = sheet.getRow(0).getPhysicalNumberOfCells();
		int totalRows = sheet.getPhysicalNumberOfRows();

		arrayData = new String[totalRows - 1][totalCols];
		for (int i = 1; i < totalRows; i++) {
			for (int j = 0; j < totalCols; j++) {
				XSSFCell testData = sheet.getRow(i).getCell(j);
				if (testData != null) {
					arrayData[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				}
			}

		}
		wb.close();
		return arrayData;

	}
}
