package br.unipar.trabalho2bim.service;

import br.unipar.trabalho2bim.model.Endereco;
import br.unipar.trabalho2bim.repository.EnderecoRepository;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco insert (Endereco endereco){
        enderecoRepository.saveAndFlush(endereco);
        return endereco;
    }
    public Endereco findById (Long id) throws Exception{
        Optional<Endereco> retorno =  enderecoRepository.findById(id);
        if (retorno.isPresent()){
            return retorno.get();
        }else{
            throw new Exception("endereco (" + id + ") não encontrado.");
        }
    }

    public void update(Endereco endereco) {
        enderecoRepository.saveAndFlush(endereco);
    }
}
