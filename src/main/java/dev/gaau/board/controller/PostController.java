package dev.gaau.board.controller;

import dev.gaau.board.dto.post.request.PostCreateRequestDto;
import dev.gaau.board.dto.post.response.PostResponseDto;
import dev.gaau.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @ResponseBody
    @PostMapping("/api/write")
    public ResponseEntity<PostResponseDto> createPost(PostCreateRequestDto request) {
        PostResponseDto postDto = postService.createPost(request);

        return ResponseEntity.ok(postDto);
    }
}
