package br.unipar.trabalho2bim.repository;

import br.unipar.trabalho2bim.model.Medico;
import io.swagger.annotations.ApiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    @Query
    List<Medico> findAllByOrderByNome();
    @Query("SELECT m FROM Medico m WHERE m.id NOT IN " +
            "(SELECT mi.id FROM Medico mi, Consulta ci " +
            "WHERE mi.id = ci.medico.id AND ((ci.dataHora BETWEEN :dataIni1 AND :dataFim1) " +
            "OR ci.dataHora BETWEEN :dataIni2 AND :dataFim2))")
    List<Medico> findMedicoDisp(@Param("dataIni1") Timestamp dataIni1, @Param("dataFim1") Timestamp dataFim1, @Param("dataIni2") Timestamp dataIni2, @Param("dataFim2") Timestamp dataFim2);
}
