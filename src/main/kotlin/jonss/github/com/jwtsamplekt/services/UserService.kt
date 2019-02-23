package jonss.github.com.jwtsamplekt.services

import jonss.github.com.jwtsamplekt.models.User
import jonss.github.com.jwtsamplekt.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {


    @Autowired
    private lateinit var userRepository: UserRepository

    fun create(user: User): User {
        return userRepository.save(user)
    }

}
