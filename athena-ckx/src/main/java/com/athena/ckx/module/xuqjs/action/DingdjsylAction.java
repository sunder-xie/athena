package com.athena.ckx.module.xuqjs.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.athena.authority.entity.LoginUser;
import com.athena.authority.util.AuthorityUtils;
import com.athena.ckx.entity.xuqjs.Dingdjsyl;
import com.athena.ckx.module.xuqjs.service.DingdjsylService;
import com.athena.component.service.Message;
import com.athena.util.CommonUtil;
import com.athena.util.athenalog.impl.UserOperLog;
import com.toft.core3.container.annotation.Component;
import com.toft.core3.container.annotation.Inject;
import com.toft.core3.container.core.ComponentDefinition;
import com.toft.mvc.ActionSupport;
import com.toft.mvc.annotaions.Param;


/**
 * 订单计算依赖关系Action
 * @author qizhongtao
 * @date 2012-4-07
 */
@Component (scope = ComponentDefinition.SCOPE_PROTOTYPE)
public class DingdjsylAction extends ActionSupport{
	
	@Inject
	private DingdjsylService dingdjsylService;
	
	@Inject
	private UserOperLog userOperLog;
	
	/**
	 * 登录人信息
	 * @author denggq
	 * @date 2018-4-18
	 * @return bean
	 */
	public LoginUser getLoginUser() {
		return (LoginUser) AuthorityUtils.getSecurityUser();
	}
	
	/**
	  * 主页面
	  * @author qizhongtao
	  * @Date 2012-4-16
	  * @return String
	  */
	public String execute(){
		setResult("usercenter",getLoginUser().getUsercenter());
		return "select";
	}
	
	/**
	 * 分页查询
	 * @author qizhongtao
	 * @Date 2012-4-16
	 * @return String
	 * */
	public String query(@Param Dingdjsyl bean){
		try{
			setResult("result",dingdjsylService.select(bean));
			userOperLog.addCorrect(CommonUtil.MODULE_CKX, "订单计算依赖关系", "数据查询");
		}catch (Exception e) {
			Map<String,String> message = new HashMap<String,String>();
			message.put("message", e.getMessage());
			userOperLog.addError(CommonUtil.MODULE_CKX, "订单计算依赖关系", "数据查询", CommonUtil.getClassMethod(), CommonUtil.replaceBlank(e.getMessage()));
		}
		return AJAX;
	}
	
	/**
	 * 单数据查询
	 * @author qizhongtao
	 * @Date 2012-5-10
	 * @return String
	 * */
	public String get(@Param Dingdjsyl bean){
		try{
			setResult("result",dingdjsylService.get(bean));
			userOperLog.addCorrect(CommonUtil.MODULE_CKX, "订单计算依赖关系", "单数据查询");
		}catch (Exception e) {
			Map<String,String> message = new HashMap<String,String>();
			message.put("message", e.getMessage());
			userOperLog.addError(CommonUtil.MODULE_CKX, "订单计算依赖关系", "单数据查询", CommonUtil.getClassMethod(), CommonUtil.replaceBlank(e.getMessage()));
		}
		return AJAX;
	}
	
	/**
	 * 多数据查询
	 * @author denggq
	 * @Date 2012-5-10
	 * @return String
	 * */
	public String list(@Param Dingdjsyl bean){
		try{
			setResult("result",dingdjsylService.list(bean));
			userOperLog.addCorrect(CommonUtil.MODULE_CKX, "订单计算依赖关系", "多数据查询");
		}catch (Exception e) {
			Map<String,String> message = new HashMap<String,String>();
			message.put("message", e.getMessage());
			userOperLog.addError(CommonUtil.MODULE_CKX, "订单计算依赖关系", "多数据查询", CommonUtil.getClassMethod(), CommonUtil.replaceBlank(e.getMessage()));
		}
		return AJAX;
	}
	
	/**
	 * 行编辑保存数据
	 * @author qizhongtao
	 * @Date 2012-4-16
	 * @Param insert,edit,delete
	 * @return String
	 * */
	public String save(@Param("insert") ArrayList<Dingdjsyl> insert,@Param("edit") ArrayList<Dingdjsyl> edit,@Param("delete") ArrayList<Dingdjsyl> delete){
		Map<String,String> message = new HashMap<String,String>();
		try {
			Message m = new Message(dingdjsylService.save(insert, edit, delete, getLoginUser().getUsername()),"i18n.ckx.xuqjs.i18n_xitcsdy");
			message.put("message", m.getMessage());
			userOperLog.addCorrect(CommonUtil.MODULE_CKX, "订单计算依赖关系", "数据保存");
		} catch (Exception e) {
			setResult("success", false);
			message.put("message", e.getMessage());
			userOperLog.addError(CommonUtil.MODULE_CKX, "订单计算依赖关系", "数据保存", CommonUtil.getClassMethod(), CommonUtil.replaceBlank(e.getMessage()));
		}
		setResult("result",message);
		return AJAX;
	}
}
