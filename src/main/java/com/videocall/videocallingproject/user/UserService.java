package com.videocall.videocallingproject.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

    private static final List<User> user_list = new ArrayList<>();

    public void register(@RequestBody User user) {
        user.setStatus("online");
        user_list.add(user);
    }

    public User login(User user) {
        var userIndex = IntStream.range(0, user_list.size())
        
                .filter(i -> user_list.get(i).getEmail().equals(user.getEmail()))
                .findAny()
                .orElseThrow(() -> new RuntimeException("User Not Found !"));

        var connectedUsers = user_list.get(userIndex);
        if (!connectedUsers.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Password is incorrect !");
        }
        connectedUsers.setStatus("online");
        return connectedUsers;
    }

    public void logout(String email) {
        var userIndex = IntStream.range(0, user_list.size())
                .filter(i -> user_list.get(i).getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User Not Found !"));
        user_list.get(userIndex).setStatus("offline");
    }

    public List<User> findAll(){
        return user_list;
    }

}
