package br.com.unipar.hibernateteste.model.usuario;

import br.com.unipar.hibernateteste.model.enums.SituacaoEnum;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private Date datahora;

    @ManyToOne
    @JoinColumn(name = "id_pet")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(length = 120)
    private String obs;

    private BigDecimal valor_total = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    private SituacaoEnum situacao;

    @OneToMany(mappedBy = "agendamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AgendamentoServico> agendamentoServicos = new ArrayList<>();

    public SituacaoEnum getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoEnum situacao) {
        this.situacao = situacao;
    }

    public Agendamento(Long id, Date datahora, Pet pet, Usuario usuario, String obs, SituacaoEnum situacao) {
        this.id = id;
        this.datahora = datahora;
        this.pet = pet;
        this.usuario = usuario;
        this.obs = obs;
        this.situacao = situacao;
    }

    public Agendamento() {
    }

    public Date getDatahora() {
        return datahora;
    }

    public void setDatahora(Date datahora) {
        this.datahora = datahora;
    }


    public List<AgendamentoServico> getAgendamentoServicos() {
        return agendamentoServicos;
    }

    public void setAgendamentoServicos(List<AgendamentoServico> agendamentoServicos) {
        this.agendamentoServicos = agendamentoServicos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public BigDecimal getValor_total() {
        return valor_total;
    }

    public void setValor_total(BigDecimal valor_total) {
        this.valor_total = valor_total;
    }
    
    public String toStringListaServicos() {
        String servicos = "";
        for (AgendamentoServico listaServico : agendamentoServicos) {
            servicos = servicos + listaServico.getServico().getDescricao() + ",";
        }
        
        if (servicos.length() > 2) {
            servicos.substring(0,servicos.length() - 2);
        }
        return servicos;
    }

    @Override
    public String toString() {
        return "Agendamento{" + "id=" + id + ", datahora=" + datahora + ", pet=" + pet + ", usuario=" + usuario + ", obs=" + obs + ", valor_total=" + valor_total + ", situacao=" + situacao + ", agendamentoServicos=" + agendamentoServicos + '}';
    }

    public static int soma(int a, int b){
        return a+b;
    }
    

}
