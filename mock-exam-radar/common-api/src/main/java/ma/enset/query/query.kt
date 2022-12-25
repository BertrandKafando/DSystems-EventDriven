package ma.enset.query

class  GetAllRadarQuery  {}
class GetRadarByIdQuery (val id: String) {}

class GetAllVehiclesQuery {}
class GetVehicleByIdQuery (val id: String) {}

class GetVehicleByOwnerQuery(val id: String) {}

class GetOwnerVehicles(val id:String){}
class GetAllOwners {}
class GetOwnerByIdQuery (val id: String) {}


class GetAllInfractionsQuery{}
class GetInfractioByIdQuery(val id: String) {}

class GetInfractionVehicleQuery(val id: String) {}
class GetInfractionRadarQuery(val id: String) {}
class GetInfractionParsonQuery(val id: String) {}

