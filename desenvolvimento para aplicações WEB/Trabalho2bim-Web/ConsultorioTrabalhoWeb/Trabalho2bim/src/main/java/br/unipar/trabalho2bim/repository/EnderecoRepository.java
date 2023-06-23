package br.unipar.trabalho2bim.repository;

import br.unipar.trabalho2bim.model.Endereco;
import io.swagger.annotations.ApiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository <Endereco, Long> {

}
