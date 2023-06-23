package br.unipar.trabalho2bim.repository;

import br.unipar.trabalho2bim.model.Paciente;
import io.swagger.annotations.ApiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    @Query
    List<Paciente> findAllByOrderByNome();
}
