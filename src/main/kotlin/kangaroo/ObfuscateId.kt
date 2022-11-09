package kangaroo

import java.util.UUID

class ObfuscateId {

  fun obfuscated(value: String): UUID = UUID.nameUUIDFromBytes(value.toByteArray())
}
