package com.les2.hello.repository;

import com.les2.hello.model.Cat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component

public interface CatRepository extends CrudRepository<Cat, Long> {

}
