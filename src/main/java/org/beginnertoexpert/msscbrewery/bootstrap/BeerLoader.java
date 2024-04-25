package org.beginnertoexpert.msscbrewery.bootstrap;

import jakarta.persistence.Column;
import org.beginnertoexpert.msscbrewery.domain.Beer;
import org.beginnertoexpert.msscbrewery.repositories.Beerrepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final Beerrepository beerrepository;

    public BeerLoader(Beerrepository beerrepository) {
        this.beerrepository = beerrepository;
    }


    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {

        if(beerrepository.count() == 0){
           beerrepository.save(Beer.builder()
                   .beerName("dummy1")
                   .beerStyle("style1")
                   .price(new BigDecimal("12.95"))
                   .upc(301L)
                   .minonhand(12L)
                   .build());
            beerrepository.save(Beer.builder()
                    .beerName("dummy2")
                    .beerStyle("style2")
                    .price(new BigDecimal("11.95"))
                    .upc(302L)
                    .minonhand(12L)
                    .build());
            beerrepository.save(Beer.builder()
                    .beerName("dummy3")
                    .beerStyle("style3")
                    .price(new BigDecimal("10.95"))
                    .upc(303L)
                    .minonhand(12L)
                    .build());
        }
        System.out.println("Loaded : "+beerrepository.count());
    }
}
