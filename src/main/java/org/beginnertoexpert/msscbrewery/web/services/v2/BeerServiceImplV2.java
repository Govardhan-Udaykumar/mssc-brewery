package org.beginnertoexpert.msscbrewery.web.services.v2;

import org.beginnertoexpert.msscbrewery.web.model.v2.BeerDtoV2;
import org.beginnertoexpert.msscbrewery.web.model.v2.BeerStyleEnum;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImplV2 implements BeerServiceV2{
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder().id(beerId)
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleEnum.ALE)
                .build();
    }

    @Override
    public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {
        return BeerDtoV2.builder()
                .id(beerDto.getId())
                .beerName(beerDto.getBeerName())
                .build();
    }

    @Override
    public void update(UUID beerId, BeerDtoV2 beerDto) {
        // todo
    }

    @Override
    public void deleteBeerById(UUID beerId) {

    }
}
