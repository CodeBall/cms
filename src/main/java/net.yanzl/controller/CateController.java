package net.yanzl.controller;

import net.yanzl.entity.CateEntity;
import net.yanzl.entity.UserEntity;
import net.yanzl.service.ICateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by xqq on 16-4-26.
 */

@Controller
@RequestMapping("cate")
public class CateController {

    @Autowired
    private ICateService cateService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public @ResponseBody boolean addCate(HttpServletRequest request){

        String cateName = request.getParameter("cateName");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(new Date());

        Long parent = Long.parseLong(request.getParameter("parent"));

        CateEntity cate = cateService.addCate(cateName,date,parent);

        if(cate == null)
            return false;
        else
            return true;
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public @ResponseBody boolean deleteCate(@PathVariable Long id){
        if(cateService.deleteCate(id))
            return true;
        else
            return false;
    }

    @RequestMapping(value = "update/{id}",method = RequestMethod.POST)
    public @ResponseBody boolean updateCate(@PathVariable Long id,HttpServletRequest request){
        Map<String,String> map = new HashMap<String, String>();
        map.put("id",String.valueOf(id));

        map.put("name",request.getParameter("cateName"));
        map.put("parent",request.getParameter("parent"));

        if(cateService.updateCate(map))
            return true;
        else
            return false;
    }

    @RequestMapping(value = "/{page}/{size}",method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> findAll(@PathVariable int page,@PathVariable int size){
        Map<String,Object> rnt = new HashMap<String, Object>();
        Page<CateEntity> cates = cateService.findAll(page,size);

        if (cates == null || !cates.hasContent()){
            rnt.put("status",0);
            return rnt;
        }

        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();

        for (CateEntity cate : cates){
            Map<String,Object> one = new HashMap<String, Object>();
            one.put("id",cate.getCateId());
            one.put("cateName",cate.getCateName());
            one.put("parent",cate.getParentId());
            one.put("date",cate.getDate());

            list.add(one);
        }

        rnt.put("posts", list);
        rnt.put("status", 1);
        return rnt;
    }
}
