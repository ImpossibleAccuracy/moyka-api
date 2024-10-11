package org.ksystem.app.data.base

import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.id.EntityID
import org.ksystem.app.domain.model.Id

abstract class ModelImpl(id: EntityID<Id>, table: BaseTable) : IntEntity(id) {
    var idValue: Id
        get() = id.value
        set(value) {
            id._value = value
        }

    val createdAt: LocalDateTime by table.createdAt
    var updatedAt: LocalDateTime? by table.updatedAt
}