package hello.world.demo.user

import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository: MongoRepository<User, ObjectId>{
    fun findByEmail(email: String): User?
}