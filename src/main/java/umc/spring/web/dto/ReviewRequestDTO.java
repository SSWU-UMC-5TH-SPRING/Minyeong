package umc.spring.web.dto;

import lombok.Getter;
import umc.spring.validation.annotation.ExistCategories;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

public class ReviewRequestDTO {
    @Getter
    public static class AddReviewReq {
        @NotNull
        Double score;
        @NotBlank
        String content;
        @NotBlank
        String images;
        @NotNull
        Timestamp created_at;
        @NotNull
        Long shopId;
    }
}
