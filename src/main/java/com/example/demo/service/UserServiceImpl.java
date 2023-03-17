package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;

    public UserServiceImpl(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<Role> getAllRoles() {
        return roleService.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
      //  user = addUserRole(user);
        System.out.println(user.getFirstName());

        userRepository.save(user);

    }

    @Override
    @Transactional
    public void updateUser(User updateUser) {
     //   User user = addUserRole(updateUser);

     //   userRepository.save(updateUser);
        userRepository.save(updateUser);
    }



//    public User addUserRole(User user) {
//        Role USR = roleService.findByName("ROLE_USER");
//        Role ADM = roleService.findByName("ROLE_ADMIN");
//
//        Set<Role> roleForSet = new HashSet<>();
//        roleForSet.add(USR);
//
//        for (Role r : user.getRoles()) {
//            if (r.getId() == 1) {
//                roleForSet.add(ADM);
//
//            }
//        }
//        ;
//        user.setRoles(roleForSet);
//
//        return user;
//    }
}
