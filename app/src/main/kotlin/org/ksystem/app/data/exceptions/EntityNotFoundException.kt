package org.ksystem.app.data.exceptions

import org.ksystem.app.domain.exception.ServiceException

class EntityNotFoundException : ServiceException("Entity not found", 500)

