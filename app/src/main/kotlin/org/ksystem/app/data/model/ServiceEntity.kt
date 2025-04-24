package org.ksystem.app.data.model

import org.jetbrains.exposed.dao.id.EntityID
import org.ksystem.app.data.base.ModelImpl
import org.ksystem.app.data.database.table.ServiceTable
import org.ksystem.app.domain.model.Id
import org.ksystem.app.domain.model.ServiceDomain

class ServiceEntity(id: EntityID<Id>) : ServiceDomain, ModelImpl(id, ServiceTable) {
    override var name: String by ServiceTable.name
}