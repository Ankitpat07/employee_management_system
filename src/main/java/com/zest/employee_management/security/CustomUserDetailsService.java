package com.zest.employee_management.security;

import com.zest.employee_management.entity.User.User;
import com.zest.employee_management.repository.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService
        implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(
            String username)
            throws UsernameNotFoundException {

        User user = userRepository.findByUserName(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "User not found"
                        ));

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getUserName())
                .password(user.getPassword())
                .build();
    }
}
