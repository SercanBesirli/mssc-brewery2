package guru.springframework.msscbrewery.customer.service;

import guru.springframework.msscbrewery.customer.web.CustomerDto;

import java.util.UUID;


public interface CustomerService {


    CustomerDto getCustomer(UUID customerId);

    CustomerDto createCustomer(CustomerDto customerDto);

    void updateCustomer(UUID customerId, CustomerDto customerDto);

    void deleteCustomer(UUID customerId);
}
