package br.unipar.pet.dogui.service;

import br.unipar.pet.dogui.model.Endereco;
import br.unipar.pet.dogui.service.repository.EnderecoRepository;
import java.util.ArrayList;

public class EnderecoService {

    private EnderecoRepository repository = new EnderecoRepository();

    public Endereco insert(Endereco endereco) throws Exception {
        
        validaEndereco(endereco);
        
        return repository.insert(endereco);
        
    }

    private void validaEndereco(Endereco endereco) throws Exception {
        PessoaService pessoaService = new PessoaService();
        
        if (endereco.getNomeRua()== null ||
            endereco.getNomeRua().isEmpty()) {
            throw new Exception("Nome da rua inválido");
        }
        if (endereco.getDsBairro()== null && 
            endereco.getDsBairro().isEmpty()) {
            throw new Exception("Nome do bairro inválido");
        }
        if(endereco.getPessoa().getId() == 0){
            throw new Exception("Informe a pessoa deste endereço");
        }
        
        if(endereco.getNrCasa() == 0){
            throw new Exception("Informe o número da casa deste endereço");
        }
        
        if(pessoaService.findById(endereco.getPessoa().getId()).getId() == 0){
            throw new Exception("Pessoa não cadastrada");
        }
        
    }

    public Endereco update(Endereco endereco) throws Exception {
        validaEndereco(endereco);
        return repository.update(endereco);
    }

    public void delete(int id) throws Exception {
    
        repository.delete(id);
    
    }

    public Endereco findById(int id)  throws Exception {
    
        return repository.findById(id);
        
    }
    
    public ArrayList<Endereco> findByAll()  throws Exception {
    
        return repository.findAll();
        
    }
    
    public ArrayList<Endereco> findWithParameteres(int idPessoa)  throws Exception {
    
        return repository.findWithParameters(idPessoa);
        
    }
}
