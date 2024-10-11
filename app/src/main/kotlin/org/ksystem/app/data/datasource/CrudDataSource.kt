package org.ksystem.app.data.datasource

import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.ksystem.app.data.base.BaseDao
import org.ksystem.app.data.base.ModelImpl
import org.ksystem.app.data.database.utils.exists
import org.ksystem.app.data.exceptions.EntityNotFoundException
import org.ksystem.app.domain.model.BaseModel
import org.ksystem.app.domain.model.Id
import org.ksystem.app.utils.ioCall

@Suppress("UNCHECKED_CAST")
abstract class CrudDataSource<T : BaseModel, I : ModelImpl>(
    private val dao: BaseDao<I>,
) {
    suspend fun save(block: T.() -> Unit): T = ioCall {
        dao.new {
            block(this as T)
        } as T
    }

    suspend fun save(id: Id, block: T.() -> Unit): T = ioCall {
        val entity = dao
            .findByIdAndUpdate(id) {
                block(it as T)
            } as T?

        entity ?: throw EntityNotFoundException()
    }

    suspend fun existsById(id: Id): Boolean = ioCall {
        dao.exists(dao.table.id eq id)
    }


    suspend fun findById(id: Id): T? = ioCall {
        dao.findById(id) as T?
    }

    suspend fun getAll(): List<T> = ioCall {
        dao.all().toList() as List<T>
    }

    suspend fun deleteById(id: Id): Boolean = ioCall {
        dao.table.deleteWhere {
            dao.table.id eq id
        } > 0
    }
}