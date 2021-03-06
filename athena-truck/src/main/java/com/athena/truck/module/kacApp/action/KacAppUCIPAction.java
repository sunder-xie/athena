package com.athena.truck.module.kacApp.action;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.athena.authority.entity.LoginUser;
import com.athena.authority.util.AuthorityUtils;
import com.athena.component.service.Message;
import com.athena.truck.entity.Ucip;
import com.athena.truck.module.kacApp.service.KacAppUCIPService;
import com.athena.util.CommonUtil;
import com.athena.util.athenalog.impl.UserOperLog;
import com.toft.core3.container.annotation.Component;
import com.toft.core3.container.annotation.Inject;
import com.toft.core3.container.core.ComponentDefinition;
import com.toft.mvc.ActionSupport;
import com.toft.mvc.annotaions.Param;

/**
 * 用户中心坐标IP
 * @author CSY
 * @Date 2016-9-6
 */
@Component(scope = ComponentDefinition.SCOPE_PROTOTYPE)
public class KacAppUCIPAction extends ActionSupport {
	
	@Inject
	private UserOperLog userOperLog;
	
	@Inject
	private KacAppUCIPService kacAppUCIPService;
	
	/**
	 * 日志打印
	 */
	public static final Logger logger = Logger.getLogger(KacAppUCIPAction.class);
	
	/**
	  * 获取用户信息
	  * @author CSY
	  * @Date 2016-9-7
	  * @return LoginUser
	  */
	public LoginUser  getLoginUser() {
		return AuthorityUtils.getSecurityUser();
	}
	
	
	/**
	 * 跳转页面
	 * @author CSY
	 * @Date 2016-9-7
	 * @return String
	 */
	public String execute() {
		return "select";
	}
	
	/**
	 * 分页查询方法
	 * @author CSY
	 * @Date 2016-9-7
	 * @param bean
	 * @return String
	 */
	public String query(@Param Ucip bean) {
		try{
			setResult("result", kacAppUCIPService.query(bean));
			userOperLog.addCorrect("kcApp", "用户中心坐标IP", "数据查询");
		}catch (Exception e) {
			Map<String,String> message = new HashMap<String,String>();
			message.put("message", e.getMessage());
			userOperLog.addError("kcApp", "用户中心坐标IP", "数据查询", CommonUtil.getClassMethod(), CommonUtil.replaceBlank(e.getMessage()));
		}
		return AJAX;
	}
	
	/**
	 * 行编辑保存方法
	 * @author CSY
	 * @Date 2016-9-7
	 * @param bean
	 * @return String
	 */
	public String save(@Param("insert") ArrayList<Ucip> insert,@Param("edit") ArrayList<Ucip> edit,@Param("delete") ArrayList<Ucip> delete) {
		Map<String,String> map = new HashMap<String,String>();
		try {
			Message m = new Message(kacAppUCIPService.save(insert, edit, delete,getLoginUser().getUsername()),"i18n.ckx.xuqjs.i18n_xitcsdy");
			map.put("message", m.getMessage());
			userOperLog.addCorrect("kcApp", "用户中心坐标IP", "数据保存");
		}catch (Exception e) {
			setResult("success", false);
			map.put("message", e.getMessage());
			userOperLog.addError("kcApp", "用户中心坐标IP", "数据保存", CommonUtil.getClassMethod(), CommonUtil.replaceBlank(e.getMessage()));
		}
		setResult("result", map);
		return AJAX;
	}
	
	
	
}
