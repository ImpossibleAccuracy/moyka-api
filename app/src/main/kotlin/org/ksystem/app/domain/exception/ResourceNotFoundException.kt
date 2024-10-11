package org.ksystem.app.domain.exception

class ResourceNotFoundException(message: String) : ServiceException(message, 404)