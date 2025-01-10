package me.moonchangbae.springbootdeveloper.repository;

import me.moonchangbae.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {



}
