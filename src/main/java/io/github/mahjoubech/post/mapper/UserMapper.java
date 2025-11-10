package io.github.mahjoubech.post.mapper;

import io.github.mahjoubech.post.dto.request.RegisterRequest;
import io.github.mahjoubech.post.model.entity.Commnter;
import io.github.mahjoubech.post.model.entity.Poster;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    void toPosterEntity(RegisterRequest register, @MappingTarget Poster poster);
    @Mapping(target = "id", ignore = true)
    void toCommenterEntity(RegisterRequest register, @MappingTarget Commnter commenter);

}
