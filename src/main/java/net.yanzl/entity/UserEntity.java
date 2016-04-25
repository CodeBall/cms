package net.yanzl.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

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
    private Set<ArticleEntity> articles = new HashSet<ArticleEntity>();

    public UserEntity() {
    }

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Column(name = "userName",nullable = false,unique = true,length = 30)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "password",nullable = false,length = 30)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "email",nullable = false,unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 定义用户和文章的关系,一对多的关系
     */
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    @OrderBy("uid")
    public Set<ArticleEntity> getArticles() {
        return articles;
    }


    public void setArticles(Set<ArticleEntity> articles) {
        this.articles = articles;
    }
}