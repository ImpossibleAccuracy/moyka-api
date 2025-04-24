package org.ksystem.app.data.base

import org.jetbrains.exposed.dao.IntEntityClass
import kotlin.reflect.KClass

abstract class BaseDao<T : ModelImpl>(
    table: BaseTable,
    modelClass: KClass<T>
) : IntEntityClass<T>(table, modelClass.java) {
    // TODO: add createdAt and updatedAt fields
    /*init {
        EntityHook.subscribe { action ->
            if (action.changeType == EntityChangeType.Updated) {
                try {
                    action.toEntity(this)?.updatedAt = LocalDateTime.now()
                } catch (_: Exception) {
                }
            }
        }
    }*/
}
