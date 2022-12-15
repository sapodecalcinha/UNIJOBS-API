package br.com.uniamerica.unijobs.unijobsapi.service;

import br.com.uniamerica.unijobs.unijobsapi.Entity.Job;
import br.com.uniamerica.unijobs.unijobsapi.Entity.Tipo;
import br.com.uniamerica.unijobs.unijobsapi.Entity.Usuario;
import br.com.uniamerica.unijobs.unijobsapi.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class JobService {

    @Autowired
    public JobRepository jobRepository;

    public Job findById(Long id){
        return this.jobRepository.findById(id).orElse(new Job());
    }

    public List<Job> findAll()
    {
        return this.jobRepository.findAll();
    }

    public List<Job> findByTipo(Tipo tipo){ return this.jobRepository.findByTipo(tipo); }

    public List<Job> findByJobUsuario(Long id){ return this.jobRepository.findByJobsUsuario(id); }

    @Transactional
    public Job save(Job job){
        return this.jobRepository.save(job);
    }


    @Transactional
    public void atualizar(final Long id, final Job job){
        if (id.equals(job.getUsuario().getId()) && !this.jobRepository.findByJobsUsuario(id).isEmpty()){
            this.jobRepository.save(job);
        }else{
            throw new RuntimeException("Id não encontrado");
        }
    }

    @Transactional
    public void deletar(final Long id, final Job job){
        if (id.equals(job.getId()) && !this.jobRepository.findById(id).isEmpty()){
            this.jobRepository.delete(job);
        }else{
            throw new RuntimeException("Id não encontrado");
        }
    }



}
