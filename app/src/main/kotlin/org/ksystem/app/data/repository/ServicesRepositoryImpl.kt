package org.ksystem.app.data.repository

import org.ksystem.app.data.datasource.ServiceDataSource
import org.ksystem.app.domain.model.ServiceDomain
import org.ksystem.app.domain.repository.ServicesRepository

class ServicesRepositoryImpl(
    private val serviceDataSource: ServiceDataSource,
) : ServicesRepository {
    override suspend fun getAll(): List<ServiceDomain> =
        serviceDataSource.getAll()
}