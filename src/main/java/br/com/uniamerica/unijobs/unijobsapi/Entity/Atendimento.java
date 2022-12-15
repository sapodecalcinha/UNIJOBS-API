package br.com.uniamerica.unijobs.unijobsapi.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "td_atendimentos", schema = "projetointegrador")
@NoArgsConstructor
public class Atendimento extends AbstractEntity{

    @Getter @Setter
    @Column(name = "hrIninicio", nullable = false)
    private LocalDateTime hrInicio;

    @Getter @Setter
    @Column(name = "hrFinal", nullable = false)
    private LocalDateTime hrFinal;

    @Getter @Setter
    @Column(name = "domingo", nullable = true)
    private Boolean domingo;

    @Getter @Setter
    @Column(name = "segunda", nullable = true)
    private Boolean segunda;

    @Getter @Setter
    @Column(name = "terca", nullable = true)
    private Boolean terca;

    @Getter @Setter
    @Column(name = "quarta", nullable = true)
    private Boolean quarta;

    @Getter @Setter
    @Column(name = "quinta", nullable = true)
    private Boolean quinta;

    @Getter @Setter
    @Column(name = "sexta", nullable = true)
    private Boolean sexta;

    @Getter @Setter
    @Column(name = "sabado", nullable = true)
    private Boolean sabado;



}
