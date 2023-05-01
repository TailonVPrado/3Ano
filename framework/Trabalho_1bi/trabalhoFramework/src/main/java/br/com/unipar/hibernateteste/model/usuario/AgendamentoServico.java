package br.com.unipar.hibernateteste.model.usuario;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class AgendamentoServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id_agendamentoservico;

    @ManyToOne
    @JoinColumn(name = "id_agendamento")
    private Agendamento agendamento;

    @ManyToOne
    @JoinColumn(name = "id_servico")
    private Servico servico;

    private BigDecimal valor_un;

    public AgendamentoServico(Agendamento agendamento, Servico servico, BigDecimal valor_un) {
        this.agendamento = agendamento;
        this.servico = servico;
        this.valor_un = valor_un;
    }

    public AgendamentoServico(Long id_agendamentoservico, Agendamento agendamento, Servico servico, BigDecimal valor_un) {
        this.id_agendamentoservico = id_agendamentoservico;
        this.agendamento = agendamento;
        this.servico = servico;
        this.valor_un = valor_un;
    }

    public AgendamentoServico() {
    }

    public Long getId_agendamentoservico() {
        return id_agendamentoservico;
    }

    public void setId_agendamentoservico(Long id_agendamentoservico) {
        this.id_agendamentoservico = id_agendamentoservico;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public BigDecimal getValor_un() {
        return valor_un;
    }

    public void setValor_un(BigDecimal valor_un) {
        this.valor_un = valor_un;
    }

    @Override
    public String toString() {
        return "AgendamentoServico{" + "id_agendamentoservico=" + id_agendamentoservico + ", agendamento=" + agendamento + ", servico=" + servico + ", valor_un=" + valor_un + '}';
    }

}
