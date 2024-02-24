package com.gusdev.transfershop.infra.mapper;

import com.gusdev.transfershop.core.domain.TaxNumber;
import com.gusdev.transfershop.core.domain.User;
import com.gusdev.transfershop.infra.dto.request.CreateUserRequest;
import com.gusdev.transfershop.infra.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity userEntityToUser(User user) {
        return new UserEntity(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getTaxNumber().getValue(),
                user.getFullName(),
                user.getType(),
                user.getCreatedAt(),
                user.getUpdateAt()
        );
    }
   public User userToCreateUserRequest(CreateUserRequest userRequest) throws Exception {
        return new User(
                userRequest.email(),
                userRequest.password(),
                new TaxNumber(userRequest.taxNumber()),
                userRequest.fullName(),
                userRequest.type()

        );
    }
    public User userEntityToUser(UserEntity userEntity) throws Exception {
        return new User(
                userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                new TaxNumber(userEntity.getTaxNumber()),
                userEntity.getFullName(),
                userEntity.getUserType(),
                userEntity.getCreatedAt(),
                userEntity.getUpdatedAt()
        );
    }
}
