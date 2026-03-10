package com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.adapter;


import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity.UserEntity;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.mapper.UserEntityMapper;
import com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.repository.UserRepository;
import com.lemondeperdu.Le.Monde.Perdu.metier.exception.UserException;
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
    public User updateCompteCreer(String id, User userUpdate) {

        UserEntity userTrouve = findByUserId(id);



        if (userUpdate.getIdUser() != null) {
            userTrouve.setPseudo(userUpdate.getIdUser());
        }
        // Mise à jour uniquement des champs non nuls
        if (userUpdate.getPseudo() != null) {
            userTrouve.setPseudo(userUpdate.getPseudo());
        }

        if (userUpdate.getGenre() != null) {
            userTrouve.setGenre(userUpdate.getGenre());
        }

        // Sauvegarde en BDD
        UserEntity savedEntity = userRepository.save(userTrouve);

        // Remapping en modèle domaine
        return userEntityMapper.toModel(savedEntity);
    }

    @Override
    public Optional<User> recupererUtilisateur(String id) {
        return userRepository.findById(id).map(userEntityMapper::toModel);
    }

    @Override
    public User updateUtilisateur(String id, User user) {


        UserEntity userTrouve = findByUserId(id);


        if (user.getIdUser() != null) {
            userTrouve.setPseudo(userTrouve.getIdUser());
        }
        // Mise à jour uniquement des champs non nuls
        if (user.getPseudo() != null) {
            userTrouve.setPseudo(userTrouve.getPseudo());
        }

        if(user.getEmail() != null) {
            userTrouve.setEmail(user.getEmail());
        }

        if (user.getGenre() != null) {
            userTrouve.setGenre(userTrouve.getGenre());
        }

        // Sauvegarde en BDD
        UserEntity savedEntity = userRepository.save(userTrouve);

        // Remapping en modèle domaine
        return userEntityMapper.toModel(savedEntity);
    }

    private UserEntity findByUserId(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserException("Utilisateur non trouvé"));
    }

}
