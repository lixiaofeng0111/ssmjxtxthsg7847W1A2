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

import com.entity.Xueshengguanxishenqing;
import com.server.XueshengguanxishenqingServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class XueshengguanxishenqingController {
	@Resource
	private XueshengguanxishenqingServer xueshengguanxishenqingService;


   
	@RequestMapping("addXueshengguanxishenqing.do")
	public String addXueshengguanxishenqing(HttpServletRequest request,Xueshengguanxishenqing xueshengguanxishenqing,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		xueshengguanxishenqing.setAddtime(time.toString().substring(0, 19));
		xueshengguanxishenqingService.add(xueshengguanxishenqing);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "xueshengguanxishenqingList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:xueshengguanxishenqingList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateXueshengguanxishenqing.do")
	public String doUpdateXueshengguanxishenqing(int id,ModelMap map,Xueshengguanxishenqing xueshengguanxishenqing){
		xueshengguanxishenqing=xueshengguanxishenqingService.getById(id);
		map.put("xueshengguanxishenqing", xueshengguanxishenqing);
		return "xueshengguanxishenqing_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("xueshengguanxishenqingDetail.do")
	public String xueshengguanxishenqingDetail(int id,ModelMap map,Xueshengguanxishenqing xueshengguanxishenqing){
		xueshengguanxishenqing=xueshengguanxishenqingService.getById(id);
		map.put("xueshengguanxishenqing", xueshengguanxishenqing);
		return "xueshengguanxishenqing_detail";
	}
//	前台详细
	@RequestMapping("xsgxsqDetail.do")
	public String xsgxsqDetail(int id,ModelMap map,Xueshengguanxishenqing xueshengguanxishenqing){
		xueshengguanxishenqing=xueshengguanxishenqingService.getById(id);
		map.put("xueshengguanxishenqing", xueshengguanxishenqing);
		return "xueshengguanxishenqingdetail";
	}
//	
	@RequestMapping("updateXueshengguanxishenqing.do")
	public String updateXueshengguanxishenqing(int id,ModelMap map,Xueshengguanxishenqing xueshengguanxishenqing,HttpServletRequest request,HttpSession session){
		xueshengguanxishenqingService.update(xueshengguanxishenqing);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:xueshengguanxishenqingList.do";
	}

//	分页查询
	@RequestMapping("xueshengguanxishenqingList.do")
	public String xueshengguanxishenqingList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xueshengguanxishenqing xueshengguanxishenqing, String yonghuming, String xingming, String xingbie, String dianhua, String shenfenzheng, String xuehao, String xueshengxingming, String xueshengguanxi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xueshengxingming==null||xueshengxingming.equals("")){pmap.put("xueshengxingming", null);}else{pmap.put("xueshengxingming", xueshengxingming);}
		if(xueshengguanxi==null||xueshengguanxi.equals("")){pmap.put("xueshengguanxi", null);}else{pmap.put("xueshengguanxi", xueshengguanxi);}
		
		int total=xueshengguanxishenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xueshengguanxishenqing> list=xueshengguanxishenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xueshengguanxishenqing_list";
	}
	
	@RequestMapping("xueshengguanxishenqing_yanben1.do")
	public String xueshengguanxishenqing_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xueshengguanxishenqing xueshengguanxishenqing, String yonghuming, String xingming, String xingbie, String dianhua, String shenfenzheng, String xuehao, String xueshengxingming, String xueshengguanxi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xueshengxingming==null||xueshengxingming.equals("")){pmap.put("xueshengxingming", null);}else{pmap.put("xueshengxingming", xueshengxingming);}
		if(xueshengguanxi==null||xueshengguanxi.equals("")){pmap.put("xueshengguanxi", null);}else{pmap.put("xueshengguanxi", xueshengguanxi);}
		
		int total=xueshengguanxishenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xueshengguanxishenqing> list=xueshengguanxishenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xueshengguanxishenqing_yanben1";
	}
	@RequestMapping("xueshengguanxishenqing_yanben2.do")
	public String xueshengguanxishenqing_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xueshengguanxishenqing xueshengguanxishenqing, String yonghuming, String xingming, String xingbie, String dianhua, String shenfenzheng, String xuehao, String xueshengxingming, String xueshengguanxi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xueshengxingming==null||xueshengxingming.equals("")){pmap.put("xueshengxingming", null);}else{pmap.put("xueshengxingming", xueshengxingming);}
		if(xueshengguanxi==null||xueshengguanxi.equals("")){pmap.put("xueshengguanxi", null);}else{pmap.put("xueshengguanxi", xueshengguanxi);}
		
		int total=xueshengguanxishenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xueshengguanxishenqing> list=xueshengguanxishenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xueshengguanxishenqing_yanben2";
	}
	@RequestMapping("xueshengguanxishenqing_yanben3.do")
	public String xueshengguanxishenqing_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xueshengguanxishenqing xueshengguanxishenqing, String yonghuming, String xingming, String xingbie, String dianhua, String shenfenzheng, String xuehao, String xueshengxingming, String xueshengguanxi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xueshengxingming==null||xueshengxingming.equals("")){pmap.put("xueshengxingming", null);}else{pmap.put("xueshengxingming", xueshengxingming);}
		if(xueshengguanxi==null||xueshengguanxi.equals("")){pmap.put("xueshengguanxi", null);}else{pmap.put("xueshengguanxi", xueshengguanxi);}
		
		int total=xueshengguanxishenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xueshengguanxishenqing> list=xueshengguanxishenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xueshengguanxishenqing_yanben3";
	}
	@RequestMapping("xueshengguanxishenqing_yanben4.do")
	public String xueshengguanxishenqing_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xueshengguanxishenqing xueshengguanxishenqing, String yonghuming, String xingming, String xingbie, String dianhua, String shenfenzheng, String xuehao, String xueshengxingming, String xueshengguanxi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xueshengxingming==null||xueshengxingming.equals("")){pmap.put("xueshengxingming", null);}else{pmap.put("xueshengxingming", xueshengxingming);}
		if(xueshengguanxi==null||xueshengguanxi.equals("")){pmap.put("xueshengguanxi", null);}else{pmap.put("xueshengguanxi", xueshengguanxi);}
		
		int total=xueshengguanxishenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xueshengguanxishenqing> list=xueshengguanxishenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xueshengguanxishenqing_yanben4";
	}
	@RequestMapping("xueshengguanxishenqing_yanben5.do")
	public String xueshengguanxishenqing_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xueshengguanxishenqing xueshengguanxishenqing, String yonghuming, String xingming, String xingbie, String dianhua, String shenfenzheng, String xuehao, String xueshengxingming, String xueshengguanxi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xueshengxingming==null||xueshengxingming.equals("")){pmap.put("xueshengxingming", null);}else{pmap.put("xueshengxingming", xueshengxingming);}
		if(xueshengguanxi==null||xueshengguanxi.equals("")){pmap.put("xueshengguanxi", null);}else{pmap.put("xueshengguanxi", xueshengguanxi);}
		
		int total=xueshengguanxishenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xueshengguanxishenqing> list=xueshengguanxishenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xueshengguanxishenqing_yanben5";
	}
	
	@RequestMapping("xueshengguanxishenqingList2.do")
	public String xueshengguanxishenqingList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xueshengguanxishenqing xueshengguanxishenqing, String yonghuming, String xingming, String xingbie, String dianhua, String shenfenzheng, String xuehao, String xueshengxingming, String xueshengguanxi, String issh,HttpServletRequest request){
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
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xueshengxingming==null||xueshengxingming.equals("")){pmap.put("xueshengxingming", null);}else{pmap.put("xueshengxingming", xueshengxingming);}
		if(xueshengguanxi==null||xueshengguanxi.equals("")){pmap.put("xueshengguanxi", null);}else{pmap.put("xueshengguanxi", xueshengguanxi);}
		
		
		int total=xueshengguanxishenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xueshengguanxishenqing> list=xueshengguanxishenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xueshengguanxishenqing_list2";
	}
	@RequestMapping("xueshengguanxishenqingList3.do")
	public String xueshengguanxishenqingList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xueshengguanxishenqing xueshengguanxishenqing, String yonghuming, String xingming, String xingbie, String dianhua, String shenfenzheng, String xuehao, String xueshengxingming, String xueshengguanxi, String issh,HttpServletRequest request){
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
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xueshengxingming==null||xueshengxingming.equals("")){pmap.put("xueshengxingming", null);}else{pmap.put("xueshengxingming", xueshengxingming);}
		if(xueshengguanxi==null||xueshengguanxi.equals("")){pmap.put("xueshengguanxi", null);}else{pmap.put("xueshengguanxi", xueshengguanxi);}
		
		
		int total=xueshengguanxishenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xueshengguanxishenqing> list=xueshengguanxishenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xueshengguanxishenqing_list3";
	}
	
	@RequestMapping("xsgxsqList.do")
	public String xsgxsqList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xueshengguanxishenqing xueshengguanxishenqing, String yonghuming, String xingming, String xingbie, String dianhua, String shenfenzheng, String xuehao, String xueshengxingming, String xueshengguanxi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xueshengxingming==null||xueshengxingming.equals("")){pmap.put("xueshengxingming", null);}else{pmap.put("xueshengxingming", xueshengxingming);}
		if(xueshengguanxi==null||xueshengguanxi.equals("")){pmap.put("xueshengguanxi", null);}else{pmap.put("xueshengguanxi", xueshengguanxi);}
		
		int total=xueshengguanxishenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xueshengguanxishenqing> list=xueshengguanxishenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xueshengguanxishenqinglist";
	}
	@RequestMapping("xsgxsqListtp.do")
	public String xsgxsqListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xueshengguanxishenqing xueshengguanxishenqing, String yonghuming, String xingming, String xingbie, String dianhua, String shenfenzheng, String xuehao, String xueshengxingming, String xueshengguanxi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xueshengxingming==null||xueshengxingming.equals("")){pmap.put("xueshengxingming", null);}else{pmap.put("xueshengxingming", xueshengxingming);}
		if(xueshengguanxi==null||xueshengguanxi.equals("")){pmap.put("xueshengguanxi", null);}else{pmap.put("xueshengguanxi", xueshengguanxi);}
		
		int total=xueshengguanxishenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xueshengguanxishenqing> list=xueshengguanxishenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xueshengguanxishenqinglisttp";
	}
	
	@RequestMapping("deleteXueshengguanxishenqing.do")
	public String deleteXueshengguanxishenqing(int id,HttpServletRequest request){
		xueshengguanxishenqingService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:xueshengguanxishenqingList.do";
	}
	
	
}
