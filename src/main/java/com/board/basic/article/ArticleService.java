package com.board.basic.article;

import com.board.basic.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public void create(String title, String content, SiteUser author) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setAuthor(author);
        article.setCreateDate(LocalDateTime.now());

        this.articleRepository.save(article);

    }

    public Article getArticle(Integer id) {
        Optional<Article> article = this.articleRepository.findById(id);
        return article.get();
    }

    public List<Article> getList(String keyword) {
        return this.articleRepository.findAllByKeyword(keyword);
    }

    public void delete (Article article) {
        this.articleRepository.delete(article);
    }

    public void deleteById (Integer id) {
        this.articleRepository.deleteById(id);
    }

    public void modify(Article article, String title, String content) {
        article.setTitle(title);
        article.setContent(content);
        this.articleRepository.save(article);
    }

}
