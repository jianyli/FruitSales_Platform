package com.li.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.li.dao.RetailerDao;
import com.li.entity.Retailer;
import com.li.service.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service  //为了包扫描的时候这个Service被扫描到  
public class RetailerServiceImpl implements RetailerService {
    
    @Autowired
	RetailerDao retailerDao;

	public Retailer get(String id) { return retailerDao.get(id); }
	public List<Retailer> find(Map map) {
		return retailerDao.find(map);
	} 
	public void insert(Retailer retailer) {
		retailerDao.insert(retailer);
	}
	public void update(Retailer retailer) {
		retailerDao.update(retailer);
	}
	public void deleteById(Serializable id) {
		retailerDao.deleteById(id);
	}
	public void delete(Serializable[] ids) {
		retailerDao.delete(ids);
	}
	public int count(Map map) {
		return retailerDao.count(map);
	}
}
