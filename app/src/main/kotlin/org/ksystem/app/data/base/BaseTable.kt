package org.ksystem.app.data.base

import org.jetbrains.exposed.dao.id.IntIdTable

abstract class BaseTable(name: String) : IntIdTable(name)