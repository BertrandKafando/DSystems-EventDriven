package ma.enset.dtos

import ma.enset.Owner
import java.util.*

data class RadarCommandDTO (
        var maxSpeed: Long,
        var longitude: String,
        var latitude: String
        );


data class VehiculeCommandDTO (
        val matricule:String,
        val brand:String,
        val puissance:Long,
        val model: String,
        val owner: Owner
        );


data class InfractionDTO (
        val date: Date,
        val radarNumber: String,
        val matriculeVehicle: String,
        val speedVehicle: Double,
        val radarSpeedMax: Double,
        val montant: Double
);



data class OwnerDTO(
        val name: String,
        val email: String,

        );

