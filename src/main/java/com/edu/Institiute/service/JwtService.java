package com.edu.Institiute.service;

import com.edu.Institiute.dto.requestDto.LoginRequestDto;
import com.edu.Institiute.dto.responseDto.LoginResponseDto;
import com.edu.Institiute.entity.Role;
import com.edu.Institiute.entity.User;
import com.edu.Institiute.repo.UserRepo;
import com.edu.Institiute.utill.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findById(username).get();

        if (user!=null){
            return new org.springframework.security.core.userdetails.User(
                    user.getUserName(),
                    user.getUserPassword(),
                    getAuthority(user)
            );

        }else {
            throw new UsernameNotFoundException("User not found with username" + username);
        }

    }

    private Set getAuthority(User user){

        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        for (Role role: user.getRole()){
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }

        return authorities;
    }

    public LoginResponseDto createJwtToken(LoginRequestDto loginRequestDto) throws Exception {

        String username = loginRequestDto.getUsername();
        String userPassword= loginRequestDto.getUserPassword();

        authenticate(username,userPassword);

        UserDetails userDetails = loadUserByUsername(username);
        String newGeneratedToken = jwtUtil.generateToken(userDetails);
        User user = userRepo.findById(username).get();

        LoginResponseDto loginResponseDto = new LoginResponseDto(
                user,
                newGeneratedToken
        );


        return loginResponseDto;
    }

    private void authenticate(String username , String userPassword) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, userPassword));
        }catch (BadCredentialsException e){

            throw new Exception("Invalid_Credentials", e);
        }

    }
}
