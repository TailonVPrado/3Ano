package br.unipar.trabalho2bim.service;

import br.unipar.trabalho2bim.model.Medico;
import br.unipar.trabalho2bim.model.enumModel.EspecialidadeEnum;
import br.unipar.trabalho2bim.repository.EnderecoRepository;
import br.unipar.trabalho2bim.repository.MedicoRepository;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private EnderecoService enderecoService;
    public Medico insert (Medico medico) throws Exception {
        validaCadastro(medico);
        medico.setAtivo(true);
        if(medico.getEndereco().getId() == null){
            enderecoService.insert(medico.getEndereco());
        }
        else{
            enderecoService.update(medico.getEndereco());
        }

        medicoRepository.saveAndFlush(medico);
        return medico;
    }
    public Medico findById (Long id) throws Exception{
        Optional<Medico> retorno = medicoRepository.findById(id);
        if (retorno.isPresent()){
            return retorno.get();
        }else {
            throw new Exception("Medico (" + id + ") não foi encontrado.");
        }
    }

    public List<Medico> findAll() {
        return medicoRepository.findAllByOrderByNome();
    }

    public void validaCadastro (Medico medico) throws Exception{
        if(medico.getEspecialidade() == null){
            throw new Exception("A especialidade deve ser informada");
        }
        if(medico.getEspecialidade() != EspecialidadeEnum.CARDIOLOGIA &&
                medico.getEspecialidade() != EspecialidadeEnum.GINECOLOGIA &&
                medico.getEspecialidade() != EspecialidadeEnum.DERMATOLOGIA &&
                medico.getEspecialidade() != EspecialidadeEnum.ORTOPEDIA){
            throw new Exception("A especialidade informada é inválida");
        }
    }

    public Medico update(Medico medico) throws Exception{
        validaUpdate(medico);
        medicoRepository.saveAndFlush(medico);
        return medico;
    }

    public void validaUpdate(Medico medico) throws Exception{
        if(medico.getId() == null)
            throw new Exception("para atualizar o registro informe o ID");

        Optional<Medico> optMedico = medicoRepository.findById(medico.getId());
        Medico oldMedico;

        if (!optMedico.isPresent())
            throw new Exception("O médico com id (" + medico.getId() + ") não esta cadastrado.");

        oldMedico = optMedico.get();

        if (!medico.getEmail().equals(oldMedico.getEmail()))
            throw new Exception("Não é permitido alterar o email do médico");
        else if (!medico.getCrm().equals(oldMedico.getCrm()))
            throw new Exception("Não é permitido alterar o CRM do médico");
        else if (medico.getEspecialidade() != oldMedico.getEspecialidade())
            throw new Exception("Não é permitido alterar a especialidade do médico");
    }

    public Medico delete(Long id) throws Exception{
        Optional<Medico> optMedico = medicoRepository.findById(id);
        Medico medico;

        if (!optMedico.isPresent())
            throw new Exception("O médico com id (" + id + ") não esta cadastrado.");

        medico = optMedico.get();
        medico.setAtivo(false);
        medicoRepository.saveAndFlush(medico);
        return medico;
    }
}
