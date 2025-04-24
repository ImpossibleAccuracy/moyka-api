package org.ksystem.app.domain.model

import org.ksystem.app.domain.model.base.BaseModel
import org.ksystem.app.domain.model.security.RoleDomain

interface AccountDomain : BaseModel {
    var username: String
    var password: String
    var firstName: String
    var middleName: String
    var lastName: String
    var email: String
    var phone: String
    var role: RoleDomain
}
