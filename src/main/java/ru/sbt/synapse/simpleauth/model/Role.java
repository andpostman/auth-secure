//package ru.sbt.synapse.simpleauth.model;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.io.Serializable;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Table(name = "role", schema = "tmc")
//@Getter
//@Setter
//@NoArgsConstructor
//@EqualsAndHashCode(exclude = "id")
//public class Role{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//    @Column(name = "name")
//    private String name;
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "role")
//    private Set<EmployeeRoles> employeeRoles;
//
//}