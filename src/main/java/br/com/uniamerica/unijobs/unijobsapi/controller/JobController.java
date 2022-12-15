package br.com.uniamerica.unijobs.unijobsapi.controller;

import br.com.uniamerica.unijobs.unijobsapi.Entity.Atendimento;
import br.com.uniamerica.unijobs.unijobsapi.Entity.Imagem;
import br.com.uniamerica.unijobs.unijobsapi.Entity.Job;
import br.com.uniamerica.unijobs.unijobsapi.Entity.Tipo;
import br.com.uniamerica.unijobs.unijobsapi.repository.ImagemRepository;
import br.com.uniamerica.unijobs.unijobsapi.repository.JobRepository;
import br.com.uniamerica.unijobs.unijobsapi.service.ImagemService;
import br.com.uniamerica.unijobs.unijobsapi.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("api/job")
public class JobController {

    @Autowired
    public JobService jobService;

    @Autowired
    public JobRepository jobRepository;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(this.jobRepository.findByJobsAtivos());
    }

    @GetMapping("/filtroId/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            this.jobService.findById(id);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body(this.jobRepository.findById(id).orElse(null));
    }

    @GetMapping("/filtroTipo/{tipo}")
    public ResponseEntity<?> findByTipo(@PathVariable Tipo tipo) {
        try {
            this.jobService.findByTipo(tipo);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body(this.jobRepository.findByTipo(tipo));
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Job job){
        this.jobRepository.save(job);
        return ResponseEntity.ok().body("Registro cadastrado com sucesso");
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable Long id,
            @RequestBody Job job
    ){
        try {
            this.jobService.atualizar(id,job);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro atualizado com sucesso");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(
            @PathVariable Long id,
            @RequestBody Job job
    ){
        try {
            this.jobService.deletar(id,job);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro deletado com sucesso");
    }
}
