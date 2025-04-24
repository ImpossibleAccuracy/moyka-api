package org.ksystem.app.server.feature.order

import io.ktor.server.routing.*
import org.ksystem.app.server.feature.order.routes.*

fun Routing.orderRoutes() {
    serviceListRoute()
    getAllOrdersRoute()
    getMyOrdersRoute()
    createOrderRoute()
    updateOrderStatusRoute()
}
