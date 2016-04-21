package net.yanzl.repository;

import net.yanzl.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xqq on 16-4-16.
 */
/**
 * User相关DAO
 * Created by yzl on 16-4-16.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    /**
     * 根据email查找用户
     */
    @Query("SELECT u FROM UserEntity u WHERE u.email = :email")
    UserEntity getUserByEmail(@Param("email")String email);

    /**
     * 根据用户名查询用户
     */
    @Query("SELECT u FROM UserEntity u WHERE u.userName = :userName")
    UserEntity getUserByUserName(@Param("userName")String userName);
    /**
     * 根据用户id删除用户信息
     */
//    @Query("DELETE  FROM UserEntity u WHERE u.userId = :userId")
//    boolean deleteUserById(@Param("userId")Long userTd);
}
