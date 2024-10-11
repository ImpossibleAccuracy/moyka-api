package org.ksystem.app.domain.model

import org.ksystem.app.domain.model.security.Role

interface Account : BaseModel {
    var username: String
    var password: String

    val roles: Iterable<Role>
}
