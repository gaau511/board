package dev.gaau.board.service;

import dev.gaau.board.domain.Post;
import dev.gaau.board.dto.post.request.PostCreateRequestDto;
import dev.gaau.board.dto.post.request.PostUpdateRequestDto;
import dev.gaau.board.dto.post.response.PostAbstractResponseDto;
import dev.gaau.board.dto.post.response.PostResponseDto;
import dev.gaau.board.mapper.PostMapper;
import dev.gaau.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public PostResponseDto createPost(PostCreateRequestDto request) {
        Post post = postMapper.postCreateRequestDtoToPost(request);
        Post savedPost = postRepository.save(post);

        return postMapper.postToPostResponseDto(savedPost);
    }

    public PostResponseDto updatePost(Long id, PostUpdateRequestDto request) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + id));

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

    public Void deletePost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + id));

        postRepository.delete(post);
        return null;
    }

    public PostResponseDto getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + id));

        return postMapper.postToPostResponseDto(post);
    }

    public List<PostAbstractResponseDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();

        return posts.stream().map(post -> postMapper.postToPostAbstractResponseDto(post)).toList();
    }
}
