package br.unipar.trabalho2bim.repository;

import br.unipar.trabalho2bim.model.Consulta;
import io.swagger.annotations.ApiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    @Query("SELECT c FROM Consulta c WHERE date(c.dataHora) = date(:data) AND c.paciente.id = :id")
    List<Consulta> findByDataAndPaciente(@Param("data") Date data, @Param("id") Long id);

    @Query("SELECT c from Consulta c where date(c.dataHora) = date(:data)")
    List<Consulta> findConstasAgendadas(@Param("data") Date data);

}
