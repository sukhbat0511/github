package sukhbat.orderme.domain.entities;

public class Delivery extends Entity{
    public Delivery(String id)
    {
        super(id);
    }

    enum Type {UPS, Postal, Stagecoach}

    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
