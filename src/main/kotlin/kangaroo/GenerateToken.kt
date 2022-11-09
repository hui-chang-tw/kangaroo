package kangaroo

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.interfaces.DecodedJWT
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.*

class GenerateToken {
  private val secret = "I am a secret stored in the server"
  private val algorithm: Algorithm = Algorithm.HMAC512(secret)
  private val idClaimName = "id-claim"

  fun generate(value: UUID): String {

    return JWT.create()
      .withClaim(idClaimName, value.toString())
      .withIssuedAt(Instant.now())
      .withIssuer("sddtc")
      .withExpiresAt(Instant.now().plus(1, ChronoUnit.DAYS))
      .sign(algorithm)
  }

  fun decode(token: String): String {
    val jwt: DecodedJWT = JWT.require(algorithm)
      .build()
      .verify(token)

    return jwt.getClaim(idClaimName).asString()
  }
}
