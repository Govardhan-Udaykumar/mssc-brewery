package org.beginnertoexpert.msscbrewery.web.controller.v2;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.beginnertoexpert.msscbrewery.web.model.BeerDto;
import org.beginnertoexpert.msscbrewery.web.model.v2.BeerDtoV2;
import org.beginnertoexpert.msscbrewery.web.services.BeerService;
import org.beginnertoexpert.msscbrewery.web.services.v2.BeerServiceV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

    private final BeerServiceV2 beerServiceV2;

    public BeerControllerV2(BeerServiceV2 beerService) {
        this.beerServiceV2 = beerService;
    }


    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
    }

    //getBeers
    @PostMapping  //post mapping..
    public ResponseEntity<BeerDtoV2> handlePost(@Valid @RequestBody BeerDtoV2 beerDto){
        BeerDtoV2 saveBeer = beerServiceV2.saveNewBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/beer/"+saveBeer.getId().toString()+"/"+beerDto.getBeerName());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> handleUpdate(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDtoV2 beerDto){
        beerServiceV2.update(beerId,beerDto);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> deleteBeerById(@PathVariable("beerId") UUID beerId){
        beerServiceV2.deleteBeerById(beerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
