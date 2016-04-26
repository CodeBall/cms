package net.yanzl.controller;

import net.yanzl.entity.ArticleEntity;
import net.yanzl.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 文章操作控制层
 * Created by xqq on 16-4-21.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private IArticleService articleService;

    /**
     * 分页获取文章列表,包括题目,时间,内容,作者
     * @param page,第几页,页面中从第1页开始计数,数据库查询从第0页开始计数,所以传递过来的页面在参数传递时要减一
     * @param size,每页有多少页,后期确定下来之后改为固定值
     * @return
     */
    @RequestMapping(value = "/{page}/{size}",method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getAll(@PathVariable int page,@PathVariable int size){
        Map<String,Object> rnt = new HashMap<String, Object>();
        Page<ArticleEntity> articles = articleService.findAll(page-1,size);

        if(articles == null || !articles.hasContent()){
            rnt.put("status", 0);
            return rnt;
        }

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (ArticleEntity article : articles){
            Map<String,Object> one = new HashMap<String, Object>();
            one.put("id",article.getArticleId());
            one.put("title",article.getArticleName());
            one.put("time",article.getTime());
            one.put("author",article.getUser().getUserName());
            one.put("content",article.getArticleContent().length() > 50 ?
                    article.getArticleContent().substring(50) :
                    article.getArticleContent());
            list.add(one);
        }
        rnt.put("posts", list);
        rnt.put("status", 1);
        return rnt;
    }

    /**
     * 获取某一个id的文章内容
     * @param id
     * @return
     */
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> get(@PathVariable Long id){
        Map<String, Object> rnt = new HashMap<String, Object>();
        ArticleEntity articleEntity = articleService.findOne(id);

        if(articleEntity != null){
            rnt.put("id",articleEntity.getArticleId());
            rnt.put("title", articleEntity.getArticleName());
            rnt.put("cate",articleEntity.getCate() == null ? "未分类": articleEntity.getCate().getCateName());
            rnt.put("time",articleEntity.getTime());
            rnt.put("auther",articleEntity.getUser().getUserName());
            rnt.put("content",articleEntity.getArticleContent());
            rnt.put("status", 1);
        }else {
            rnt.put("status", 0);
        }

        return rnt;
    }

    /**
     * 添加文章,文章名称,内容,分类不能为空,在前段页面写脚本检查,分类默认为"未分类"
     * @param request
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public boolean addArticle(HttpServletRequest request){
        HttpSession session = request.getSession();

        String articleName = request.getParameter("articleName");
        String articleContent = request.getParameter("articleContent");
        //获取文章发布时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(new Date());
        //获取文章所属用户
        String user_id = (String) session.getAttribute("userId");
        Long uid = Long.parseLong(user_id);
        //获取文章分类
        Long cid = Long.parseLong(request.getParameter("cateId"));

        ArticleEntity article = articleService.addArticle(articleName, articleContent, date, uid, cid);

        if(article.getArticleId()>0)
            return true;
        else
            return false;
    }

    /**
     * 删除文章
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public boolean deleteArticle(@PathVariable Long id){
        if(articleService.deleteArticle(id))
            return true;
        else
            return false;
    }

    /**
     * 修改文章
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    public boolean updateArticle(@PathVariable Long id,HttpServletRequest request){
        Map<String,String> map = new HashMap<String, String>();
        map.put("id",String.valueOf(id));
        map.put("name",request.getParameter("name"));
        map.put("content",request.getParameter("content"));

        if(articleService.updateArticle(map))
            return true;
        else
            return false;
    }

}
