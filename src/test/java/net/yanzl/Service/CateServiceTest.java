package net.yanzl.Service;

import net.yanzl.entity.CateEntity;
import net.yanzl.service.ICateService;
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
 * 文章分类Service层测试类
 * Created by xqq on 16-4-21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(value = "classpath*:spring.xml")
public class CateServiceTest {

    @Autowired
    private ICateService service;

    /**
     * 测试添加文章分类
     */
    @Test
    public void save(){
        String name = "混蛋海波3";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(new Date());
        Long parent = (long)1;

        CateEntity cate = service.addCate(name,date,parent);
        assert cate.getCateId() == 9;
    }

    @Test
    public void delete(){
        System.out.println(service.deleteCate((long)2));
    }

    @Test
    public void update(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("id","9");
        map.put("name","Python学习");
        System.out.println(service.updateCate(map));
    }

    @Test
    public void find(){
        Page<CateEntity> page = service.findAll(0,3);
        for (CateEntity cate : page){
            System.out.println(cate.getCateId() + "\t" + cate.getCateName());
        }
    }

}
