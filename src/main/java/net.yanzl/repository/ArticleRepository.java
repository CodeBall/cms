package net.yanzl.repository;

import net.yanzl.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xqq on 16-4-17.
 */
@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity,Long> {
}
