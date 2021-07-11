package hello.world.demo

import hello.world.demo.article.Article
import hello.world.demo.article.ArticleRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

class ArticleAPITest: AbstractIntegrationTest() {

	@Autowired
	lateinit var articleRepository: ArticleRepository

	@Autowired
	lateinit var mockMvc: MockMvc

	@Test
	fun contextLoads() {
		articleRepository.deleteAll()
		articleRepository.save(Article(text = "lorem ipsum"))

		mockMvc.perform(MockMvcRequestBuilders.get("/api/articles"))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.status().isOk)
	}
}
