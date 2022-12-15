package br.com.uniamerica.unijobs.unijobsapi.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "td_imagens", schema = "projetointegrador")
@NoArgsConstructor
public class Imagem extends AbstractEntity{

    @Getter @Setter
    @Column(name = "url", length = 255,nullable = false)
    private String url;

    @Getter @Setter
    @Column(name = "ordem", nullable = false)
    private int ordem;

}
