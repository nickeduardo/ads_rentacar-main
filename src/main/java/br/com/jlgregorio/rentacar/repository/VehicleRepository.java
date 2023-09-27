package br.com.jlgregorio.rentacar.repository;

import br.com.jlgregorio.rentacar.model.CustomerModel;
import br.com.jlgregorio.rentacar.model.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*Vai interagir direto com o banco de dados*/
@Repository
public interface VehicleRepository extends JpaRepository<VehicleModel, Integer> {

}
