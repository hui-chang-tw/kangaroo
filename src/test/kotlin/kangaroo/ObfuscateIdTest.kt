package kangaroo

import io.mockk.junit5.MockKExtension
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.UUID

@ExtendWith(MockKExtension::class)
class ObfuscateIdTest {

  private val subject: ObfuscateId = ObfuscateId()

  @Test
  fun `given string when obfuscated then return uuid`() {
    val input = "abc123www"

    val result = subject.obfuscated(input)
    val runAgain = subject.obfuscated(input)

    assertThat(result).isEqualTo(runAgain)
  }

  @Test
  fun `given a uuid string when obfuscated then return uuid`() {
    val input = UUID.randomUUID().toString()

    val result = subject.obfuscated(input)
    val runAgain = subject.obfuscated(input)

    assertThat(result).isEqualTo(runAgain)
  }
}
