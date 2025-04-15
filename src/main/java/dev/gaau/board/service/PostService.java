package dev.gaau.board.service;

import dev.gaau.board.dto.post.request.PostCreateRequestDto;
import dev.gaau.board.dto.post.request.PostDeleteRequestDto;
import dev.gaau.board.dto.post.request.PostUpdateRequestDto;
import dev.gaau.board.dto.post.response.PostAbstractResponseDto;
import dev.gaau.board.dto.post.response.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    public PostResponseDto createPost(PostCreateRequestDto request) {

    }
    public PostResponseDto updatePost(PostUpdateRequestDto request) {}
    public PostResponseDto deletePost(PostDeleteRequestDto request) {}
    public PostResponseDto getPostById(Long postId) {}
    public List<PostAbstractResponseDto> getAllPosts() {};
}
