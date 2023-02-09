package com.les2.hello.service;

import com.les2.hello.model.Cat;
import com.les2.hello.model.Kitten;
import com.les2.hello.repository.KittenRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class KittenService {

    @Autowired
    KittenRepository kittenRepository;

    public Kitten newKitten(Cat cat, Kitten kitten){
        kitten.setCat(cat);
        return kittenRepository.save(kitten);
    }
}
