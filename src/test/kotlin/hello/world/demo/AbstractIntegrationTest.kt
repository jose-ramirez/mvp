package hello.world.demo

import org.junit.jupiter.api.TestInstance
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.support.TestPropertySourceUtils
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@ActiveProfiles("test")
@Import(TestConfig::class)
@ContextConfiguration(
    initializers = [
        AbstractIntegrationTest.Companion.MongoInitializer::class
    ]
)
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AbstractIntegrationTest {
    companion object {
        @Container
        @JvmField
        val container = KGenericContainer("mongo:latest").apply {
            withExposedPorts(27017)
        }

        init {
            container.start()
        }

        class MongoInitializer : ApplicationContextInitializer<ConfigurableApplicationContext> {
            override fun initialize(context: ConfigurableApplicationContext) {
                TestPropertySourceUtils.addInlinedPropertiesToEnvironment(
                    context,
                    "database.url=${container.containerIpAddress}:${container.getMappedPort(27017)}"
                )
            }
        }
    }
}