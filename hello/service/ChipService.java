package com.les2.hello.service;

import com.les2.hello.model.Cat;
import com.les2.hello.model.Chip;
import com.les2.hello.repository.CatRepository;
import com.les2.hello.repository.ChipRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ChipService {

    @Autowired
    ChipRepository chipRepository;

    @Autowired
    CatRepository catRepository;

    public Chip newChip(Cat cat, Chip chip) {
        chip.setCat(cat);
        return chipRepository.save(chip);
    }
}
