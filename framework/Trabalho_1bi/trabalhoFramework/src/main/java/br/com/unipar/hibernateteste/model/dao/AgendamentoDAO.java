package br.com.unipar.hibernateteste.model.dao;

import br.com.unipar.hibernateteste.model.usuario.Agendamento;
public class AgendamentoDAO extends GenericDAO<Agendamento>{
    public AgendamentoDAO(){
        super(Agendamento.class);
    }
}
