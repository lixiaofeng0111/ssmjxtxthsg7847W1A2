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

import com.entity.Xuejixinxi;
import com.server.XuejixinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class XuejixinxiController {
	@Resource
	private XuejixinxiServer xuejixinxiService;


   
	@RequestMapping("addXuejixinxi.do")
	public String addXuejixinxi(HttpServletRequest request,Xuejixinxi xuejixinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		xuejixinxi.setAddtime(time.toString().substring(0, 19));
		xuejixinxiService.add(xuejixinxi);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "xuejixinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:xuejixinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateXuejixinxi.do")
	public String doUpdateXuejixinxi(int id,ModelMap map,Xuejixinxi xuejixinxi){
		xuejixinxi=xuejixinxiService.getById(id);
		map.put("xuejixinxi", xuejixinxi);
		return "xuejixinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("xuejixinxiDetail.do")
	public String xuejixinxiDetail(int id,ModelMap map,Xuejixinxi xuejixinxi){
		xuejixinxi=xuejixinxiService.getById(id);
		map.put("xuejixinxi", xuejixinxi);
		return "xuejixinxi_detail";
	}
//	前台详细
	@RequestMapping("xjxxDetail.do")
	public String xjxxDetail(int id,ModelMap map,Xuejixinxi xuejixinxi){
		xuejixinxi=xuejixinxiService.getById(id);
		map.put("xuejixinxi", xuejixinxi);
		return "xuejixinxidetail";
	}
//	
	@RequestMapping("updateXuejixinxi.do")
	public String updateXuejixinxi(int id,ModelMap map,Xuejixinxi xuejixinxi,HttpServletRequest request,HttpSession session){
		xuejixinxiService.update(xuejixinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:xuejixinxiList.do";
	}

//	分页查询
	@RequestMapping("xuejixinxiList.do")
	public String xuejixinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xuejixinxi xuejixinxi, String xuehao, String xingming, String xingbie, String zhaopian, String minzu, String jiguan, String shenfenzheng, String ruxueshijian1,String ruxueshijian2, String zhuanye, String yuanxiao, String cengci, String xuejizhuangtai, String beizhu, String gonghao){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}		if(minzu==null||minzu.equals("")){pmap.put("minzu", null);}else{pmap.put("minzu", minzu);}		if(jiguan==null||jiguan.equals("")){pmap.put("jiguan", null);}else{pmap.put("jiguan", jiguan);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(ruxueshijian1==null||ruxueshijian1.equals("")){pmap.put("ruxueshijian1", null);}else{pmap.put("ruxueshijian1", ruxueshijian1);}		if(ruxueshijian2==null||ruxueshijian2.equals("")){pmap.put("ruxueshijian2", null);}else{pmap.put("ruxueshijian2", ruxueshijian2);}		if(zhuanye==null||zhuanye.equals("")){pmap.put("zhuanye", null);}else{pmap.put("zhuanye", zhuanye);}		if(yuanxiao==null||yuanxiao.equals("")){pmap.put("yuanxiao", null);}else{pmap.put("yuanxiao", yuanxiao);}		if(cengci==null||cengci.equals("")){pmap.put("cengci", null);}else{pmap.put("cengci", cengci);}		if(xuejizhuangtai==null||xuejizhuangtai.equals("")){pmap.put("xuejizhuangtai", null);}else{pmap.put("xuejizhuangtai", xuejizhuangtai);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		
		int total=xuejixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xuejixinxi> list=xuejixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xuejixinxi_list";
	}
	
	@RequestMapping("xuejixinxi_yanben1.do")
	public String xuejixinxi_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xuejixinxi xuejixinxi, String xuehao, String xingming, String xingbie, String zhaopian, String minzu, String jiguan, String shenfenzheng, String ruxueshijian1,String ruxueshijian2, String zhuanye, String yuanxiao, String cengci, String xuejizhuangtai, String beizhu, String gonghao){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}		if(minzu==null||minzu.equals("")){pmap.put("minzu", null);}else{pmap.put("minzu", minzu);}		if(jiguan==null||jiguan.equals("")){pmap.put("jiguan", null);}else{pmap.put("jiguan", jiguan);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(ruxueshijian1==null||ruxueshijian1.equals("")){pmap.put("ruxueshijian1", null);}else{pmap.put("ruxueshijian1", ruxueshijian1);}		if(ruxueshijian2==null||ruxueshijian2.equals("")){pmap.put("ruxueshijian2", null);}else{pmap.put("ruxueshijian2", ruxueshijian2);}		if(zhuanye==null||zhuanye.equals("")){pmap.put("zhuanye", null);}else{pmap.put("zhuanye", zhuanye);}		if(yuanxiao==null||yuanxiao.equals("")){pmap.put("yuanxiao", null);}else{pmap.put("yuanxiao", yuanxiao);}		if(cengci==null||cengci.equals("")){pmap.put("cengci", null);}else{pmap.put("cengci", cengci);}		if(xuejizhuangtai==null||xuejizhuangtai.equals("")){pmap.put("xuejizhuangtai", null);}else{pmap.put("xuejizhuangtai", xuejizhuangtai);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		
		int total=xuejixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xuejixinxi> list=xuejixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xuejixinxi_yanben1";
	}
	@RequestMapping("xuejixinxi_yanben2.do")
	public String xuejixinxi_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xuejixinxi xuejixinxi, String xuehao, String xingming, String xingbie, String zhaopian, String minzu, String jiguan, String shenfenzheng, String ruxueshijian1,String ruxueshijian2, String zhuanye, String yuanxiao, String cengci, String xuejizhuangtai, String beizhu, String gonghao){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}		if(minzu==null||minzu.equals("")){pmap.put("minzu", null);}else{pmap.put("minzu", minzu);}		if(jiguan==null||jiguan.equals("")){pmap.put("jiguan", null);}else{pmap.put("jiguan", jiguan);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(ruxueshijian1==null||ruxueshijian1.equals("")){pmap.put("ruxueshijian1", null);}else{pmap.put("ruxueshijian1", ruxueshijian1);}		if(ruxueshijian2==null||ruxueshijian2.equals("")){pmap.put("ruxueshijian2", null);}else{pmap.put("ruxueshijian2", ruxueshijian2);}		if(zhuanye==null||zhuanye.equals("")){pmap.put("zhuanye", null);}else{pmap.put("zhuanye", zhuanye);}		if(yuanxiao==null||yuanxiao.equals("")){pmap.put("yuanxiao", null);}else{pmap.put("yuanxiao", yuanxiao);}		if(cengci==null||cengci.equals("")){pmap.put("cengci", null);}else{pmap.put("cengci", cengci);}		if(xuejizhuangtai==null||xuejizhuangtai.equals("")){pmap.put("xuejizhuangtai", null);}else{pmap.put("xuejizhuangtai", xuejizhuangtai);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		
		int total=xuejixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xuejixinxi> list=xuejixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xuejixinxi_yanben2";
	}
	@RequestMapping("xuejixinxi_yanben3.do")
	public String xuejixinxi_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xuejixinxi xuejixinxi, String xuehao, String xingming, String xingbie, String zhaopian, String minzu, String jiguan, String shenfenzheng, String ruxueshijian1,String ruxueshijian2, String zhuanye, String yuanxiao, String cengci, String xuejizhuangtai, String beizhu, String gonghao){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}		if(minzu==null||minzu.equals("")){pmap.put("minzu", null);}else{pmap.put("minzu", minzu);}		if(jiguan==null||jiguan.equals("")){pmap.put("jiguan", null);}else{pmap.put("jiguan", jiguan);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(ruxueshijian1==null||ruxueshijian1.equals("")){pmap.put("ruxueshijian1", null);}else{pmap.put("ruxueshijian1", ruxueshijian1);}		if(ruxueshijian2==null||ruxueshijian2.equals("")){pmap.put("ruxueshijian2", null);}else{pmap.put("ruxueshijian2", ruxueshijian2);}		if(zhuanye==null||zhuanye.equals("")){pmap.put("zhuanye", null);}else{pmap.put("zhuanye", zhuanye);}		if(yuanxiao==null||yuanxiao.equals("")){pmap.put("yuanxiao", null);}else{pmap.put("yuanxiao", yuanxiao);}		if(cengci==null||cengci.equals("")){pmap.put("cengci", null);}else{pmap.put("cengci", cengci);}		if(xuejizhuangtai==null||xuejizhuangtai.equals("")){pmap.put("xuejizhuangtai", null);}else{pmap.put("xuejizhuangtai", xuejizhuangtai);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		
		int total=xuejixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xuejixinxi> list=xuejixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xuejixinxi_yanben3";
	}
	@RequestMapping("xuejixinxi_yanben4.do")
	public String xuejixinxi_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xuejixinxi xuejixinxi, String xuehao, String xingming, String xingbie, String zhaopian, String minzu, String jiguan, String shenfenzheng, String ruxueshijian1,String ruxueshijian2, String zhuanye, String yuanxiao, String cengci, String xuejizhuangtai, String beizhu, String gonghao){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}		if(minzu==null||minzu.equals("")){pmap.put("minzu", null);}else{pmap.put("minzu", minzu);}		if(jiguan==null||jiguan.equals("")){pmap.put("jiguan", null);}else{pmap.put("jiguan", jiguan);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(ruxueshijian1==null||ruxueshijian1.equals("")){pmap.put("ruxueshijian1", null);}else{pmap.put("ruxueshijian1", ruxueshijian1);}		if(ruxueshijian2==null||ruxueshijian2.equals("")){pmap.put("ruxueshijian2", null);}else{pmap.put("ruxueshijian2", ruxueshijian2);}		if(zhuanye==null||zhuanye.equals("")){pmap.put("zhuanye", null);}else{pmap.put("zhuanye", zhuanye);}		if(yuanxiao==null||yuanxiao.equals("")){pmap.put("yuanxiao", null);}else{pmap.put("yuanxiao", yuanxiao);}		if(cengci==null||cengci.equals("")){pmap.put("cengci", null);}else{pmap.put("cengci", cengci);}		if(xuejizhuangtai==null||xuejizhuangtai.equals("")){pmap.put("xuejizhuangtai", null);}else{pmap.put("xuejizhuangtai", xuejizhuangtai);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		
		int total=xuejixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xuejixinxi> list=xuejixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xuejixinxi_yanben4";
	}
	@RequestMapping("xuejixinxi_yanben5.do")
	public String xuejixinxi_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xuejixinxi xuejixinxi, String xuehao, String xingming, String xingbie, String zhaopian, String minzu, String jiguan, String shenfenzheng, String ruxueshijian1,String ruxueshijian2, String zhuanye, String yuanxiao, String cengci, String xuejizhuangtai, String beizhu, String gonghao){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}		if(minzu==null||minzu.equals("")){pmap.put("minzu", null);}else{pmap.put("minzu", minzu);}		if(jiguan==null||jiguan.equals("")){pmap.put("jiguan", null);}else{pmap.put("jiguan", jiguan);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(ruxueshijian1==null||ruxueshijian1.equals("")){pmap.put("ruxueshijian1", null);}else{pmap.put("ruxueshijian1", ruxueshijian1);}		if(ruxueshijian2==null||ruxueshijian2.equals("")){pmap.put("ruxueshijian2", null);}else{pmap.put("ruxueshijian2", ruxueshijian2);}		if(zhuanye==null||zhuanye.equals("")){pmap.put("zhuanye", null);}else{pmap.put("zhuanye", zhuanye);}		if(yuanxiao==null||yuanxiao.equals("")){pmap.put("yuanxiao", null);}else{pmap.put("yuanxiao", yuanxiao);}		if(cengci==null||cengci.equals("")){pmap.put("cengci", null);}else{pmap.put("cengci", cengci);}		if(xuejizhuangtai==null||xuejizhuangtai.equals("")){pmap.put("xuejizhuangtai", null);}else{pmap.put("xuejizhuangtai", xuejizhuangtai);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		
		int total=xuejixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xuejixinxi> list=xuejixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xuejixinxi_yanben5";
	}
	
	@RequestMapping("xuejixinxiList2.do")
	public String xuejixinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xuejixinxi xuejixinxi, String xuehao, String xingming, String xingbie, String zhaopian, String minzu, String jiguan, String shenfenzheng, String ruxueshijian1,String ruxueshijian2, String zhuanye, String yuanxiao, String cengci, String xuejizhuangtai, String beizhu, String gonghao,HttpServletRequest request){
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
		
		pmap.put("gonghao", (String)request.getSession().getAttribute("username"));
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}		if(minzu==null||minzu.equals("")){pmap.put("minzu", null);}else{pmap.put("minzu", minzu);}		if(jiguan==null||jiguan.equals("")){pmap.put("jiguan", null);}else{pmap.put("jiguan", jiguan);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(ruxueshijian1==null||ruxueshijian1.equals("")){pmap.put("ruxueshijian1", null);}else{pmap.put("ruxueshijian1", ruxueshijian1);}		if(ruxueshijian2==null||ruxueshijian2.equals("")){pmap.put("ruxueshijian2", null);}else{pmap.put("ruxueshijian2", ruxueshijian2);}		if(zhuanye==null||zhuanye.equals("")){pmap.put("zhuanye", null);}else{pmap.put("zhuanye", zhuanye);}		if(yuanxiao==null||yuanxiao.equals("")){pmap.put("yuanxiao", null);}else{pmap.put("yuanxiao", yuanxiao);}		if(cengci==null||cengci.equals("")){pmap.put("cengci", null);}else{pmap.put("cengci", cengci);}		if(xuejizhuangtai==null||xuejizhuangtai.equals("")){pmap.put("xuejizhuangtai", null);}else{pmap.put("xuejizhuangtai", xuejizhuangtai);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		
		int total=xuejixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xuejixinxi> list=xuejixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xuejixinxi_list2";
	}	
	
	@RequestMapping("xjxxList.do")
	public String xjxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xuejixinxi xuejixinxi, String xuehao, String xingming, String xingbie, String zhaopian, String minzu, String jiguan, String shenfenzheng, String ruxueshijian1,String ruxueshijian2, String zhuanye, String yuanxiao, String cengci, String xuejizhuangtai, String beizhu, String gonghao){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}		if(minzu==null||minzu.equals("")){pmap.put("minzu", null);}else{pmap.put("minzu", minzu);}		if(jiguan==null||jiguan.equals("")){pmap.put("jiguan", null);}else{pmap.put("jiguan", jiguan);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(ruxueshijian1==null||ruxueshijian1.equals("")){pmap.put("ruxueshijian1", null);}else{pmap.put("ruxueshijian1", ruxueshijian1);}		if(ruxueshijian2==null||ruxueshijian2.equals("")){pmap.put("ruxueshijian2", null);}else{pmap.put("ruxueshijian2", ruxueshijian2);}		if(zhuanye==null||zhuanye.equals("")){pmap.put("zhuanye", null);}else{pmap.put("zhuanye", zhuanye);}		if(yuanxiao==null||yuanxiao.equals("")){pmap.put("yuanxiao", null);}else{pmap.put("yuanxiao", yuanxiao);}		if(cengci==null||cengci.equals("")){pmap.put("cengci", null);}else{pmap.put("cengci", cengci);}		if(xuejizhuangtai==null||xuejizhuangtai.equals("")){pmap.put("xuejizhuangtai", null);}else{pmap.put("xuejizhuangtai", xuejizhuangtai);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		
		int total=xuejixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xuejixinxi> list=xuejixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xuejixinxilist";
	}
	@RequestMapping("xjxxListtp.do")
	public String xjxxListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xuejixinxi xuejixinxi, String xuehao, String xingming, String xingbie, String zhaopian, String minzu, String jiguan, String shenfenzheng, String ruxueshijian1,String ruxueshijian2, String zhuanye, String yuanxiao, String cengci, String xuejizhuangtai, String beizhu, String gonghao){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}		if(minzu==null||minzu.equals("")){pmap.put("minzu", null);}else{pmap.put("minzu", minzu);}		if(jiguan==null||jiguan.equals("")){pmap.put("jiguan", null);}else{pmap.put("jiguan", jiguan);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(ruxueshijian1==null||ruxueshijian1.equals("")){pmap.put("ruxueshijian1", null);}else{pmap.put("ruxueshijian1", ruxueshijian1);}		if(ruxueshijian2==null||ruxueshijian2.equals("")){pmap.put("ruxueshijian2", null);}else{pmap.put("ruxueshijian2", ruxueshijian2);}		if(zhuanye==null||zhuanye.equals("")){pmap.put("zhuanye", null);}else{pmap.put("zhuanye", zhuanye);}		if(yuanxiao==null||yuanxiao.equals("")){pmap.put("yuanxiao", null);}else{pmap.put("yuanxiao", yuanxiao);}		if(cengci==null||cengci.equals("")){pmap.put("cengci", null);}else{pmap.put("cengci", cengci);}		if(xuejizhuangtai==null||xuejizhuangtai.equals("")){pmap.put("xuejizhuangtai", null);}else{pmap.put("xuejizhuangtai", xuejizhuangtai);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		
		int total=xuejixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xuejixinxi> list=xuejixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xuejixinxilisttp";
	}
	
	@RequestMapping("deleteXuejixinxi.do")
	public String deleteXuejixinxi(int id,HttpServletRequest request){
		xuejixinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:xuejixinxiList.do";
	}
	
	
}
