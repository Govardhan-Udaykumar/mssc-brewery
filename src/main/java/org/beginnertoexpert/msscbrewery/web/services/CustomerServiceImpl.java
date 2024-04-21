package org.beginnertoexpert.msscbrewery.web.services;

import org.beginnertoexpert.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .id(customerId)
                .name("Alex").build();
    }

    @Override
    public CustomerDto postCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(customerDto.getId())
                .name("Alex").build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        // stub....
    }

    @Override
    public void deleteCustomerById(UUID beerId) {
        // stub....
    }
}
