package com.test.api.tools;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/***
 * 操作xls的类
 * @author xusai
 *
 */
public class xlsTool {
	private String path;
	private FileInputStream is;
	private XSSFWorkbook ws;
	
	
	public xlsTool(String path) throws Exception {
		// TODO Auto-generated constructor stub
		this.path=path;
		is=new FileInputStream(path);
		ws=new XSSFWorkbook(is);
	}
	/***
	 * 获取指定sheet的指定列的所有cell
	 * @param lie 指定列，从0开始
	 * @return
	 */
	public List getAllCellInL(int sheetNum,int lie){
		List<String> cells=new ArrayList<String>();
		XSSFSheet hsheet=ws.getSheetAt(sheetNum);
		if (hsheet == null) {
			return cells;
		}
//		System.out.println(hsheet.getLastRowNum());//从0开始
		for (int hang = 0; hang <= hsheet.getLastRowNum(); hang++) {
			XSSFRow hrow=hsheet.getRow(hang);
			XSSFCell xcell=hrow.getCell((short)lie);
			xcell.setCellType(CellType.STRING);//防止读取数字时自动添加小数
			if (xcell==null) {
				continue;
			}
			cells.add(String.valueOf(xcell));
		}
		return cells;
	}
	
	

}
