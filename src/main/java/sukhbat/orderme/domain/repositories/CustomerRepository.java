package sukhbat.orderme.domain.repositories;

import org.apache.commons.lang3.Validate;
import sukhbat.orderme.domain.entities.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepository
{
  private Map<String, Customer> customers = new HashMap<>();

  public CustomerRepository()
  {
    this.customers.put("C1", new Customer("C1", "Sukhee"));
    this.customers.put("C2", new Customer("C2", "Ochiroo"));
  }

  public Customer findById(String customerId)
  {
    if (this.customers.keySet().contains(customerId))
    {
      return this.customers.get(customerId);
    }
    else
    {
      return null;
    }
  }
}
