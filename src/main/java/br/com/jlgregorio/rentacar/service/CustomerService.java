package br.com.jlgregorio.rentacar.service;

import br.com.jlgregorio.rentacar.dto.CustomerDTO;
import br.com.jlgregorio.rentacar.exception.ResourceNotFoundException;
import br.com.jlgregorio.rentacar.mapper.CustomModelMapper;
import br.com.jlgregorio.rentacar.model.CustomerModel;
import br.com.jlgregorio.rentacar.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired /*Conceito de injeção de dependência... Por debaixo dos panos, ele implementa todos os métodos*/
    private CustomerRepository repository;

    public CustomerDTO create(CustomerDTO dto) {
        //converts DTO object to model object
        CustomerModel model = CustomModelMapper.parseObject(dto, CustomerModel.class);
        //..persists the model and return a DTO object
        return CustomModelMapper.parseObject(repository.save(model), CustomerDTO.class);
    }

    //find a model using the id
    public CustomerDTO findById(int id) {
        //retrive the model using the id
        CustomerModel model = repository.findById(id).orElseThrow(() -> new
                ResourceNotFoundException(null));
        //..converts model in DTO object
        return CustomModelMapper.parseObject(model, CustomerDTO.class);
    }

    public List<CustomerDTO> findAll(){ /*criando uma lista de ????IDFK gera uma lista de MODELS*/
        List<CustomerModel> list = repository.findAll();
        return CustomModelMapper.parseObjectList(list, CustomerDTO.class);
    }

    public CustomerDTO update(CustomerDTO dto){
        CustomerModel model = repository.findById(dto.getId()).orElseThrow(() -> new ResourceNotFoundException(null));
        model = CustomModelMapper.parseObject(dto, CustomerModel.class);
        return CustomModelMapper.parseObject(repository.save(model), CustomerDTO.class);
    }

    public void delete(CustomerDTO dto){
        CustomerModel model = repository.findById(dto.getId()).orElseThrow(() -> new ResourceNotFoundException(null));
        repository.delete(model);
    }
    

}
