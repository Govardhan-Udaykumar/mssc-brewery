package org.beginnertoexpert.msscbrewery.web.services;

import org.beginnertoexpert.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);
}
