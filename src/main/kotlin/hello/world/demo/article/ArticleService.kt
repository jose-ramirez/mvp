package hello.world.demo.article

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ArticleService {
    @Autowired
    lateinit var articleRepository: ArticleRepository

    fun getArticles(): List<Article> = articleRepository.findAll()
}