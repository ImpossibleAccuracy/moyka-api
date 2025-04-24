package org.ksystem.app.data.datasource

import org.ksystem.app.data.database.dao.ServiceDao
import org.ksystem.app.data.model.ServiceEntity
import org.ksystem.app.domain.model.ServiceDomain

class ServiceDataSource : CrudDataSource<ServiceDomain, ServiceEntity>(ServiceDao)