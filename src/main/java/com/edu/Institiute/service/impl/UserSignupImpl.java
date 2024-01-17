package com.edu.Institiute.service.impl;

import com.edu.Institiute.dto.UserDto;
import com.edu.Institiute.dto.requestDto.SignupRequestDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.entity.Role;
import com.edu.Institiute.exception.EntryNotFoundException;
import com.edu.Institiute.repo.RoleRepo;
import com.edu.Institiute.repo.UserRepo;
import com.edu.Institiute.service.UserSignupService;
import com.edu.Institiute.utill.mapper.RoleMapper;
import com.edu.Institiute.utill.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UserSignupImpl implements UserSignupService {

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }

    @Override
    public CommonResponseDto saveUser(SignupRequestDto dto) {
        try {
            String encodedPassword = getEncodedPassword(dto.getUserPassword());

            UserDto userDto = new UserDto(
                    dto.getUserName(),
                    dto.getUserFirstName(),
                    dto.getUserLastName(),
                    encodedPassword
            );

            userRepo.save(userMapper.dtoToUserEntity(userDto));

            return new CommonResponseDto(201, "User saved!", userDto.getUserName(), new ArrayList<>());
        }catch (Exception e){
            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
        }
    }



}
