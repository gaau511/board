package dev.gaau.board.controller.api;

import dev.gaau.board.dto.post.request.PostCreateRequestDto;
import dev.gaau.board.dto.post.request.PostUpdateRequestDto;
import dev.gaau.board.dto.post.response.PostAbstractResponseDto;
import dev.gaau.board.dto.post.response.PostResponseDto;
import dev.gaau.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class PostApiController {

    private final PostService postService;

    @PostMapping("/write")
    public ResponseEntity<PostResponseDto> createPost(@RequestBody PostCreateRequestDto request) {
        PostResponseDto postDto = postService.createPost(request);

        return ResponseEntity.ok(postDto);
    }

    @GetMapping
    public ResponseEntity<List<PostAbstractResponseDto>> viewPostList() {
        List<PostAbstractResponseDto> postDtos = postService.getAllPosts();

        return ResponseEntity.ok(postDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDto> viewPost(@PathVariable("id") Long id) {
        PostResponseDto postDto = postService.getPostById(id);

        return ResponseEntity.ok(postDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PostResponseDto> updatePost(@PathVariable("id") Long id,
                                                      @RequestBody PostUpdateRequestDto request) {
        PostResponseDto postDto = postService.updatePost(id, request);

        return ResponseEntity.ok(postDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable("id") Long id) {
        postService.deletePost(id);

        return ResponseEntity.ok().build();
    }
}
