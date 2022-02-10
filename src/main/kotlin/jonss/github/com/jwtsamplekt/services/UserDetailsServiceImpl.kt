package jonss.github.com.jwtsamplekt.services

import jonss.github.com.jwtsamplekt.models.UserDetailsImpl
import jonss.github.com.jwtsamplekt.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class UserDetailsServiceImpl (var userRepository: UserRepository): UserDetailsService {


    override fun loadUserByUsername(email: String?): UserDetails {
        val user = userRepository.findByEmail(email) ?: throw UsernameNotFoundException(email)

        return UserDetailsImpl(user)
    }
}