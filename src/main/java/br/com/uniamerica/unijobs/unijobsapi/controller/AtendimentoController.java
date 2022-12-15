package br.com.uniamerica.unijobs.unijobsapi.controller;

import br.com.uniamerica.unijobs.unijobsapi.Entity.Atendimento;
import br.com.uniamerica.unijobs.unijobsapi.repository.AtendimentoRepository;
import br.com.uniamerica.unijobs.unijobsapi.service.AtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("api/atendimento")
public class AtendimentoController {

    @Autowired
    public AtendimentoService atendimentoService;

    @Autowired
    public AtendimentoRepository atendimentoRepository;


    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(this.atendimentoRepository.findByAtendimentosAtivos());
    }

    @GetMapping("/filtroId/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            this.atendimentoService.findById(id);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body(this.atendimentoRepository.findById(id).orElse(null));
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Atendimento atendimento){
        this.atendimentoRepository.save(atendimento);
        return ResponseEntity.ok().body("Registro cadastrado com sucesso");
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable Long id,
            @RequestBody Atendimento atendimento
    ){
        try {
            this.atendimentoService.atualizar(id,atendimento);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro atualizado com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(
            @PathVariable Long id,
            @RequestBody Atendimento atendimento
    ){
        try {
            this.atendimentoService.deletar(id,atendimento);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro deletado com sucesso");
    }
}
