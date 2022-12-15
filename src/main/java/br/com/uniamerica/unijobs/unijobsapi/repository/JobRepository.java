package br.com.uniamerica.unijobs.unijobsapi.repository;

import br.com.uniamerica.unijobs.unijobsapi.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;


import java.math.BigDecimal;
import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job,Long> {

  @Query("SELECT job FROM Job job WHERE job.ativo = true")
  public List<Job> findByJobsAtivos();

  @Query("SELECT job FROM Job job WHERE job.usuario.id = :id")
  public List<Job> findByJobsUsuario(@Param("id") Long id);

  @Query("from Job where titulo = :titulo")
  public List<Job> findByTitulo(@Param("titulo")  String titulo);

  @Query("from Job where atendimento = :atendimento")
  public List<Job> findByAtendimento(@Param("atendimento") Atendimento atendimento);

  @Query("from Job where preco = :preco")
  public List<Job> findByPreco(@Param("preco")  BigDecimal preco);

  @Query("from Job where tipo = :tipo and ativo is true")
  public List<Job> findByTipo(@Param("tipo") Tipo tipo);

  @Query("from Job where descricao = :descricao")
  public List<Job> findByDescricao(@Param("descricao")  String descricao);

  @Query("from Job where usuario = :usuario")
  public List<Job> findByUsuario(@Param("usuario") Usuario usuario);

  @Query("from Job where endereco = :endereco")
  public List<Job> findByEndereco(@Param("endereco") Endereco endereco);

  @Query("from Job where imagem = :imagem")
  public List<Job> findByImagem(@Param("imagem") Imagem imagem);



}
