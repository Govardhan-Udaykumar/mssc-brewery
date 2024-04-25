package org.beginnertoexpert.msscbrewery.repositories;

import org.beginnertoexpert.msscbrewery.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface Beerrepository extends PagingAndSortingRepository<Beer, UUID> {
}
