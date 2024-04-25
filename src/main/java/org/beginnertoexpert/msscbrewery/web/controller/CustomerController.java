package org.beginnertoexpert.msscbrewery.web.controller;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.beginnertoexpert.msscbrewery.web.model.BeerDto;
import org.beginnertoexpert.msscbrewery.web.model.CustomerDto;
import org.beginnertoexpert.msscbrewery.web.services.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("customerId")UUID customerId){

        return new ResponseEntity<CustomerDto>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> handlePost(@Valid @RequestBody CustomerDto customerDto){
       CustomerDto customerDto1 = customerService.postCustomer(customerDto);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location","/api/v1/customer"+customerDto1.getId().toString());

        return new ResponseEntity<>(httpHeaders,HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDto> handlePost(@PathVariable UUID customerId,@Valid @RequestBody CustomerDto customerDto){
        customerService.updateCustomer(customerId,customerDto);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<BeerDto> deleteCustomerById(@PathVariable("customerId") UUID beerId){
        customerService.deleteCustomerById(beerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
