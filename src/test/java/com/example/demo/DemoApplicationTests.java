package com.example.demo;

import com.example.demo.article.Article;
import com.example.demo.article.ArticleRepository;
import com.example.demo.article.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class Test11ApplicationTests {

	@Autowired
	private ArticleRepository articleRepository;


	@Test
	void contextLoads() {
		Article ta = new Article();
		ta.setTitle("제목");
		ta.setContent("내용");
		ta.setCreateDate(LocalDateTime.now());
		this.articleRepository.save(ta);
	}

	@Autowired
	private ArticleService articleService;

	@Test
	void testJpa() {
		for (int i = 1; i <= 300; i++) {
			String subject = String.format("테스트 데이터입니다:[%03d]", i);
			String content = "내용무";
			this.articleService.create(subject, content, null);
		}
	}

}