package dev.gaau.board.dto.post.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDeleteRequestDto {
    private Long postId;
}
