package net.yanzl.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
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
    private Date time;
    private String auther;
    private int del;

    public ArticleEntity(String articleName,String articleContent,Date time,String auther,int del){
        this.articleName = articleName;
        this.articleContent = articleContent;
        this.time = time;
        this.auther = auther;
        this.del = del;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleContent() {return articleContent;}

    public void setArticleContent(String articleContent) {this.articleContent = articleContent;}

    public Date getTime() { return time;}

    public void setTime(Date time) {this.time = time;}

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public int getDel() {
        return del;
    }

    public void setDel(int del) {
        this.del = del;
    }
}