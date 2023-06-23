package br.unipar.trabalho2bim.service;

import br.unipar.trabalho2bim.Util;
import br.unipar.trabalho2bim.model.Consulta;
import br.unipar.trabalho2bim.model.Medico;
import br.unipar.trabalho2bim.model.dto.ConsultaDto;
import br.unipar.trabalho2bim.model.enumModel.MotivoCancelamentoEnum;
import br.unipar.trabalho2bim.repository.ConsultaRepository;
import br.unipar.trabalho2bim.repository.MedicoRepository;
import io.swagger.annotations.ApiModel;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private Util util;
    @Autowired
    private MedicoRepository medicoRepository;

    public Consulta insert(@RequestBody ConsultaDto consultaDto) throws Exception{
        Consulta consulta = new Consulta();
        consulta.setMedico(consultaDto.getMedico());
        consulta.setPaciente(consultaDto.getPaciente());
        consulta.setAtivo(true);
        consulta.setDataHora(util.stringToDate(consultaDto.getDataHora()));

        validaInsert(consulta);

        consultaRepository.saveAndFlush(consulta);
        return consulta;
    }

    public Consulta findById(Long id) throws Exception{
        Optional<Consulta> retorno = consultaRepository.findById(id);
        if (retorno.isPresent()){
            return retorno.get();
        }else{
            throw new Exception("A consulta (" + id + ") não foi encontrada.");
        }
    }

    private void validaInsert(Consulta consulta) throws Exception{
        if(!consulta.getPaciente().isAtivo()){
            throw new Exception("Não é possivel marcar consultas para pacientes inativos!");
        }

        if(consulta.getMedico() != null && !consulta.getMedico().isAtivo()){
            throw new Exception("Não é possivel marcar consultas com médicos inativos!");
        }

        if(util.diaDaSemana(consulta.getDataHora()).equals("SUNDAY")){
            throw new Exception("Não é possivel marcar consultas aos domingos!");
        }

        //valida se o agendamento esta sendo feito 30 minutos antes da consulta
        validaTempoMinimoAgendamento(consulta);

        //valida horario da consulta para que ela seja marcada entre as 07:00 e às 19:00 (aqui ta bem go Horse mesmo)
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(consulta.getDataHora());

        if(!(Integer.parseInt(String.valueOf(calendar.get(Calendar.HOUR_OF_DAY) + ("0"+calendar.get(Calendar.MINUTE)).substring(0,2))) >= 700 &&
                Integer.parseInt(String.valueOf(calendar.get(Calendar.HOUR_OF_DAY) + ("0"+calendar.get(Calendar.MINUTE)).substring(0,2))) <= 1900))  {
            throw new Exception("consultas podem ser marcadas apenas entre as 07:00 e às 19:00");
        }

        if(consultaRepository.findByDataAndPaciente(consulta.getDataHora(), consulta.getPaciente().getId()).size() > 0){
            throw new Exception("Não é possivel marcar mais de uma consulta por dia para o mesmo paciente");
        };

        validaHorarioMedico(consulta);
    }

    private void validaTempoMinimoAgendamento(Consulta consulta) throws Exception{
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(consulta.getDataHora());
        LocalDateTime dateTime = LocalDateTime.of(calendar.get(Calendar.YEAR),
                                                  calendar.get(Calendar.MONTH)+1,
                                                  calendar.get(Calendar.DAY_OF_MONTH),
                                                  calendar.get(Calendar.HOUR_OF_DAY),
                                                  calendar.get(Calendar.MINUTE));

        if(dateTime.minusMinutes(30).isBefore(LocalDateTime.now())){
            throw new Exception("nao é permitido marcar uma consulta com menos de 30 minutos de antecedencia");
        }
    }

    private void validaHorarioMedico(Consulta consulta) throws Exception{
        List<Consulta> listaConsultasDia = consultaRepository.findConstasAgendadas(consulta.getDataHora());

        if(consulta.getMedico() != null){
            for (Consulta con : listaConsultasDia) {
                //mega gambiarra para validar se nao vai ter um horario dentro do outro
                if(consulta.getMedico().getId() == con.getMedico().getId() && con.getMotivoCancelamento() == null){
                    if((util.dateToLocalDateTime(consulta.getDataHora()).isAfter(util.dateToLocalDateTime(con.getDataHora())) || util.dateToLocalDateTime(consulta.getDataHora()).isEqual(util.dateToLocalDateTime(con.getDataHora())))&&
                            (util.dateToLocalDateTime(consulta.getDataHora()).isBefore(util.dateToLocalDateTime(con.getDataHora()).plusMinutes(60)) || util.dateToLocalDateTime(consulta.getDataHora()).isEqual(util.dateToLocalDateTime(con.getDataHora()).plusMinutes(60)))){
                        throw new Exception("Este horário nao esta disponivel com o medico (" + consulta.getMedico().getId()+")");
                    } else if ((util.dateToLocalDateTime(consulta.getDataHora()).plusMinutes(60).isAfter(util.dateToLocalDateTime(con.getDataHora())) || util.dateToLocalDateTime(consulta.getDataHora()).plusMinutes(60).isEqual(util.dateToLocalDateTime(con.getDataHora())))&&
                            (util.dateToLocalDateTime(consulta.getDataHora()).plusMinutes(60).isBefore(util.dateToLocalDateTime(con.getDataHora()).plusMinutes(60)) ||util.dateToLocalDateTime(consulta.getDataHora()).plusMinutes(60).isEqual(util.dateToLocalDateTime(con.getDataHora()).plusMinutes(60)))){
                        throw new Exception("Este horário nao esta disponivel com o medico (" + consulta.getMedico().getId()+")");
                    }
                }
            }
        }else{
            List<Medico> medicosDisponiveis = medicoRepository.findMedicoDisp(Timestamp.valueOf(util.dateToLocalDateTime(consulta.getDataHora())), Timestamp.valueOf(util.dateToLocalDateTime(consulta.getDataHora()).plusHours(1)),
                    Timestamp.valueOf(util.dateToLocalDateTime(consulta.getDataHora()).minusHours(1)), Timestamp.valueOf(util.dateToLocalDateTime(consulta.getDataHora())));

            //aqui vai pegar um medico aleatorio conforme parte do RQF-010
            System.out.println(medicosDisponiveis.size());
            if(medicosDisponiveis.size() > 0){
                int numeroAleatorio = new Random().nextInt(medicosDisponiveis.size());
                consulta.setMedico(medicosDisponiveis.get(numeroAleatorio));
            }else{
                throw new Exception("Não há médicos disponiveis para este horário.");
            }
        }
    }

    public List<Consulta> findAll() {
        return consultaRepository.findAll();
    }

    public Consulta delete(ConsultaDto consultaDto) throws Exception{
        Consulta consulta = validaDelete(consultaDto);
        consultaRepository.saveAndFlush(consulta);
        return consulta;
    }

    private Consulta validaDelete(ConsultaDto consultaDto) throws Exception{
        if(consultaDto.getId() == null){
            throw new Exception("Informe o id da consulta para realizar o seu cancelamento");
        }
        if(consultaDto.getMotivoCancelamento() == null || (!consultaDto.getMotivoCancelamento().equals(MotivoCancelamentoEnum.MEDICO_CANCELOU.toString()) &&
                                                           !consultaDto.getMotivoCancelamento().equals(MotivoCancelamentoEnum.PACIENTE_DESISTIU.toString()) &&
                                                           !consultaDto.getMotivoCancelamento().equals(MotivoCancelamentoEnum.OUTROS.toString()))){
            throw new Exception("Informe um motivo de cancelamento válido. Motivos disponiveis: " + MotivoCancelamentoEnum.MEDICO_CANCELOU+", "+MotivoCancelamentoEnum.PACIENTE_DESISTIU+", " + MotivoCancelamentoEnum.OUTROS);
        }

        Optional<Consulta> optConsulta = consultaRepository.findById(consultaDto.getId());

        if (!optConsulta.isPresent())
            throw new Exception("A consulta com id (" + consultaDto.getId() + ") não esta cadastrada.");
        Consulta consulta = optConsulta.get();

        System.out.println(util.dateToLocalDateTime(consulta.getDataHora()).minusHours(1));
        System.out.println(LocalDateTime.now());
        System.out.println(util.dateToLocalDateTime(consulta.getDataHora()).plusHours(24).isBefore(LocalDateTime.now()));
        if(util.dateToLocalDateTime(consulta.getDataHora()).minusHours(24).isBefore(LocalDateTime.now())){
            throw new Exception("Não é possivel cancelar a consulta, porque o o tempo de antecedência minimima para realizar o cancelamento é de 24 Horas!");
        }

        consulta.setAtivo(false);
        consulta.setMotivoCancelamento(MotivoCancelamentoEnum.valueOf(consultaDto.getMotivoCancelamento()));
        return consulta;
    }
}
