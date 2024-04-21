package org.beginnertoexpert.msscbrewery.web.services;

import org.beginnertoexpert.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(beerId)
                .beerName("Galaxy Cat")
                .beerStyle("Pale ale")
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                        .id(beerDto.getId())
                .beerName(beerDto.getBeerName())
                .build();
    }

    @Override
    public void update(UUID beerId, BeerDto beerDto) {
        // todo
    }

    @Override
    public void deleteBeerById(UUID beerId) {

    }
}
