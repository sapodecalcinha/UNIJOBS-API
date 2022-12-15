package br.com.uniamerica.unijobs.unijobsapi.repository;

import br.com.uniamerica.unijobs.unijobsapi.Entity.Atendimento;
import br.com.uniamerica.unijobs.unijobsapi.Entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Long> {

    @Query("SELECT endereco FROM Endereco endereco WHERE endereco.ativo = true")
    public List<Endereco> findByEnderecosAtivos();

    @Query("from Endereco where cep = :cep")
    public List<Endereco> findByCep(@Param("cep") String cep);

    @Query("from Endereco where logradouro = :logradouro")
    public List<Endereco> findByLogradouro(@Param("logradouro")  String logradouro);

    @Query("from Endereco where estado = :estado")
    public List<Endereco> findByEstado(@Param("estado")  String estado);

    @Query("from Endereco where cidade = :cidade")
    public List<Endereco> findByCidade(@Param("cidade") String cidade);

    @Query("from Endereco where numero = :numero")
    public List<Endereco> findByNumero(@Param("numero") String numero);

    @Query("from Endereco where complemento = :complemento")
    public List<Endereco> findByComplemento(@Param("complemento") String complemento);

}
