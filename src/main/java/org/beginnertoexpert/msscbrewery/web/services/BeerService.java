package org.beginnertoexpert.msscbrewery.web.services;

import org.beginnertoexpert.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);
}
