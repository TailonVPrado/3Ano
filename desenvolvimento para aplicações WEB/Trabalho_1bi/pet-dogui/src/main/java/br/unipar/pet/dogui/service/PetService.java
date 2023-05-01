package br.unipar.pet.dogui.service;

import br.unipar.pet.dogui.model.Pet;
import br.unipar.pet.dogui.model.enums.GeneroEnum;
import br.unipar.pet.dogui.model.enums.PorteEnum;
import br.unipar.pet.dogui.service.repository.PetRepository;
import java.util.ArrayList;

public class PetService {


    private PetRepository repository = new PetRepository();

    public Pet insert(Pet pet) throws Exception {
        
        validaPet(pet);
        
        return repository.insert(pet);
        
    }

    private void validaPet(Pet pet) throws Exception {
        PessoaService pessoaService = new PessoaService();
        
        if (pet.getNome() == null || 
            pet.getNome().isEmpty()) {
            throw new Exception("Nome do pet inválido");
        }
        if(pessoaService.findById(pet.getDono().getId()).getId() == 0){
            throw new Exception("Dono não cadastrada");
        }
        
        if(pet.getPeso() <= 0){
            throw new Exception("Peso inválido");
        }
        
        
        /*tentemos validar o ENUM para nao dar problemas na classo, mas ja no insert da PetResource dava problema,
        pelo que deu de entetender é pq ja da erro na hora de criar o objeto, porem nao conseguimos achar umna forma 
        de evitar com que de esse erro feio, voltando uma mensagem tratada.
        obs.: a ideia era tratar o erro aqui, mas o erro acontece bem antes, como ja foi explicado a cima*/
        if(pet.getGenero() != GeneroEnum.FEMEA && 
           pet.getGenero() != GeneroEnum.MACHO){
            throw new Exception("Genero inválido");
        }
        if(pet.getPorte() != PorteEnum.MINI &&
           pet.getPorte() != PorteEnum.PEQUENO &&
           pet.getPorte() != PorteEnum.MEDIO &&
           pet.getPorte() != PorteEnum.GRANDE ){
            throw new Exception("Porte inválido");
        }
        
        
    }

    public Pet update(Pet pet) throws Exception {
        validaPet(pet);
        return repository.update(pet);
    }

    public void delete(int id) throws Exception {
    
        repository.delete(id);
    
    }

    public Pet findById(int id)  throws Exception {
    
        return repository.findById(id);
        
    }
    
    public ArrayList<Pet> findByAll()  throws Exception {
    
        return repository.findAll();
        
    }
    
    public ArrayList<Pet> findWithParameteres(int idDono, String nomePet, String nomeDono)  throws Exception {
    
        return repository.findWithParameters(idDono, nomePet, nomeDono);
        
    }
}
