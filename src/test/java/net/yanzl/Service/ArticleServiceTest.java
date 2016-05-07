package net.yanzl.Service;

import net.yanzl.entity.ArticleEntity;
import net.yanzl.service.IArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xqq on 16-4-21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(value = "classpath*:spring.xml")
public class ArticleServiceTest {
    @Autowired
    private IArticleService service;

    /**
     * 测试增加文章
     */
    @Test
    public void save(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String time = df.format(new Date());
        ArticleEntity article = service.addArticle("测试文章6", "测试文章6的内容", time,(long)2,(long)2);
        System.out.println(article.getArticleId()+"\t"+article.getUser());
    }
    /**
     * 测试删除文章
     */
    @Test
    public void delete(){
        System.out.println(service.deleteArticle((long) 3));
    }
    /**
     * 测试修改文章
     */
    @Test
    public void update(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("id","1");
        map.put("name","修改文章测试");
        map.put("content","修改文章的内容");
        System.out.println(service.updateArticle(map));
    }
    /**
     * 测试分页查询
     */
    @Test
    public void findall(){
        //查询第几页,每页有多少数据
        Page<ArticleEntity> page = service.findAll(0,4);
        System.out.println(page.getSize());
        for (ArticleEntity article : page){
            System.out.println(article.getArticleId()+"\t"+article.getArticleName()+"\t"+article.getUser().getUserName());
        }
    }

    /*@Test
    public void findMine(){
        Page<ArticleEntity> page = service.findMine((long) 3,0,3);
        System.out.println(page.getSize());
        for (ArticleEntity article : page){
            System.out.println(article.getArticleId()+"\t"+article.getArticleName()+"\t"+article.getUser().getUserName());
        }
    }*/
    /**
     * 查询某一篇文章
     */
    @Test
    public void findOne(){
        ArticleEntity article = service.findOne((long) 1);
        System.out.println(article.getArticleId()+"\t"+article.getArticleName());
    }

}
