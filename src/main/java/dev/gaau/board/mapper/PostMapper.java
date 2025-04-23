package dev.gaau.board.mapper;

import dev.gaau.board.domain.Post;
import dev.gaau.board.dto.post.request.PostCreateRequestDto;
import dev.gaau.board.dto.post.response.PostResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper( PostMapper.class );

    Post postCreateRequestDtoToPost(PostCreateRequestDto request);
    PostResponseDto postToPostResponseDto(Post post);
}
