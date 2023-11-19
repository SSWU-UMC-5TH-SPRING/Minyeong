package umc.spring.converter;

import umc.spring.domain.Food;
import umc.spring.domain.mapping.FoodOfUser;

import java.util.List;
import java.util.stream.Collectors;

public class UserPreferConverter {
    public static List<FoodOfUser> toUserPreferList(List<Food> foodCategoryList){
        return foodCategoryList.stream()
                .map(foodCategory ->
                        FoodOfUser.builder()
                                .food(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
