package br.com.uniamerica.unijobs.unijobsapi.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "td_usuarios", schema = "projetointegrador")
@NoArgsConstructor
public class Usuario extends AbstractEntity{

    @Getter @Setter
    @Column(name = "nome", length = 30, nullable = false)
    private String nome;

    @Getter @Setter
    @Column(name = "ra", nullable = false, unique = true)
    private String ra;

    @Getter @Setter
    @Column(name = "redeSocial", length = 80,nullable = true, unique = true)
    private String redeSocial;

    @Getter @Setter
    @Column(name = "telefone", nullable = false, unique = true)
    private String telefone;


}
