package net.yanzl.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArticleEntity.class)
public abstract class ArticleEntity_ {

	public static volatile SingularAttribute<ArticleEntity, CateEntity> cate;
	public static volatile SingularAttribute<ArticleEntity, String> articleName;
	public static volatile SingularAttribute<ArticleEntity, Long> articleId;
	public static volatile SingularAttribute<ArticleEntity, String> auther;
	public static volatile SingularAttribute<ArticleEntity, String> articleContent;
	public static volatile SingularAttribute<ArticleEntity, Integer> del;
	public static volatile SingularAttribute<ArticleEntity, String> time;
	public static volatile SingularAttribute<ArticleEntity, UserEntity> user;

}

