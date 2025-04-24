package org.ksystem.app.domain.repository

import org.ksystem.app.domain.model.Id
import org.ksystem.app.domain.model.ServiceDomain

interface ServicesRepository {
    suspend fun getAll(): List<ServiceDomain>

    suspend fun exists(id: Id): Boolean
}