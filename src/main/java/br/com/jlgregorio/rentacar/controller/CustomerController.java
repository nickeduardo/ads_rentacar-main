package br.com.jlgregorio.rentacar.controller;

import br.com.jlgregorio.rentacar.dto.CustomerDTO;
import br.com.jlgregorio.rentacar.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*ESSA CAMADA DEVE SER SIMPLES E DIRETA*/

@RestController /*criado para descocoplar ao máximo todas as ferrametas*/
@RequestMapping("/api/customers") /*ponto de entrada da requisição na URL*/
public class CustomerController {
    @Autowired /*para não ter que instanciar o cara depois*/
    private CustomerService service;
    @PostMapping
    public CustomerDTO create(@RequestBody CustomerDTO dto){
        return service.create(dto); /*chamando de service e criando com base na modo*/
    }
    @GetMapping("/{id}")
    public CustomerDTO findById(@PathVariable("id") int id){
        return service.findById(id); /*o endpoint + o parâmetro que inserimos, no caso ID*/
    }

    @GetMapping
    public List<CustomerDTO> findALl(){
        return service.findAll();
    }

    @PutMapping
    public CustomerDTO update(@RequestBody CustomerDTO dto){
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
        CustomerDTO dto = service.findById(id);
        service.delete(dto);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}