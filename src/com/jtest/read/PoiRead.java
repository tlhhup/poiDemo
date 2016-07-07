package com.jtest.read;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.jtest.action.UserDao;
import com.jtest.entity.User;

public class PoiRead {

	/**
	 * 组成：Workbook--->Sheet--->Row-->Cell
	 * 
	 * @param is
	 * @throws Exception
	 */
	public static void readPoi(InputStream is) throws Exception {
		Workbook wb = WorkbookFactory.create(is);
		// 获取所有的sheet
		Iterator<Sheet> sheets = wb.iterator();
		while (sheets.hasNext()) {
			Sheet sheet = sheets.next();
			// 获取该sheet中所有的行
			Iterator<Row> rows = sheet.iterator();
			while (rows.hasNext()) {
				Row row = rows.next();
				// 获取所有的单元格
				Iterator<Cell> cells = row.cellIterator();
				while (cells.hasNext()) {
					Cell cell = cells.next();
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						System.out.println(cell.getRichStringCellValue().getString());
						break;
					case Cell.CELL_TYPE_NUMERIC:
						if (DateUtil.isCellDateFormatted(cell)) {
							System.out.println(cell.getDateCellValue());
						} else {
							System.out.println(cell.getNumericCellValue());
						}
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						System.out.println(cell.getBooleanCellValue());
						break;
					case Cell.CELL_TYPE_FORMULA:
						System.out.println(cell.getCellFormula());
						break;
					default:
						System.out.println();
					}
				}
			}
		}
	}

	public static void writePoi() throws Exception {
		UserDao userDao = new UserDao();
		List<User> users = userDao.queryAll();
		if (users != null && !users.isEmpty()) {
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("用户");
			for(int i=0;i<users.size();i++){
				User user = users.get(i);
				HSSFRow row = sheet.createRow(i);
				row.createCell(0).setCellValue(user.getId());
				row.createCell(1).setCellValue(user.getUserName());
				row.createCell(2).setCellValue(user.getPassword());
				row.createCell(3).setCellValue(user.getRealName());
			}
			
			//生成文件-->当前项目根目录
			FileOutputStream fos = new FileOutputStream(new File("workbook.xls"));
			wb.write(fos);
			fos.flush();
			fos.close();
			
			wb.close();
		}
	}

}