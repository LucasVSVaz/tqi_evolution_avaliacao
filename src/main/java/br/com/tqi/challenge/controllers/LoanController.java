package br.com.tqi.challenge.controllers;

import br.com.tqi.challenge.dto.response.MessageResponseDTO;
import br.com.tqi.challenge.dto.resquest.LoanDTO;
import br.com.tqi.challenge.dto.resquest.LoanPresentation;
import br.com.tqi.challenge.entities.Loan;
import br.com.tqi.challenge.exceptions.LoanNotFoundException;
import br.com.tqi.challenge.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/loan")
@AllArgsConstructor
public class LoanController {

    private LoanService loanService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid LoanDTO loanDTO) {
        return loanService.create(loanDTO);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody LoanDTO loanDTO) throws LoanNotFoundException {
        return loanService.updateById(id, loanDTO);
    }

    @DeleteMapping("/{id}")
    public MessageResponseDTO deleteById(@PathVariable Long id) throws LoanNotFoundException {
        return loanService.deleteById(id);
    }

    @GetMapping
    public List<Loan> getAll() {
        return loanService.getAll();
    }

    @GetMapping("/{id}")
    public Loan getById(@PathVariable Long id) throws LoanNotFoundException {
        return loanService.getById(id);
    }

    @GetMapping("/detail")
    public List<LoanPresentation> testReturn (){
        return loanService.loanDetail();
    }
}
