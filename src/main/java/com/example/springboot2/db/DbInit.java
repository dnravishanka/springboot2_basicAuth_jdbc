package com.example.springboot2.db;

import com.example.springboot2.model.Users;
import com.example.springboot2.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    private UserRepository userRepository;

    public DbInit(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //create users
        Users nadun = new Users("nadun", "nadun123", "USERS", "");
        Users manager = new Users("manager", "manager123", "ADMIN", "ACCESS_NAME,ACCESS_ADDRESS");
        Users admin = new Users("admin", "admin123", "MANAGER", "ACCESS_NAME,ACCESS_ALL,ACCESS_ADDRESS");
        List<Users> users = Arrays.asList(nadun, manager, admin);
        //save in database
        this.userRepository.saveAll(users);

    }
}
