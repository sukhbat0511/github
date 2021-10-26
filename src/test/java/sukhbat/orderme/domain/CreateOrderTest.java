package sukhbat.orderme.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import sukhbat.orderme.domain.entities.Customer;
import sukhbat.orderme.domain.entities.Food;
import sukhbat.orderme.domain.entities.Order;
import sukhbat.orderme.domain.repositories.CustomerRepository;
import sukhbat.orderme.domain.repositories.FoodRepository;
import sukhbat.orderme.domain.usecases.CreateOrder;

public class CreateOrderTest
{
  CustomerRepository customerRepository = Mockito.mock(CustomerRepository.class);
  FoodRepository foodRepository = Mockito.mock(FoodRepository.class);

  @Test(expected = IllegalArgumentException.class)
  public void orderDoesntCreateWithEmptyFoods()
  {
    CreateOrder usecase = new CreateOrder(customerRepository, foodRepository);
    Order order = usecase.execute("C1", Collections.emptyList());
  }

  @Test(expected = IllegalArgumentException.class)
  public void orderDoesntCreateWithNullFoods()
  {
    CreateOrder usecase = new CreateOrder(customerRepository, foodRepository);
    Order order = usecase.execute("", Collections.emptyList());
  }

  @Test(expected = NullPointerException.class)
  public void orderDoesntCreateWithNullCustomer()
  {
    CreateOrder usecase = new CreateOrder(customerRepository, foodRepository);
    List<String> foodIds = new ArrayList<>();
    foodIds.add("F1");
    foodIds.add("F2");

    Order order = usecase.execute(null, foodIds);
  }

  @Test(expected = IllegalArgumentException.class)
  public void orderDoesntCreateWithBlankCustomer()
  {
    CreateOrder usecase = new CreateOrder(customerRepository, foodRepository);
    List<String> foodIds = new ArrayList<>();
    foodIds.add("F1");
    foodIds.add("F2");

    Order order = usecase.execute("", foodIds);
  }

  @Test
  public void orderCreated()
  {
    Mockito.when(customerRepository.findById("C1")).thenReturn(new Customer("C1", "Test"));
    Mockito.when(foodRepository.findById("F1")).thenReturn(new Food("F1", "Mongolian", 10000, "khushuur"));
    Mockito.when(foodRepository.findById("F2")).thenReturn(new Food("F2", "Mongolian", 5000, "buuz"));

    CreateOrder usecase = new CreateOrder(customerRepository, foodRepository);
    List<String> foodIds = new ArrayList<>();
    foodIds.add("F1");
    foodIds.add("F2");

    Order order = usecase.execute("C1", foodIds);

    Assert.assertNotNull(order);
    Assert.assertNotNull(order.getId());
    Assert.assertFalse(order.getId().isEmpty());

    Assert.assertEquals("C1", order.getCustomer().getId());
    Assert.assertEquals(2, order.getFoods().size());
    Assert.assertEquals("khushuur", order.getFoods().get(0).getName());

  }

//  @Test(expected = NullPointerException.class)
//  public void customershouldnotbenull()
//  {
//    Mockito.when(customerRepository.findById("C1")).thenReturn(null);
//    CreateOrder useCase = new CreateOrder(customerRepository, foodRepository);
//    List<String> foodIds = new ArrayList<>();
//    foodIds.add("F1");
//    foodIds.add("F2");
//
//    useCase.execute("C1", foodIds);
//  }

//  @Mock
//  FoodRepository foodRepository;
//
//  @Test(expected = NullPointerException.class)
//  public void foodshouldnotbenull()
//  {
//    Mockito.when(foodRepository.findById("")).thenReturn(null);
//    CreateOrder useCase = new CreateOrder(customerRepository, foodRepository);
//    List<String> foodIds = new ArrayList<>();
//    foodIds.add("F1");
//    foodIds.add("F2");
//
//    useCase.execute("C1", foodIds);
//  }
}
