package com.athena.component.input;

import java.util.Date;

import com.athena.component.DateTimeUtil;
import com.athena.component.exchange.Record;
import com.athena.component.exchange.SpaceFinal;
import com.athena.component.exchange.config.DataParserConfig;
import com.athena.component.exchange.db.DbDataWriter;
 
public class LjGysLsBzDBDataWriter extends DbDataWriter {

	private  Date date = new Date();
	public LjGysLsBzDBDataWriter(DataParserConfig dataParserConfig) {
		super(dataParserConfig);
	}
	public boolean before() {
		try{
			String sqlStr =" delete from "+SpaceFinal.spacename_ck+".ckx_lingjgyslsbz t ";
			super.execute(sqlStr);
			
		}catch(RuntimeException e)
		{
			logger.error(e.getMessage());
		}
		return super.before();
	}
	
	public void afterRecord(int rowIndex, Record record,Object line){		
		//record.put("CREATOR", "interface");
		record.put("CREATOR", super.dataExchange.getCID());
		record.put("CREATE_TIME", date);
		//record.put("EDITOR", "interface");
		record.put("EDITOR",  super.dataExchange.getCID());
		record.put("EDIT_TIME", date);
		try {
			super.afterRecord(rowIndex, record, line);
		} catch (Exception e) {
			super.makeErrorMessage(rowIndex, record, e.getMessage(), line);
		}
		
		
	}

}
