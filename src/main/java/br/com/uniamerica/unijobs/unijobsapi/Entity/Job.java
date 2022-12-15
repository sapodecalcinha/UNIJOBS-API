package br.com.uniamerica.unijobs.unijobsapi.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "td_jobs", schema = "projetointegrador")
@NoArgsConstructor
public class Job extends AbstractEntity{


    @Getter @Setter
    @Column(name = "titulo", length = 20, nullable = false)
    private String titulo;

    @Getter @Setter
    @OneToOne
    @JoinColumn(name = "id_atendimento", nullable = false)
    private Atendimento atendimento;

    @Getter @Setter
    @Column(name = "preco", scale = 3, precision = 5)
    private BigDecimal preco;

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false,length = 30)
    private Tipo tipo;

    @Getter @Setter
    @Column(name = "descricao")
    private String descricao;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Getter @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", nullable = false)
    private List<Endereco> endereco;

    @Getter @Setter
    @OneToOne
    @JoinColumn(name = "id_imagem", nullable = false)
    private Imagem imagem;

}