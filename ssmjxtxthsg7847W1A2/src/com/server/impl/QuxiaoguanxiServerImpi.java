package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.QuxiaoguanxiMapper;
import com.entity.Quxiaoguanxi;
import com.server.QuxiaoguanxiServer;
@Service
public class QuxiaoguanxiServerImpi implements QuxiaoguanxiServer {
   @Resource
   private QuxiaoguanxiMapper gdao;
	@Override
	public int add(Quxiaoguanxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Quxiaoguanxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Quxiaoguanxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Quxiaoguanxi> getsyquxiaoguanxi1(Map<String, Object> map) {
		return gdao.getsyquxiaoguanxi1(map);
	}
	public List<Quxiaoguanxi> getsyquxiaoguanxi2(Map<String, Object> map) {
		return gdao.getsyquxiaoguanxi2(map);
	}
	public List<Quxiaoguanxi> getsyquxiaoguanxi3(Map<String, Object> map) {
		return gdao.getsyquxiaoguanxi3(map);
	}
	
	@Override
	public Quxiaoguanxi quchongQuxiaoguanxi(Map<String, Object> account) {
		return gdao.quchongQuxiaoguanxi(account);
	}

	@Override
	public List<Quxiaoguanxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Quxiaoguanxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Quxiaoguanxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

