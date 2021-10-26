package sukhbat.orderme.domain.repositories;

import org.apache.commons.lang3.Validate;
import sukhbat.orderme.domain.entities.Chef;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChefRepository
{
  private Map<String, Chef> chefs = new HashMap<>();

  public ChefRepository()
  {
    this.chefs.put("C1", new Chef("Ch1", "Ramsey"));
    this.chefs.put("C2", new Chef("Ch2", "Linguini"));
  }

  public Chef findById(String chefId)
  {
    if (this.chefs.keySet().contains(chefId))
    {
      return this.chefs.get(chefId);
    }
    else
    {
      return null;
    }
  }
}
