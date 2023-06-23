package br.unipar.trabalho2bim.controller;

import br.unipar.trabalho2bim.model.Endereco;
import br.unipar.trabalho2bim.service.EnderecoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/endereco")
@Api("Controlador responsavel por operações do objeto Endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    @ApiOperation(value = "Endpoint responsavel por inserir um novo endereco")
    public Endereco insert(@RequestBody Endereco endereco){
        return enderecoService.insert(endereco);
    }
    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Endpoint responsavel por consultar um endereco especifico")
    public Endereco findById (@PathVariable Long id) throws Exception {
        return enderecoService.findById(id);
    }

}
