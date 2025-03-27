package domain.api.controller;

import domain.model.Pessoa;
import domain.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Data
@AllArgsConstructor
@RequestMapping(value = "/pessoas")
public class PessoaController {

    private PessoaRepository pessoaRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa adicionar(@RequestBody @Valid Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @GetMapping(value = "/{pessoaId}")
    public ResponseEntity<Pessoa> buscar(@PathVariable Long pessoaId) {
        return this.pessoaRepository.findById(pessoaId)
                .map(pessoa -> ResponseEntity.ok(pessoa))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{pessoaId}")
    public void remover(@PathVariable Long pessoaId) {
        pessoaRepository.deleteById(pessoaId);
    }
}
