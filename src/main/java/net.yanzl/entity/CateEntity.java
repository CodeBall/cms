package net.yanzl.entity;


import javax.persistence.*;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cate")
public class CateEntity{
    private long cateId;
    private String cateName;
    private long parentId;
    private String date;
    private Set<ArticleEntity> article = new HashSet<ArticleEntity>();

    public CateEntity(){}

    public CateEntity(String cateName){
        this.cateName = cateName;
        this.parentId = 0;
        this.date = "1970-01-01 00:00:00";
    }
    public CateEntity(String cateName, String date){
        this.cateName = cateName;
        this.parentId = 0;
        this.date = date;
    }
    public CateEntity(String cateName, String date, long parentId){
        this.cateName = cateName;
        this.parentId = parentId;
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cateId")
    public long getCateId() {return cateId;}

    public void setCateId(long cateId) {this.cateId = cateId;}

    @Column(name = "cateName",unique = true,nullable = false,length = 200)
    public String getCateName() {return cateName;}

    public void setCateName(String cateName) {this.cateName = cateName;}

    @Column(name = "parentId")
    public long getParentId() {return parentId;}

    public void setParentId(long parientId) {this.parentId = parientId;}

    @Column(name = "date")
    public String getDate() {return date;}

    public void setDate(String date) {this.date = date;}

    /**
     * 文章类型类和文章类的关系:One-to-Many
     */
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "cate")
    @OrderBy("cid")
    public Set<ArticleEntity> getArticle() {
        return article;
    }

    public void setArticle(Set<ArticleEntity> article) {
        this.article = article;
    }
}