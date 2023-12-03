package umc.spring.web.dto;

import lombok.Getter;

public class ShopRequestDTO {
    @Getter
    public static class AddShopToRegionReq {
        String name;
        String address;
        boolean status;
        String imageURL;
        String category;
        Long region;
    }
}
