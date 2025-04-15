package dev.gaau.board.dto.post.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostAbstractResponseDto {

    private Long postId;
    private String nickname;
    private String title;
    private LocalDateTime createdAt;

}
