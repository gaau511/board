package dev.gaau.board.service;

import dev.gaau.board.domain.Post;
import dev.gaau.board.dto.post.request.PostCreateRequestDto;
import dev.gaau.board.dto.post.request.PostDeleteRequestDto;
import dev.gaau.board.dto.post.request.PostUpdateRequestDto;
import dev.gaau.board.dto.post.response.PostAbstractResponseDto;
import dev.gaau.board.dto.post.response.PostResponseDto;
import dev.gaau.board.mapper.PostMapper;
import dev.gaau.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public PostResponseDto createPost(PostCreateRequestDto request) {
        Post post = postMapper.postCreateRequestDtoToPost(request);
        Post savedPost = postRepository.save(post);

        return postMapper.postToPostResponseDto(savedPost);
    }

    public PostResponseDto updatePost(Long postId, PostUpdateRequestDto request) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + postId));

        if (!request.getNickname().isEmpty()) {
            post.setNickname(request.getNickname());
        }
        if (!request.getTitle().isEmpty()) {
            post.setTitle(request.getTitle());
        }
        if (!request.getContent().isEmpty()) {
            post.setContent(request.getContent());
        }

        return postMapper.postToPostResponseDto(post);
    }
    public PostResponseDto deletePost(PostDeleteRequestDto request) {return null;}
    public PostResponseDto getPostById(Long postId) {return null;}
    public List<PostAbstractResponseDto> getAllPosts() {return null;};
}
