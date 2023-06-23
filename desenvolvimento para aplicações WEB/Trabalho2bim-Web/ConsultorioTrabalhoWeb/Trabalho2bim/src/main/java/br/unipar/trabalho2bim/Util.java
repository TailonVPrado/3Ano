package br.unipar.trabalho2bim;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
public class Util {
    public void dateValit(String date) throws Exception{
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDate.parse(date, formatter);
        } catch (Exception e) {
            throw new Exception("Data ou hora inválidos! Verifique.");
        }
    }

    public Date stringToDate(String date) throws Exception{
        dateValit(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try{
            return dateFormat.parse(date);
        }catch (Exception e){
            new Exception("Erro ao converter data");
        }
        return new Date();
    }

    public String diaDaSemana(Date date){
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate.getDayOfWeek().toString();
    }

    public LocalDate dateToLocalDate(Date date){
        Instant instant = date.toInstant();
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        return zonedDateTime.toLocalDate();
    }
    public LocalDateTime dateToLocalDateTime(Date date){
        Instant instant = date.toInstant();
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        return zonedDateTime.toLocalDateTime();
    }

}
