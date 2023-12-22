package umc.spring.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ShopRequestDTO {
    @Getter
    public static class AddShopToRegionReq {
        @NotBlank
        String name;
        @Size(min = 5, max = 12)
        String address;
        @NotNull
        boolean status;
        @NotBlank
        String imageURL;
        @NotBlank
        String category;
        @NotNull
        Long region;
    }
}
