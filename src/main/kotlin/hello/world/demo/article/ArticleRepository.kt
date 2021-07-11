package hello.world.demo.article

import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface ArticleRepository: MongoRepository<Article, ObjectId>