package kangaroo

import io.mockk.junit5.MockKExtension
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.*

@ExtendWith(MockKExtension::class)
class GenerateTokenTest {

  private val subject = GenerateToken()

  @Test
  fun `given id when perform generate token then return a JWT token`() {
    val id = UUID.randomUUID()

    val token = subject.generate(id)

    assertThat(token).isNotNull
  }

  @Test
  fun `given a jwt token when decode then return id`() {
    val token =
      "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpZC1jbGFpbSI6IjVkODA4NjA5LTc2ZjMtNGU0Zi1iMjY1LTZjZjVjOTg2MzZkNCIsImlzcyI6InNkZHRjIiwiZXhwIjoxNjY4MDc3NTgxLCJpYXQiOjE2Njc5OTExODF9.vT57RpDvqMxFAxP6O3PoQDS8TYr2TF_ZR0UiANoNi9DXgzK4U_dPXJCNgi2HytElcWNa7hQu-NWsIbGLTEOi0A"

    val id = subject.decode(token)

    assertThat(id).isEqualTo("5d808609-76f3-4e4f-b265-6cf5c98636d4")
  }
}
