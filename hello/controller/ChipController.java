package com.les2.hello.controller;

import com.les2.hello.model.Chip;
import com.les2.hello.service.ChipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/chip")
public class ChipController {

    @Autowired
    ChipService chipService;

}