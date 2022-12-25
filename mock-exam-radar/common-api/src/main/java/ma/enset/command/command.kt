package ma.enset

import org.axonframework.modelling.command.TargetAggregateIdentifier

abstract class BaseCommand<T>(
        @TargetAggregateIdentifier
        open val id : T
)

//Radar

data class CreateRadarCommand (
        override val id:String,
        val maxSpeed: Long,
        val longitude: String,
        val latitude: String

        ):BaseCommand<String>(id)


data class UpdateRadarCommand (
        override val id:String,
        val maxSpeed: Long,
        val longitude: String,
        val latitude: String

):BaseCommand<String>(id)
