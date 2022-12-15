package br.com.uniamerica.unijobs.unijobsapi.service;


import br.com.uniamerica.unijobs.unijobsapi.Entity.Imagem;
import br.com.uniamerica.unijobs.unijobsapi.repository.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ImagemService {
    @Autowired
    public ImagemRepository imagemRepository;


    public Imagem findById(Long id){
        return this.imagemRepository.findById(id).orElse(new Imagem());
    }

    public List<Imagem> findAll()
    {
        return this.imagemRepository.findAll();
    }

    @Transactional
    public Imagem save(Imagem imagem){
        return this.imagemRepository.save(imagem);
    }


    @Transactional
    public void atualizar(final Long id, final Imagem imagem){
        if (id.equals(imagem.getId()) && !this.imagemRepository.findById(id).isEmpty()){
            this.imagemRepository.save(imagem);
        }else{
            throw new RuntimeException("Id não encontrado");
        }
    }

    @Transactional
    public void deletar(final Long id, final Imagem imagem){
        if (id.equals(imagem.getId()) && !this.imagemRepository.findById(id).isEmpty()){
            this.imagemRepository.delete(imagem);
        }else{
            throw new RuntimeException("Id não encontrado");
        }
    }

}
