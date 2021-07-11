package hello.world.demo.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {
    @Autowired
    private lateinit var userRepository: UserRepository

    fun getUser(email: String): User? = userRepository.findByEmail(email)
}