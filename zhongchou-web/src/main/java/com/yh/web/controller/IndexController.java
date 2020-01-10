package com.yh.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.dubbo.common.json.JSON;
import com.yh.mapper.QuestionotherMapper;
import com.yh.pojo.Projects;
import com.yh.pojo.Questionall;
import com.yh.pojo.Questionother;
import com.yh.pojo.User;
import com.yh.pojo.zhongchouResult;
import com.yh.pojo.f_common.QuestionallCommon;
import com.yh.pojo.f_common.SendMail;
import com.yh.service.ProjectService;
import com.yh.service.questionall.QuestionallService;
import com.yh.service.user.UserService;

@Controller
public class IndexController {

	@Autowired
	private QuestionallService questionallService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value="/" ,produces = {"text/html;charset=UTF-8"})
	public String index(){

		return "index";
	}
	@RequestMapping("/index")
	public String toindex(){
		
		
		return "index";
	}
	//判断首页是否有登录
	@RequestMapping(value="/gonnindex", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String gonnindex(HttpServletRequest req){
		HttpSession session = req.getSession(false);
		zhongchouResult result=zhongchouResult.build(200, "成功");
		if(session!=null){
			Object object = session.getAttribute("user");
			
			List<com.yh.pojo.User> list2 = castList(object,User.class);
			
			result = zhongchouResult.ok(200, "成功", list2);
			if(list2.size()>0){
				System.out.println(list2.get(0).getUsName());
				result.setMsg("<a href='user.html'>欢迎，"+list2.get(0).getUsName()+"</a><span style='color: white;'>|</span><a href='loginOut'>lOut</a>");				
			}
			
		}
		String json="";
		try {
			json = JSON.json(result);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return json;
	}
	
	//问题管理
	@RequestMapping(value="/questionall", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String questionall(HttpServletRequest req){
		HttpSession session = req.getSession(false);
		
		
		
		ArrayList<QuestionallCommon> list = new ArrayList<>();
		
		List<Questionall> listf = questionallService.selectQuestionallAll();
		
		for (Questionall questionall : listf) {
			QuestionallCommon common = new QuestionallCommon();
			String questionname = questionall.getQuestionname();
			common.setQuestionname(questionname);
			//根据父id查询子问题
			List<Questionother> questionother = questionallService.selectQuestionother(questionall.getQuestionid());
			common.setQuestionotherList(questionother);
			list.add(common);
		}
		
		zhongchouResult result = zhongchouResult.ok(200, "成功", list);
		if(session!=null){
			Object object = session.getAttribute("user");
			
			List<com.yh.pojo.User> list2 = castList(object,User.class);
			
			if(list2.size()>0){
				System.out.println(list2.get(0).getUsName());
				result.setMsg("<a href='user.html'>欢迎，"+list2.get(0).getUsName()+"</a><span style='color: white;'>|</span><a href='loginOut'>lOut</a>");				
			}
			
		}
		
		String json="";
		try {
			json = JSON.json(result);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return json;
	}
	
	public static <T> List<T> castList(Object obj, Class<T> clazz)
	{
	    List<T> result = new ArrayList<T>();
	    if(obj instanceof List<?>)
	    {
	        for (Object o : (List<?>) obj)
	        {
	            result.add(clazz.cast(o));
	        }
	        return result;
	    }
	    return null;
	}
	
	//跳转问题页面
	@RequestMapping(value="/cop")
	public String CopQuestionall(HttpServletRequest req){
		
		return "cop";
	}
	
	//跳转登录页面
	@RequestMapping(value="/{url}")
	public String login(@PathVariable String url){
		
		return url;
	}
	
//	@RequestMapping(value="/gologin")
//	public String gologin(){
//		return "login";
//	}
//	@RequestMapping(value="/toreg")
//	public String toreg(){
//		return "reg";
//	}

	//登录验证
	@RequestMapping(value="/login", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String logins(HttpServletRequest req){
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		zhongchouResult result = userService.selectUserByNameAndPwd(username, password);
		
		if(result.getStatus()==200){
			HttpSession session = req.getSession();
			session.setAttribute("user", result.getData());
		}
		
		
		String json="";
		try {
			json = JSON.json(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	//用户查询所有的项目
	@RequestMapping(value="/selectProjectsByIdAll", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String selectProjectsByIdAll(HttpServletRequest req){
		HttpSession session = req.getSession(false);
		zhongchouResult result=zhongchouResult.build(500, "你还没有发布项目呢~~");
		if(session!=null){
			Object object = session.getAttribute("user");
			
			List<com.yh.pojo.User> list2 = castList(object,User.class);
			
			//System.out.println(list2.get(0).getUsName());
			
			//忘了存用户的id了
			Integer usId = list2.get(0).getUsId();
			if(usId!=null){
				result = projectService.selectByUserId(list2.get(0).getUsId());
				
				//result.setMsg(msg);
				result.setMsg("<a href='user.html'>欢迎，"+list2.get(0).getUsName()+"</a><span style='color: white;'>|</span><a href='loginOut'>lOut</a>");				
			}
			
			//为了修改登录字样 为个人中心
			if(list2.size()>0){
				System.out.println(list2.get(0).getUsName());
				result.setMsg("<a href='user.html'>欢迎，"+list2.get(0).getUsName()+"</a><span style='color: white;'>|</span><a href='loginOut'>lOut</a>");				
			}
			
			
		}
		String json="";
		try {
			json = JSON.json(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	
	@RequestMapping(value="/toUserByAll" , produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String toUserByAll(HttpServletRequest req){
		HttpSession session = req.getSession(false);
		zhongchouResult zhongchouResult=null;
		if(session!=null){
			Object object = session.getAttribute("user");
			
			List<com.yh.pojo.User> list2 = castList(object,User.class);
			zhongchouResult = com.yh.pojo.zhongchouResult.ok(200, "用户信息", list2);
		}else{
			zhongchouResult = zhongchouResult.build(500, "你可能没有登录");
		}
		String json="";
		try {
			json = JSON.json(zhongchouResult);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	
	//根据用户id修改信息
	@RequestMapping(value="/updateUserById", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String  updateUserById(HttpServletRequest req){
		HttpSession session = req.getSession(false);
		zhongchouResult result=zhongchouResult.build(500, "修改失败~~");
		if(session!=null){
			Object object = session.getAttribute("user");
			
			List<com.yh.pojo.User> list2 = castList(object,User.class);
			
			//System.out.println(list2.get(0).getUsName());
			
			User user = new User();
			
			Integer integer = userService.updatauser(user);
			if(integer>0){
				List<User> list = new ArrayList<>();
				list.add(user);
				session.setAttribute("user", list);
			}
			//result.setMsg("<a href='user.html'>欢迎，"+list2.get(0).getUsName()+"</a><span style='color: white;'>|</span><a href='loginOut'>lOut</a>");
			
		}
		String json="";
		try {
			json = JSON.json(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	//用户退出功能
	@RequestMapping(value="/loginOut")
	public String loginOut(HttpServletRequest req){
		HttpSession session = req.getSession(false);
		session.invalidate();
		return "index";
	}
	
	//生成验证码
	@RequestMapping(value="/sendCode", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String sendCode(HttpServletRequest req){
		
		String url = req.getParameter("usEmail");
		//生成验证码
				Calendar calendar = Calendar.getInstance();
				int year = calendar.get(Calendar.YEAR);
				int month = calendar.get(Calendar.MONTH)+1;
				int ri = calendar.get(Calendar.DAY_OF_MONTH);
				int shi = calendar.get(Calendar.HOUR_OF_DAY);
				int fen = calendar.get(Calendar.MINUTE);
				int miao = calendar.get(Calendar.SECOND);
				String code=year+""+month+ri+shi+fen+miao;
				String substring = code.substring(2);
				System.out.println(substring);
				System.out.println(url);
				zhongchouResult build=null;
				try {
					boolean b = sendMail(url,substring,"验证码");
					if(b){
						HttpSession session = req.getSession(false);
						if(session==null){
							session=req.getSession();
							session.setAttribute("code", substring);
							build = zhongchouResult.build(200, "验证码发送成功");
						}else{
							session.setAttribute("code", substring);
							build = zhongchouResult.build(200, "验证码发送成功");
						}
					}
				} catch (Exception e) {
					build = zhongchouResult.build(500, "验证码发送失败");
				}
				
				String json="";
				try {
					json = JSON.json(build);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return json;
	}
	
	
	//邮件发送方法
	public static boolean  sendMail(String url,String code,String msg) throws Exception{
		SendMail mail = new SendMail("3070979976@qq.com", "zrgioxlewjefdhbe");
		Map<String, String> map = new HashMap<String, String>();
		map.put("mail.smtp.host", "smtp.qq.com");
		map.put("mail.smtp.auth", "true");
		map.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		map.put("mail.smtp.port", "465");
		map.put("mail.smtp.socketFactory.port", "465");
		mail.setPros(map);
		mail.initMessage();
		/*
		 * 调用setRecipients(list);发送list集合类型 List<String> list = new
		 * ArrayList<String>(); list.add("********@qq.com");
		 */
		  
		  mail.setRecipient(url); // 输出信息
	
		// 邮件主题
		mail.setSubject("AI测试Java邮箱功能");
		
		// 发送时间 Date类型(默认即时发送)
		mail.setDate(new Date()); 
		//mail.setDate(100);
		
		// 发送者昵称
		mail.setFrom("AI");
 
		// 邮件内容
		mail.setContent("你的"+msg+"为:<a>"+code+"</a>", "text/html; charset=UTF-8");

		return mail.sendMessage(); // 是否发送成功
	}
	
	
	//获取注册的信息
	@RequestMapping(value="/register", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String register(HttpServletRequest req,String usEmail,String usName,String usPassword1,String codes){
		User user = new User();
		user.setUsEmail(usEmail);
		user.setUsPassword(usPassword1);
		user.setUsName(usName);
		user.setUsCode(codes);
		HttpSession session2 = req.getSession(false);
		String code = (String)session2.getAttribute("code");
		System.out.println(code+"--+++++++++++++++++++++++++++++++++++++++++++");
		if(!code.equals(codes)){
			zhongchouResult result = zhongchouResult.build(500, "验证码输入错误");
			String json="";
			try {
				json = JSON.json(result);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return json;
		}
		
		Integer i = userService.InsterUser(user);
		zhongchouResult result=null;
		if(i>0){
			List<User> list = new ArrayList<>();
			list.add(user);
			result = zhongchouResult.ok(200,"<a href='user.html'>欢迎，"+usName+"</a><span style='color: white;'>|</span><a href='loginOut'>lOut</a>", list);
			HttpSession session = req.getSession();
			session.setAttribute("user", result.getData());
		}else{
			result=zhongchouResult.build(500, "注册失败");			
		}
		String json="";
		try {
			json = JSON.json(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}
  //跳转到众筹资讯页面
	@RequestMapping("/ly-list")
	public String toLylist(){
		return "ly-list";
	}
	
	//众筹资讯查询方法
	@RequestMapping(value="/information", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String information( ){
		List<Projects> list = projectService.selectProjectsAll();
		zhongchouResult result = zhongchouResult.ok(200, "成功" ,list);	
		String json="";
		try {
			json = JSON.json(result);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return json;
	}
	
	
	@RequestMapping(value="/to_new_product", produces = {"text/html;charset=UTF-8"})
	@ResponseBody
	public String new_product(HttpServletRequest req){
		
		HttpSession session = req.getSession(false);
		zhongchouResult result=zhongchouResult.build(500, "请登录");
		if(session!=null){
			Object object = session.getAttribute("user");
			
			List<com.yh.pojo.User> list2 = castList(object,User.class);
			
			result = zhongchouResult.ok(500, "成功", list2);
			if(list2!=null){
				if(list2.size()>0){
					System.out.println(list2.get(0).getUsName());
					result.setStatus(200);
					result.setMsg("<a href='user.html'>欢迎，"+list2.get(0).getUsName()+"</a><span style='color: white;'>|</span><a href='loginOut'>lOut</a>");				
				}else{
					System.out.println("请登录");
				}				
			}
			
		}
		System.out.println("请登录");
		String json="";
		try {
			json = JSON.json(result);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return json;
	}
	
	//找回密码
	@RequestMapping(value="/bo_retrievePassword", produces = {"text/html;charset=UTF-8"})
	@ResponseBody
	public String retrievePassword(HttpServletRequest req,String usEmail,String codes){
		HttpSession session2 = req.getSession(false);
		String code = (String)session2.getAttribute("code");
		System.out.println(code+"--+++++++++++++++++++++++++++++++++++++++++++");
		if(!code.equals(codes)){
			zhongchouResult result = zhongchouResult.build(500, "验证码输入错误");
			String json="";
			try {
				json = JSON.json(result);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return json;
		}
		
		zhongchouResult result = userService.selectUserByEmail(usEmail);
		
		if(result.getStatus()==200){
			User user = (User) result.getData();
			String password = user.getUsPassword();
			try {
				boolean b = sendMail(usEmail,password,"密码");
				if(b){
					zhongchouResult result2 = zhongchouResult.build(200, "密码已发送至邮箱");
					String json="";
					try {
						json = JSON.json(result2);
					} catch (IOException e) {
						
						e.printStackTrace();
					}
					return json;
				}
			} catch (Exception e) {
				String json="";
				try {
					result.setMsg("验证码发送失败~");
					json = JSON.json(result);
				} catch (IOException e1) {			
					e1.printStackTrace();
				}	
				return json;
			}
		}
		String json="";
		try {
				json = JSON.json(result);
		} catch (IOException e) {
				
				e.printStackTrace();
		}
		return json;
		
	}
  
}


