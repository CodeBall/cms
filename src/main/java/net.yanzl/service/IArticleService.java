package net.yanzl.service;


import net.yanzl.entity.ArticleEntity;
import net.yanzl.entity.UserEntity;
import org.springframework.data.domain.Page;
import java.util.Map;

/**
 * 文章Service层,完成文章的所有操作
 * Created by xqq on 16-4-17.
 */
public interface IArticleService {
    ArticleEntity addArticle(String articleName,String articleContent,String time,String auther,UserEntity user);
    boolean deleteArticle(Long articleId);
    boolean updateArticle(Map<String,String>map,ArticleEntity article);
    Page<ArticleEntity> findAll(int start,int num);
    ArticleEntity findOne(Long articleId);
    Long articleCount(Long id);
}
