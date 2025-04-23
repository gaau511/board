package dev.gaau.board.dto.post.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostCreateRequestDto {

    @Schema(example = "james")
    private String nickname;

    @Schema(example = "Greeting!")
    private String title;

    @Schema(example = "Hello everyone!")
    private String content;
}
