package com.athena.ckx.entity.paicfj;

import java.util.Date;

import com.athena.component.entity.Domain;
import com.toft.core3.support.PageableSupport;

public class Ckx_peizcl extends PageableSupport implements Domain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void setId(String id) {

	}

	public String getId() {
		return null;
	}

	 private String  usercenter        ;//用户中心
	 private String  celbh             ;//策略编号
	 private String  celmc             ;//策略名称
	 private String  chexbh            ;//车型编号
	 private String  youxj             ;//优先级
	 private String  beiz              ;//备注
	 private String  active            ;//标识
	 private String  creator           ;//创建人
	 private Date    create_time       ;//创建时间
	 private String  editor            ;//修改人
	 private Date    edit_time         ;//修改时间

	 
	 
	 private Double baozsl;         //统计这一策略下的的总的包装数量
	 private String celbhs;
	public String getCelbhs() {
		return celbhs;
	}

	public void setCelbhs(String celbhs) {
		this.celbhs = celbhs;
	}

	public Double getBaozsl() {
		return baozsl;
	}

	public void setBaozsl(Double baozsl) {
		this.baozsl = baozsl;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getUsercenter() {
		return usercenter;
	}

	public void setUsercenter(String usercenter) {
		this.usercenter = usercenter;
	}

	public String getCelbh() {
		return celbh;
	}

	public void setCelbh(String celbh) {
		this.celbh = celbh;
	}

	public String getCelmc() {
		return celmc;
	}

	public void setCelmc(String celmc) {
		this.celmc = celmc;
	}

	public String getChexbh() {
		return chexbh;
	}

	public void setChexbh(String chexbh) {
		this.chexbh = chexbh;
	}

	public String getYouxj() {
		return youxj;
	}

	public void setYouxj(String youxj) {
		this.youxj = youxj;
	}

	public String getBeiz() {
		return beiz;
	}

	public void setBeiz(String beiz) {
		this.beiz = beiz;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public Date getEdit_time() {
		return edit_time;
	}

	public void setEdit_time(Date edit_time) {
		this.edit_time = edit_time;
	}
	 
}
