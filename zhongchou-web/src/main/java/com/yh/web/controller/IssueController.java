package com.yh.web.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.json.JSONObject;
import com.yh.pojo.Draft;
import com.yh.pojo.Identity;
import com.yh.pojo.IdentityExample;
import com.yh.pojo.IdentityExample.Criteria;
import com.yh.pojo.Projects;
import com.yh.pojo.Repay;
import com.yh.pojo.User;
import com.yh.pojo.zhongchouResult;
import com.yh.pojo.f_common.QiniuUtils;
import com.yh.service.IssueService;
import com.yh.service.ProjectService;
import com.yh.service.identity.IdentityService;
import com.yh.service.user.UserService;

import freemarker.template.utility.DateUtil;

@Controller
public class IssueController {
	
	//注入 projects service
	@Autowired
	private ProjectService projectService;
	//注入user service
	@Autowired
	private UserService userService;
	//注入 identity service
	@Autowired
	private IdentityService identityService;
	
	
	@Autowired
private IssueService issueServiceImpl;
	@RequestMapping("/addProject")
	public  String  addProject(String usName, String usIdcard,String usPhone,String proAName,
			String proAPhone,String usAddress,String pstName,String psName,String psGoal,
			String psAddress,String psMoney,String psDays,String psVideo,String psStory,
			String psSupport,String psRepay,String psAboutme,String ryType,String psFile,
			String ryPaymoney,String ryRule,String ryContent,String ryNumber,String ryTime,
			HttpServletRequest req){
		Draft d=new Draft();
		HttpSession session = req.getSession(false);
		if(session!=null){
			Object object = session.getAttribute("user");
			
			List<com.yh.pojo.User> list2 = IndexController.castList(object,User.class);
			
			if(list2!=null){
				Integer usId = list2.get(0).getUsId();
				d.setUsId(usId);
			}
			
		}
		//int id=2;
		d.setPsFile(psFile);
		d.setUsAddress(usAddress);
		d.setUsIdcard(usIdcard);
		d.setUsName(usName);
		d.setUsPhone(usPhone);
		//d.setUsId(id);
		d.setProAName(proAName);
		d.setProAPhone(proAPhone);
		d.setPsAboutme(psAboutme);
		d.setPsAddress(psAddress);
		int a=Integer.parseInt(psDays);
		d.setPsDays(a);
		d.setPsGoal(psGoal);
		double b=Double.parseDouble(psMoney);
		d.setPsMoney(b);
		d.setPsName(psName);
		d.setPsRepay(psRepay);
		d.setPsStory(psStory);
		d.setPsSupport(psSupport);
		if(pstName.equals("支教助学")){
			d.setPstId(1);
		}else if(pstName.equals("妇女家庭")){
			d.setPstId(7);
		}else if(pstName.equals("儿童关爱")){
			d.setPstId(2);
		}else if(pstName.equals("绿色环保")){
			d.setPstId(3);
		}else if(pstName.equals("动物保护")){
			d.setPstId(5);
		}else if(pstName.equals("扶老助孤")){
			d.setPstId(6);
		}
		
		d.setPsVideo(psVideo);
		d.setRyContent(ryContent);
		if(ryType.equals("1")){
		d.setRyType(1);
		}else{
			d.setRyType(2);
		}
		d.setRyNumber(ryNumber);
		double c=Double.parseDouble(ryPaymoney);
		d.setRyPaymoney(c);
		d.setRyRule(ryRule);
		d.setRyTime(ryTime);
		
		System.out.println(d);
		
		boolean addProject = issueServiceImpl.addProject(d);
		System.out.println(addProject);

		return "index";
	}
	
	
	@RequestMapping("/shimingrenzheng")
	public String shimingrenzheng(){
		
		return "product/shimingrenzheng";
	}
	//跳转基本信息
	@RequestMapping("/jibenxinxi")
	public String jibenxinxi(){
		
		return "product/jibenxinxi";
	}
	
	//在基本信息页面查询  session 判断是否有项目信息
	@RequestMapping(value="/Gojibenxinxi" , produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String Gojibenxinxi(HttpServletRequest req){
		HttpSession session = req.getSession(false);
		//定义返回的数据类型
		zhongchouResult results=null;
		//如果 session 为null  是不会走到这一步的
		if(session!=null){
			Object object = session.getAttribute("user");
			
			List<com.yh.pojo.User> list2 = IndexController.castList(object,User.class);
			//大于0说明session中有用户信息
			if(list2.size()>0){
				
				Integer usId = list2.get(0).getUsId();
				//zhongchouResult result = projectService.selectByUserId(usId);
				//Integer status = result.getStatus();
				//等于200说明发布过项目
				//if(status==200){
					//根据id查询用户信息
					ArrayList<User> list = new ArrayList<>();
					User user = userService.selectuser(usId);
					list.add(user);
					//将查询到的信息存入session   顺便更新session
					session.setAttribute("user", list);
					
					//把查询到的用户信息 放进返回的数据类型中
					results=zhongchouResult.ok(200, "用户信息", user);
					
				//等于500说明没有发布过项目  也就没有基本信息
				//}else if(status==500){
					//results=zhongchouResult.ok(500, "没有用户信息", null);
				//}
			}
			//zhongchouResult = com.yh.pojo.zhongchouResult.ok(200, "用户信息", list2);
		}
		String json="";
		try {
			json = JSON.json(results);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	@RequestMapping("/xiangmuxinxi")
	public String xiangmuxinxi(){
		
		return "product/xiangmuxinxi";
	}
	
	@RequestMapping("/xiangmugushi")
	public String xiangmugushi(){
		
		return "product/xiangmugushi";
	}
	
	@RequestMapping("/huibaoshezhi")
	public String huibaoshezhi(){
		
		return "product/huibaoshezhi";
	}
	
	//是否正在审核中
	@RequestMapping(value="/isfshenhezhong", produces = {"text/html;charset=UTF-8"})
	@ResponseBody
	public String isfshenhezhong(HttpServletRequest req){
		HttpSession session = req.getSession(false);
		
		//定义返回的数据类型
		zhongchouResult results=null;
		
		//如果 session 为空  没有登录退出
		if(session!=null){
			Object object = session.getAttribute("user");
			
			List<com.yh.pojo.User> list2 = IndexController.castList(object,User.class);
			//大于0说明session中有用户信息
			if(list2.size()>0){
				Integer usId = list2.get(0).getUsId();
				Identity identByUsId = identityService.selectByUsId(usId);
				if(identByUsId!=null){
					results=zhongchouResult.ok(200, "正在审核中请耐心等待！！！");
				}else{
					results=zhongchouResult.ok(500, "请实名");
				}
			}
			//zhongchouResult = com.yh.pojo.zhongchouResult.ok(200, "用户信息", list2);
		}
		String json="";
		try {
			json = JSON.json(results);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	
	//实名认证提交
	@RequestMapping("/shimingfile1")
	public String shimingfile1(HttpServletRequest request){
		
		HttpSession session = request.getSession(false);
		
		String idCard = request.getParameter("idCard");
		String Address = request.getParameter("Address");
		String img1 = request.getParameter("img1");		
		String img2 = request.getParameter("img2");
		String usPhone = request.getParameter("usPhone");
		
		//System.out.println(usName+usPhone+idCard);
		User user = new User();
		user.setUsIdcard(idCard);
		user.setUsPhone(usPhone);
		user.setUsAddress(Address);
		//IdentityExample example = new IdentityExample();
		//Criteria criteria = example.createCriteria();
		Identity identity = new Identity();
			if(session!=null){
				Object object = session.getAttribute("user");
				List<com.yh.pojo.User> list2 = IndexController.castList(object,User.class);
				//大于0说明session中有用户信息
				if(list2.size()>0){
					Integer usId = list2.get(0).getUsId();
					
					user.setUsEmail(list2.get(0).getUsEmail());
					user.setUsPassword(list2.get(0).getUsPassword());
					user.setUsRole(list2.get(0).getUsRole());
					user.setUsName(list2.get(0).getUsName());
					
					identity.setUsId(usId);
					identity.setUsIdentityImage1(img1);
					identity.setUsIdentityImage2(img2);
					user.setUsId(usId);
					Integer integer = userService.updatauser(user);
					
					//修改成功 更新session
					if(integer>0){
						List<User> list = new ArrayList<>();
						list.add(user);
						session.setAttribute("user", list);
					}
					
					
					Integer integer2 = identityService.insertIdentityAll(identity);
					
					if(integer>0 && integer2>0){
						System.out.println(integer+integer2);
						return "new_product";
					}	
				}
				//zhongchouResult = com.yh.pojo.zhongchouResult.ok(200, "用户信息", list2);
			}
					
		System.out.println("-----------------------");
		return "new_product";
	}
	
	//图片上传
    @RequestMapping(value="/importPicFile" ,produces="application/json;charset=utf-8" )  
    public @ResponseBody String importPicFile1(  
  @RequestParam MultipartFile myfile,HttpServletRequest request){  
                System.out.println("--------444444444444-------------");
                zhongchouResult result=null;
               if(myfile.isEmpty()){  
            	   result = zhongchouResult.build(500, "请重新上传图片");
              } else{  
            	  String saveFileName2 = UUID.randomUUID().toString().replace("-","");
            	  try {
					String string = QiniuUtils.upload2Qiniu(myfile.getBytes(), saveFileName2);
					result = zhongchouResult.build(200, string);
					System.out.println(string);
				} catch (IOException e) {
					
					e.printStackTrace();
				}
                    //String originalFilename=myfile.getOriginalFilename();
                    //System.out.println(originalFilename);
                   
              }  
               String json="";
       		try {
       			json = JSON.json(result);
       		} catch (IOException e) {
       			e.printStackTrace();
       		}
       		return json;
        }  
	
    
    //添加项目
    @RequestMapping(value="/xiangmusubmit", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String xiangmusubmit(HttpServletRequest req,String ps_name,String ps_Address,String ps_file
    		,String ps_video,String ps_goal,String ps_money,String ps_days,String ps_cust_name,String selectEd
    		,String ps_cust_phone,String ps_story,String ry_paymoney,String ry_number,String ry_content){
    	
    	HttpSession session = req.getSession(false);
    	
    	//String ps_name1 = req.getParameter("ps_name");
    	//String ps_Address1 = req.getParameter("ps_Address");
    	System.out.println(ps_name+":"+ps_Address);
    	//System.out.println(ps_name1+":"+ps_Address1);
    	
    	Projects projects = new Projects();
    	projects.setPsCustName(ps_cust_name);
    	projects.setPsCustPhone(ps_cust_phone);
    	//projects.setPsCustAddress(ps_Address);
    	projects.setPsFile(ps_file);
    	projects.setPsName(ps_name);
    	projects.setPsGoal(ps_goal);
    	projects.setPsAddress(ps_Address);
    	projects.setPsMoney(Double.parseDouble(ps_money));
    	projects.setPsDays(Integer.parseInt(ps_days));
    	projects.setPsVideo(ps_video);
    	//projects.setPsStory(psStory);
    	//byte[] bytes = ps_story.getBytes();
    	projects.setPsStory(ps_story);
    	projects.setPsType(0);
    	
    	projects.setPsPstId(Integer.parseInt(selectEd));
    	if(session!=null){
			Object object = session.getAttribute("user");
			
			List<com.yh.pojo.User> list2 = IndexController.castList(object,User.class);
			
			if(list2.size()>0){
				projects.setPsUsId(list2.get(0).getUsId());					
				//添加项目信息
				Integer integer = projectService.insertProjects(projects);
				
				Integer psId = projects.getPsId();
				//System.out.println(psId+".............................");
				//添加回报表
				Repay repay = new Repay();
				repay.setRyUsId(list2.get(0).getUsId());
				repay.setRyType(0);
				repay.setRyPaymoney(Double.parseDouble(ry_paymoney));
				repay.setRyRule(ry_number);
				repay.setRyContent(ry_content);
				repay.setRyPsId(integer);
				Integer integer2 = projectService.insertRepay(repay);
				
				if(integer>0 && integer2>0){
					System.out.println("添加成功");
					zhongchouResult result = zhongchouResult.build(200, "添加成功");
					String json="";
					try {
						json = JSON.json(result);
					} catch (IOException e) {
						
						e.printStackTrace();
					}
					return json;
				}
			}
			
		}
    	zhongchouResult result = zhongchouResult.build(500, "添加失败");
		String json="";
		try {
			json = JSON.json(result);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return json;
    }
}