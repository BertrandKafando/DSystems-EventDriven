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

data class Owner (
        var id:String,
        var name: String,
        var email: String,
        );


data class CreateVehicleCommand(
        override val id: String,
        val matricule: String,
        val brand: String,
        val puissance: Long,
        val model: String,
        val owner: Owner

): BaseCommand<String>(id)

data class UpdateVehicleCommand(
        override  val id:String,
        val matricule:String,
        val brand:String,
        val puissance:Long,
        val model: String,
        val owner: Owner

): BaseCommand<String>(id)


data class CreateOwnerCommand(
        override val id:String,
        val name: String,
        val email: String,

):BaseCommand<String>(id)


data class UpdateOwnerCommand(
        override val id:String,
        val name: String,
        val email: String,

        ):BaseCommand<String>(id)
