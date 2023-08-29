package models;

import lombok.Data;

@Data
public class ModelCurrency {

    private String currencyName;
    private String forexBuying;
    private String forexSelling;
    private String banknoteBuying;
    private String banknoteSelling;

    public ModelCurrency(String currencyName, String forexBuying, String forexSelling, String banknoteBuying, String banknoteSelling) {
        this.currencyName = currencyName;
        this.forexBuying = forexBuying;
        this.forexSelling = forexSelling;
        this.banknoteBuying = banknoteBuying;
        this.banknoteSelling = banknoteSelling;
    }
}
