package umc.spring.web.dto;

import lombok.Getter;
import umc.spring.validation.annotation.ExistCategories;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class UserRequestDTO {
    @Getter
    public static class UserJoinReq {
        @NotBlank
        String name;
        @NotNull
        Integer gender;
        @NotNull
        Integer birth_year;
        @NotNull
        Integer birth_month;
        @NotNull
        Integer birth_day;
        @Size(min = 5, max = 12)
        String address;
        @ExistCategories
        List<Long> likeFoods;
    }
}
