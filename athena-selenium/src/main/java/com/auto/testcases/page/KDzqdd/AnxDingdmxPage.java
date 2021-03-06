package com.auto.testcases.page.KDzqdd;
import holmos.webtest.element.Element;
import holmos.webtest.element.TextField;
import holmos.webtest.struct.Collection;
import holmos.webtest.struct.Page;


/**
 * AX订单明细
 * @author 李智
 */
public class AnxDingdmxPage extends Page{
	
	public AnxDingdmxPage() {
		this.comment = "爱信订单明细";
		this.init();
	}
	public SearchDingdmxs list_dingdmxs = new SearchDingdmxs("订单明细查询结果");
	public Element labl_p0rq = new Element("p0日期");
	{
		list_dingdmxs.addXpathLocator("//div[@id='grid_aixdd']/div[6]/table/tbody/tr/td[2]/div/table/tbody/tr");
		labl_p0rq.addXpathLocator("//div[@id='grid_aixdd']/div[2]/div");
	}
	
	public class SearchDingdmxs extends Collection {

		public SearchDingdmxs(String comment) {
			super(comment);
		}
		
		public Element labl_lingjh = new Element("查询结果中的零件号");
		public Element labl_gys = new Element("查询结果中的供应商");
		public Element labl_p0 = new Element("p0");
		public Element labl_p1 = new Element("p1");
		public Element labl_p2 = new Element("p2");
		public Element labl_p3 = new Element("p3");
		{
			labl_lingjh.addXpathLocator("./td[5]");
			labl_gys.addXpathLocator("./td[4]");
			labl_p0.addXpathLocator("./td[11]");
			labl_p1.addXpathLocator("./td[12]");
			labl_p2.addXpathLocator("./td[13]");
			labl_p3.addXpathLocator("./td[14]");
		}
	}
}
