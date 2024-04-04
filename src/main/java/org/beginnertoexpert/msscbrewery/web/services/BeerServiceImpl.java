package org.beginnertoexpert.msscbrewery.web.services;

import org.beginnertoexpert.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

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
}
