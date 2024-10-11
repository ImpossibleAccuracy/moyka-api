package org.ksystem.app.data.datasource

import org.ksystem.app.data.database.dao.RoleDao
import org.ksystem.app.data.model.RoleEntity
import org.ksystem.app.utils.ioCall

class RoleDataSource {
    suspend fun save(block: RoleEntity.() -> Unit): RoleEntity = ioCall {
        RoleDao.new(block)
    }

    suspend fun getAll(): List<RoleEntity> = ioCall {
        RoleDao.all().toList()
    }
}