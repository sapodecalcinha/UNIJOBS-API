package br.com.uniamerica.unijobs.unijobsapi.controller;

import br.com.uniamerica.unijobs.unijobsapi.Entity.Atendimento;
import br.com.uniamerica.unijobs.unijobsapi.Entity.Job;
import br.com.uniamerica.unijobs.unijobsapi.Entity.Usuario;
import br.com.uniamerica.unijobs.unijobsapi.repository.JobRepository;
import br.com.uniamerica.unijobs.unijobsapi.repository.UsuarioRepository;
import br.com.uniamerica.unijobs.unijobsapi.service.JobService;
import br.com.uniamerica.unijobs.unijobsapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("api/usuario")
public class UsuarioController {

    @Autowired
    public UsuarioService usuarioService;

    @Autowired
    public UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(this.usuarioRepository.findByUsuariosAtivos());
    }

    @GetMapping("/filtroId/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            this.usuarioService.findById(id);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body(this.usuarioRepository.findById(id).orElse(null));
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Usuario usuario){
        this.usuarioRepository.save(usuario);
        return ResponseEntity.ok().body("Registro cadastrado com sucesso");
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable Long id,
            @RequestBody Usuario usuario
    ){
        try {
            this.usuarioService.atualizar(id,usuario);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro atualizado com sucesso");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(
            @PathVariable Long id,
            @RequestBody Usuario usuario
    ){
        try {
            this.usuarioService.deletar(id,usuario);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro deletado com sucesso");
    }







}
