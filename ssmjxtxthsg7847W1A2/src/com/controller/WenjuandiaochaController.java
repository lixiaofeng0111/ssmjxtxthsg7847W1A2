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

import com.entity.Wenjuandiaocha;
import com.server.WenjuandiaochaServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class WenjuandiaochaController {
	@Resource
	private WenjuandiaochaServer wenjuandiaochaService;


   
	@RequestMapping("addWenjuandiaocha.do")
	public String addWenjuandiaocha(HttpServletRequest request,Wenjuandiaocha wenjuandiaocha,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		wenjuandiaocha.setAddtime(time.toString().substring(0, 19));
		wenjuandiaochaService.add(wenjuandiaocha);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "wenjuandiaochaList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:wenjuandiaochaList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateWenjuandiaocha.do")
	public String doUpdateWenjuandiaocha(int id,ModelMap map,Wenjuandiaocha wenjuandiaocha){
		wenjuandiaocha=wenjuandiaochaService.getById(id);
		map.put("wenjuandiaocha", wenjuandiaocha);
		return "wenjuandiaocha_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("wenjuandiaochaDetail.do")
	public String wenjuandiaochaDetail(int id,ModelMap map,Wenjuandiaocha wenjuandiaocha){
		wenjuandiaocha=wenjuandiaochaService.getById(id);
		map.put("wenjuandiaocha", wenjuandiaocha);
		return "wenjuandiaocha_detail";
	}
//	前台详细
	@RequestMapping("wjdcDetail.do")
	public String wjdcDetail(int id,ModelMap map,Wenjuandiaocha wenjuandiaocha){
		wenjuandiaocha=wenjuandiaochaService.getById(id);
		map.put("wenjuandiaocha", wenjuandiaocha);
		return "wenjuandiaochadetail";
	}
//	
	@RequestMapping("updateWenjuandiaocha.do")
	public String updateWenjuandiaocha(int id,ModelMap map,Wenjuandiaocha wenjuandiaocha,HttpServletRequest request,HttpSession session){
		wenjuandiaochaService.update(wenjuandiaocha);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:wenjuandiaochaList.do";
	}

//	分页查询
	@RequestMapping("wenjuandiaochaList.do")
	public String wenjuandiaochaList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wenjuandiaocha wenjuandiaocha, String bianhao, String wenti1, String wenti2, String wenti3, String wenti4, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(wenti1==null||wenti1.equals("")){pmap.put("wenti1", null);}else{pmap.put("wenti1", wenti1);}		if(wenti2==null||wenti2.equals("")){pmap.put("wenti2", null);}else{pmap.put("wenti2", wenti2);}		if(wenti3==null||wenti3.equals("")){pmap.put("wenti3", null);}else{pmap.put("wenti3", wenti3);}		if(wenti4==null||wenti4.equals("")){pmap.put("wenti4", null);}else{pmap.put("wenti4", wenti4);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=wenjuandiaochaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wenjuandiaocha> list=wenjuandiaochaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wenjuandiaocha_list";
	}
	
	@RequestMapping("wenjuandiaocha_yanben1.do")
	public String wenjuandiaocha_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wenjuandiaocha wenjuandiaocha, String bianhao, String wenti1, String wenti2, String wenti3, String wenti4, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(wenti1==null||wenti1.equals("")){pmap.put("wenti1", null);}else{pmap.put("wenti1", wenti1);}		if(wenti2==null||wenti2.equals("")){pmap.put("wenti2", null);}else{pmap.put("wenti2", wenti2);}		if(wenti3==null||wenti3.equals("")){pmap.put("wenti3", null);}else{pmap.put("wenti3", wenti3);}		if(wenti4==null||wenti4.equals("")){pmap.put("wenti4", null);}else{pmap.put("wenti4", wenti4);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=wenjuandiaochaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wenjuandiaocha> list=wenjuandiaochaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wenjuandiaocha_yanben1";
	}
	@RequestMapping("wenjuandiaocha_yanben2.do")
	public String wenjuandiaocha_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wenjuandiaocha wenjuandiaocha, String bianhao, String wenti1, String wenti2, String wenti3, String wenti4, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(wenti1==null||wenti1.equals("")){pmap.put("wenti1", null);}else{pmap.put("wenti1", wenti1);}		if(wenti2==null||wenti2.equals("")){pmap.put("wenti2", null);}else{pmap.put("wenti2", wenti2);}		if(wenti3==null||wenti3.equals("")){pmap.put("wenti3", null);}else{pmap.put("wenti3", wenti3);}		if(wenti4==null||wenti4.equals("")){pmap.put("wenti4", null);}else{pmap.put("wenti4", wenti4);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=wenjuandiaochaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wenjuandiaocha> list=wenjuandiaochaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wenjuandiaocha_yanben2";
	}
	@RequestMapping("wenjuandiaocha_yanben3.do")
	public String wenjuandiaocha_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wenjuandiaocha wenjuandiaocha, String bianhao, String wenti1, String wenti2, String wenti3, String wenti4, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(wenti1==null||wenti1.equals("")){pmap.put("wenti1", null);}else{pmap.put("wenti1", wenti1);}		if(wenti2==null||wenti2.equals("")){pmap.put("wenti2", null);}else{pmap.put("wenti2", wenti2);}		if(wenti3==null||wenti3.equals("")){pmap.put("wenti3", null);}else{pmap.put("wenti3", wenti3);}		if(wenti4==null||wenti4.equals("")){pmap.put("wenti4", null);}else{pmap.put("wenti4", wenti4);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=wenjuandiaochaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wenjuandiaocha> list=wenjuandiaochaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wenjuandiaocha_yanben3";
	}
	@RequestMapping("wenjuandiaocha_yanben4.do")
	public String wenjuandiaocha_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wenjuandiaocha wenjuandiaocha, String bianhao, String wenti1, String wenti2, String wenti3, String wenti4, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(wenti1==null||wenti1.equals("")){pmap.put("wenti1", null);}else{pmap.put("wenti1", wenti1);}		if(wenti2==null||wenti2.equals("")){pmap.put("wenti2", null);}else{pmap.put("wenti2", wenti2);}		if(wenti3==null||wenti3.equals("")){pmap.put("wenti3", null);}else{pmap.put("wenti3", wenti3);}		if(wenti4==null||wenti4.equals("")){pmap.put("wenti4", null);}else{pmap.put("wenti4", wenti4);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=wenjuandiaochaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wenjuandiaocha> list=wenjuandiaochaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wenjuandiaocha_yanben4";
	}
	@RequestMapping("wenjuandiaocha_yanben5.do")
	public String wenjuandiaocha_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wenjuandiaocha wenjuandiaocha, String bianhao, String wenti1, String wenti2, String wenti3, String wenti4, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(wenti1==null||wenti1.equals("")){pmap.put("wenti1", null);}else{pmap.put("wenti1", wenti1);}		if(wenti2==null||wenti2.equals("")){pmap.put("wenti2", null);}else{pmap.put("wenti2", wenti2);}		if(wenti3==null||wenti3.equals("")){pmap.put("wenti3", null);}else{pmap.put("wenti3", wenti3);}		if(wenti4==null||wenti4.equals("")){pmap.put("wenti4", null);}else{pmap.put("wenti4", wenti4);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=wenjuandiaochaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wenjuandiaocha> list=wenjuandiaochaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wenjuandiaocha_yanben5";
	}
	
	@RequestMapping("wenjuandiaochaList2.do")
	public String wenjuandiaochaList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wenjuandiaocha wenjuandiaocha, String bianhao, String wenti1, String wenti2, String wenti3, String wenti4, String faburen,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("faburen", (String)request.getSession().getAttribute("username"));
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(wenti1==null||wenti1.equals("")){pmap.put("wenti1", null);}else{pmap.put("wenti1", wenti1);}		if(wenti2==null||wenti2.equals("")){pmap.put("wenti2", null);}else{pmap.put("wenti2", wenti2);}		if(wenti3==null||wenti3.equals("")){pmap.put("wenti3", null);}else{pmap.put("wenti3", wenti3);}		if(wenti4==null||wenti4.equals("")){pmap.put("wenti4", null);}else{pmap.put("wenti4", wenti4);}		
		
		int total=wenjuandiaochaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wenjuandiaocha> list=wenjuandiaochaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wenjuandiaocha_list2";
	}	
	
	@RequestMapping("wjdcList.do")
	public String wjdcList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wenjuandiaocha wenjuandiaocha, String bianhao, String wenti1, String wenti2, String wenti3, String wenti4, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(wenti1==null||wenti1.equals("")){pmap.put("wenti1", null);}else{pmap.put("wenti1", wenti1);}		if(wenti2==null||wenti2.equals("")){pmap.put("wenti2", null);}else{pmap.put("wenti2", wenti2);}		if(wenti3==null||wenti3.equals("")){pmap.put("wenti3", null);}else{pmap.put("wenti3", wenti3);}		if(wenti4==null||wenti4.equals("")){pmap.put("wenti4", null);}else{pmap.put("wenti4", wenti4);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=wenjuandiaochaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wenjuandiaocha> list=wenjuandiaochaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wenjuandiaochalist";
	}
	@RequestMapping("wjdcListtp.do")
	public String wjdcListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wenjuandiaocha wenjuandiaocha, String bianhao, String wenti1, String wenti2, String wenti3, String wenti4, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(wenti1==null||wenti1.equals("")){pmap.put("wenti1", null);}else{pmap.put("wenti1", wenti1);}		if(wenti2==null||wenti2.equals("")){pmap.put("wenti2", null);}else{pmap.put("wenti2", wenti2);}		if(wenti3==null||wenti3.equals("")){pmap.put("wenti3", null);}else{pmap.put("wenti3", wenti3);}		if(wenti4==null||wenti4.equals("")){pmap.put("wenti4", null);}else{pmap.put("wenti4", wenti4);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=wenjuandiaochaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wenjuandiaocha> list=wenjuandiaochaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wenjuandiaochalisttp";
	}
	
	@RequestMapping("deleteWenjuandiaocha.do")
	public String deleteWenjuandiaocha(int id,HttpServletRequest request){
		wenjuandiaochaService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:wenjuandiaochaList.do";
	}
	
	
}
