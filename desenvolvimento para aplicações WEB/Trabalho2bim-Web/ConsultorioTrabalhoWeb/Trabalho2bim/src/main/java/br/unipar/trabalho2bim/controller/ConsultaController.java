package br.unipar.trabalho2bim.controller;

import br.unipar.trabalho2bim.model.Consulta;
import br.unipar.trabalho2bim.model.Medico;
import br.unipar.trabalho2bim.model.dto.ConsultaDto;
import br.unipar.trabalho2bim.service.ConsultaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/consulta")
@Api("Controlador responsavel por operações do objeto Consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    @ApiOperation(value = " Endpoint responsavel por inserir uma nova consulta")
    public Consulta insert(@RequestBody ConsultaDto consulta)throws Exception{
        return consultaService.insert(consulta);
    }
    @GetMapping(path = "/{id}")
    @ApiOperation(value = " Endpoint responsavel por consultar uma consulta especifica")
    public Consulta findById (@PathVariable Long id) throws Exception{
        return consultaService.findById(id);
    }

    @GetMapping
    @ApiOperation(value = " Endpoint responsavel por consultar Consultas do sistema")
    public List<Consulta> findALl(){
        return consultaService.findAll();
    }

    @DeleteMapping
    @ApiOperation(value = " Endpoint responsavel por cancelar uma Consulta")
    public Consulta delete(@RequestBody ConsultaDto consultaDto) throws Exception{
        return consultaService.delete(consultaDto);
    }
}
