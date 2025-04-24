package org.ksystem.app.data.model

import org.jetbrains.exposed.dao.id.EntityID
import org.ksystem.app.data.base.ModelImpl
import org.ksystem.app.data.database.table.AccountTable
import org.ksystem.app.domain.model.AccountDomain
import org.ksystem.app.domain.model.Id
import org.ksystem.app.domain.model.security.RoleDomain

class AccountEntity(id: EntityID<Id>) : AccountDomain, ModelImpl(id, AccountTable) {
    override var username: String by AccountTable.username
    override var password: String by AccountTable.password
    override var firstName: String by AccountTable.firstName
    override var middleName: String by AccountTable.middleName
    override var lastName: String by AccountTable.lastName
    override var email: String by AccountTable.email
    override var phone: String by AccountTable.phone
    private var roleName by AccountTable.role

    override var role: RoleDomain
        get() = RoleDomain.entries.first {
            it.roleName == roleName
        }
        set(value) {
            roleName = value.roleName
        }
}