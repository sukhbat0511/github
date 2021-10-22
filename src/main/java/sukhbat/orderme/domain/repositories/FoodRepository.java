package sukhbat.orderme.domain.repositories;

import java.util.HashMap;
import java.util.Map;

import sukhbat.orderme.domain.entities.Customer;
import sukhbat.orderme.domain.entities.Food;

public class FoodRepository
{
  private Map<String, Food> foods = new HashMap<>();

  public FoodRepository()
  {
    this.foods.put("F1",  new Food("f1", "t1", 0, "n1"));
    this.foods.put("F2",  new Food("f2", "t2" ,0,"n2" ));

  }

  public Food findById(String foodId)
  {
    if (this.foods.keySet().contains(foodId))
    {
      return this.foods.get(foodId);
    }
    else

    return null;
  }
}
