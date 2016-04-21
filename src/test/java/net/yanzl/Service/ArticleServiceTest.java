package net.yanzl.Service;

import net.yanzl.entity.ArticleEntity;
import net.yanzl.entity.UserEntity;
import net.yanzl.repository.UserRepository;
import net.yanzl.service.IArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xqq on 16-4-21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(value = "classpath*:spring.xml")
public class ArticleServiceTest {
    @Autowired
    private IArticleService service;

    @Autowired
    private UserRepository userRepository;

    /**
     * 测试增加文章
     */
    @Test
    public void save(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String time = df.format(new Date());
        UserEntity user = userRepository.findOne((long) 1);
        ArticleEntity article = service.addArticle("测试文章7", "测试文章七的内容", time, "作者三",user);
        System.out.println(article.getArticleId()+"\t"+article.getUser());
    }
}
