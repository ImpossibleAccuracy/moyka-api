package org.ksystem.app.domain.repository

import org.ksystem.app.domain.model.ServiceDomain

interface ServicesRepository {
    suspend fun getAll(): List<ServiceDomain>
}