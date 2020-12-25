package guru.springframework.msscbrewery.customer.service;

import guru.springframework.msscbrewery.customer.web.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CustomerServiceImp implements  CustomerService{
    @Override
    public CustomerDto getCustomer(UUID customerId) {
        return CustomerDto.builder().customerId(customerId).name("SERCAN").build();
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        return CustomerDto.builder().customerId(UUID.randomUUID()).name("SERCAN").build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {

    }

    @Override
    public void deleteCustomer(UUID customerId) {
        log.debug("Deleting Customer..");
    }
}
