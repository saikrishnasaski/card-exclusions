package com.gai.card.exclusions;

import com.gai.card.exclusions.entity.ExclusionEntity;
import com.gai.card.exclusions.model.CreateExclusion;
import com.gai.card.exclusions.service.ExclusionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor

public class ExclusionController {

    private final ExclusionService exclusionService;
    private ExclusionEntity exclusionEntity;

    @PostMapping("/exclusions")
    public Integer createExclusion(@RequestBody CreateExclusion request) {

        return exclusionService.saveExclusion(request);

    }

    @GetMapping("/{cardnumber}")
    public ResponseEntity<List<ExclusionEntity>> getExclusions(@PathVariable String cardnumber)
    {
        List<ExclusionEntity> exclusionEntityList=exclusionService.getExlusions(cardnumber);


        return new ResponseEntity<>(exclusionEntityList,HttpStatus.OK);
    }

}
