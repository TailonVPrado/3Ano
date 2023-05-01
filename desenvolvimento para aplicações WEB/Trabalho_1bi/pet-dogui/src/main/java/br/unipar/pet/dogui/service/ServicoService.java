package br.unipar.pet.dogui.service;

import br.unipar.pet.dogui.model.Servico;
import br.unipar.pet.dogui.service.repository.ServicoRepository;
import java.util.ArrayList;

public class ServicoService {
    
    private ServicoRepository repository = new ServicoRepository();

    public Servico insert(Servico servico) throws Exception {
        
        validaServico(servico);
        
        return repository.insert(servico);
        
    }

    private void validaServico(Servico servico) throws Exception {
    
        if (servico.getDescricao() == null || 
            servico.getDescricao().isEmpty()) {
            throw new Exception("Descricao do servico "
                    + "não informada");
        }
        
        if (servico.getValor() <= 0) {
            throw new Exception("Valor informado deve ser "
                    + "maior que zero");
        }
    
    }

    public Servico update(Servico servico) throws Exception {
    
        validaServico(servico);
        
        return repository.update(servico);
    
    }

    public void delete(int id) throws Exception {
    
        repository.delete(id);
    
    }

    public Servico findById(int id)  throws Exception {
    
        return repository.findById(id);
        
    }
    
    public ArrayList<Servico> findByAll()  throws Exception {
    
        return repository.findAll();
        
    }
    
    public ArrayList<Servico> findWithParameteres(String descricao)  throws Exception {
    
        return repository.findWithParameters(descricao);
        
    }
    
}
