package br.unipar.trabalho2bim.controller;

import br.unipar.trabalho2bim.model.Paciente;
import br.unipar.trabalho2bim.service.PacienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/paciente")
@Api("Controlador responsavel por operações do objeto Paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;
    @PostMapping
    @ApiOperation(value = " Endpoint responsavel por inserir um novo paciente")
    public Paciente insert (@Valid @RequestBody Paciente paciente){
        return pacienteService.insert(paciente);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = " Endpoint responsavel por consultar um paciente especifico")
    public Paciente findById (@PathVariable Long id) throws Exception{
        return pacienteService.findById(id);
    }

    @GetMapping
    @ApiOperation(value = " Endpoint responsavel por consultar todos os pacientes cadastrados em ordem alfabética")
    public List<Paciente> findAll(){
        return pacienteService.findAll();
    }

    @PutMapping
    @ApiOperation(value = " Endpoint responsavel por atualizar um paciente")
    public Paciente update(@Valid @RequestBody Paciente paciente) throws Exception{
        return pacienteService.update(paciente);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = " Endpoint responsavel por desativar um paciente do sistema")
    public Paciente delete(@PathVariable Long id) throws Exception{
        return pacienteService.delete(id);
    }
}
