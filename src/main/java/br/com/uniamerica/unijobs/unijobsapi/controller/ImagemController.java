package br.com.uniamerica.unijobs.unijobsapi.controller;

import br.com.uniamerica.unijobs.unijobsapi.Entity.Atendimento;
import br.com.uniamerica.unijobs.unijobsapi.Entity.Endereco;
import br.com.uniamerica.unijobs.unijobsapi.Entity.Imagem;
import br.com.uniamerica.unijobs.unijobsapi.repository.EnderecoRepository;
import br.com.uniamerica.unijobs.unijobsapi.repository.ImagemRepository;
import br.com.uniamerica.unijobs.unijobsapi.service.EnderecoService;
import br.com.uniamerica.unijobs.unijobsapi.service.ImagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("api/imagem")
public class ImagemController {


    @Autowired
    public ImagemService imagemService;

    @Autowired
    public ImagemRepository imagemRepository;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(this.imagemRepository.findByImagensAtivos());
    }

    @GetMapping("/filtroId/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            this.imagemService.findById(id);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body(this.imagemRepository.findById(id).orElse(null));
    }
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Imagem imagem){
        this.imagemRepository.save(imagem);
        return ResponseEntity.ok().body("Registro cadastrado com sucesso");
    }


    @PutMapping
    public ResponseEntity<?> atualizar(
            @PathVariable Long id,
            @RequestBody Imagem imagem
    ){
        try {
            this.imagemService.atualizar(id,imagem);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro atualizado com sucesso");
    }


    @DeleteMapping
    public ResponseEntity<?> deletar(
            @PathVariable Long id,
            @RequestBody Imagem imagem
    ){
        try {
            this.imagemService.deletar(id,imagem);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro deletado com sucesso");
    }

}
