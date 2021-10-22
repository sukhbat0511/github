package sukhbat.orderme.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import sukhbat.orderme.domain.entities.Order;
import sukhbat.orderme.domain.repositories.CustomerRepository;
import sukhbat.orderme.domain.repositories.FoodRepository;
import sukhbat.orderme.domain.usecases.CreateOrder;

public class CreateOrderTest
{
  @Test(expected = IllegalArgumentException.class)
  public void orderDoesntCreateWithEmptyFoods()
  {
    CreateOrder usecase = new CreateOrder();
    Order order = usecase.execute("C1", Collections.emptyList());
  }

  @Test(expected = IllegalArgumentException.class)
  public void orderDoesntCreateWithNullFoods()
  {
    CreateOrder usecase = new CreateOrder();
    Order order = usecase.execute("", Collections.emptyList());
  }

  @Test(expected = NullPointerException.class)
  public void orderDoesntCreateWithNullCustomer()
  {
    CreateOrder usecase = new CreateOrder();
    List<String> foodIds = new ArrayList<>();
    foodIds.add("F1");
    foodIds.add("F2");

    Order order = usecase.execute(null, foodIds);
  }

  @Test(expected = IllegalArgumentException.class)
  public void orderDoesntCreateWithBlankCustomer()
  {
    CreateOrder usecase = new CreateOrder();
    List<String> foodIds = new ArrayList<>();
    foodIds.add("F1");
    foodIds.add("F2");

    Order order = usecase.execute("", foodIds);
  }

  @Test
  public void orderCreated()
  {
    CreateOrder usecase = new CreateOrder();
    List<String> foodIds = new ArrayList<>();
    foodIds.add("F1");
    foodIds.add("F2");

    Order order = usecase.execute("C1", foodIds);
  }

  @Mock
  CustomerRepository customerRepository;

  @Test(expected = NullPointerException.class)
  public void findById()
  {
    Mockito.when(customerRepository.findById("C1")).thenReturn(null);
    CreateOrder useCase = new CreateOrder();
    List<String> foodIds = new ArrayList<>();
    foodIds.add("F1");
    foodIds.add("F2");

    useCase.execute("C1", foodIds);
  }
  @Mock
  FoodRepository foodRepository;
  @Test
  public void findById()
  {
    Mockito.when(foodRepository.findById("")).thenReturn(null);
    CreateOrder useCase = new CreateOrder();
    List<String> foodIds = new ArrayList<>();
    foodIds.add("F1");
    foodIds.add("F2");

    useCase.execute("C1", foodIds);
  }
}
