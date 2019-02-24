package jonss.github.com.jwtsamplekt.controllers

import jonss.github.com.jwtsamplekt.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/users")
class UserController{

    @Autowired
    private lateinit var userService: UserService

    @GetMapping("/me")
    fun me() = ResponseEntity.ok(userService.myself()!!)

}