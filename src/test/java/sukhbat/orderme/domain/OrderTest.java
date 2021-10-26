package sukhbat.orderme.domain;

import org.junit.Assert;
import org.junit.Test;
import sukhbat.orderme.domain.entities.Customer;
import sukhbat.orderme.domain.entities.Food;
import sukhbat.orderme.domain.entities.Order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderTest
{

  @Test(expected = NullPointerException.class)
  public void ctrDoesntGetNullCustomer()
  {
    List<Food> foods = new ArrayList<>();
    foods.add(new Food("F1", "mongolian", 1000, "Hushuur"));
    new Order("O1", null, foods);
  }

  @Test(expected = NullPointerException.class)
  public void ctrDoesntGetNullFoods()
  {
    new Order("O2", new Customer("C1", "Sukhee"), null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void ctrDoesntGetEmptyFoods()
  {
    new Order("O3", new Customer("C2", "Sukhee"), Collections.emptyList());
  }

  @Test
  public void ctrCreatesNewOrder()
  {
    List<Food> foods = new ArrayList<>();
    foods.add(new Food("F2", "mongolian", 1000, "Hushuur"));
    Order newOrder = new Order("O3", new Customer("C3", "Sukhee"), foods);

    Assert.assertNotNull(newOrder);
    Assert.assertEquals("Sukhee", newOrder.getCustomer().getName());
    Assert.assertFalse(newOrder.getFoods().isEmpty());
    Assert.assertEquals(1, newOrder.getFoods().size());
    Assert.assertEquals("Hushuur", newOrder.getFoods().get(0).getName());
  }
}
