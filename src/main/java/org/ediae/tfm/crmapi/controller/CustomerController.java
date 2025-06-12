package org.ediae.tfm.crmapi.controller;

import org.ediae.tfm.crmapi.entity.Customer;
import org.ediae.tfm.crmapi.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/todos")
    public ResponseEntity<List<Customer>> getCustomer() {
    return ResponseEntity.ok(customerService.findAllCustomers());
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<Optional<Customer>> getCustomerById( @PathVariable int id) {
        return ResponseEntity.ok(customerService.findCustomerById(id));
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> deleteCustomerById( @PathVariable int id) {
        customerService.deleteCustomerById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/crearCliente")
    public ResponseEntity<Customer> createClient(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.createCustomer(customer));
    }

    @PutMapping("/actualizarCliente")
    public ResponseEntity<Customer> updateClient(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.updateCustomer(customer));
    }

}
