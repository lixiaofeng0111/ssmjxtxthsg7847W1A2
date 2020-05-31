package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ZuoyeMapper;
import com.entity.Zuoye;
import com.server.ZuoyeServer;
@Service
public class ZuoyeServerImpi implements ZuoyeServer {
   @Resource
   private ZuoyeMapper gdao;
	@Override
	public int add(Zuoye po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Zuoye po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Zuoye> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Zuoye> getsyzuoye1(Map<String, Object> map) {
		return gdao.getsyzuoye1(map);
	}
	public List<Zuoye> getsyzuoye2(Map<String, Object> map) {
		return gdao.getsyzuoye2(map);
	}
	public List<Zuoye> getsyzuoye3(Map<String, Object> map) {
		return gdao.getsyzuoye3(map);
	}
	
	@Override
	public Zuoye quchongZuoye(Map<String, Object> account) {
		return gdao.quchongZuoye(account);
	}

	@Override
	public List<Zuoye> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Zuoye> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Zuoye getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

