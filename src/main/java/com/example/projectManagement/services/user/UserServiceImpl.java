package com.example.projectManagement.services.user;

import com.example.projectManagement.models.entities.User;
import com.example.projectManagement.repositories.UserRepository;
import com.example.projectManagement.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;
@Service
public class UserServiceImpl extends CrudServiceImpl<UserRepository, User, Integer> implements UserService {
    protected UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
    }
    @Override
    public Stream<User> readAll() {
        return super.readAll();
    }
}

