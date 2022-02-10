package jonss.github.com.jwtsamplekt.services

import jonss.github.com.jwtsamplekt.models.User
import jonss.github.com.jwtsamplekt.models.UserDetailsImpl
import jonss.github.com.jwtsamplekt.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.security.core.context.SecurityContextHolder



@Service
@RequiredArgsConstructor
class UserService (var userRepository: UserRepository, var bCryptPasswordEncoder: BCryptPasswordEncoder ){

    fun create(user: User): User {
        user.password = bCryptPasswordEncoder.encode(user.password)
        return userRepository.save(user)
    }

    fun myself(): String? {
        return userRepository.findByEmail(getCurrentUserEmail())?.fullName
    }

    private fun getCurrentUserEmail(): String? {
        val user = SecurityContextHolder.getContext().authentication.principal as UserDetailsImpl
        return user.username
    }

}
