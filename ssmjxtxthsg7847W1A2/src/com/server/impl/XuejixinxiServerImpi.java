package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.XuejixinxiMapper;
import com.entity.Xuejixinxi;
import com.server.XuejixinxiServer;
@Service
public class XuejixinxiServerImpi implements XuejixinxiServer {
   @Resource
   private XuejixinxiMapper gdao;
	@Override
	public int add(Xuejixinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Xuejixinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Xuejixinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Xuejixinxi> getsyxuejixinxi1(Map<String, Object> map) {
		return gdao.getsyxuejixinxi1(map);
	}
	public List<Xuejixinxi> getsyxuejixinxi2(Map<String, Object> map) {
		return gdao.getsyxuejixinxi2(map);
	}
	public List<Xuejixinxi> getsyxuejixinxi3(Map<String, Object> map) {
		return gdao.getsyxuejixinxi3(map);
	}
	
	@Override
	public Xuejixinxi quchongXuejixinxi(Map<String, Object> account) {
		return gdao.quchongXuejixinxi(account);
	}

	@Override
	public List<Xuejixinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Xuejixinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Xuejixinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

