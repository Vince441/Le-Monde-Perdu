package com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.adapter;


import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity.UserEntity;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.mapper.UserEntityMapper;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.repository.UserRepository;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.User;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.output.UserPort;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserAdapter implements UserPort {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    public UserAdapter(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public User creeUser(User user) {
        UserEntity userEntity = userEntityMapper.toEntity(user);
        UserEntity userSaved = userRepository.save(userEntity);

        return userEntityMapper.toModel(userSaved);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email).map(userEntityMapper::toModel);
    }

    @Override
    public User updateUser(User user) {
        UserEntity userEntity = userEntityMapper.toEntity(user);
        UserEntity userUpdated = userRepository.save(userEntity);

        return userEntityMapper.toModel(userUpdated);
    }
}
