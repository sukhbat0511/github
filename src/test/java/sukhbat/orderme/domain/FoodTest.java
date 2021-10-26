package sukhbat.orderme.domain;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.internal.matchers.Null;
import sukhbat.orderme.domain.entities.Food;

public class FoodTest
{
  @Test(expected = NullPointerException.class)
  public void ctrDoesntGetNullName()
  {
    new Food("f1", "t1", 0, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void ctrDoesntGetEmptyName()
  {
    new Food("f1", "t1", 0, "");
  }

  @Test(expected = IllegalArgumentException.class)
  public void ctrDoesntGetNegativePrice()
  {
    new Food("f1", "t1", -55, "khushuur");
  }

  @Test()
  public void ctrCreates()
  {
    Food food = new Food("f1", "t1", 55, "buuz");
    Assert.assertNotNull(food);
    Assert.assertEquals("f1", food.getId());
    Assert.assertEquals("buuz", food.getName());
    Assert.assertEquals(55, food.getListPrice());
  }
}
