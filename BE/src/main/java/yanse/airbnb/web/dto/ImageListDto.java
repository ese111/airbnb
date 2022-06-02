package yanse.airbnb.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ImageListDto {
    private String imageUrl;
    private String title;
    private String content;
}