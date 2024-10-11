package org.ksystem.app.data.model

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.id.EntityID
import org.ksystem.app.data.database.table.RoleTable
import org.ksystem.app.domain.model.Id
import org.ksystem.app.domain.model.security.Role

class RoleEntity(id: EntityID<Id>) : IntEntity(id) {
    private var title by RoleTable.title

    var role: Role
        get() = Role.entries.first { it.roleName == title }
        set(value) {
            title = value.roleName
        }
}
