package br.com.uniamerica.unijobs.unijobsapi.repository;

import br.com.uniamerica.unijobs.unijobsapi.Entity.Atendimento;
import br.com.uniamerica.unijobs.unijobsapi.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    @Query("SELECT usuario FROM Usuario usuario WHERE usuario.ativo = true")
    public List<Usuario> findByUsuariosAtivos();

    @Query("from Usuario where nome = :nome")
    public List<Usuario> findByNome(@Param("nome") String nome);

    @Query("from Usuario where ra = :ra")
    public List<Usuario> findByRa(@Param("ra") int ra );

    @Query("from Usuario where redeSocial = :redeSocial")
    public List<Usuario> findByRedeSocial(@Param("redeSocial") String redeSocial);

    @Query("from Usuario where telefone = :telefone")
    public List<Usuario> findByTelefone(@Param("telefone") int telefone);

}
