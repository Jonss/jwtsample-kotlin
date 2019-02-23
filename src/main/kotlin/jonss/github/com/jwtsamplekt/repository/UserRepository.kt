package jonss.github.com.jwtsamplekt.repository

import jonss.github.com.jwtsamplekt.models.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
    fun findByEmail(email: String?): User?

}
