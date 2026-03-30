package com.lemondeperdu.Le.Monde.Perdu.metier.service;

import com.lemondeperdu.Le.Monde.Perdu.metier.model.User;
import com.lemondeperdu.Le.Monde.Perdu.metier.model.UserDetailsImpl;
import com.lemondeperdu.Le.Monde.Perdu.metier.port.output.UserPort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserPort userPort;

    public UserDetailsServiceImpl(UserPort userPort) {
        this.userPort = userPort;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userPort.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));
        return new UserDetailsImpl(user);
    }
}
