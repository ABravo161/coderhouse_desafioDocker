package com.coderhouse.service.impl;

import com.coderhouse.builder.UserBuilder;

import com.coderhouse.model.UserFactory;
import com.coderhouse.model.request.UserRequest;
import com.coderhouse.model.response.UserResponse;
import com.coderhouse.repository.UserRepository;
import com.coderhouse.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserFactory userFactory = new UserFactory();

    @Override
    public UserResponse create(UserRequest request) {
        var document= userFactory.createUser(request);
        return UserBuilder.docToResponseCreate(repository.save(document));
    }

    @Override
    public UserResponse getUser(String id){
        return UserBuilder.docToResponseCreate(repository.findById(id).orElseThrow());
    }

    @Override
    public List<UserResponse> searchAll() {
        return UserBuilder.listDocToResponse(repository.findAll());
    }


}

