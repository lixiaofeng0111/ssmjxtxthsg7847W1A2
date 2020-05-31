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

import com.entity.Kaoshianpai;
import com.server.KaoshianpaiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class KaoshianpaiController {
	@Resource
	private KaoshianpaiServer kaoshianpaiService;


   
	@RequestMapping("addKaoshianpai.do")
	public String addKaoshianpai(HttpServletRequest request,Kaoshianpai kaoshianpai,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		kaoshianpai.setAddtime(time.toString().substring(0, 19));
		kaoshianpaiService.add(kaoshianpai);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "kaoshianpaiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:kaoshianpaiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateKaoshianpai.do")
	public String doUpdateKaoshianpai(int id,ModelMap map,Kaoshianpai kaoshianpai){
		kaoshianpai=kaoshianpaiService.getById(id);
		map.put("kaoshianpai", kaoshianpai);
		return "kaoshianpai_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("kaoshianpaiDetail.do")
	public String kaoshianpaiDetail(int id,ModelMap map,Kaoshianpai kaoshianpai){
		kaoshianpai=kaoshianpaiService.getById(id);
		map.put("kaoshianpai", kaoshianpai);
		return "kaoshianpai_detail";
	}
//	前台详细
	@RequestMapping("ksapDetail.do")
	public String ksapDetail(int id,ModelMap map,Kaoshianpai kaoshianpai){
		kaoshianpai=kaoshianpaiService.getById(id);
		map.put("kaoshianpai", kaoshianpai);
		return "kaoshianpaidetail";
	}
//	
	@RequestMapping("updateKaoshianpai.do")
	public String updateKaoshianpai(int id,ModelMap map,Kaoshianpai kaoshianpai,HttpServletRequest request,HttpSession session){
		kaoshianpaiService.update(kaoshianpai);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:kaoshianpaiList.do";
	}

//	分页查询
	@RequestMapping("kaoshianpaiList.do")
	public String kaoshianpaiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kaoshianpai kaoshianpai, String changci, String kechengmingcheng, String jiaoshihao, String kaoshishijian, String kaoshishiduan, String shuoming, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(changci==null||changci.equals("")){pmap.put("changci", null);}else{pmap.put("changci", changci);}		if(kechengmingcheng==null||kechengmingcheng.equals("")){pmap.put("kechengmingcheng", null);}else{pmap.put("kechengmingcheng", kechengmingcheng);}		if(jiaoshihao==null||jiaoshihao.equals("")){pmap.put("jiaoshihao", null);}else{pmap.put("jiaoshihao", jiaoshihao);}		if(kaoshishijian==null||kaoshishijian.equals("")){pmap.put("kaoshishijian", null);}else{pmap.put("kaoshishijian", kaoshishijian);}		if(kaoshishiduan==null||kaoshishiduan.equals("")){pmap.put("kaoshishiduan", null);}else{pmap.put("kaoshishiduan", kaoshishiduan);}		if(shuoming==null||shuoming.equals("")){pmap.put("shuoming", null);}else{pmap.put("shuoming", shuoming);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=kaoshianpaiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kaoshianpai> list=kaoshianpaiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kaoshianpai_list";
	}
	
	@RequestMapping("kaoshianpai_yanben1.do")
	public String kaoshianpai_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kaoshianpai kaoshianpai, String changci, String kechengmingcheng, String jiaoshihao, String kaoshishijian, String kaoshishiduan, String shuoming, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(changci==null||changci.equals("")){pmap.put("changci", null);}else{pmap.put("changci", changci);}		if(kechengmingcheng==null||kechengmingcheng.equals("")){pmap.put("kechengmingcheng", null);}else{pmap.put("kechengmingcheng", kechengmingcheng);}		if(jiaoshihao==null||jiaoshihao.equals("")){pmap.put("jiaoshihao", null);}else{pmap.put("jiaoshihao", jiaoshihao);}		if(kaoshishijian==null||kaoshishijian.equals("")){pmap.put("kaoshishijian", null);}else{pmap.put("kaoshishijian", kaoshishijian);}		if(kaoshishiduan==null||kaoshishiduan.equals("")){pmap.put("kaoshishiduan", null);}else{pmap.put("kaoshishiduan", kaoshishiduan);}		if(shuoming==null||shuoming.equals("")){pmap.put("shuoming", null);}else{pmap.put("shuoming", shuoming);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=kaoshianpaiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kaoshianpai> list=kaoshianpaiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kaoshianpai_yanben1";
	}
	@RequestMapping("kaoshianpai_yanben2.do")
	public String kaoshianpai_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kaoshianpai kaoshianpai, String changci, String kechengmingcheng, String jiaoshihao, String kaoshishijian, String kaoshishiduan, String shuoming, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(changci==null||changci.equals("")){pmap.put("changci", null);}else{pmap.put("changci", changci);}		if(kechengmingcheng==null||kechengmingcheng.equals("")){pmap.put("kechengmingcheng", null);}else{pmap.put("kechengmingcheng", kechengmingcheng);}		if(jiaoshihao==null||jiaoshihao.equals("")){pmap.put("jiaoshihao", null);}else{pmap.put("jiaoshihao", jiaoshihao);}		if(kaoshishijian==null||kaoshishijian.equals("")){pmap.put("kaoshishijian", null);}else{pmap.put("kaoshishijian", kaoshishijian);}		if(kaoshishiduan==null||kaoshishiduan.equals("")){pmap.put("kaoshishiduan", null);}else{pmap.put("kaoshishiduan", kaoshishiduan);}		if(shuoming==null||shuoming.equals("")){pmap.put("shuoming", null);}else{pmap.put("shuoming", shuoming);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=kaoshianpaiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kaoshianpai> list=kaoshianpaiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kaoshianpai_yanben2";
	}
	@RequestMapping("kaoshianpai_yanben3.do")
	public String kaoshianpai_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kaoshianpai kaoshianpai, String changci, String kechengmingcheng, String jiaoshihao, String kaoshishijian, String kaoshishiduan, String shuoming, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(changci==null||changci.equals("")){pmap.put("changci", null);}else{pmap.put("changci", changci);}		if(kechengmingcheng==null||kechengmingcheng.equals("")){pmap.put("kechengmingcheng", null);}else{pmap.put("kechengmingcheng", kechengmingcheng);}		if(jiaoshihao==null||jiaoshihao.equals("")){pmap.put("jiaoshihao", null);}else{pmap.put("jiaoshihao", jiaoshihao);}		if(kaoshishijian==null||kaoshishijian.equals("")){pmap.put("kaoshishijian", null);}else{pmap.put("kaoshishijian", kaoshishijian);}		if(kaoshishiduan==null||kaoshishiduan.equals("")){pmap.put("kaoshishiduan", null);}else{pmap.put("kaoshishiduan", kaoshishiduan);}		if(shuoming==null||shuoming.equals("")){pmap.put("shuoming", null);}else{pmap.put("shuoming", shuoming);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=kaoshianpaiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kaoshianpai> list=kaoshianpaiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kaoshianpai_yanben3";
	}
	@RequestMapping("kaoshianpai_yanben4.do")
	public String kaoshianpai_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kaoshianpai kaoshianpai, String changci, String kechengmingcheng, String jiaoshihao, String kaoshishijian, String kaoshishiduan, String shuoming, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(changci==null||changci.equals("")){pmap.put("changci", null);}else{pmap.put("changci", changci);}		if(kechengmingcheng==null||kechengmingcheng.equals("")){pmap.put("kechengmingcheng", null);}else{pmap.put("kechengmingcheng", kechengmingcheng);}		if(jiaoshihao==null||jiaoshihao.equals("")){pmap.put("jiaoshihao", null);}else{pmap.put("jiaoshihao", jiaoshihao);}		if(kaoshishijian==null||kaoshishijian.equals("")){pmap.put("kaoshishijian", null);}else{pmap.put("kaoshishijian", kaoshishijian);}		if(kaoshishiduan==null||kaoshishiduan.equals("")){pmap.put("kaoshishiduan", null);}else{pmap.put("kaoshishiduan", kaoshishiduan);}		if(shuoming==null||shuoming.equals("")){pmap.put("shuoming", null);}else{pmap.put("shuoming", shuoming);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=kaoshianpaiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kaoshianpai> list=kaoshianpaiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kaoshianpai_yanben4";
	}
	@RequestMapping("kaoshianpai_yanben5.do")
	public String kaoshianpai_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kaoshianpai kaoshianpai, String changci, String kechengmingcheng, String jiaoshihao, String kaoshishijian, String kaoshishiduan, String shuoming, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(changci==null||changci.equals("")){pmap.put("changci", null);}else{pmap.put("changci", changci);}		if(kechengmingcheng==null||kechengmingcheng.equals("")){pmap.put("kechengmingcheng", null);}else{pmap.put("kechengmingcheng", kechengmingcheng);}		if(jiaoshihao==null||jiaoshihao.equals("")){pmap.put("jiaoshihao", null);}else{pmap.put("jiaoshihao", jiaoshihao);}		if(kaoshishijian==null||kaoshishijian.equals("")){pmap.put("kaoshishijian", null);}else{pmap.put("kaoshishijian", kaoshishijian);}		if(kaoshishiduan==null||kaoshishiduan.equals("")){pmap.put("kaoshishiduan", null);}else{pmap.put("kaoshishiduan", kaoshishiduan);}		if(shuoming==null||shuoming.equals("")){pmap.put("shuoming", null);}else{pmap.put("shuoming", shuoming);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=kaoshianpaiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kaoshianpai> list=kaoshianpaiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kaoshianpai_yanben5";
	}
	
	@RequestMapping("kaoshianpaiList2.do")
	public String kaoshianpaiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kaoshianpai kaoshianpai, String changci, String kechengmingcheng, String jiaoshihao, String kaoshishijian, String kaoshishiduan, String shuoming, String faburen,HttpServletRequest request){
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
		if(changci==null||changci.equals("")){pmap.put("changci", null);}else{pmap.put("changci", changci);}		if(kechengmingcheng==null||kechengmingcheng.equals("")){pmap.put("kechengmingcheng", null);}else{pmap.put("kechengmingcheng", kechengmingcheng);}		if(jiaoshihao==null||jiaoshihao.equals("")){pmap.put("jiaoshihao", null);}else{pmap.put("jiaoshihao", jiaoshihao);}		if(kaoshishijian==null||kaoshishijian.equals("")){pmap.put("kaoshishijian", null);}else{pmap.put("kaoshishijian", kaoshishijian);}		if(kaoshishiduan==null||kaoshishiduan.equals("")){pmap.put("kaoshishiduan", null);}else{pmap.put("kaoshishiduan", kaoshishiduan);}		if(shuoming==null||shuoming.equals("")){pmap.put("shuoming", null);}else{pmap.put("shuoming", shuoming);}		
		
		int total=kaoshianpaiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kaoshianpai> list=kaoshianpaiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kaoshianpai_list2";
	}	
	
	@RequestMapping("ksapList.do")
	public String ksapList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kaoshianpai kaoshianpai, String changci, String kechengmingcheng, String jiaoshihao, String kaoshishijian, String kaoshishiduan, String shuoming, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(changci==null||changci.equals("")){pmap.put("changci", null);}else{pmap.put("changci", changci);}		if(kechengmingcheng==null||kechengmingcheng.equals("")){pmap.put("kechengmingcheng", null);}else{pmap.put("kechengmingcheng", kechengmingcheng);}		if(jiaoshihao==null||jiaoshihao.equals("")){pmap.put("jiaoshihao", null);}else{pmap.put("jiaoshihao", jiaoshihao);}		if(kaoshishijian==null||kaoshishijian.equals("")){pmap.put("kaoshishijian", null);}else{pmap.put("kaoshishijian", kaoshishijian);}		if(kaoshishiduan==null||kaoshishiduan.equals("")){pmap.put("kaoshishiduan", null);}else{pmap.put("kaoshishiduan", kaoshishiduan);}		if(shuoming==null||shuoming.equals("")){pmap.put("shuoming", null);}else{pmap.put("shuoming", shuoming);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=kaoshianpaiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kaoshianpai> list=kaoshianpaiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kaoshianpailist";
	}
	@RequestMapping("ksapListtp.do")
	public String ksapListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kaoshianpai kaoshianpai, String changci, String kechengmingcheng, String jiaoshihao, String kaoshishijian, String kaoshishiduan, String shuoming, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(changci==null||changci.equals("")){pmap.put("changci", null);}else{pmap.put("changci", changci);}		if(kechengmingcheng==null||kechengmingcheng.equals("")){pmap.put("kechengmingcheng", null);}else{pmap.put("kechengmingcheng", kechengmingcheng);}		if(jiaoshihao==null||jiaoshihao.equals("")){pmap.put("jiaoshihao", null);}else{pmap.put("jiaoshihao", jiaoshihao);}		if(kaoshishijian==null||kaoshishijian.equals("")){pmap.put("kaoshishijian", null);}else{pmap.put("kaoshishijian", kaoshishijian);}		if(kaoshishiduan==null||kaoshishiduan.equals("")){pmap.put("kaoshishiduan", null);}else{pmap.put("kaoshishiduan", kaoshishiduan);}		if(shuoming==null||shuoming.equals("")){pmap.put("shuoming", null);}else{pmap.put("shuoming", shuoming);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=kaoshianpaiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kaoshianpai> list=kaoshianpaiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kaoshianpailisttp";
	}
	
	@RequestMapping("deleteKaoshianpai.do")
	public String deleteKaoshianpai(int id,HttpServletRequest request){
		kaoshianpaiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:kaoshianpaiList.do";
	}
	
	@RequestMapping("quchongKaoshianpai.do")
	public void quchongKaoshianpai(Kaoshianpai kaoshianpai,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("changci", kaoshianpai.getChangci());
		   System.out.println("changci==="+kaoshianpai.getChangci());
		   System.out.println("changci222==="+kaoshianpaiService.quchongKaoshianpai(map));
		   JSONObject obj=new JSONObject();
		   if(kaoshianpaiService.quchongKaoshianpai(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "场次可以用！");
				  
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
