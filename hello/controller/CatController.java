package com.les2.hello.controller;

import com.les2.hello.model.Cat;
import com.les2.hello.repository.CatRepository;
import com.les2.hello.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/cat/")
public class CatController {

    @Autowired
    CatService catService;
    //Create
    @PostMapping("/new")
    public Cat newCat(@RequestBody Cat cat) {
        return catService.addCat(cat);
    }
    //Read
    @GetMapping("/all")
    public Iterable<Cat> getAllCats() {
        return catService.getAllCats();
    }

    @GetMapping("/{id}")
    public Optional<Cat> getCatById (@PathVariable(value="id") long id) {
        return catService.getOneCat(id);
    }
    //Update
    @PutMapping("/{id}")
    public Cat updateCatById(@PathVariable(value="id") long id, @RequestBody Cat cat) {
        return catService.updateCatById(id, cat);
    }

    //Delete
    @DeleteMapping("\"/{id}\"")
    public String deleteCatById(@PathVariable(value="id") long id) {
            return catService.deleteCatById(id);
        }

    @DeleteMapping("/all")
    public void deleteAllCats() {
        catService.deleteAllCats();
    }
}
