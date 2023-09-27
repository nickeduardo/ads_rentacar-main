package br.com.jlgregorio.rentacar.repository;

import br.com.jlgregorio.rentacar.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*Vai interagir direto com o banco de dados*/

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Integer> {



}
