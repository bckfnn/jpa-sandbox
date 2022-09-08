package org.example;

import javax.ws.rs.*;
import java.util.List;
import java.util.Optional;

@Path("/roots")
public class RootResource {

  private final RootRepository rootRepository;

  public RootResource(RootRepository rootRepository) {
    this.rootRepository = rootRepository;
  }

  @GET
  public Iterable<RootEntity> findAll() {
    return rootRepository.findAll();
  }
  @GET
  @Path("/rel")
  public Iterable<RootEntity> findAllWithRelation() {
    return rootRepository.findRelationAll();
  }


  @DELETE
  @Path("{id}")
  public void delete(long id) {
    rootRepository.deleteById(id);
  }

  @POST
  @Path("/name/{name}")
  public RootEntity create(String name) {
    return rootRepository.save(new RootEntity(name));
  }

  @PUT
  @Path("/id/{id}/name/{name}")
  public RootEntity changeColor(Long id, String name) {
    Optional<RootEntity> optional = rootRepository.findById(id);
    if (optional.isPresent()) {
      RootEntity fruit = optional.get();
      fruit.setName(name);
      return rootRepository.save(fruit);
    }

    throw new IllegalArgumentException("No Fruit with id " + id + " exists");
  }

  @GET
  @Path("/name/{name}")
  public List<RootEntity> findByName(String name) {
    return rootRepository.findByName(name);
  }
}
