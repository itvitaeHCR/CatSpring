package com.les2.hello.service;

import com.les2.hello.model.Cat;
import com.les2.hello.repository.CatRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class CatService {
    @Autowired
    CatRepository catRepository;

    public Optional<Cat> getOneCat(long id) {
        return catRepository.findById(id);
    }

    public Iterable<Cat> getAllCats() {
        return catRepository.findAll();
    }

    public Cat addCat(Cat cat) {
        return catRepository.save(cat);
    }

    public String deleteCatById(long id) {
        if (catRepository.existsById(id)) {
            catRepository.deleteById(id);
            return "cat removed from database";
        }
        return "this did not work";
    }


    public Cat updateCatById(long id, Cat cat) {
        if (!catRepository.existsById(id)) { // guard class
            return null;
        }
        System.out.println(cat.getAge());
        System.out.println(cat.getName());

        return cat;
    }


    public void deleteAllCats() {
        catRepository.deleteAll();
        ;
    }

}