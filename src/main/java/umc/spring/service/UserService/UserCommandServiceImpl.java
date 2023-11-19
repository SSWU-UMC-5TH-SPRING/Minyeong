package umc.spring.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodHandler;
import umc.spring.converter.UserConverter;
import umc.spring.converter.UserPreferConverter;
import umc.spring.domain.Food;
import umc.spring.domain.User;
import umc.spring.domain.mapping.FoodOfUser;
import umc.spring.repository.FoodRepository;
import umc.spring.repository.UserRepository;
import umc.spring.web.dto.UserRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;
    private final FoodRepository foodRepository;

    @Override
    public User joinUser(UserRequestDTO.UserJoinReq request) {
        User newUser = UserConverter.toUser(request);

        List<Food> foodList = request.getLikeFoods().stream()
                .map(category -> {
                    return foodRepository.findById(category).orElseThrow(() -> new FoodHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<FoodOfUser> userPreferList = UserPreferConverter.toUserPreferList(foodList);

        userPreferList.forEach(foodOfUser -> {foodOfUser.setUser(newUser);});

        return userRepository.save(newUser);
    }
}
