package dev.gaau.board.controller;

import dev.gaau.board.dto.post.request.PostCreateRequestDto;
import dev.gaau.board.dto.post.request.PostUpdateRequestDto;
import dev.gaau.board.dto.post.response.PostAbstractResponseDto;
import dev.gaau.board.dto.post.response.PostResponseDto;
import dev.gaau.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @ResponseBody
    @PostMapping("/api/write")
    public ResponseEntity<PostResponseDto> createPost(@RequestBody PostCreateRequestDto request) {
        PostResponseDto postDto = postService.createPost(request);

        return ResponseEntity.ok(postDto);
    }

    @ResponseBody
    @GetMapping("/api")
    public ResponseEntity<List<PostAbstractResponseDto>> viewPostList() {
        List<PostAbstractResponseDto> postDtos = postService.getAllPosts();

        return ResponseEntity.ok(postDtos);
    }

    @ResponseBody
    @GetMapping("/api/{id}")
    public ResponseEntity<PostResponseDto> viewPost(@PathVariable("id") Long id) {
        PostResponseDto postDto = postService.getPostById(id);

        return ResponseEntity.ok(postDto);
    }

    @ResponseBody
    @PatchMapping("/api/{id}")
    public ResponseEntity<PostResponseDto> updatePost(@PathVariable("id") Long id,
                                                      @RequestBody PostUpdateRequestDto request) {
        PostResponseDto postDto = postService.updatePost(id, request);

        return ResponseEntity.ok(postDto);
    }

}
