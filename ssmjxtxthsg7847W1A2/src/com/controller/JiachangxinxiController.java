package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Jiachangxinxi;
import com.server.JiachangxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class JiachangxinxiController {
	@Resource
	private JiachangxinxiServer jiachangxinxiService;


   
	@RequestMapping("addJiachangxinxi.do")
	public String addJiachangxinxi(HttpServletRequest request,Jiachangxinxi jiachangxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		jiachangxinxi.setAddtime(time.toString().substring(0, 19));
		jiachangxinxiService.add(jiachangxinxi);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "jiachangxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:jiachangxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateJiachangxinxi.do")
	public String doUpdateJiachangxinxi(int id,ModelMap map,Jiachangxinxi jiachangxinxi){
		jiachangxinxi=jiachangxinxiService.getById(id);
		map.put("jiachangxinxi", jiachangxinxi);
		return "jiachangxinxi_updt";
	}
	
	@RequestMapping("doUpdateJiachangxinxi2.do")
	public String doUpdateJiachangxinxi2(ModelMap map,Jiachangxinxi jiachangxinxi,HttpServletRequest request){
		jiachangxinxi=jiachangxinxiService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("jiachangxinxi", jiachangxinxi);
		return "jiachangxinxi_updt2";
	}
	
@RequestMapping("updateJiachangxinxi2.do")
	public String updateJiachangxinxi2(int id,ModelMap map,Jiachangxinxi jiachangxinxi){
		jiachangxinxiService.update(jiachangxinxi);
		return "redirect:doUpdateJiachangxinxi2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("jiachangxinxiDetail.do")
	public String jiachangxinxiDetail(int id,ModelMap map,Jiachangxinxi jiachangxinxi){
		jiachangxinxi=jiachangxinxiService.getById(id);
		map.put("jiachangxinxi", jiachangxinxi);
		return "jiachangxinxi_detail";
	}
//	前台详细
	@RequestMapping("jcxxDetail.do")
	public String jcxxDetail(int id,ModelMap map,Jiachangxinxi jiachangxinxi){
		jiachangxinxi=jiachangxinxiService.getById(id);
		map.put("jiachangxinxi", jiachangxinxi);
		return "jiachangxinxidetail";
	}
//	
	@RequestMapping("updateJiachangxinxi.do")
	public String updateJiachangxinxi(int id,ModelMap map,Jiachangxinxi jiachangxinxi,HttpServletRequest request,HttpSession session){
		jiachangxinxiService.update(jiachangxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:jiachangxinxiList.do";
	}

//	分页查询
	@RequestMapping("jiachangxinxiList.do")
	public String jiachangxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiachangxinxi jiachangxinxi, String yonghuming, String mima, String xingming, String xingbie, String dianhua, String shenfenzheng){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		
		int total=jiachangxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiachangxinxi> list=jiachangxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiachangxinxi_list";
	}
	
	@RequestMapping("jiachangxinxi_yanben1.do")
	public String jiachangxinxi_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiachangxinxi jiachangxinxi, String yonghuming, String mima, String xingming, String xingbie, String dianhua, String shenfenzheng){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		
		int total=jiachangxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiachangxinxi> list=jiachangxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiachangxinxi_yanben1";
	}
	@RequestMapping("jiachangxinxi_yanben2.do")
	public String jiachangxinxi_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiachangxinxi jiachangxinxi, String yonghuming, String mima, String xingming, String xingbie, String dianhua, String shenfenzheng){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		
		int total=jiachangxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiachangxinxi> list=jiachangxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiachangxinxi_yanben2";
	}
	@RequestMapping("jiachangxinxi_yanben3.do")
	public String jiachangxinxi_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiachangxinxi jiachangxinxi, String yonghuming, String mima, String xingming, String xingbie, String dianhua, String shenfenzheng){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		
		int total=jiachangxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiachangxinxi> list=jiachangxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiachangxinxi_yanben3";
	}
	@RequestMapping("jiachangxinxi_yanben4.do")
	public String jiachangxinxi_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiachangxinxi jiachangxinxi, String yonghuming, String mima, String xingming, String xingbie, String dianhua, String shenfenzheng){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		
		int total=jiachangxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiachangxinxi> list=jiachangxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiachangxinxi_yanben4";
	}
	@RequestMapping("jiachangxinxi_yanben5.do")
	public String jiachangxinxi_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiachangxinxi jiachangxinxi, String yonghuming, String mima, String xingming, String xingbie, String dianhua, String shenfenzheng){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		
		int total=jiachangxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiachangxinxi> list=jiachangxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiachangxinxi_yanben5";
	}
	
	
	
	@RequestMapping("jcxxList.do")
	public String jcxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiachangxinxi jiachangxinxi, String yonghuming, String mima, String xingming, String xingbie, String dianhua, String shenfenzheng){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		
		int total=jiachangxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiachangxinxi> list=jiachangxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiachangxinxilist";
	}
	@RequestMapping("jcxxListtp.do")
	public String jcxxListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiachangxinxi jiachangxinxi, String yonghuming, String mima, String xingming, String xingbie, String dianhua, String shenfenzheng){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		
		int total=jiachangxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiachangxinxi> list=jiachangxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiachangxinxilisttp";
	}
	
	@RequestMapping("deleteJiachangxinxi.do")
	public String deleteJiachangxinxi(int id,HttpServletRequest request){
		jiachangxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:jiachangxinxiList.do";
	}
	
	@RequestMapping("quchongJiachangxinxi.do")
	public void quchongJiachangxinxi(Jiachangxinxi jiachangxinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("yonghuming", jiachangxinxi.getYonghuming());
		   System.out.println("yonghuming==="+jiachangxinxi.getYonghuming());
		   System.out.println("yonghuming222==="+jiachangxinxiService.quchongJiachangxinxi(map));
		   JSONObject obj=new JSONObject();
		   if(jiachangxinxiService.quchongJiachangxinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "用户名可以用！");
				  
			   }
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=null;
		   try {
			out=response.getWriter();
			out.print(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
