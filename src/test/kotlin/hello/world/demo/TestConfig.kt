package hello.world.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@TestConfiguration
class TestConfig {
    @Autowired
    private lateinit var webApplicationContext: WebApplicationContext

    @Bean
    fun myMockMvc() =  MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
}