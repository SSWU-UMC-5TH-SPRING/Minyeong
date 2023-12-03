package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ShopConverter;
import umc.spring.domain.Shop;
import umc.spring.service.ShopService.ShopCommandService;
import umc.spring.web.dto.ShopRequestDTO;
import umc.spring.web.dto.ShopResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shop")
public class ShopRestController {
    private final ShopCommandService shopCommandService;

    @PostMapping("/shop/add")
    public ApiResponse<ShopResponseDTO.AddRegionRes> join(@RequestBody @Valid ShopRequestDTO.AddShopToRegionReq request) {
        Shop shop = shopCommandService.addShop(request);
        return ApiResponse.onSuccess(ShopConverter.toAddResultRes(shop));
    }
}
