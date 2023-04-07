package com.example.projectManagement.models.forms;

import com.example.projectManagement.models.entities.User;
import lombok.Data;

@Data
public class UserCreateForm {
    private String name;
    private String firstName;
    private String username;
    private String password;
    private String address;
    private String birthDate;

    public User toBll(){
        User entity = new User();
        entity.setName(name);
        entity.setFirstName(firstName);
        entity.setUsername(username);
        entity.setPassword(password);
        entity.setAddress(address);
        entity.setBirthDate(birthDate);
        return entity;
    }

    @Override
    public String toString() {
        return "UserCreateForm{" +
                "name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}
