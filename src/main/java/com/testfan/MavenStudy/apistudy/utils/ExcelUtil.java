package com.testfan.MavenStudy.apistudy.utils;
/** 

* @author 作者 沙陌 

* @version 创建时间：2020年8月2日 下午1:43:23 

*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	private static Logger logger=Logger.getLogger(ExcelUtil.class);
	public XSSFWorkbook excelWorkbook;//整个excel文档对象,包括多个sheet工作表
	public XSSFSheet xssfSheet;//某个sheet工作表对象,根据sheet表的名称来获取sheet对象
	public Row row;//某个行对象
	public Cell cell;//某个单元格对象，根据行和列的交集
	//传入Excel 的路径，读取整个Excel的文档
	public ExcelUtil(String excelPath) throws Exception {
		FileInputStream fileInputStream=new FileInputStream(new File(excelPath));
		this.excelWorkbook=new XSSFWorkbook(fileInputStream);
	}

	/**
	 *
	 * @param sheetName:sheet 工作表的名称
	 * @param rownum：第几行
	 * @param colnum：第几列
	 * @return
	 */
	//在某个sheet工作表的第几行第几列，这样就确定了是哪一个单元格
	public String getCellData(String sheetName,int rownum,int colnum) {
		String cellvalue="";//定义一个单元格的名称
		try {
			//1.传入sheet工作表名称，得到sheet工作表对象
			xssfSheet=excelWorkbook.getSheet(sheetName);
			//2.得到行对象
			row=xssfSheet.getRow(rownum);
			//3. 得到单元格对象
			cell=row.getCell(colnum);
			// 单元格有多个数据类型：数字，字符串，时间等
			if (cell.getCellType()==XSSFCell.CELL_TYPE_BOOLEAN) {
				cellvalue=String.valueOf(cell.getBooleanCellValue());
			}else if (cell.getCellType()==XSSFCell.CELL_TYPE_STRING) {
				cellvalue=cell.getStringCellValue();
			}else if (cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC) {
				short format = cell.getCellStyle().getDataFormat();
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					Date d = cell.getDateCellValue();
					DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
					cellvalue = formater.format(d);
				} else if (format == 14 || format == 31 || format == 57 || format == 58) {
					// 日期
					DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
					Date date = DateUtil.getJavaDate(cell.getNumericCellValue());
					cellvalue = formater.format(date);
				} else if (format == 20 || format == 32) {
					// 时间
					DateFormat formater = new SimpleDateFormat("HH:mm");
					Date date = DateUtil.getJavaDate(cell.getNumericCellValue());
					cellvalue = formater.format(date);
				} else {
					DecimalFormat df = new DecimalFormat("0");
					cellvalue = df.format(cell.getNumericCellValue());
				}
			}
			//如果单元格是空的
			else if (cell.getCellType()==XSSFCell.CELL_TYPE_BLANK) {
				cellvalue="";
			}
			logger.info("读取【"+sheetName+"】的第"+rownum+"行第"+colnum+"列的值是："+cellvalue);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e);
			new RuntimeException(e);
		}

		//cellvalue = cell.getStringCellValue();
		//System.out.println(cellvalue);
		return cellvalue;
		
	}

	/**
	 * 将Excel 中的数据转化为一个二维数据
	 * @param sheetName
	 * @return
	 */
	public Object[][] getSheetData(String sheetName) {
		//循环去读这个sheet的行和列
		int rowCount = excelWorkbook.getSheet(sheetName).getLastRowNum();//获取sheet工作表的所有的行
		int colCount = excelWorkbook.getSheet(sheetName).getRow(0).getLastCellNum();//获取sheet工作表的所有的列
		System.out.println("工作表有几行："+rowCount);
		System.out.println("工作表有几列："+colCount);
		Object[][] data=new Object[rowCount][colCount];//定义一个几行几列的数组
		for (int i = 1; i <=rowCount; i++) {//循环行，从1开始，第1行是表头，不是数据，所有从第2行开始，也就是int i =1
			for (int j = 0; j < colCount; j++) {//循环列
				String cellData = getCellData(sheetName,i,j);//当前的行和列
				//System.out.println(cellData);
				data[i-1][j]=cellData;
				//data[0][0]=注册成功  data[0][1]=autotest,data[0][2]=123456
				//data[1][0]=用户已存在  data[1][1]=autotest,data[1][2]=123456
			}
		}
		return data;
	}
	public void close() {
		try {
			excelWorkbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		ExcelUtil excelUtil=new ExcelUtil("src/main/resources/datadriver/mtxshop.xlsx");
//		excelUtil.getCellData("reg", 1, 2);
		//遍历读取
		Object[][] sheetData = excelUtil.getSheetData("reg");
		for (int i = 0; i < sheetData.length; i++) {
			for (int j = 0; j < sheetData[i].length; j++) {
				System.out.println(sheetData[i][j]);
			}
			System.out.println("==============================");
		}
		excelUtil.close();
	}
	
}
