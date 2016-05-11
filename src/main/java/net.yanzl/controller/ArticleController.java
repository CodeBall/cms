package net.yanzl.controller;

import net.yanzl.entity.ArticleEntity;
import net.yanzl.entity.CateEntity;
import net.yanzl.service.IArticleService;
import net.yanzl.service.ICateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

    @Autowired
    private ICateService cateService;
    /**
     * 分页获取文章列表,包括题目,时间,内容,作者
     * @param page,第几页,页面中从第1页开始计数,数据库查询从第0页开始计数,所以传递过来的页面在参数传递时要减一
     * @param size,每页有多少页,后期确定下来之后改为固定值
     * @return
     */
    @RequestMapping(value = "/{page}/{size}",method = RequestMethod.GET)
    public String getAll(ModelMap rnt,@PathVariable int page,@PathVariable int size){
        Page<ArticleEntity> articles = articleService.findAll(page-1,size);

        if(articles == null || !articles.hasContent()){
            rnt.addAttribute("status", 0);
            return "article/articleList";
        }

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (ArticleEntity article : articles){
            Map<String,Object> one = new HashMap<String, Object>();
            one.put("id",article.getArticleId());
            one.put("title",article.getArticleName());
            one.put("time",article.getTime());
            one.put("author",article.getUser().getUserName());
            one.put("cate",article.getCate().getCateName());
            one.put("del",article.getDel());
            one.put("content",article.getArticleContent().length() > 50 ?
                    article.getArticleContent().substring(50) :
                    article.getArticleContent());
            list.add(one);
        }
        rnt.addAttribute("posts", list);
        rnt.addAttribute("status", 1);
        return "article/articleList";
    }

    /**
     * 获取某一个id的文章内容
     * @param id
     * @return
     */
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public String get(ModelMap rnt, @PathVariable Long id){
        ArticleEntity articleEntity = articleService.findOne(id);

        if(articleEntity != null){
            rnt.addAttribute("id", articleEntity.getArticleId());
            rnt.addAttribute("title", articleEntity.getArticleName());
            rnt.addAttribute("cate", articleEntity.getCate() == null ? "未分类" : articleEntity.getCate().getCateName());
            rnt.addAttribute("time", articleEntity.getTime());
            rnt.addAttribute("auther", articleEntity.getUser().getUserName());
            rnt.addAttribute("content", articleEntity.getArticleContent());
        }
        return "article/article";
    }


    /**
     * 调取写文章的页面
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addArticle(ModelMap map){
        List<CateEntity> cate = cateService.getAll();
        map.addAttribute("cate",cate);
        return "article/addArticle";
    }
    /**
     * 添加文章,文章名称,内容,分类不能为空,在前段页面写脚本检查,分类默认为"未分类"
     * @param request
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addArticle(ModelMap map,HttpServletRequest request){
        HttpSession session = request.getSession();

        String articleName = request.getParameter("articleName");
        String articleContent = request.getParameter("articleContent");
        //获取文章发布时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String time = df.format(new Date());

        //获取文章状态,0代表草稿,1代表已发表
        String status = request.getParameter("status");
        int del = Integer.parseInt(status);
        //获取文章所属用户
        String user_id = session.getAttribute("userId").toString();
        Long uid = Long.parseLong(user_id);
        //获取文章分类
        Long cid = Long.parseLong(request.getParameter("cateId"));


        ArticleEntity article = articleService.addArticle(articleName, articleContent, time,del, uid, cid);

        if(article.getArticleId()>0)
            map.addAttribute("status","添加文章成功");
        else
            map.addAttribute("status","添加文章失败");
        return "status";
    }

    /**
     * 删除文章
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String deleteArticle(ModelMap map,@PathVariable Long id){
        System.out.println(id);
        if(articleService.deleteArticle(id))
            map.addAttribute("status","删除文章成功");
        else
            map.addAttribute("status","删除文章失败");
        return "status";
    }

    /**
     * 调取更新文章页面
     * @param map
     * @param id
     * @return
     */
    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public String updateArticle(ModelMap map,@PathVariable Long id){
        ArticleEntity article = articleService.findOne(id);
        map.addAttribute("article",article);

        List<CateEntity> cate = cateService.getAll();
        map.addAttribute("cate", cate);

        return "article/updateArticle";
    }

    /**
     * 修改文章
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    public String updateArticle(ModelMap rnt,@PathVariable Long id,HttpServletRequest request){
        Map<String,String> map = new HashMap<String, String>();
        map.put("id", String.valueOf(id));
        map.put("name",request.getParameter("articleName"));
        map.put("content",request.getParameter("articleContent"));
        map.put("cate",request.getParameter("cateId"));
        map.put("del",request.getParameter("status"));

        if(articleService.updateArticle(map))
            rnt.addAttribute("status","文章修改成功!");
        else
            rnt.addAttribute("status","文章修改失败");
        System.out.println("实物完成");
        return "status";
    }

    @RequestMapping(value = "/toDraft/{id}",method = RequestMethod.GET)
    public String toDraft(ModelMap rnt,@PathVariable Long id){
        Map<String,String> map = new HashMap<String, String>();
        map.put("id", String.valueOf(id));
        map.put("del", "0");
        if(articleService.updateArticle(map))
            rnt.addAttribute("status","文章已成功移动至回收站!");
        else
            rnt.addAttribute("status","文章移动失败");
        return "status";
    }

}
