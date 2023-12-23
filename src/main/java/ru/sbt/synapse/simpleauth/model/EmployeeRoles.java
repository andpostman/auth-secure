//package ru.sbt.synapse.simpleauth.model;
//
//import jakarta.persistence.*;
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Table(name = "employee_roles", schema = "tmc")
//@Getter
//@Setter
//@NoArgsConstructor
//@EqualsAndHashCode(exclude = "id")
//public class EmployeeRoles {
//
//    @Id
//    Long id;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "employee_id")
//    Employee employee;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "role_id")
//    Role role;
//}
