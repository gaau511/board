package dev.gaau.board.dto.post.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostUpdateRequestDto {

    @Schema(example = "")
    private String nickname;

    @Schema(example = "Title changed")
    private String title;

    @Schema(example = "Content changed")
    private String content;
}
