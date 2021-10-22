package sukhbat.orderme.domain.usecases;

import org.apache.commons.lang3.Validate;
import sukhbat.orderme.domain.entities.Customer;
import sukhbat.orderme.domain.entities.Food;
import sukhbat.orderme.domain.entities.Order;
import sukhbat.orderme.domain.repositories.CustomerRepository;
import sukhbat.orderme.domain.repositories.FoodRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CreateOrder {

    private final CustomerRepository customerRepository = new CustomerRepository();
    private final FoodRepository foodRepository = new FoodRepository();

    public Order execute(String customerId, List<String> foodIds)
    {
        Validate.notBlank(customerId);
        Validate.notNull(foodIds);
        Validate.notEmpty(foodIds);

        Customer customer = customerRepository.findById(customerId);

        if (null == customer)
        {
            throw new IllegalArgumentException("Customer [" + customerId + "] doesnt exist!");
        }

        List<Food> foods = new ArrayList<>();
        for (String foodId: foodIds)
        {
            Food food = foodRepository.findById(foodId);
            if (null != food)
            {
                foods.add(food);
            }
        }

        return new Order(UUID.randomUUID().toString(), customer, foods);
    }
}
