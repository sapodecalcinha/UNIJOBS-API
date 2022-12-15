package br.com.uniamerica.unijobs.unijobsapi.service;

import br.com.uniamerica.unijobs.unijobsapi.Entity.Atendimento;
import br.com.uniamerica.unijobs.unijobsapi.Entity.Endereco;
import br.com.uniamerica.unijobs.unijobsapi.repository.AtendimentoRepository;
import br.com.uniamerica.unijobs.unijobsapi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class EnderecoService {

    @Autowired
    public EnderecoRepository enderecoRepository;


    public Endereco findById(Long id){
        return this.enderecoRepository.findById(id).orElse(new Endereco());
    }

    public List<Endereco> findAll()
    {
        return this.enderecoRepository.findAll();
    }

    @Transactional
    public Endereco save(Endereco endereco){
        return this.enderecoRepository.save(endereco);
    }


    @Transactional
    public void atualizar(final Long id, final Endereco endereco){
        if (id.equals(endereco.getId()) && !this.enderecoRepository.findById(id).isEmpty()){
            this.enderecoRepository.save(endereco);
        }else{
            throw new RuntimeException("Id não encontrado");
        }
    }

    @Transactional
    public void deletar(final Long id, final Endereco endereco){
        if (id.equals(endereco.getId()) && !this.enderecoRepository.findById(id).isEmpty()){
            this.enderecoRepository.delete(endereco);
        }else{
            throw new RuntimeException("Id não encontrado");
        }
    }



}
