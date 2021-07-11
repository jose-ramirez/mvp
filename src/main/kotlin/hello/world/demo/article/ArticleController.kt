package hello.world.demo.article

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ArticleController {
    @Autowired
    private lateinit var articleService: ArticleService

    @GetMapping("/api/articles")
    fun getArticles(): ResponseEntity<List<Article>> = ResponseEntity.ok(articleService.getArticles())
}