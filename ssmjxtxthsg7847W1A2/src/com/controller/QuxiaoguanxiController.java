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

import com.entity.Quxiaoguanxi;
import com.server.QuxiaoguanxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class QuxiaoguanxiController {
	@Resource
	private QuxiaoguanxiServer quxiaoguanxiService;


   
	@RequestMapping("addQuxiaoguanxi.do")
	public String addQuxiaoguanxi(HttpServletRequest request,Quxiaoguanxi quxiaoguanxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		quxiaoguanxi.setAddtime(time.toString().substring(0, 19));
		quxiaoguanxiService.add(quxiaoguanxi);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "quxiaoguanxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:quxiaoguanxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateQuxiaoguanxi.do")
	public String doUpdateQuxiaoguanxi(int id,ModelMap map,Quxiaoguanxi quxiaoguanxi){
		quxiaoguanxi=quxiaoguanxiService.getById(id);
		map.put("quxiaoguanxi", quxiaoguanxi);
		return "quxiaoguanxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("quxiaoguanxiDetail.do")
	public String quxiaoguanxiDetail(int id,ModelMap map,Quxiaoguanxi quxiaoguanxi){
		quxiaoguanxi=quxiaoguanxiService.getById(id);
		map.put("quxiaoguanxi", quxiaoguanxi);
		return "quxiaoguanxi_detail";
	}
//	前台详细
	@RequestMapping("qxgxDetail.do")
	public String qxgxDetail(int id,ModelMap map,Quxiaoguanxi quxiaoguanxi){
		quxiaoguanxi=quxiaoguanxiService.getById(id);
		map.put("quxiaoguanxi", quxiaoguanxi);
		return "quxiaoguanxidetail";
	}
//	
	@RequestMapping("updateQuxiaoguanxi.do")
	public String updateQuxiaoguanxi(int id,ModelMap map,Quxiaoguanxi quxiaoguanxi,HttpServletRequest request,HttpSession session){
		quxiaoguanxiService.update(quxiaoguanxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:quxiaoguanxiList.do";
	}

//	分页查询
	@RequestMapping("quxiaoguanxiList.do")
	public String quxiaoguanxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Quxiaoguanxi quxiaoguanxi, String yonghuming, String xingbie, String dianhua, String shenfenzheng, String xuehao, String xueshengxingming, String xueshengguanxi, String quxiaoyuanyin, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xueshengxingming==null||xueshengxingming.equals("")){pmap.put("xueshengxingming", null);}else{pmap.put("xueshengxingming", xueshengxingming);}		if(xueshengguanxi==null||xueshengguanxi.equals("")){pmap.put("xueshengguanxi", null);}else{pmap.put("xueshengguanxi", xueshengguanxi);}		if(quxiaoyuanyin==null||quxiaoyuanyin.equals("")){pmap.put("quxiaoyuanyin", null);}else{pmap.put("quxiaoyuanyin", quxiaoyuanyin);}		
		int total=quxiaoguanxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Quxiaoguanxi> list=quxiaoguanxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "quxiaoguanxi_list";
	}
	
	@RequestMapping("quxiaoguanxi_yanben1.do")
	public String quxiaoguanxi_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Quxiaoguanxi quxiaoguanxi, String yonghuming, String xingbie, String dianhua, String shenfenzheng, String xuehao, String xueshengxingming, String xueshengguanxi, String quxiaoyuanyin, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xueshengxingming==null||xueshengxingming.equals("")){pmap.put("xueshengxingming", null);}else{pmap.put("xueshengxingming", xueshengxingming);}		if(xueshengguanxi==null||xueshengguanxi.equals("")){pmap.put("xueshengguanxi", null);}else{pmap.put("xueshengguanxi", xueshengguanxi);}		if(quxiaoyuanyin==null||quxiaoyuanyin.equals("")){pmap.put("quxiaoyuanyin", null);}else{pmap.put("quxiaoyuanyin", quxiaoyuanyin);}		
		int total=quxiaoguanxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Quxiaoguanxi> list=quxiaoguanxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "quxiaoguanxi_yanben1";
	}
	@RequestMapping("quxiaoguanxi_yanben2.do")
	public String quxiaoguanxi_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Quxiaoguanxi quxiaoguanxi, String yonghuming, String xingbie, String dianhua, String shenfenzheng, String xuehao, String xueshengxingming, String xueshengguanxi, String quxiaoyuanyin, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xueshengxingming==null||xueshengxingming.equals("")){pmap.put("xueshengxingming", null);}else{pmap.put("xueshengxingming", xueshengxingming);}		if(xueshengguanxi==null||xueshengguanxi.equals("")){pmap.put("xueshengguanxi", null);}else{pmap.put("xueshengguanxi", xueshengguanxi);}		if(quxiaoyuanyin==null||quxiaoyuanyin.equals("")){pmap.put("quxiaoyuanyin", null);}else{pmap.put("quxiaoyuanyin", quxiaoyuanyin);}		
		int total=quxiaoguanxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Quxiaoguanxi> list=quxiaoguanxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "quxiaoguanxi_yanben2";
	}
	@RequestMapping("quxiaoguanxi_yanben3.do")
	public String quxiaoguanxi_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Quxiaoguanxi quxiaoguanxi, String yonghuming, String xingbie, String dianhua, String shenfenzheng, String xuehao, String xueshengxingming, String xueshengguanxi, String quxiaoyuanyin, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xueshengxingming==null||xueshengxingming.equals("")){pmap.put("xueshengxingming", null);}else{pmap.put("xueshengxingming", xueshengxingming);}		if(xueshengguanxi==null||xueshengguanxi.equals("")){pmap.put("xueshengguanxi", null);}else{pmap.put("xueshengguanxi", xueshengguanxi);}		if(quxiaoyuanyin==null||quxiaoyuanyin.equals("")){pmap.put("quxiaoyuanyin", null);}else{pmap.put("quxiaoyuanyin", quxiaoyuanyin);}		
		int total=quxiaoguanxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Quxiaoguanxi> list=quxiaoguanxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "quxiaoguanxi_yanben3";
	}
	@RequestMapping("quxiaoguanxi_yanben4.do")
	public String quxiaoguanxi_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Quxiaoguanxi quxiaoguanxi, String yonghuming, String xingbie, String dianhua, String shenfenzheng, String xuehao, String xueshengxingming, String xueshengguanxi, String quxiaoyuanyin, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xueshengxingming==null||xueshengxingming.equals("")){pmap.put("xueshengxingming", null);}else{pmap.put("xueshengxingming", xueshengxingming);}		if(xueshengguanxi==null||xueshengguanxi.equals("")){pmap.put("xueshengguanxi", null);}else{pmap.put("xueshengguanxi", xueshengguanxi);}		if(quxiaoyuanyin==null||quxiaoyuanyin.equals("")){pmap.put("quxiaoyuanyin", null);}else{pmap.put("quxiaoyuanyin", quxiaoyuanyin);}		
		int total=quxiaoguanxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Quxiaoguanxi> list=quxiaoguanxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "quxiaoguanxi_yanben4";
	}
	@RequestMapping("quxiaoguanxi_yanben5.do")
	public String quxiaoguanxi_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Quxiaoguanxi quxiaoguanxi, String yonghuming, String xingbie, String dianhua, String shenfenzheng, String xuehao, String xueshengxingming, String xueshengguanxi, String quxiaoyuanyin, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xueshengxingming==null||xueshengxingming.equals("")){pmap.put("xueshengxingming", null);}else{pmap.put("xueshengxingming", xueshengxingming);}		if(xueshengguanxi==null||xueshengguanxi.equals("")){pmap.put("xueshengguanxi", null);}else{pmap.put("xueshengguanxi", xueshengguanxi);}		if(quxiaoyuanyin==null||quxiaoyuanyin.equals("")){pmap.put("quxiaoyuanyin", null);}else{pmap.put("quxiaoyuanyin", quxiaoyuanyin);}		
		int total=quxiaoguanxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Quxiaoguanxi> list=quxiaoguanxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "quxiaoguanxi_yanben5";
	}
	
	@RequestMapping("quxiaoguanxiList2.do")
	public String quxiaoguanxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Quxiaoguanxi quxiaoguanxi, String yonghuming, String xingbie, String dianhua, String shenfenzheng, String xuehao, String xueshengxingming, String xueshengguanxi, String quxiaoyuanyin, String issh,HttpServletRequest request){
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
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xueshengxingming==null||xueshengxingming.equals("")){pmap.put("xueshengxingming", null);}else{pmap.put("xueshengxingming", xueshengxingming);}		if(xueshengguanxi==null||xueshengguanxi.equals("")){pmap.put("xueshengguanxi", null);}else{pmap.put("xueshengguanxi", xueshengguanxi);}		if(quxiaoyuanyin==null||quxiaoyuanyin.equals("")){pmap.put("quxiaoyuanyin", null);}else{pmap.put("quxiaoyuanyin", quxiaoyuanyin);}		
		
		int total=quxiaoguanxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Quxiaoguanxi> list=quxiaoguanxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "quxiaoguanxi_list2";
	}	
	
	@RequestMapping("qxgxList.do")
	public String qxgxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Quxiaoguanxi quxiaoguanxi, String yonghuming, String xingbie, String dianhua, String shenfenzheng, String xuehao, String xueshengxingming, String xueshengguanxi, String quxiaoyuanyin, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xueshengxingming==null||xueshengxingming.equals("")){pmap.put("xueshengxingming", null);}else{pmap.put("xueshengxingming", xueshengxingming);}		if(xueshengguanxi==null||xueshengguanxi.equals("")){pmap.put("xueshengguanxi", null);}else{pmap.put("xueshengguanxi", xueshengguanxi);}		if(quxiaoyuanyin==null||quxiaoyuanyin.equals("")){pmap.put("quxiaoyuanyin", null);}else{pmap.put("quxiaoyuanyin", quxiaoyuanyin);}		
		int total=quxiaoguanxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Quxiaoguanxi> list=quxiaoguanxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "quxiaoguanxilist";
	}
	@RequestMapping("qxgxListtp.do")
	public String qxgxListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Quxiaoguanxi quxiaoguanxi, String yonghuming, String xingbie, String dianhua, String shenfenzheng, String xuehao, String xueshengxingming, String xueshengguanxi, String quxiaoyuanyin, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xueshengxingming==null||xueshengxingming.equals("")){pmap.put("xueshengxingming", null);}else{pmap.put("xueshengxingming", xueshengxingming);}		if(xueshengguanxi==null||xueshengguanxi.equals("")){pmap.put("xueshengguanxi", null);}else{pmap.put("xueshengguanxi", xueshengguanxi);}		if(quxiaoyuanyin==null||quxiaoyuanyin.equals("")){pmap.put("quxiaoyuanyin", null);}else{pmap.put("quxiaoyuanyin", quxiaoyuanyin);}		
		int total=quxiaoguanxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Quxiaoguanxi> list=quxiaoguanxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "quxiaoguanxilisttp";
	}
	
	@RequestMapping("deleteQuxiaoguanxi.do")
	public String deleteQuxiaoguanxi(int id,HttpServletRequest request){
		quxiaoguanxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:quxiaoguanxiList.do";
	}
	
	
}
