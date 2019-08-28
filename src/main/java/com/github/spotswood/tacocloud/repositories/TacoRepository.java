package com.github.spotswood.tacocloud.repositories;

import com.github.spotswood.tacocloud.models.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {

}