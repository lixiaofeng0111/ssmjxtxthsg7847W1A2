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

import com.entity.Zuoye;
import com.server.ZuoyeServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ZuoyeController {
	@Resource
	private ZuoyeServer zuoyeService;


   
	@RequestMapping("addZuoye.do")
	public String addZuoye(HttpServletRequest request,Zuoye zuoye,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		zuoye.setAddtime(time.toString().substring(0, 19));
		zuoyeService.add(zuoye);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		return "redirect:postback.jsp";
	}
 
//	处理编辑
	@RequestMapping("doUpdateZuoye.do")
	public String doUpdateZuoye(int id,ModelMap map,Zuoye zuoye){
		zuoye=zuoyeService.getById(id);
		map.put("zuoye", zuoye);
		return "zuoye_updt";
	}
	
	
//	后台详细
	@RequestMapping("zuoyeDetail.do")
	public String zuoyeDetail(int id,ModelMap map,Zuoye zuoye){
		zuoye=zuoyeService.getById(id);
		map.put("zuoye", zuoye);
		return "zuoye_detail";
	}
//	前台详细
	@RequestMapping("zyDetail.do")
	public String zyDetail(int id,ModelMap map,Zuoye zuoye){
		zuoye=zuoyeService.getById(id);
		map.put("zuoye", zuoye);
		return "zuoyedetail";
	}
//	
	@RequestMapping("updateZuoye.do")
	public String updateZuoye(int id,ModelMap map,Zuoye zuoye,HttpServletRequest request,HttpSession session){
		zuoyeService.update(zuoye);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
	}

//	分页查询
	@RequestMapping("zuoyeList.do")
	public String zuoyeList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zuoye zuoye, String zuoyebianhao, String zuoyemingcheng, String zuoyeleixing, String neirong, String fujian, String yaoqiushijian1,String yaoqiushijian2, String kecheng, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zuoyebianhao==null||zuoyebianhao.equals("")){pmap.put("zuoyebianhao", null);}else{pmap.put("zuoyebianhao", zuoyebianhao);}		if(zuoyemingcheng==null||zuoyemingcheng.equals("")){pmap.put("zuoyemingcheng", null);}else{pmap.put("zuoyemingcheng", zuoyemingcheng);}		if(zuoyeleixing==null||zuoyeleixing.equals("")){pmap.put("zuoyeleixing", null);}else{pmap.put("zuoyeleixing", zuoyeleixing);}		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}		if(fujian==null||fujian.equals("")){pmap.put("fujian", null);}else{pmap.put("fujian", fujian);}		if(yaoqiushijian1==null||yaoqiushijian1.equals("")){pmap.put("yaoqiushijian1", null);}else{pmap.put("yaoqiushijian1", yaoqiushijian1);}		if(yaoqiushijian2==null||yaoqiushijian2.equals("")){pmap.put("yaoqiushijian2", null);}else{pmap.put("yaoqiushijian2", yaoqiushijian2);}		if(kecheng==null||kecheng.equals("")){pmap.put("kecheng", null);}else{pmap.put("kecheng", kecheng);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=zuoyeService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zuoye> list=zuoyeService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zuoye_list";
	}
	
	@RequestMapping("zuoye_yanben1.do")
	public String zuoye_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zuoye zuoye, String zuoyebianhao, String zuoyemingcheng, String zuoyeleixing, String neirong, String fujian, String yaoqiushijian1,String yaoqiushijian2, String kecheng, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zuoyebianhao==null||zuoyebianhao.equals("")){pmap.put("zuoyebianhao", null);}else{pmap.put("zuoyebianhao", zuoyebianhao);}		if(zuoyemingcheng==null||zuoyemingcheng.equals("")){pmap.put("zuoyemingcheng", null);}else{pmap.put("zuoyemingcheng", zuoyemingcheng);}		if(zuoyeleixing==null||zuoyeleixing.equals("")){pmap.put("zuoyeleixing", null);}else{pmap.put("zuoyeleixing", zuoyeleixing);}		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}		if(fujian==null||fujian.equals("")){pmap.put("fujian", null);}else{pmap.put("fujian", fujian);}		if(yaoqiushijian1==null||yaoqiushijian1.equals("")){pmap.put("yaoqiushijian1", null);}else{pmap.put("yaoqiushijian1", yaoqiushijian1);}		if(yaoqiushijian2==null||yaoqiushijian2.equals("")){pmap.put("yaoqiushijian2", null);}else{pmap.put("yaoqiushijian2", yaoqiushijian2);}		if(kecheng==null||kecheng.equals("")){pmap.put("kecheng", null);}else{pmap.put("kecheng", kecheng);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=zuoyeService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zuoye> list=zuoyeService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zuoye_yanben1";
	}
	@RequestMapping("zuoye_yanben2.do")
	public String zuoye_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zuoye zuoye, String zuoyebianhao, String zuoyemingcheng, String zuoyeleixing, String neirong, String fujian, String yaoqiushijian1,String yaoqiushijian2, String kecheng, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zuoyebianhao==null||zuoyebianhao.equals("")){pmap.put("zuoyebianhao", null);}else{pmap.put("zuoyebianhao", zuoyebianhao);}		if(zuoyemingcheng==null||zuoyemingcheng.equals("")){pmap.put("zuoyemingcheng", null);}else{pmap.put("zuoyemingcheng", zuoyemingcheng);}		if(zuoyeleixing==null||zuoyeleixing.equals("")){pmap.put("zuoyeleixing", null);}else{pmap.put("zuoyeleixing", zuoyeleixing);}		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}		if(fujian==null||fujian.equals("")){pmap.put("fujian", null);}else{pmap.put("fujian", fujian);}		if(yaoqiushijian1==null||yaoqiushijian1.equals("")){pmap.put("yaoqiushijian1", null);}else{pmap.put("yaoqiushijian1", yaoqiushijian1);}		if(yaoqiushijian2==null||yaoqiushijian2.equals("")){pmap.put("yaoqiushijian2", null);}else{pmap.put("yaoqiushijian2", yaoqiushijian2);}		if(kecheng==null||kecheng.equals("")){pmap.put("kecheng", null);}else{pmap.put("kecheng", kecheng);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=zuoyeService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zuoye> list=zuoyeService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zuoye_yanben2";
	}
	@RequestMapping("zuoye_yanben3.do")
	public String zuoye_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zuoye zuoye, String zuoyebianhao, String zuoyemingcheng, String zuoyeleixing, String neirong, String fujian, String yaoqiushijian1,String yaoqiushijian2, String kecheng, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zuoyebianhao==null||zuoyebianhao.equals("")){pmap.put("zuoyebianhao", null);}else{pmap.put("zuoyebianhao", zuoyebianhao);}		if(zuoyemingcheng==null||zuoyemingcheng.equals("")){pmap.put("zuoyemingcheng", null);}else{pmap.put("zuoyemingcheng", zuoyemingcheng);}		if(zuoyeleixing==null||zuoyeleixing.equals("")){pmap.put("zuoyeleixing", null);}else{pmap.put("zuoyeleixing", zuoyeleixing);}		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}		if(fujian==null||fujian.equals("")){pmap.put("fujian", null);}else{pmap.put("fujian", fujian);}		if(yaoqiushijian1==null||yaoqiushijian1.equals("")){pmap.put("yaoqiushijian1", null);}else{pmap.put("yaoqiushijian1", yaoqiushijian1);}		if(yaoqiushijian2==null||yaoqiushijian2.equals("")){pmap.put("yaoqiushijian2", null);}else{pmap.put("yaoqiushijian2", yaoqiushijian2);}		if(kecheng==null||kecheng.equals("")){pmap.put("kecheng", null);}else{pmap.put("kecheng", kecheng);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=zuoyeService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zuoye> list=zuoyeService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zuoye_yanben3";
	}
	@RequestMapping("zuoye_yanben4.do")
	public String zuoye_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zuoye zuoye, String zuoyebianhao, String zuoyemingcheng, String zuoyeleixing, String neirong, String fujian, String yaoqiushijian1,String yaoqiushijian2, String kecheng, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zuoyebianhao==null||zuoyebianhao.equals("")){pmap.put("zuoyebianhao", null);}else{pmap.put("zuoyebianhao", zuoyebianhao);}		if(zuoyemingcheng==null||zuoyemingcheng.equals("")){pmap.put("zuoyemingcheng", null);}else{pmap.put("zuoyemingcheng", zuoyemingcheng);}		if(zuoyeleixing==null||zuoyeleixing.equals("")){pmap.put("zuoyeleixing", null);}else{pmap.put("zuoyeleixing", zuoyeleixing);}		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}		if(fujian==null||fujian.equals("")){pmap.put("fujian", null);}else{pmap.put("fujian", fujian);}		if(yaoqiushijian1==null||yaoqiushijian1.equals("")){pmap.put("yaoqiushijian1", null);}else{pmap.put("yaoqiushijian1", yaoqiushijian1);}		if(yaoqiushijian2==null||yaoqiushijian2.equals("")){pmap.put("yaoqiushijian2", null);}else{pmap.put("yaoqiushijian2", yaoqiushijian2);}		if(kecheng==null||kecheng.equals("")){pmap.put("kecheng", null);}else{pmap.put("kecheng", kecheng);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=zuoyeService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zuoye> list=zuoyeService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zuoye_yanben4";
	}
	@RequestMapping("zuoye_yanben5.do")
	public String zuoye_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zuoye zuoye, String zuoyebianhao, String zuoyemingcheng, String zuoyeleixing, String neirong, String fujian, String yaoqiushijian1,String yaoqiushijian2, String kecheng, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zuoyebianhao==null||zuoyebianhao.equals("")){pmap.put("zuoyebianhao", null);}else{pmap.put("zuoyebianhao", zuoyebianhao);}		if(zuoyemingcheng==null||zuoyemingcheng.equals("")){pmap.put("zuoyemingcheng", null);}else{pmap.put("zuoyemingcheng", zuoyemingcheng);}		if(zuoyeleixing==null||zuoyeleixing.equals("")){pmap.put("zuoyeleixing", null);}else{pmap.put("zuoyeleixing", zuoyeleixing);}		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}		if(fujian==null||fujian.equals("")){pmap.put("fujian", null);}else{pmap.put("fujian", fujian);}		if(yaoqiushijian1==null||yaoqiushijian1.equals("")){pmap.put("yaoqiushijian1", null);}else{pmap.put("yaoqiushijian1", yaoqiushijian1);}		if(yaoqiushijian2==null||yaoqiushijian2.equals("")){pmap.put("yaoqiushijian2", null);}else{pmap.put("yaoqiushijian2", yaoqiushijian2);}		if(kecheng==null||kecheng.equals("")){pmap.put("kecheng", null);}else{pmap.put("kecheng", kecheng);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=zuoyeService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zuoye> list=zuoyeService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zuoye_yanben5";
	}
	
	@RequestMapping("zuoyeList2.do")
	public String zuoyeList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zuoye zuoye, String zuoyebianhao, String zuoyemingcheng, String zuoyeleixing, String neirong, String fujian, String yaoqiushijian1,String yaoqiushijian2, String kecheng, String faburen,HttpServletRequest request){
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
		if(zuoyebianhao==null||zuoyebianhao.equals("")){pmap.put("zuoyebianhao", null);}else{pmap.put("zuoyebianhao", zuoyebianhao);}		if(zuoyemingcheng==null||zuoyemingcheng.equals("")){pmap.put("zuoyemingcheng", null);}else{pmap.put("zuoyemingcheng", zuoyemingcheng);}		if(zuoyeleixing==null||zuoyeleixing.equals("")){pmap.put("zuoyeleixing", null);}else{pmap.put("zuoyeleixing", zuoyeleixing);}		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}		if(fujian==null||fujian.equals("")){pmap.put("fujian", null);}else{pmap.put("fujian", fujian);}		if(yaoqiushijian1==null||yaoqiushijian1.equals("")){pmap.put("yaoqiushijian1", null);}else{pmap.put("yaoqiushijian1", yaoqiushijian1);}		if(yaoqiushijian2==null||yaoqiushijian2.equals("")){pmap.put("yaoqiushijian2", null);}else{pmap.put("yaoqiushijian2", yaoqiushijian2);}		if(kecheng==null||kecheng.equals("")){pmap.put("kecheng", null);}else{pmap.put("kecheng", kecheng);}		
		
		int total=zuoyeService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zuoye> list=zuoyeService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zuoye_list2";
	}	
	
	@RequestMapping("zyList.do")
	public String zyList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zuoye zuoye, String zuoyebianhao, String zuoyemingcheng, String zuoyeleixing, String neirong, String fujian, String yaoqiushijian1,String yaoqiushijian2, String kecheng, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zuoyebianhao==null||zuoyebianhao.equals("")){pmap.put("zuoyebianhao", null);}else{pmap.put("zuoyebianhao", zuoyebianhao);}		if(zuoyemingcheng==null||zuoyemingcheng.equals("")){pmap.put("zuoyemingcheng", null);}else{pmap.put("zuoyemingcheng", zuoyemingcheng);}		if(zuoyeleixing==null||zuoyeleixing.equals("")){pmap.put("zuoyeleixing", null);}else{pmap.put("zuoyeleixing", zuoyeleixing);}		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}		if(fujian==null||fujian.equals("")){pmap.put("fujian", null);}else{pmap.put("fujian", fujian);}		if(yaoqiushijian1==null||yaoqiushijian1.equals("")){pmap.put("yaoqiushijian1", null);}else{pmap.put("yaoqiushijian1", yaoqiushijian1);}		if(yaoqiushijian2==null||yaoqiushijian2.equals("")){pmap.put("yaoqiushijian2", null);}else{pmap.put("yaoqiushijian2", yaoqiushijian2);}		if(kecheng==null||kecheng.equals("")){pmap.put("kecheng", null);}else{pmap.put("kecheng", kecheng);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=zuoyeService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zuoye> list=zuoyeService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zuoyelist";
	}
	@RequestMapping("zyListtp.do")
	public String zyListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zuoye zuoye, String zuoyebianhao, String zuoyemingcheng, String zuoyeleixing, String neirong, String fujian, String yaoqiushijian1,String yaoqiushijian2, String kecheng, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zuoyebianhao==null||zuoyebianhao.equals("")){pmap.put("zuoyebianhao", null);}else{pmap.put("zuoyebianhao", zuoyebianhao);}		if(zuoyemingcheng==null||zuoyemingcheng.equals("")){pmap.put("zuoyemingcheng", null);}else{pmap.put("zuoyemingcheng", zuoyemingcheng);}		if(zuoyeleixing==null||zuoyeleixing.equals("")){pmap.put("zuoyeleixing", null);}else{pmap.put("zuoyeleixing", zuoyeleixing);}		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}		if(fujian==null||fujian.equals("")){pmap.put("fujian", null);}else{pmap.put("fujian", fujian);}		if(yaoqiushijian1==null||yaoqiushijian1.equals("")){pmap.put("yaoqiushijian1", null);}else{pmap.put("yaoqiushijian1", yaoqiushijian1);}		if(yaoqiushijian2==null||yaoqiushijian2.equals("")){pmap.put("yaoqiushijian2", null);}else{pmap.put("yaoqiushijian2", yaoqiushijian2);}		if(kecheng==null||kecheng.equals("")){pmap.put("kecheng", null);}else{pmap.put("kecheng", kecheng);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=zuoyeService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zuoye> list=zuoyeService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zuoyelisttp";
	}
	
	@RequestMapping("deleteZuoye.do")
	public String deleteZuoye(int id,HttpServletRequest request){
		zuoyeService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:zuoyeList.do";
	}
	
	@RequestMapping("quchongZuoye.do")
	public void quchongZuoye(Zuoye zuoye,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("zuoyebianhao", zuoye.getZuoyebianhao());
		   System.out.println("zuoyebianhao==="+zuoye.getZuoyebianhao());
		   System.out.println("zuoyebianhao222==="+zuoyeService.quchongZuoye(map));
		   JSONObject obj=new JSONObject();
		   if(zuoyeService.quchongZuoye(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "作业编号可以用！");
				  
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
