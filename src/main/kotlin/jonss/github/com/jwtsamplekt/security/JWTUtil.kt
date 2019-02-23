package jonss.github.com.jwtsamplekt.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

@Component
class JWTUtil {

    @Value("\${jwt.secret}")
    private lateinit var secret: String

    private val expiration: Long = 60000

    fun generateToken(username: String): String {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret.toByteArray())
                .compact()
    }

}
