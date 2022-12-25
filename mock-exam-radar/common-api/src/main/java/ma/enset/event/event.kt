package ma.enset.event

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
