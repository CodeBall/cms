package net.yanzl.database;

import net.yanzl.entity.ArticleEntity;
import net.yanzl.repository.ArticleRepository;
import net.yanzl.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * 文章管理Dao层测试
 * Created by xqq on 16-4-20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(value = "classpath*:spring.xml")
public class ArticleDaoTest {
    @Autowired
    private ArticleRepository dao;

    @Autowired
    private UserRepository userRepository;

    /**
     * 测试存储文章信息
     */
    @Test
    public void save(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String time = df.format(new Date());
        //创建article基本对象
        ArticleEntity article = new ArticleEntity("测试文章7","测试文章七的内容",time,1);
        //获取当前登陆用户
//        UserEntity user = userRepository.findOne((long) 1);
//        System.out.println(user.getEmail());
//        //将该文章与当前登录用户相连
//        article.setUser(user);
        //保存
        dao.save(article);
        System.out.println(article.getArticleId());
    }

    /**
     * 测试删除文章信息
     */
    @Test
    public void delete(){
        dao.delete((long) 2);
        System.out.println("Yes");
    }

    /**
     * 测试查询信息
     */
    @Test
    public void findAll(){
        List<ArticleEntity> list = dao.findAll();
        for(ArticleEntity article : list){
            System.out.println(article.getArticleId()+"\t"+article.getArticleName());
        }
    }
    /**
     * 测试修改文章信息
     */
    @Test
    public void update(){
        ArticleEntity article = dao.findOne((long) 3);
        article.setArticleName("测试文章2");
        dao.save(article);
        System.out.print(article.getArticleId()+"\t"+article.getArticleName());
    }
    /**
     * 测试文章分页处理能力
     */
    @Test
    public void page(){
        Page<ArticleEntity> list = dao.findAll(new PageRequest(0,5,new Sort(new Sort.Order(Sort.Direction.DESC,"time"))));
        for(ArticleEntity article : list){
            System.out.println(article.getArticleId()+"\t"+article.getArticleName());
        }
    }
}
