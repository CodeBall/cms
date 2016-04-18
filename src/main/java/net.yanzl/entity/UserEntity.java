package net.yanzl.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.lang.String;

/**
 *用户基本信息表
 */

@Entity
@Table(name="users")
public class UserEntity{
    private long userId;
    private String userName;
    private String password;
    private String email;

    /**
     *
     * @param userName
     * @param password
     * @param email
     */
    public UserEntity(String userName,String password,String email){
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}