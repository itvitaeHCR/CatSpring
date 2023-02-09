package com.les2.hello.repository;

import com.les2.hello.model.Kitten;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface KittenRepository extends CrudRepository<Kitten, Long> {
}
