package pe.edu.bikeswap.inventoryservice.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pe.edu.bikeswap.inventoryservice.domain.model.Post;
import pe.edu.bikeswap.inventoryservice.entity.PostEntity;

import java.util.List;

@Mapper
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);
    PostEntity postModelToEntity(Post post);
    Post postEntityToModel(PostEntity postEntity);
    List<Post> postEntityListToModelList(List<PostEntity> postEntities);
}
