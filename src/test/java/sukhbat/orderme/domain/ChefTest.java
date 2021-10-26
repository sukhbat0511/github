package sukhbat.orderme.domain;

import org.junit.Assert;
import org.junit.Test;
import sukhbat.orderme.domain.entities.Chef;

public class ChefTest
{
  @Test(expected = NullPointerException.class)
  public void ctrDoesntGetNullName()
  {
    new Chef("Ch1", null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void ctrDoesntGetEmptyName()
  {
    new Chef("Ch1", "");
  }

  @Test
  public void ctrCreates()
  {
    Chef chef = new Chef("Ch1", "Ramsey");
    Assert.assertNotNull(chef);
    Assert.assertEquals("Ch1", chef.getId());
    Assert.assertEquals("Ramsey", chef.getName());
  }
}


