package com.li.dao;

import com.li.entity.Retailer;

import java.util.Map;

public interface RetailerDao extends BaseDao<Retailer> {
    public int count(Map map);
}
