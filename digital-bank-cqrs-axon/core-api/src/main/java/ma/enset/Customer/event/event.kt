package ma.enset.Customer.event

abstract class BaseEvent<T>(
        open val id : T
)
data class CustomerCreatedEvent(
        override val id: String,
        val name: String,
        val email: String
) : BaseEvent<String>(id)


data class CustomrUpdatedEvent(
        override val id: String,
        val  name: String,
        val email: String
): BaseEvent<String>(id)
