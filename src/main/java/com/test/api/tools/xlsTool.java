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
 * ����xls����
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
	 * ��ȡָ��sheet��ָ���е�����cell
	 * @param lie ָ���У���0��ʼ
	 * @return
	 */
	public List getAllCellInL(int sheetNum,int lie){
		List<String> cells=new ArrayList<String>();
		XSSFSheet hsheet=ws.getSheetAt(sheetNum);
		if (hsheet == null) {
			return cells;
		}
//		System.out.println(hsheet.getLastRowNum());//��0��ʼ
		for (int hang = 0; hang <= hsheet.getLastRowNum(); hang++) {
			XSSFRow hrow=hsheet.getRow(hang);
			XSSFCell xcell=hrow.getCell((short)lie);
			xcell.setCellType(CellType.STRING);//��ֹ��ȡ����ʱ�Զ����С��
			if (xcell==null) {
				continue;
			}
			cells.add(String.valueOf(xcell));
		}
		return cells;
	}
	
	

}
