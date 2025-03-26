package domain.api.controller;

import domain.model.Categoria;
import domain.repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Data
@AllArgsConstructor
@RequestMapping("/categorias")
public class CategoriaController {

    private CategoriaRepository categoriaRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria adicionar(@RequestBody @Valid Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @GetMapping("/{categoriaId}")
    public ResponseEntity<Categoria> buscar(@PathVariable Long categoriaId) {
        Optional<Categoria> categoria = this.categoriaRepository.findById(categoriaId);
        return categoria.isPresent() ? ResponseEntity.ok(categoria.get()) : ResponseEntity.notFound().build();
        /*
        return this.categoriaRepository.findById(codigo)
            .map(categoria -> ResponseEntity.ok(categoria))
            .orElse(ResponseEntity.notFound().build());
         */
    }
}
