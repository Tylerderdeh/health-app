package kz.iitu.healthapp.service;

import kz.iitu.healthapp.model.UserResponse;

import java.util.List;

public interface UserService {

    List<UserResponse> getAll();

    UserResponse getById(Long id);
}
