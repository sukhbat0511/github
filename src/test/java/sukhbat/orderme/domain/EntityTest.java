package sukhbat.orderme.domain;

import org.junit.Assert;
import org.junit.Test;
import sukhbat.orderme.domain.entities.Entity;

public class EntityTest
{
  @Test(expected = NullPointerException.class)
  public void ctrDoesntGetNullId()
  {
    new Entity(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void ctrDoesntGetEmptyId()
  {
    new Entity("");
  }

  @Test
  public void ctrCreated()
  {
    Entity entity = new Entity("E1");
    Assert.assertNotNull(entity);
    Assert.assertEquals("E1", entity.getId());
  }
}

