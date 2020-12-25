package guru.springframework.msscbrewery.customer.web;


import guru.springframework.msscbrewery.customer.service.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId) {
        return new ResponseEntity<>(CustomerDto.builder().customerId(customerId).name("SERCAN").build(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity createCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto savedCustomer = customerService.createCustomer(customerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/customer" + savedCustomer.getCustomerId().toString());

        return  new ResponseEntity(headers,HttpStatus.CREATED);
    }


    @PutMapping("/{customerId}")
    public ResponseEntity getCustomer(@PathVariable("customerId") UUID customerId,@RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(customerId,customerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerId") UUID customerId){
        customerService.deleteCustomer(customerId);
    }

}
