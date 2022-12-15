package br.com.uniamerica.unijobs.unijobsapi.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "td_enderecos", schema = "projetointegrador")
@NoArgsConstructor
public class Endereco extends AbstractEntity{

    @Getter @Setter
    @Column(name = "cep", nullable = false,length = 12)
    private String cep;

    @Getter @Setter
    @Column(name = "logradouro", length = 100, nullable = false)
    private String logradouro;

    @Getter @Setter
    @Column(name = "estado", length = 63, nullable = false, unique = true)
    private String estado;

    @Getter @Setter
    @Column(name = "cidade", length = 63, nullable = false)
    private String cidade;

    @Getter @Setter
    @Column(name = "numero", length = 10, nullable = false)
    private String numero;

    @Getter @Setter
    @Column(name = "complemento", length = 255)
    private String complemento;

}
