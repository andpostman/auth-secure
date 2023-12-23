package ru.sbt.synapse.simpleauth.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.sbt.synapse.simpleauth.model.Employee;
import ru.sbt.synapse.simpleauth.repository.EmployeeRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeDetailsService implements UserDetailsService {

    private final EmployeeRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("User:{}",username);
        Employee employee = repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        log.info("employee: {}",employee.toString());
        return employee;
    }
}
