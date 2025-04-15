package dev.gaau.board.dto.post.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostCreateRequestDto {
    private String nickname;
    private String title;
    private String name;
}
