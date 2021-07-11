package hello.world.demo.article

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId

@Document("articles")
data class Article(@MongoId val id: ObjectId? = null, val text: String)