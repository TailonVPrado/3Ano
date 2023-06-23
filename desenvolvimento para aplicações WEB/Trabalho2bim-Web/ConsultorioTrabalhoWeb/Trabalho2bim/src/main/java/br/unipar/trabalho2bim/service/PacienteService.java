package br.unipar.trabalho2bim.service;

import br.unipar.trabalho2bim.model.Medico;
import br.unipar.trabalho2bim.model.Paciente;
import br.unipar.trabalho2bim.repository.EnderecoRepository;
import br.unipar.trabalho2bim.repository.PacienteRepository;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private EnderecoService enderecoService;
    public Paciente insert(Paciente paciente) {
        paciente.setAtivo(true);
        if (paciente.getEndereco().getId() == null){
            enderecoService.insert(paciente.getEndereco());
        }else{
            enderecoService.update(paciente.getEndereco());
        }

        pacienteRepository.saveAndFlush(paciente);
        return paciente;

    }
    public Paciente findById (Long id) throws Exception{
        Optional<Paciente> retorno = pacienteRepository.findById(id);
        if (retorno.isPresent()){
            return retorno.get();
        }else {
            throw new Exception("O Paciente (" + id + ") não foi encontrado.");
        }
    }

    public List<Paciente> findAll() {
        return pacienteRepository.findAllByOrderByNome();
    }

    public Paciente update(Paciente paciente) throws Exception{
        validaUpdate(paciente);
        pacienteRepository.saveAndFlush(paciente);
        return paciente;
    }
    public void validaUpdate(Paciente paciente) throws Exception{
        if(paciente.getId() == null)
            throw new Exception("para atualizar o registro informe o ID");

        Optional<Paciente> optPaciente = pacienteRepository.findById(paciente.getId());
        Paciente oldPaciente;

        if (!optPaciente.isPresent())
            throw new Exception("O paciente com id (" + paciente.getId() + ") não esta cadastrado.");

        oldPaciente = optPaciente.get();

        if (!paciente.getEmail().equals(oldPaciente.getEmail()))
            throw new Exception("Não é permitido alterar o email do paciente");
        else if (!paciente.getCpf().equals(oldPaciente.getCpf()))
            throw new Exception("Não é permitido alterar o CPF do paciente");

    }

    public Paciente delete(Long id) throws Exception{
        Optional<Paciente> optPaciente = pacienteRepository.findById(id);
        Paciente paciente;

        if (!optPaciente.isPresent())
            throw new Exception("O paciente com id (" + id + ") não esta cadastrado.");

        paciente = optPaciente.get();
        paciente.setAtivo(false);
        pacienteRepository.saveAndFlush(paciente);
        return paciente;
    }
}
