package com.li.controller;

import com.li.entity.Retailer;
import com.li.service.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RetailerController extends BaseController {
    @Autowired
    RetailerService service;
    @RequestMapping("/retailer/list.action")
    public String list(Model model, Retailer retailer, String startTime, String endTime) {
        Map<String,Object> map = retailToMap(retailer);
        if (startTime != null && !startTime.equals("")) {
            map.put("startTime", startTime);
        }
        if (endTime != null && !endTime.equals("")) {
            map.put("endTime", endTime);
        }
        List<Retailer> list = service.find(map);
        model.addAttribute("list",list);
        model.addAttribute("currentPage", retailer.getCurrentPage());
        model.addAttribute("startPage", retailer.getStartPage());
        int countNumber = service.count(map);
        int pageSize = retailer.getPageSize();
        model.addAttribute("countNumber", countNumber);
        model.addAttribute("pageSize", pageSize);
        int sumPageNumber = countNumber % pageSize == 0 ? (countNumber/pageSize) : (countNumber/pageSize +1);
        model.addAttribute("sumPageNumber", sumPageNumber);
        return "/retailer/retailerHome.jsp";
    }
    private Map<String,Object> retailToMap(Retailer retailer) {
        Map<String,Object> map = new HashMap<>();
        map.put("name",checkIsEmpty(retailer.getName()));
        map.put("telephone", checkIsEmpty(retailer.getTelephone()));
        map.put("address",retailer.getAddress());
        map.put("status", retailer.getStatus() == -1 ? null : retailer.getStatus());
        map.put("createTime", checkIsEmpty(retailer.getCreateTime()));
        map.put("startPage", retailer.getStartPage());
        map.put("pageSize", retailer.getPageSize());
        return map;
    }
    private String checkIsEmpty(String param) {
        return param == null ? null : (param.equals("") ? null : "%" + param + "%");
    }
}
