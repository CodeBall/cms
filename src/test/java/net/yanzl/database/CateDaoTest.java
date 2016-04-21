package net.yanzl.database;

import net.yanzl.repository.CateRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import net.yanzl.entity.CateEntity;

import java.util.List;

/**
 * 文章分类Dao层测试
 * Created by xqq on 16-4-20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(value = {"classpath*:spring.xml"})
public class CateDaoTest {
    @Autowired
    private CateRepository cate;

    /**
     * 测试存储文章分类信息
     */
    @Test
    public void save(){
        CateEntity Cate = new CateEntity("Python学习");
        cate.save(Cate);
        System.out.println(Cate.getCateId());
    }

    /**
     * 测试删除文章分类信息
     */
    @Test
    public void delete(){
        cate.delete((long) 3);
        System.out.println("true");
    }
    /**
     * 测试根据id查找文章分类信息
     */
    @Test
    @Transactional
    public void findCateById(){
        CateEntity Cate = cate.findOne((long) 2);
        System.out.println("Id:"+Cate.getCateId()+",\tname:"+Cate.getCateName());
    }
    /**
     * 查询所有数据
     */
    @Test
    public void findAll(){
        List<CateEntity> list = cate.findAll();
        for(CateEntity Cate:list){
            System.out.println("Id:"+Cate.getCateId()+",\tname:"+Cate.getCateName()+"ParentId:"+Cate.getParentId());
        }
    }
    /**
     * 测试修改文章分类信息
     */
    @Test
    public void updateCate(){
        CateEntity Cate = cate.findOne((long)2);
        Cate.setParentId(1);
        cate.save(Cate);
        System.out.println("Id:"+Cate.getCateId()+",\tname:"+Cate.getCateName()+"ParentId:"+Cate.getParentId());
    }
}
