package net.yanzl.service;

import net.yanzl.entity.CateEntity;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 文章类型Service层,完成文章类型的基本操作
 * Created by xqq on 16-4-17.
 */
public interface ICateService {
    CateEntity addCate(String cateName,Long parent,Date date);
    boolean deleteCate(Long cateId);
    boolean updateCate(Map<String,String>map,CateEntity cate);
    List<CateEntity> findAll();
    CateEntity findOne(Long cateId);
}
