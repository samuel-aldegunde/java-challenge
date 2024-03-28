package com.intelygenz.controller;

import com.intelygenz.service.BinaryIntegerSorterService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/integers")
public class BinaryIntegerSorterController {
    @Autowired
    private final BinaryIntegerSorterService sorterService;

    public BinaryIntegerSorterController(BinaryIntegerSorterService sorterService) {
        this.sorterService = sorterService;
    }

    @GetMapping
    public List<Integer> getSortedIntegers(@RequestParam(name = "id", required = false)Integer id) {
        return sorterService.getSortedIntegers(id);
    }
}
