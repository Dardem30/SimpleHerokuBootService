package com.example.simpleservicebootheroku.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class User {
    private int id;
    private String password;
    private String username;
    private Set<Role> roleSet;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_user",joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(password, user.password) &&
                Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, password, username);
    }
}
