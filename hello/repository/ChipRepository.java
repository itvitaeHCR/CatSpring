package com.les2.hello.repository;

import com.les2.hello.model.Chip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ChipRepository extends CrudRepository<Chip, Long> {
}
