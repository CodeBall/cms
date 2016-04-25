package net.yanzl.entity;

import javax.persistence.*;
import java.lang.String;
import java.util.Date;

/**
 * 文章信息表
 */
@Entity
@Table(name = "article")
public class ArticleEntity{
    private long articleId;
    private String articleName;
    private String articleContent;
    private String time;
    private int del;
    private UserEntity user ;
    private CateEntity cate;

    public ArticleEntity(){}

    public ArticleEntity(String articleName,String articleContent,String time){
        this.articleName = articleName;
        this.articleContent = articleContent;
        this.time = time;
        this.del = 0;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "articleId")
    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    @Column(name = "articleName",nullable = false)
    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    @Column(name = "articleContent",nullable = false,length = 3000)
    public String getArticleContent() {return articleContent;}

    public void setArticleContent(String articleContent) {this.articleContent = articleContent;}

    @Column(name = "time",nullable = false)
    public String getTime() { return time;}

    public void setTime(String time) {this.time = time;}

    @Column(name = "del",nullable = false)
    public int getDel() {
        return del;
    }

    public void setDel(int del) {
        this.del = del;
    }

    /**
     * 定义文章和用户之间的关系,一对多的关系
     */
    @ManyToOne
    @JoinColumn(name = "uid")
    public UserEntity getUser(){
        return user;
    }
    /**
     * 定义文章和文章分类之间的关系,一对一的关系
     */
    @ManyToOne
    @JoinColumn(name = "cid")
    public CateEntity getCate(){
        return cate;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setCate(CateEntity cate) {
        this.cate = cate;
    }

}