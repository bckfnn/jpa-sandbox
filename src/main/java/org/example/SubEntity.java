package org.example;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "subentity")
public class SubEntity {

  @Id
  @GeneratedValue
  private Long id;



  @JsonIgnore
  @ManyToOne
  private RootEntity root;

  @Column(length = 40)
  private String name;

  @OneToOne(fetch = FetchType.LAZY)
  private OneEntity one;

  public SubEntity() {
  }

  public SubEntity(String name) {
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

  public RootEntity getRoot() {
    return root;
  }

  public void setRoot(RootEntity root) {
    this.root = root;
  }

  public OneEntity getOne() {
    return one;
  }
}
