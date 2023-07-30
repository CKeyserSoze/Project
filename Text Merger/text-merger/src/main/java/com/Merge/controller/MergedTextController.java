package com.cobanoglu.controller;

import com.cobanoglu.dto.MergedTextDto;
import com.cobanoglu.model.MergedText;
import com.cobanoglu.service.MergedTextService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("merged-text")
@RequiredArgsConstructor
@CrossOrigin
public class MergedTextController {

    private final MergedTextService mergedTextService;

    @GetMapping
    public ResponseEntity<List<MergedText>> getAll() {
        return ResponseEntity.ok(mergedTextService.getAll());
    }

    @PostMapping
    public ResponseEntity<MergedText> printMergedText(@RequestBody MergedTextDto mergedTextDto) {
        return ResponseEntity.ok(mergedTextService.printMergedText(mergedTextDto));
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveMergedText(@RequestBody MergedText mergedText) {
        return ResponseEntity.ok(mergedTextService.saveMergedText(mergedText));
    }
}
