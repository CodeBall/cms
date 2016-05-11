package net.yanzl.controller;

import net.yanzl.entity.CateEntity;
import net.yanzl.service.ICateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addCate(ModelMap map){
        List<CateEntity> cate = cateService.getAll();
        map.addAttribute("cate",cate);
        return "cate/addCate";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addCate(ModelMap map,HttpServletRequest request){

        String cateName = request.getParameter("cateName");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(new Date());
        String par = request.getParameter("parent");

        if (cateName.isEmpty() || par.isEmpty()){
            map.addAttribute("status","请将分类信息填写完整");
            return "cate/addCate";
        }
        Long parent = Long.parseLong(par);


        CateEntity cate = cateService.addCate(cateName,date,parent);

        if(cate == null)
            map.addAttribute("status","添加分类信息失败");
        else
            map.addAttribute("status","添加分类信息成功");

        return "status";
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String deleteCate(ModelMap map,@PathVariable Long id){
        if(cateService.deleteCate(id))
            map.addAttribute("status","删除成功!");
        else
            map.addAttribute("status","删除失败!");

        return "status";
    }


    /**
     * 调取更新文章分类页面
     * @param map
     * @param id
     * @return
     */
    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    public String updateCate(ModelMap map,@PathVariable Long id){
        CateEntity cate = cateService.getCate(id);
        map.addAttribute("cate",cate);
        List<CateEntity> cates = cateService.getAll();
        map.addAttribute("cates",cates);
        return "cate/update";
    }

    /**
     * 文章分类更新操作
     * @param id
     * @return
     */
    @RequestMapping(value = "update/{id}",method = RequestMethod.POST)
    public String updateCate(ModelMap rnt,@PathVariable Long id,String catename,String parent){
        Map<String,String> map = new HashMap<String, String>();
        map.put("id", String.valueOf(id));

        if (catename.isEmpty()||parent.isEmpty()){
            rnt.addAttribute("status","请填写完整的分类信息!");
            CateEntity cate = cateService.getCate(id);
            rnt.addAttribute("cate",cate);
            return "cate/update";
        }
        map.put("name",catename);
        map.put("parent",parent);

        if(cateService.updateCate(map))
            rnt.addAttribute("status","修改分类信息成功");
        else
            rnt.addAttribute("status","修改分类信息失败");
        return "status";
    }

    /**
     * 获取分类信息
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/{page}/{size}",method = RequestMethod.GET)
    public String findAll(ModelMap rnt,@PathVariable int page,@PathVariable int size){
        Page<CateEntity> cates = cateService.findAll(page-1,size);

        if (cates == null || !cates.hasContent()){
            rnt.put("status",0);
            return "cate/cateList";
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
        return "cate/cateList";
    }
}
