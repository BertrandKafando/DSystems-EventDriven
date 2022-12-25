package ma.enset.event
import ma.enset.Owner

abstract class BaseEvent<T>(
        open val id : T
)

//Radar

data class RadarCreatedEvent(
        override val id:String,
        val maxSpeed: Long,
        val longitude: String,
        val latitude: String
): BaseEvent<String>(id)


data class RadarUpdatedEvent(
        override val id:String,
        val maxSpeed: Long,
        val longitude: String,
        val latitude: String
): BaseEvent<String>(id)


data class VehicleCreatedEvent(
        override  val id:String,
        val matricule:String,
        val brand:String,
        val puissance:Long,
        val model: String,
        val owner: Owner
): BaseEvent<String>(id)

data class VehicleUpdatedEvent(
        override  val id:String,
        val matricule:String,
        val brand:String,
        val model: String,
        val puissance:Long,
        val owner: Owner

): BaseEvent<String>(id)


data class OwnerUpdatedEvent(
        override val id:String,
        val name: String,
        val email: String,

        ): BaseEvent<String>(id)


data class OwnerCreatedEvent(
        override val id:String,
        val name: String,
        val email: String,

        ): BaseEvent<String>(id)
