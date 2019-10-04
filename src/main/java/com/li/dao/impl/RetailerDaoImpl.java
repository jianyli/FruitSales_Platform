package com.li.dao.impl;

import com.li.dao.RetailerDao;
import com.li.entity.Retailer;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class RetailerDaoImpl extends BaseDaoImpl<Retailer> implements RetailerDao {
    public RetailerDaoImpl() {
        super.setNs("mapper.RetailerMapper");
    }

    @Override
    public int count(Map map) {
        return this.getSqlSession().selectOne(this.getNs()+".count",map);
    }
}
