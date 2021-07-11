package hello.world.demo.user

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId

@Document("users")
data class User(@MongoId val id: ObjectId? = null, val email: String)