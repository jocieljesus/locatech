package br.com.fiap.locatech.controllers;

import br.com.fiap.locatech.entities.Aluguel;
import br.com.fiap.locatech.services.AluguelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {

    private static final Logger logger = LoggerFactory.getLogger(AluguelController.class);

    private final AluguelService aluguelService;

    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    @GetMapping
    public ResponseEntity<List<Aluguel>> listarAlgueis(@RequestParam("page") int page, @RequestParam("size") int size) {
        logger.info("GET -> listarAlugueis");
        var alugueis = aluguelService.findAllAlugueis(page, size);
        return ResponseEntity.ok(alugueis);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Aluguel>> listarAluguelById(@PathVariable long id){
        logger.info("GET -> listarAluguelById");
        var aluguel = aluguelService.findAluguelById(id);
        return ResponseEntity.ok(aluguel);
    }

    @PostMapping
    public ResponseEntity<Void> salvarAluguel(@RequestBody Aluguel aluguel){
        logger.info("POST -> salvarAluguel");
        this.aluguelService.saveAluguel(aluguel);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarAluguel(@PathVariable long id, @RequestBody Aluguel aluguel){
        logger.info("POST -> updateAluguel");
        this.aluguelService.updateAluguel(aluguel, id);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluguel(@PathVariable("id") long id){
        logger.info("DELETE -> deleteAluguel");
        this.aluguelService.deleteAluguel(id);
        return ResponseEntity.ok().build();
    }
}
