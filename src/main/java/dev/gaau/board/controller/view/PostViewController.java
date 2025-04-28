package dev.gaau.board.controller.view;

import dev.gaau.board.dto.post.request.PostCreateRequestDto;
import dev.gaau.board.dto.post.request.PostUpdateRequestDto;
import dev.gaau.board.dto.post.response.PostAbstractResponseDto;
import dev.gaau.board.dto.post.response.PostResponseDto;
import dev.gaau.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/view/board")
public class PostViewController {

    private final PostService postService;

    @GetMapping
    public String viewPostListPage(Model model) {
        List<PostAbstractResponseDto> postDtos = postService.getAllPosts();
        model.addAttribute("posts", postDtos);

        return "view/board/list.html";
    }

    @GetMapping("/{id}")
    public String viewPostPage(@PathVariable("id") Long id, Model model) {
        PostResponseDto postDto = postService.getPostById(id);
        model.addAttribute("post", postDto);

        return "view/board/post.html";
    }

    @GetMapping("/write")
    public String createPostPage() {
        return "view/board/write.html";
    }

    @PostMapping("/write")
    public String createPost(@ModelAttribute PostCreateRequestDto request) {
        postService.createPost(request);
        return "redirect:/view/board";
    }

}
