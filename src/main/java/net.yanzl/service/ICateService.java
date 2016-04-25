package net.yanzl.service;

import net.yanzl.entity.CateEntity;
import org.springframework.data.domain.Page;
import java.util.Map;

/**
 * 文章类型Service层,完成文章类型的基本操作
 * Created by xqq on 16-4-17.
 */
public interface ICateService {
    CateEntity addCate(String cateName,String date,Long parent);
    CateEntity addCate(String cateName,String date);
    CateEntity addCate(String cateName);
    boolean deleteCate(Long cateId);
    boolean updateCate(Map<String,String>map);
    Page<CateEntity> findAll(int page,int size);
}
