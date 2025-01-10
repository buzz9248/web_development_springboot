package me.moonchangbae.springbootdeveloper.dto;

import lombok.Getter;
import me.moonchangbae.springbootdeveloper.domain.Article;

@Getter
public class ArticleListViewResponse {
    private final Long id;
    private final String title;
    private final String content;

    public ArticleListViewResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
    }
    /*
        다 작성 후 controller 패키지에
        BlogViewController 파일 생성.
     */

}
