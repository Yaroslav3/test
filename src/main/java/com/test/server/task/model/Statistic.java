package com.test.server.task.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "statistic")
public class Statistic {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Column(name = "page_views")
  private int page_views;

  @Column(name = "date")
  private Date date;

  @Column(name = "clicks")
  private int clicks;

  @Column(name = "user_id")
  private Long userId;

  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "user_id", insertable = false, updatable = false)
  private Users users;
}
