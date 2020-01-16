package com.yh.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yh.mapper.AdminMapper;
import com.yh.mapper.JurisdictionMapper;
import com.yh.pojo.Admin;
import com.yh.pojo.JurisdictionExample;
import com.yh.pojo.JurisdictionExample.Criteria;
import com.yh.pojo.zhongchouResult;
import com.yh.service.AdminAddService;
import com.yh.service.AdminManageService;

/**
 * 管理员账号管理界面
 * @author zhangdi
 *
 */
@Controller
public class AdminAddController {

	@Autowired
	private AdminMapper adminMapper;
	
	@Autowired
	private JurisdictionMapper jurisdictionMapper;
	
	@Autowired
	private AdminAddService adminAddService;
	
	@Autowired
	private AdminManageService adminManageServace;
	
	@RequestMapping("/admin/account_admin")
	public String findAllAdmin(HttpServletRequest req){
		String count = req.getParameter("count");
		String pages = req.getParameter("pages");
		int page = 1;
		if(pages==null ){
			pages = "1";
			page = Integer.parseInt(pages);
		}else{
			page = Integer.parseInt(pages);
		}
		int coun = 5;
		if(count == null ){
			count="5";
			 coun = Integer.parseInt(count);
		}else{
			coun = Integer.parseInt(count);
		}
		PageHelper.startPage(page,coun);
		List<Admin> list = adminManageServace.findAllAdmin();
		PageInfo<Admin> info = new PageInfo<>(list);
		req.setAttribute("pb", info);
		req.setAttribute("list", list);
		return "account_admin";	
	}
	
	
	/**
	 * 删除管理员
	 */
	@RequestMapping("/admindelete")
	public String admindelete(HttpServletRequest req){
		String adminid = req.getParameter("adminid");
		int i = adminMapper.deleteByPrimaryKey(Integer.parseInt(adminid));
		
		JurisdictionExample example = new JurisdictionExample();
		Criteria criteria = example.createCriteria();
		criteria.andJuAdIdEqualTo(Integer.parseInt(adminid));
		int i2 = jurisdictionMapper.deleteByExample(example);
		if(i>0 && i2>0){	
			String string = findAllAdmin(req);
			return string;
		}
		return "inde";
	}
	
	

/**
 * 管理员添加方法	
 * @param req
 * @return
 */
	@RequestMapping("/admin/Admin_add")
	public String toaddAdmin(HttpServletRequest req){
		Admin admin = new Admin();
		String user = req.getParameter("user");
		String password = req.getParameter("password");
		admin.setAdminName(user);
		admin.setAdminPassword(password);
		int admin2 = adminAddService.addAdmin(admin);
		if(admin2>0){
			String findAllAdmin = findAllAdmin(req);
			return findAllAdmin;
		}
		return "admin_add_error";
	}
	
/**
 * 跳转到添加管理员页面方法
 * @return
 */
	@RequestMapping("/admin/toadd_admin")
	public String addAdmin(){
		
		return "add_admin";
	}
	

}
