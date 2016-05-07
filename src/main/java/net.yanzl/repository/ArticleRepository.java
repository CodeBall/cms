package net.yanzl.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.yanzl.entity.ArticleEntity;




/**
 * Created by xqq on 16-4-17.
 */
@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity,Long> {

    //从文章表中获取uid为uid的文章数据
   /* @Query("SELECT a FROM ArticleEntity a WHERE a.uid= :uid")
    Page<ArticleEntity> getArticleByUid(@Param("uid")Long uid,Pageable pageable);*/
}
