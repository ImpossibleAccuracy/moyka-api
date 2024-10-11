package org.ksystem.app.data.model

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.SizedIterable
import org.ksystem.app.data.base.ModelImpl
import org.ksystem.app.data.database.dao.RoleDao
import org.ksystem.app.data.database.table.AccountTable
import org.ksystem.app.data.database.table.refs.AccountRoleRef
import org.ksystem.app.domain.model.Account
import org.ksystem.app.domain.model.Id
import org.ksystem.app.domain.model.security.Role

class AccountEntity(id: EntityID<Id>) : Account, ModelImpl(id, AccountTable) {
    override var username: String by AccountTable.username
    override var password: String by AccountTable.password

    private val _roles: SizedIterable<RoleEntity> by RoleDao via AccountRoleRef
    override val roles: List<Role>
        get() = _roles.toList().map { it.role }
}