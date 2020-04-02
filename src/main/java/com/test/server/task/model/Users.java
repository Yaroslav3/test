package com.test.server.task.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "users")
public class Users {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email")
  private String email;

  @Column(name = "gender")
  private String gender;

  @Column(name = "ip_address")
  private String IpAddress;

  @Transient
  private int totalClicks;
  @Transient
  private int totalPageViews;
}
