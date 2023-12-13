package com.board.basic.article;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    @Query("select "
            + "distinct a "
            + "from Article a "
            + "left outer join SiteUser u on a.author=u "
            + "where "
            + "   a.title like %:keyword% "
            + "   or a.content like %:keyword% "
            + "   or u.email like %:keyword% "
            + "   or u.nickname like %:keyword% ")
    List<Article> findAllByKeyword(@Param("keyword") String keyword);
}