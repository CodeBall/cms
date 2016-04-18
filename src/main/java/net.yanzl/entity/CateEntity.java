package net.yanzl.entity;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.lang.String;
import java.util.Date;

@Entity
@Table(name = "cate")
public class CateEntity{
    private long cateId;
    private String cateName;
    private long parentId;
    private Date date;

    public long getCateId() {return cateId;}

    public void setCateId(long cateId) {this.cateId = cateId;}

    public String getCateName() {return cateName;}

    public void setCateName(String cateName) {this.cateName = cateName;}

    public CateEntity(String cateName){this.cateName = cateName;}

    public long getParentId() {return parentId;}

    public void setParentId(long parientId) {this.parentId = parientId;}

    public Date getDate() {return date;}

    public void setDate(Date date) {this.date = date;}
}