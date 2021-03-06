package com.athena.xqjs.module.utils.xls.yaohlgl;

import java.lang.reflect.Constructor;

import jxl.Workbook;

import org.dom4j.Document;

import com.athena.util.tag.xls.BaseSheetHandler;
import com.athena.util.tag.xls.SheetHandler;

/**
 * sheet处理器工厂
 * @author chenlei
 * @vesion 1.0
 * @date 2012-5-17
 */
public class SheetHandlerFactoryyaohlzz {
	
	/**
	 * 
	 * @param workbook xls文件对象
	 * @param sheet 要读取的sheet的名字
	 * @param table 要保存的table名
	 * @param datasourceId 数据库连接池id
	 * @param keys 主键
	 * @param clazz 根据clazz创建出sheet解析器
	 */
	public static SheetHandler getInstance(Workbook workbook, String sheet,
			String table, String datasourceId, String clazz,String keys,String dateColumns,String dateFormats) {
		SheetHandler handler = null;
		if(clazz==null || "null".equals(clazz)){
			//创建默认的sheetHandler解析器处理 
			handler = new BaseSheetHandler(workbook, sheet, table, datasourceId, clazz,keys,dateColumns,dateFormats);
		}else{
			//依据用户的clazz全名 创建用户的sheetHandler对象
			handler = createHandler(workbook,sheet,table,datasourceId,clazz,keys,dateColumns,dateFormats);
		}
		
		return handler;
	}
	
	/**
	 * 
	 * @param document xml文件对象
	 * @param sheet 要读取的sheet的名字
	 * @param table 要保存的table名
	 * @param datasourceId 数据库连接池id
	 * @param keys 主键
	 * @param clazz 根据clazz创建出sheet解析器
	 */
	public static SheetHandleryaohlzz getInstance(Document document, String sheet,
			String table, String datasourceId, String clazz,String keys,String dateColumns,String dateFormats) {
		SheetHandleryaohlzz handler = null;
		if(clazz==null || "null".equals(clazz)){
			//创建默认的sheetHandler解析器处理 
			handler = new XmlSheetHandleryaohlzz(document, sheet, table, datasourceId, clazz,keys,dateColumns,dateFormats);
		}else{
			//依据用户的clazz全名 创建用户的sheetHandler对象
			handler = createHandler(document,sheet,table,datasourceId,clazz,keys,dateColumns,dateFormats);
		}
		
		return handler;
	}
	
/**Document document, String sheet, String table,
String datasourceId, String clazz,String keys
* 根据clazz生成类
* @param clazz
* @return
*/
@SuppressWarnings({ "rawtypes", "unchecked" })
private static SheetHandleryaohlzz createHandler(Document document, String sheet,
	String table, String datasourceId, String clazzStr,String keys,String dateColumns,String dateFormats) {
	SheetHandleryaohlzz sh = null;
	try {
		Class clazz = Class.forName(clazzStr);
		Constructor c = clazz.getConstructor(Document.class,String.class,String.class,String.class,String.class,String.class,String.class);
		sh = (SheetHandleryaohlzz) c.newInstance(document,sheet,table,datasourceId,clazz,keys,dateColumns,dateFormats);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return sh;
}
	
	/**Workbook workbook, String sheet, String table,
			String datasourceId, String clazz,String keys
	 * 根据clazz生成类
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static SheetHandler createHandler(Workbook workbook, String sheet,
			String table, String datasourceId, String clazzStr,String keys,String dateColumns,String dateFormats) {
		SheetHandler sh = null;
		try {
			Class clazz = Class.forName(clazzStr);
			Constructor c = clazz.getConstructor(Workbook.class,String.class,String.class,String.class,String.class,String.class,String.class);
			sh = (SheetHandler) c.newInstance(workbook,sheet,table,datasourceId,clazz,keys,dateColumns,dateFormats);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sh;
	}

}