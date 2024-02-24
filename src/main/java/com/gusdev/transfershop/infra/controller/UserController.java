package com.gusdev.transfershop.infra.controller;

import com.gusdev.transfershop.infra.dto.request.CreateUserRequest;
import com.gusdev.transfershop.infra.dto.response.BaseResponse;
import com.gusdev.transfershop.infra.mapper.UserMapper;
import com.gusdev.transfershop.usecase.CreateUserUc;
import org.hibernate.TransactionException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.gusdev.transfershop.infra.utils.Utility.LOGGER;

@RestController
@RequestMapping("v1/users")
public class UserController {
    private CreateUserUc createUserUc;
    private UserMapper userMapper;

    public UserController(CreateUserUc createUserUc, UserMapper userMapper) {
        this.createUserUc = createUserUc;
        this.userMapper = userMapper;
    }
    @PostMapping(path = "/add-user")
    public BaseResponse<String> addNewUser(@RequestBody CreateUserRequest request) throws Exception, TransactionException {
        LOGGER.info("Request receive to add a new User.");
        createUserUc.createUser(userMapper.userToCreateUserRequest(request), request.pin());
        LOGGER.info("The user was created successfully");
        return BaseResponse.<String>builder().success(true).message("The user was created successfully").build();
    }
}
