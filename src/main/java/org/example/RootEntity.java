package org.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "root")
public class RootEntity {

  @Id
  @SequenceGenerator(name = "rootsSequence", sequenceName = "roots_id_seq", allocationSize = 1, initialValue = 10)
  @GeneratedValue(generator = "rootsSequence")
  private Long id;

  @Column(length = 40, unique = true)
  private String name;

  @OneToMany(mappedBy =  "root")
  private List<SubEntity> subList = new ArrayList<>();

  public RootEntity() {
  }

  public RootEntity(String name) {
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

  public List<SubEntity> getSubList() {
    return subList;
  }

  public void setSubList(List<SubEntity> subList) {
    this.subList = subList;
  }
}
