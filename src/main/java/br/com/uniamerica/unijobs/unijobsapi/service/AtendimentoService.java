package br.com.uniamerica.unijobs.unijobsapi.service;

import br.com.uniamerica.unijobs.unijobsapi.Entity.Atendimento;
import br.com.uniamerica.unijobs.unijobsapi.repository.AtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AtendimentoService {


    @Autowired
    public AtendimentoRepository atendimentoRepository;


    public Atendimento findById(Long id){
        return this.atendimentoRepository.findById(id).orElse(new Atendimento());
    }
    public List<Atendimento> findAll()
    {
        return this.atendimentoRepository.findAll();
    }


    @Transactional
    public Atendimento save(Atendimento atendimento){
        return this.atendimentoRepository.save(atendimento);
    }


    @Transactional
    public void atualizar(final Long id, final Atendimento atendimento){
        if (id.equals(atendimento.getId()) && !this.atendimentoRepository.findById(id).isEmpty()){
            this.atendimentoRepository.save(atendimento);
        }else{
            throw new RuntimeException("Id não encontrado");
        }
    }

    @Transactional
    public void deletar(final Long id, final Atendimento atendimento){
        if (id.equals(atendimento.getId()) && !this.atendimentoRepository.findById(id).isEmpty()){
            this.atendimentoRepository.delete(atendimento);
        }else{
            throw new RuntimeException("Id não encontrado");
        }
    }



}
