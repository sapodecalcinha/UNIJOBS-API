package br.com.uniamerica.unijobs.unijobsapi.repository;

import br.com.uniamerica.unijobs.unijobsapi.Entity.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento,Long> {

 @Query("SELECT atendimento FROM Atendimento atendimento WHERE atendimento.ativo = true")
 public List<Atendimento> findByAtendimentosAtivos();

 @Query("from Atendimento where hrInicio = :hrInicio")
 public List<Atendimento> findByHrInicio(@Param("hrInicio") LocalDateTime hrInicio);

 @Query("from Atendimento where hrFinal = :hrFinal")
 public List<Atendimento> findByHrFinal(@Param("hrFinal") LocalDateTime hrFinal);

 @Query("from Atendimento where domingo = :domingo")
 public List<Atendimento> findByDomingo(@Param("domingo")  Boolean domingo);

 @Query("from Atendimento where segunda = :segunda")
 public List<Atendimento> findBySegunda(@Param("segunda")  Boolean segunda);

 @Query("from Atendimento where terca = :terca")
 public List<Atendimento>  findByTerca(@Param("terca") Boolean terca);

 @Query("from Atendimento where quarta = :quarta")
 public List<Atendimento> findByQuarta(@Param("quarta")  Boolean quarta);

 @Query("from Atendimento where quinta = :quinta")
 public List<Atendimento> findByQuinta(@Param("quinta") Boolean quinta);

 @Query("from Atendimento where sexta = :sexta")
 public List<Atendimento> findBtSexta(@Param("sexta")  Boolean sexta);

 @Query("from Atendimento where sabado = :sabado")
 public List<Atendimento> findBySabado(@Param("sabado") Boolean sabado);

}
