package net.yanzl.repository;

import net.yanzl.entity.CateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Cate相关DAO
 * Created by yzl on 16-4-17.
 */
@Repository
public interface CateRepository extends JpaRepository<CateEntity,Long> {
}
