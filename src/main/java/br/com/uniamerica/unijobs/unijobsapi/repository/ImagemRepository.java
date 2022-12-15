package br.com.uniamerica.unijobs.unijobsapi.repository;

import br.com.uniamerica.unijobs.unijobsapi.Entity.Atendimento;
import br.com.uniamerica.unijobs.unijobsapi.Entity.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem,Long> {


  @Query("SELECT imagem FROM Imagem imagem WHERE imagem.ativo = true")
  public List<Imagem> findByImagensAtivos();

  @Query("from Imagem where url = :url")
  public List<Imagem> findByUrl(@Param("url") String url);

  @Query("from Imagem where ordem = :ordem")
  public List<Imagem> findByOrdem(@Param("ordem") int ordem);



}
