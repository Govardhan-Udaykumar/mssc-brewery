package org.beginnertoexpert.msscbrewery.web.services.v2;

import org.beginnertoexpert.msscbrewery.web.model.BeerDto;
import org.beginnertoexpert.msscbrewery.web.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {
    BeerDtoV2 getBeerById(UUID beerId);

    BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto);

    void update(UUID beerId, BeerDtoV2 beerDto);

    void deleteBeerById(UUID beerId);
}
