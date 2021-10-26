package sukhbat.orderme.domain.entities;

import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Entity
{
  private final String name;
  private String address;
  private String email;
  private final List<Order> orderHistory = new ArrayList<>();

  public Customer(String id, String name)
  {
    super(id);
    this.name = Validate.notBlank(name);
  }

  public String getName()
  {
    return name;
  }

  public String getAddress()
  {
    return address;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public List<Order> getOrderHistory()
  {
    return orderHistory;
  }
}


