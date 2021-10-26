package sukhbat.orderme.domain;

import org.junit.Assert;
import org.junit.Test;
import sukhbat.orderme.domain.entities.Customer;

public class CustomerTest
{

  @Test(expected = NullPointerException.class)
  public void ctrDoesntGetNullName()
  {
    new Customer("C1", null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void ctrDoesntGetEmptyName()
  {
    new Customer("C2", "");
  }

  @Test
  public void ctrCreates()
  {
    Customer customer = new Customer("C1", "Sukhee");
    Assert.assertNotNull(customer);
    Assert.assertEquals("C1", customer.getId());
    Assert.assertEquals("Sukhee", customer.getName());
  }
}

