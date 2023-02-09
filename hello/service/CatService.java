package com.les2.hello.service;

import com.les2.hello.model.Cat;
import com.les2.hello.model.Chip;
import com.les2.hello.model.Kitten;
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

    @Autowired
    ChipService chipService;

    @Autowired
    KittenService kittenService;


    //for CREATE
    public Cat addCat(Cat cat) {
        return catRepository.save(cat);
    }

    //for READ
    public Optional<Cat> getOneCat(long id) {
        return catRepository.findById(id);
    }

    public Iterable<Cat> getAllCats() {
        return catRepository.findAll();
    }

    // for UPDATE
    public Cat updateCatById(long id, Cat cat) {
        if (!catRepository.existsById(id)) { // guard class
            return null;
        }
        Cat prevCat = catRepository.findById(id).get();
        if (cat.getName() != null) {
            prevCat.setName(cat.getName());
        }
        if (cat.getAge() != null) {
            prevCat.setAge(cat.getAge());
        }
        System.out.println(cat.getAge());
        System.out.println(cat.getName());

        return catRepository.save(prevCat);
    }

    public Cat addChipToCat(long id, Chip chip) {
        if (!catRepository.existsById(id)) {
            return null;
        }
        Cat cat = catRepository.findById(id).get();
        Chip tempChip = chipService.newChip(cat, chip);
        cat.setChip(tempChip);
        return catRepository.save(cat);
    }

    public Cat catGivesBirth(long id, Kitten kitten) {
        if(!catRepository.existsById(id)) {
            return null;
        }
        Cat cat = catRepository.findById(id).get();
        Kitten tempKitten = kittenService.newKitten(cat, kitten);

        cat.getKittens().add(tempKitten);
        return catRepository.save(cat);
    }

    //for DELETE

    public void deleteAllCats() {
        catRepository.deleteAll();
    }

    public String deleteCatById(long id) {
        if (catRepository.existsById(id)) {
            catRepository.deleteById(id);
            return "cat removed from database";
        }
        return "this did not work";
    }

}