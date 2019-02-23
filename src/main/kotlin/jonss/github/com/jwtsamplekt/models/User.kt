package jonss.github.com.jwtsamplekt.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
data class User(
        @Id
        @GeneratedValue
        val id: Long = 0,
        val fullName: String = "",
        val email: String = "",
        var password: String = ""
)
