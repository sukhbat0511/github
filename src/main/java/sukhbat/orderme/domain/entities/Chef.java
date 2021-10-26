package sukhbat.orderme.domain.entities;

import java.util.List;

import org.apache.commons.lang3.Validate;

public class Chef extends Entity
{

  private String name;
  private List<Food> orderedFoods;

  public Chef(String id, String name)
  {
    super(id);
    this.name = name;
    this.name = Validate.notBlank(name);
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public List<Food> getOrderedFoods()
  {
    return orderedFoods;
  }

  public void setOrderedFoods(List<Food> orderedFoods)
  {
    this.orderedFoods = orderedFoods;
  }
}
