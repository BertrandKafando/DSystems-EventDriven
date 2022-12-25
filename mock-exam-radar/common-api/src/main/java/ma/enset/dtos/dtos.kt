package ma.enset.dtos

import ma.enset.Owner

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





data class OwnerDTO(
        val name: String,
        val email: String,

        );

