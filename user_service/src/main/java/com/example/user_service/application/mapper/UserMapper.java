package com.example.user_service.application.mapper;

import com.example.user_service.domain.model.User;
import com.example.user_service.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserEntity userModelToEntity(User user);
    User userEntityToModel(UserEntity userEntity);

    List<User> userEntityListToModelList(List<UserEntity> userEntities);
}
