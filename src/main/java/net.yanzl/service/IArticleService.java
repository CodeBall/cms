package net.yanzl.service;


import net.yanzl.entity.ArticleEntity;
import org.springframework.data.domain.Page;
import java.util.Map;

/**
 * 文章Service层,完成文章的所有操作
 * Created by xqq on 16-4-17.
 */
public interface IArticleService {
    ArticleEntity addArticle(String articleName,String articleContent,String time,int del,Long uid,Long cid);
    boolean deleteArticle(Long articleId);
    boolean updateArticle(Map<String,String>map);
    Page<ArticleEntity> findAll(int page,int size);
    //Page<ArticleEntity> findMine(Long uid,Integer page,Integer size);
    ArticleEntity findOne(Long articleId);
}
