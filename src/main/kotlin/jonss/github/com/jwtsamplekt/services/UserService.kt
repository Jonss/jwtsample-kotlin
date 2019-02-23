package jonss.github.com.jwtsamplekt.services

import jonss.github.com.jwtsamplekt.models.User
import jonss.github.com.jwtsamplekt.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService {


    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var bCryptPasswordEncoder: BCryptPasswordEncoder

    fun create(user: User): User {
        user.password = bCryptPasswordEncoder.encode(user.password)
        return userRepository.save(user)
    }

}
