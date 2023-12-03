package umc.spring.service.ShopService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodHandler;
import umc.spring.converter.ShopConverter;
import umc.spring.converter.UserConverter;
import umc.spring.converter.UserPreferConverter;
import umc.spring.domain.Food;
import umc.spring.domain.Region;
import umc.spring.domain.Shop;
import umc.spring.domain.User;
import umc.spring.domain.mapping.FoodOfUser;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.ShopRepository;
import umc.spring.service.RegionService.RegionQueryService;
import umc.spring.web.dto.ShopRequestDTO;
import umc.spring.web.dto.UserRequestDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class ShopCommandServiceImpl implements ShopCommandService {
    private final ShopRepository shopRepository;
    private final RegionRepository regionRepository;
    private final RegionQueryService regionQueryService;

    @Override
    public Shop addShop(ShopRequestDTO.AddShopToRegionReq request) {
        Optional<Region> optionalRegion = regionRepository.findById(request.getRegion());
        if (optionalRegion.isEmpty()) {
            regionQueryService.CheckRegion(false);
        }
        Region region = optionalRegion.get();
        Shop shop = ShopConverter.toShop(request, region);
        return shopRepository.save(shop);
    }
}
