package umc.spring.service.ShopService;

import umc.spring.domain.Shop;
import umc.spring.web.dto.ShopRequestDTO;

public interface ShopCommandService {
    public Shop addShop(ShopRequestDTO.AddShopToRegionReq request);
}
