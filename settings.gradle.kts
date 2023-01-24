
rootProject.name = "sucredito-ibsclient-all"


include("module:sdn:commons:sdncommons-text")
findProject(":module:sdn:commons:sdncommons-text")?.name = "sdncommons-text"

include("module:sdn:commons:sdncommons-jdbc")
findProject(":module:sdn:commons:sdncommons-jdbc")?.name = "sdncommons-jdbc"


include("module:sdn:data:ibs:sdndata-ibsjdbc")
findProject(":module:sdn:data:ibs:sdndata-ibsjdbc")?.name = "sdndata-ibsjdbc"

include("module:sdn:data:ibs:sdndata-ibsconn")
findProject(":module:sdn:data:ibs:sdndata-ibsconn")?.name = "sdndata-ibsconn"

include("module:sdn:data:ibs:sdndata-ibspool")
findProject(":module:sdn:data:ibs:sdndata-ibspool")?.name = "sdndata-ibspool"

include("module:ibs:entidad:sucreditoibs-entidad-api")
findProject(":module:ibs:entidad:sucreditoibs-entidad-api")?.name = "sucreditoibs-entidad-api"

include("module:ibs:entidad:sucreditoibs-entidad-impl")
findProject(":module:ibs:entidad:sucreditoibs-entidad-impl")?.name = "sucreditoibs-entidad-impl"


include("module:ibs:entidad:sucreditoibs-transfer-api")
findProject(":module:ibs:entidad:sucreditoibs-transfer-api")?.name = "sucreditoibs-transfer-api"

include("module:ibs:entidad:sucreditoibs-transfer-impl")
findProject(":module:ibs:entidad:sucreditoibs-transfer-impl")?.name = "sucreditoibs-transfer-impl"

include("module:client:sucredito-ibsclient-api")
findProject(":module:client:sucredito-ibsclient-api")?.name = "sucredito-ibsclient-api"

include("module:client:sucredito-ibsclient-impl")
findProject(":module:client:sucredito-ibsclient-impl")?.name = "sucredito-ibsclient-impl"

include("module:client:sucredito-ibsclient-shell")
findProject(":module:client:sucredito-ibsclient-shell")?.name = "sucredito-ibsclient-shell"