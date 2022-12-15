package br.com.uniamerica.unijobs.unijobsapi.controller;

import br.com.uniamerica.unijobs.unijobsapi.Entity.Atendimento;
import br.com.uniamerica.unijobs.unijobsapi.Entity.Endereco;
import br.com.uniamerica.unijobs.unijobsapi.repository.EnderecoRepository;
import br.com.uniamerica.unijobs.unijobsapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("api/endereco")
public class EnderecoController {

    @Autowired
    public EnderecoService enderecoService;

    @Autowired
    public EnderecoRepository enderecoRepository;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(this.enderecoRepository.findByEnderecosAtivos());
    }

    @GetMapping("/filtroId/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            this.enderecoService.findById(id);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body(this.enderecoRepository.findById(id).orElse(null));
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Endereco endereco){
        this.enderecoRepository.save(endereco);
        return ResponseEntity.ok().body("Registro cadastrado com sucesso");
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable Long id,
            @RequestBody Endereco endereco
    ){
        try {
            this.enderecoService.atualizar(id,endereco);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro atualizado com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(
            @PathVariable Long id,
            @RequestBody Endereco endereco
    ){
        try {
            this.enderecoService.deletar(id,endereco);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro deletado com sucesso");
    }


}
