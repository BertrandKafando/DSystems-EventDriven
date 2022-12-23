package ma.enset.cqrsaxionfwk.commonapi.commands;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class CeateAccountCommand extends BaseCommand<String> {
    private double initialBalance;
    private String currency;
    public CeateAccountCommand(String id, double initialBalance, String currency) {
        super(id);
        this.initialBalance = initialBalance;
        this.currency = currency;
    }

}
