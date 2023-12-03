package umc.spring.converter;

import umc.spring.domain.Region;
import umc.spring.domain.Shop;
import umc.spring.web.dto.ShopRequestDTO;
import umc.spring.web.dto.ShopResponseDTO;

public class ShopConverter {
    public static Shop toShop(ShopRequestDTO.AddShopToRegionReq request, Region region) {
        return Shop.builder()
                .name(request.getName())
                .address(request.getAddress())
                .status(request.isStatus())
                .imageURL(request.getImageURL())
                .category(request.getCategory())
                .region(region)
                .build();
    }

    public static ShopResponseDTO.AddRegionRes toAddResultRes(Shop shop) {
        return ShopResponseDTO.AddRegionRes.builder()
                .shopId(shop.getId())
                .createdAt(shop.getCreatedAt())
                .build();
    }
}
