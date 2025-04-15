package dev.gaau.board.dto.post.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostUpdateRequestDto {
    private Long postId;
    private String nickname;
    private String title;
    private String name;
}
