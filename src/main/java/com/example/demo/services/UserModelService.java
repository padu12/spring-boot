package com.example.demo.services;

import com.example.demo.models.UserModel;
import com.example.demo.repositories.UserModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserModelService {
    private final UserModelRepository userModelRepository;

    public UserModelService(UserModelRepository userModelRepository) {
        this.userModelRepository = userModelRepository;
    }

    public List<UserModel> findAll(){
        return userModelRepository.findAll();
    }

    public void save(UserModel userModel) {
        userModelRepository.save(userModel);
    }

    public void delete(int id) {
        userModelRepository.deleteById(id);
    }
}
