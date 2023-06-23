package br.unipar.trabalho2bim.controller;

import br.unipar.trabalho2bim.model.Medico;
import br.unipar.trabalho2bim.service.MedicoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping(path = "/medico")
@Api("Controlador responsavel por operações do objeto Medico")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;
    @PostMapping
    @ApiOperation(value = " Endpoint responsavel por inserir um novo médico")
    public Medico insert(@Valid @RequestBody Medico medico) throws Exception{
        return medicoService.insert(medico);
    }
    @GetMapping(path = "/{id}")
    @ApiOperation(value = " Endpoint responsavel por consultar um médico especifico")
    public Medico findById (@PathVariable Long id) throws Exception{
        return medicoService.findById(id);
    }

    @GetMapping
    @ApiOperation(value = " Endpoint responsavel por consultar todos os médicos cadastrados em ordem alfabética")
    public List<Medico> findALl(){
        return medicoService.findAll();
    }

    @PutMapping
    @ApiOperation(value = " Endpoint responsavel por atualizar um médico")
    public Medico update(@Valid @RequestBody Medico medico) throws Exception{
        return medicoService.update(medico);
    }
    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = " Endpoint responsavel por desativar um médico do sistema")
    public Medico delete (@PathVariable Long id) throws Exception{
        return medicoService.delete(id);
    }
}