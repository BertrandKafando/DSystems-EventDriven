package ma.enset.Customer.command;

import lombok.Getter;

@Getter
public class UpdateCustomerCommand extends BaseCommand<String> {
    private String name;
    private String email;

    public UpdateCustomerCommand(String id, String name, String email) {
        super(id);
        this.name = name;
        this.email = email;
    }
}
