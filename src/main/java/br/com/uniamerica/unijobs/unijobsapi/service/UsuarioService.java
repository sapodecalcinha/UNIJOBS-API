package br.com.uniamerica.unijobs.unijobsapi.service;

import br.com.uniamerica.unijobs.unijobsapi.Entity.Job;
import br.com.uniamerica.unijobs.unijobsapi.Entity.Usuario;
import br.com.uniamerica.unijobs.unijobsapi.repository.JobRepository;
import br.com.uniamerica.unijobs.unijobsapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class UsuarioService {


    @Autowired
    public UsuarioRepository usuarioRepository;

    public Usuario findById(Long id){
        return this.usuarioRepository.findById(id).orElse(new Usuario());
    }

    public List<Usuario> findAll()
    {
        return this.usuarioRepository.findAll();
    }

    @Transactional
    public Usuario save(Usuario usuario){
        return this.usuarioRepository.save(usuario);
    }


    @Transactional
    public void atualizar(final Long id, final Usuario usuario){
        if (id.equals(usuario.getId()) && !this.usuarioRepository.findById(id).isEmpty()){
            this.usuarioRepository.save(usuario);
        }else{
            throw new RuntimeException("Id não encontrado");
        }
    }

    @Transactional
    public void deletar(final Long id, final Usuario usuario){
        if (id.equals(usuario.getId()) && !this.usuarioRepository.findById(id).isEmpty()){
            this.usuarioRepository.delete(usuario);
        }else{
            throw new RuntimeException("Id não encontrado");
        }
    }






}
