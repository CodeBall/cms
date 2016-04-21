package net.yanzl.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CateEntity.class)
public abstract class CateEntity_ {

	public static volatile SingularAttribute<CateEntity, String> date;
	public static volatile SingularAttribute<CateEntity, Long> cateId;
	public static volatile SingularAttribute<CateEntity, String> cateName;
	public static volatile SingularAttribute<CateEntity, Long> parentId;
	public static volatile SetAttribute<CateEntity, ArticleEntity> article;

}

