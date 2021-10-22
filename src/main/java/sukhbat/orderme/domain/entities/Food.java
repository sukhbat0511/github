package sukhbat.orderme.domain.entities;
import org.apache.commons.lang3.Validate;

import java.time.LocalDate;
public class Food extends Entity{
    private final String type;
    private LocalDate cookedDate;
    private final int listPrice;
    private final String name;

    public Food(String id, String type, int listPrice, String name) {
        super(id);
        this.type = Validate.notBlank(type);
        this.name = Validate.notBlank(name);;
        if (listPrice < 0)
        {
            throw new IllegalArgumentException("Minus price is not allowed!");
        }
        else
        {
            this.listPrice = listPrice;
        }
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public LocalDate getCookedDate() {
        return cookedDate;
    }

    public void setCookedDate(LocalDate cookedDate) {
        this.cookedDate = cookedDate;
    }

    public int getListPrice() {
        return listPrice;
    }
}
