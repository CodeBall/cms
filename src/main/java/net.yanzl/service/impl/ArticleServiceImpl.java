package net.yanzl.service.impl;

import net.yanzl.entity.CateEntity;
import net.yanzl.entity.UserEntity;
import net.yanzl.repository.ArticleRepository;
import net.yanzl.entity.ArticleEntity;
import net.yanzl.repository.CateRepository;
import net.yanzl.repository.UserRepository;
import net.yanzl.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 文章管理Service层
 * Created by xqq on 16-4-19.
 */
@Service
@Transactional
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    //用于获取当前用户,应该在Controller进行获取操作
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CateRepository cateRepository;
    /**
     * 添加文章
     * 添加文章时,涉及到uid和cid没有写入
     * @param articleName
     * @param articleContent
     * @param time
     * @return
     */
    public ArticleEntity addArticle(String articleName,String articleContent,String time,Long uid,Long cid){
        ArticleEntity article = new ArticleEntity(articleName,articleContent,time);
        UserEntity user = userRepository.findOne(uid);
        CateEntity cate = cateRepository.findOne(cid);
        article.setUser(user);
        article.setCate(cate);
        articleRepository.save(article);
        return article;
    }

    /**
     * 删除文章,借助exists判断该文章是否存在
     * @param articleId
     * @return
     */
    public boolean deleteArticle(Long articleId){
        articleRepository.delete(articleId);
        if(articleRepository.exists(articleId))
            return false;
        else
            return true;
    }

    /**
     * 修改文章
     * 修改文章时,涉及到文章类型cid和所属作者没有选择
     * @param map
     * @return
     */
    public boolean updateArticle(Map<String,String> map){
        String id = map.get("id");
        Long articleId = Long.parseLong(id);
        ArticleEntity article = articleRepository.findOne(articleId);
        if(map.containsKey("name")){
            article.setArticleName(map.get("name"));
        }
        if(map.containsKey("content")){
            article.setArticleContent(map.get("content"));
        }
        articleRepository.save(article);
        return true;
    }

    /**
     * 分页查询所有文章
     * @param page
     * @param size
     * @return
     */
    public Page<ArticleEntity> findAll(int page,int size){
        Page<ArticleEntity> list = articleRepository.findAll(new PageRequest(page, size, new Sort(new Sort.Order(Sort.Direction.DESC, "time"))));
        return list;
    }

    /**
     * 查询某一篇文章信息
     * @param articleId
     * @return
     */
    public ArticleEntity findOne(Long articleId){
        ArticleEntity article = articleRepository.findOne(articleId);
        return article;
    }
}
