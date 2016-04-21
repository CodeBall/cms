package net.yanzl.service.impl;

import net.yanzl.entity.UserEntity;
import net.yanzl.repository.ArticleRepository;
import net.yanzl.entity.ArticleEntity;
import net.yanzl.repository.UserRepository;
import net.yanzl.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    /**
     * 添加文章
     * 添加文章时,涉及到uid和cid没有写入
     * @param articleName
     * @param articleContent
     * @param time
     * @param auther
     * @return
     */
    public ArticleEntity addArticle(String articleName,String articleContent,String time,String auther,UserEntity user){
        ArticleEntity article = new ArticleEntity(articleName,articleContent,time,auther);
        article.setUser(user);
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
     * @param article
     * @return
     */
    public boolean updateArticle(Map<String,String> map,ArticleEntity article){
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
     * @param start
     * @param num
     * @return
     */
    public Page<ArticleEntity> findAll(int start,int num){
        Page<ArticleEntity> list = articleRepository.findAll(new PageRequest(start,num,new Sort(new Sort.Order(Sort.Direction.DESC,"time"))));
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

    /**
     * 查询文章总数目
     */
    public Long articleCount(Long id){
        return articleRepository.count();
    }
}
