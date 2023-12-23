//package ru.sbt.synapse.simpleauth.service;
//
//import org.springframework.security.core.GrantedAuthority;
//import ru.sbt.synapse.simpleauth.model.Role;
//
//public class CustomGrantedAuthority implements GrantedAuthority {
//    private Role role;
//
//    public CustomGrantedAuthority(Role role) {
//        this.role = role;
//    }
//
//    @Override
//    public String getAuthority() {
//        return role.getName();
//    }
//}
