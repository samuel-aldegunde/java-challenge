package com.intelygenz.service;


import com.intelygenz.domain.model.IntegerSorterEntity;
import com.intelygenz.repository.BinaryIntegerSorterRepository;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BinaryIntegerSorterService {

    private BinaryIntegerSorterRepository repository;

    public List<Integer> getSortedIntegers(Integer id) {
        IntegerSorterEntity entity = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Id: " + id + " not found"));

        String[] integerValues = entity.getIntegers().split(",");

        return Arrays.stream(integerValues)
            .map(Integer::parseInt)
            .sorted(Comparator.comparingInt(Integer::bitCount).reversed()
                .thenComparing(Integer::intValue))
            .collect(Collectors.toList());
    }
}