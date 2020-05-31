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

import com.entity.Huida;
import com.server.HuidaServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class HuidaController {
	@Resource
	private HuidaServer huidaService;


   
	@RequestMapping("addHuida.do")
	public String addHuida(HttpServletRequest request,Huida huida,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		huida.setAddtime(time.toString().substring(0, 19));
		huidaService.add(huida);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "huidaList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:huidaList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateHuida.do")
	public String doUpdateHuida(int id,ModelMap map,Huida huida){
		huida=huidaService.getById(id);
		map.put("huida", huida);
		return "huida_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("huidaDetail.do")
	public String huidaDetail(int id,ModelMap map,Huida huida){
		huida=huidaService.getById(id);
		map.put("huida", huida);
		return "huida_detail";
	}
//	前台详细
	@RequestMapping("hdDetail.do")
	public String hdDetail(int id,ModelMap map,Huida huida){
		huida=huidaService.getById(id);
		map.put("huida", huida);
		return "huidadetail";
	}
//	
	@RequestMapping("updateHuida.do")
	public String updateHuida(int id,ModelMap map,Huida huida,HttpServletRequest request,HttpSession session){
		huidaService.update(huida);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:huidaList.do";
	}

//	分页查询
	@RequestMapping("huidaList.do")
	public String huidaList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huida huida, String bianhao, String wenti1, String wenti2, String wenti3, String wenti4, String huida1, String huida2, String huida3, String huida4, String yonghuming, String xingming){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(wenti1==null||wenti1.equals("")){pmap.put("wenti1", null);}else{pmap.put("wenti1", wenti1);}		if(wenti2==null||wenti2.equals("")){pmap.put("wenti2", null);}else{pmap.put("wenti2", wenti2);}		if(wenti3==null||wenti3.equals("")){pmap.put("wenti3", null);}else{pmap.put("wenti3", wenti3);}		if(wenti4==null||wenti4.equals("")){pmap.put("wenti4", null);}else{pmap.put("wenti4", wenti4);}		if(huida1==null||huida1.equals("")){pmap.put("huida1", null);}else{pmap.put("huida1", huida1);}		if(huida2==null||huida2.equals("")){pmap.put("huida2", null);}else{pmap.put("huida2", huida2);}		if(huida3==null||huida3.equals("")){pmap.put("huida3", null);}else{pmap.put("huida3", huida3);}		if(huida4==null||huida4.equals("")){pmap.put("huida4", null);}else{pmap.put("huida4", huida4);}		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		
		int total=huidaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huida> list=huidaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huida_list";
	}
	
	@RequestMapping("huida_yanben1.do")
	public String huida_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huida huida, String bianhao, String wenti1, String wenti2, String wenti3, String wenti4, String huida1, String huida2, String huida3, String huida4, String yonghuming, String xingming){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(wenti1==null||wenti1.equals("")){pmap.put("wenti1", null);}else{pmap.put("wenti1", wenti1);}		if(wenti2==null||wenti2.equals("")){pmap.put("wenti2", null);}else{pmap.put("wenti2", wenti2);}		if(wenti3==null||wenti3.equals("")){pmap.put("wenti3", null);}else{pmap.put("wenti3", wenti3);}		if(wenti4==null||wenti4.equals("")){pmap.put("wenti4", null);}else{pmap.put("wenti4", wenti4);}		if(huida1==null||huida1.equals("")){pmap.put("huida1", null);}else{pmap.put("huida1", huida1);}		if(huida2==null||huida2.equals("")){pmap.put("huida2", null);}else{pmap.put("huida2", huida2);}		if(huida3==null||huida3.equals("")){pmap.put("huida3", null);}else{pmap.put("huida3", huida3);}		if(huida4==null||huida4.equals("")){pmap.put("huida4", null);}else{pmap.put("huida4", huida4);}		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		
		int total=huidaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huida> list=huidaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huida_yanben1";
	}
	@RequestMapping("huida_yanben2.do")
	public String huida_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huida huida, String bianhao, String wenti1, String wenti2, String wenti3, String wenti4, String huida1, String huida2, String huida3, String huida4, String yonghuming, String xingming){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(wenti1==null||wenti1.equals("")){pmap.put("wenti1", null);}else{pmap.put("wenti1", wenti1);}		if(wenti2==null||wenti2.equals("")){pmap.put("wenti2", null);}else{pmap.put("wenti2", wenti2);}		if(wenti3==null||wenti3.equals("")){pmap.put("wenti3", null);}else{pmap.put("wenti3", wenti3);}		if(wenti4==null||wenti4.equals("")){pmap.put("wenti4", null);}else{pmap.put("wenti4", wenti4);}		if(huida1==null||huida1.equals("")){pmap.put("huida1", null);}else{pmap.put("huida1", huida1);}		if(huida2==null||huida2.equals("")){pmap.put("huida2", null);}else{pmap.put("huida2", huida2);}		if(huida3==null||huida3.equals("")){pmap.put("huida3", null);}else{pmap.put("huida3", huida3);}		if(huida4==null||huida4.equals("")){pmap.put("huida4", null);}else{pmap.put("huida4", huida4);}		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		
		int total=huidaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huida> list=huidaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huida_yanben2";
	}
	@RequestMapping("huida_yanben3.do")
	public String huida_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huida huida, String bianhao, String wenti1, String wenti2, String wenti3, String wenti4, String huida1, String huida2, String huida3, String huida4, String yonghuming, String xingming){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(wenti1==null||wenti1.equals("")){pmap.put("wenti1", null);}else{pmap.put("wenti1", wenti1);}		if(wenti2==null||wenti2.equals("")){pmap.put("wenti2", null);}else{pmap.put("wenti2", wenti2);}		if(wenti3==null||wenti3.equals("")){pmap.put("wenti3", null);}else{pmap.put("wenti3", wenti3);}		if(wenti4==null||wenti4.equals("")){pmap.put("wenti4", null);}else{pmap.put("wenti4", wenti4);}		if(huida1==null||huida1.equals("")){pmap.put("huida1", null);}else{pmap.put("huida1", huida1);}		if(huida2==null||huida2.equals("")){pmap.put("huida2", null);}else{pmap.put("huida2", huida2);}		if(huida3==null||huida3.equals("")){pmap.put("huida3", null);}else{pmap.put("huida3", huida3);}		if(huida4==null||huida4.equals("")){pmap.put("huida4", null);}else{pmap.put("huida4", huida4);}		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		
		int total=huidaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huida> list=huidaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huida_yanben3";
	}
	@RequestMapping("huida_yanben4.do")
	public String huida_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huida huida, String bianhao, String wenti1, String wenti2, String wenti3, String wenti4, String huida1, String huida2, String huida3, String huida4, String yonghuming, String xingming){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(wenti1==null||wenti1.equals("")){pmap.put("wenti1", null);}else{pmap.put("wenti1", wenti1);}		if(wenti2==null||wenti2.equals("")){pmap.put("wenti2", null);}else{pmap.put("wenti2", wenti2);}		if(wenti3==null||wenti3.equals("")){pmap.put("wenti3", null);}else{pmap.put("wenti3", wenti3);}		if(wenti4==null||wenti4.equals("")){pmap.put("wenti4", null);}else{pmap.put("wenti4", wenti4);}		if(huida1==null||huida1.equals("")){pmap.put("huida1", null);}else{pmap.put("huida1", huida1);}		if(huida2==null||huida2.equals("")){pmap.put("huida2", null);}else{pmap.put("huida2", huida2);}		if(huida3==null||huida3.equals("")){pmap.put("huida3", null);}else{pmap.put("huida3", huida3);}		if(huida4==null||huida4.equals("")){pmap.put("huida4", null);}else{pmap.put("huida4", huida4);}		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		
		int total=huidaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huida> list=huidaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huida_yanben4";
	}
	@RequestMapping("huida_yanben5.do")
	public String huida_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huida huida, String bianhao, String wenti1, String wenti2, String wenti3, String wenti4, String huida1, String huida2, String huida3, String huida4, String yonghuming, String xingming){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(wenti1==null||wenti1.equals("")){pmap.put("wenti1", null);}else{pmap.put("wenti1", wenti1);}		if(wenti2==null||wenti2.equals("")){pmap.put("wenti2", null);}else{pmap.put("wenti2", wenti2);}		if(wenti3==null||wenti3.equals("")){pmap.put("wenti3", null);}else{pmap.put("wenti3", wenti3);}		if(wenti4==null||wenti4.equals("")){pmap.put("wenti4", null);}else{pmap.put("wenti4", wenti4);}		if(huida1==null||huida1.equals("")){pmap.put("huida1", null);}else{pmap.put("huida1", huida1);}		if(huida2==null||huida2.equals("")){pmap.put("huida2", null);}else{pmap.put("huida2", huida2);}		if(huida3==null||huida3.equals("")){pmap.put("huida3", null);}else{pmap.put("huida3", huida3);}		if(huida4==null||huida4.equals("")){pmap.put("huida4", null);}else{pmap.put("huida4", huida4);}		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		
		int total=huidaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huida> list=huidaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huida_yanben5";
	}
	
	@RequestMapping("huidaList2.do")
	public String huidaList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huida huida, String bianhao, String wenti1, String wenti2, String wenti3, String wenti4, String huida1, String huida2, String huida3, String huida4, String yonghuming, String xingming,HttpServletRequest request){
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
		
		pmap.put("yonghuming", (String)request.getSession().getAttribute("username"));
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(wenti1==null||wenti1.equals("")){pmap.put("wenti1", null);}else{pmap.put("wenti1", wenti1);}		if(wenti2==null||wenti2.equals("")){pmap.put("wenti2", null);}else{pmap.put("wenti2", wenti2);}		if(wenti3==null||wenti3.equals("")){pmap.put("wenti3", null);}else{pmap.put("wenti3", wenti3);}		if(wenti4==null||wenti4.equals("")){pmap.put("wenti4", null);}else{pmap.put("wenti4", wenti4);}		if(huida1==null||huida1.equals("")){pmap.put("huida1", null);}else{pmap.put("huida1", huida1);}		if(huida2==null||huida2.equals("")){pmap.put("huida2", null);}else{pmap.put("huida2", huida2);}		if(huida3==null||huida3.equals("")){pmap.put("huida3", null);}else{pmap.put("huida3", huida3);}		if(huida4==null||huida4.equals("")){pmap.put("huida4", null);}else{pmap.put("huida4", huida4);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		
		
		int total=huidaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huida> list=huidaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huida_list2";
	}	
	
	@RequestMapping("hdList.do")
	public String hdList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huida huida, String bianhao, String wenti1, String wenti2, String wenti3, String wenti4, String huida1, String huida2, String huida3, String huida4, String yonghuming, String xingming){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(wenti1==null||wenti1.equals("")){pmap.put("wenti1", null);}else{pmap.put("wenti1", wenti1);}		if(wenti2==null||wenti2.equals("")){pmap.put("wenti2", null);}else{pmap.put("wenti2", wenti2);}		if(wenti3==null||wenti3.equals("")){pmap.put("wenti3", null);}else{pmap.put("wenti3", wenti3);}		if(wenti4==null||wenti4.equals("")){pmap.put("wenti4", null);}else{pmap.put("wenti4", wenti4);}		if(huida1==null||huida1.equals("")){pmap.put("huida1", null);}else{pmap.put("huida1", huida1);}		if(huida2==null||huida2.equals("")){pmap.put("huida2", null);}else{pmap.put("huida2", huida2);}		if(huida3==null||huida3.equals("")){pmap.put("huida3", null);}else{pmap.put("huida3", huida3);}		if(huida4==null||huida4.equals("")){pmap.put("huida4", null);}else{pmap.put("huida4", huida4);}		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		
		int total=huidaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huida> list=huidaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huidalist";
	}
	@RequestMapping("hdListtp.do")
	public String hdListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huida huida, String bianhao, String wenti1, String wenti2, String wenti3, String wenti4, String huida1, String huida2, String huida3, String huida4, String yonghuming, String xingming){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(wenti1==null||wenti1.equals("")){pmap.put("wenti1", null);}else{pmap.put("wenti1", wenti1);}		if(wenti2==null||wenti2.equals("")){pmap.put("wenti2", null);}else{pmap.put("wenti2", wenti2);}		if(wenti3==null||wenti3.equals("")){pmap.put("wenti3", null);}else{pmap.put("wenti3", wenti3);}		if(wenti4==null||wenti4.equals("")){pmap.put("wenti4", null);}else{pmap.put("wenti4", wenti4);}		if(huida1==null||huida1.equals("")){pmap.put("huida1", null);}else{pmap.put("huida1", huida1);}		if(huida2==null||huida2.equals("")){pmap.put("huida2", null);}else{pmap.put("huida2", huida2);}		if(huida3==null||huida3.equals("")){pmap.put("huida3", null);}else{pmap.put("huida3", huida3);}		if(huida4==null||huida4.equals("")){pmap.put("huida4", null);}else{pmap.put("huida4", huida4);}		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		
		int total=huidaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huida> list=huidaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huidalisttp";
	}
	
	@RequestMapping("deleteHuida.do")
	public String deleteHuida(int id,HttpServletRequest request){
		huidaService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:huidaList.do";
	}
	
	
}
