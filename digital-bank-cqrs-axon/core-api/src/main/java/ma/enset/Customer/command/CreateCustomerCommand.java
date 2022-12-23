package ma.enset.Customer.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
public class CreateCustomerCommand extends BaseCommand<String> {
    private String id;
    private String name;
    private String email;

    public CreateCustomerCommand(String id, String name, String email) {
        super(id);
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
