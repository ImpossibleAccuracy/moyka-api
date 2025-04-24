package org.ksystem.app.server.feature.order

import io.ktor.resources.*
import org.ksystem.app.server.feature.BaseRoutes

@Resource("/order")
class OrderRoute(
    @Suppress("unused") val parent: BaseRoutes = BaseRoutes()
) {
    @Resource("/services")
    class Services(
        @Suppress("unused") val parent: OrderRoute = OrderRoute()
    )

    @Resource("/my")
    class My(
        @Suppress("unused") val parent: OrderRoute = OrderRoute()
    )

    @Resource("/all")
    class All(
        @Suppress("unused") val parent: OrderRoute = OrderRoute()
    )

    @Resource("/create")
    class Create(
        @Suppress("unused") val parent: OrderRoute = OrderRoute()
    )

    @Resource("/update-status")
    class UpdateStatus(
        @Suppress("unused") val parent: OrderRoute = OrderRoute()
    )
}