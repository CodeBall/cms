package net.yanzl.service.impl;

import net.yanzl.entity.CateEntity;
import net.yanzl.repository.CateRepository;
import net.yanzl.service.ICateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * Created by xqq on 16-4-21.
 */
@Service
@Transactional
public class CateServiceImpl implements ICateService {

    @Autowired
    private CateRepository cateRepository;

    /**
     * 保存文章分类信息
     * @param cateName
     * @param date
     * @param parent
     * @return
     */
    public CateEntity addCate(String cateName,String date,Long parent){
        CateEntity cate = new CateEntity(cateName,date,parent);
        cateRepository.save(cate);
        return cate;
    }
    public CateEntity addCate(String cateName,String date){
        CateEntity cate = new CateEntity(cateName,date);
        cateRepository.save(cate);
        return cate;
    }
    public CateEntity addCate(String cateName){
        CateEntity cate = new CateEntity(cateName);
        cateRepository.save(cate);
        return cate;
    }

    /**
     * 删除文章分类信息
     * @param cateId
     * @return
     */
    public boolean deleteCate(Long cateId){
        cateRepository.delete(cateId);
        if(cateRepository.exists(cateId))
            return false;
        else
            return true;
    }

    /**
     * 更新文章分类
     * @param map
     * @return
     */
    public boolean updateCate(Map<String,String> map){
        String id = map.get("id");
        Long cateId = Long.parseLong(id);
        CateEntity cate = cateRepository.findOne(cateId);

        if(map.containsKey("name")){
            cate.setCateName(map.get("name"));
        }
        if(map.containsKey("parent")){
            cate.setParentId(Long.parseLong(map.get("parent")));
        }

        cateRepository.save(cate);

        return true;
    }

    /**
     * 分页查找所有分类
     * @param page
     * @param size
     * @return
     */
    public Page<CateEntity> findAll(int page,int size){
        Page<CateEntity> list = cateRepository.findAll(new PageRequest(page, size, new Sort(new Sort.Order(Sort.Direction.DESC, "date"))));
        return list;
    }

    /**
     * 一次性查询所有分类
     * @return
     */
    public List<CateEntity> getAll(){
        return cateRepository.findAll();
    }

    /**
     * 查询某一个分类
     * @param cateId
     * @return
     */
    public CateEntity getCate(Long cateId){
        return cateRepository.getCateByCateId(cateId);
    }
}
