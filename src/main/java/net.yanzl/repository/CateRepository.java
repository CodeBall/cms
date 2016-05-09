package net.yanzl.repository;

import net.yanzl.entity.CateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Cate相关DAO
 * Created by yzl on 16-4-17.
 */
@Repository
public interface CateRepository extends JpaRepository<CateEntity,Long> {

    /**
     * 根据id查找分类
     * @param cateId
     * @return
     */
    @Query("SELECT c FROM CateEntity c WHERE c.cateId = :cateId")
    CateEntity getCateByCateId(@Param("cateId")Long cateId);
}
