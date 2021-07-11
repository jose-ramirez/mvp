package hello.world.demo.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {
    @Autowired
    private lateinit var userService: UserService

    @GetMapping("/api/user")
    fun getUserByEmail(@RequestParam email:String): ResponseEntity<User?> = ResponseEntity.ok(userService.getUser(email))
}