package sukhbat.orderme.domain.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Order extends Entity
{
  private final Customer customer;
  private List<Food> foods;
  private Delivery delivery;
  private final LocalDate dateOrdered = LocalDate.now();

  public Order(String id, Customer customer, List<Food> foods)
  {
    super(id);
    this.customer = Objects.requireNonNull(customer);
    this.foods = Objects.requireNonNull(foods);
    if (foods.isEmpty())
    {
      throw new IllegalArgumentException("Foods shall not be empty!");
    }
  }

  public Customer getCustomer()
  {
    return customer;
  }

  public List<Food> getFoods()
  {
    return foods;
  }

  public void setFoods(List<Food> foods)
  {
    this.foods = foods;
  }

  public LocalDate getDateOrdered()
  {
    return dateOrdered;
  }

  public Delivery deliveryMethod()
  {
    return delivery;
  }

  public void setDeliveryMethod(Delivery deliveryMethod)
  {
    this.delivery = deliveryMethod;
  }
}
