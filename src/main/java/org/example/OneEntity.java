package org.example;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "oneentity")
public class OneEntity {

  @Id
  @GeneratedValue
  private Long id;

  @Column(length = 40)
  private String name;

  @OneToOne(mappedBy = "one")
  private SubEntity sub;

  public OneEntity() {
  }

  public OneEntity(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
