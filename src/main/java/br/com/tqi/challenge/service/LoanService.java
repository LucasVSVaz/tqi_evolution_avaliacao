package br.com.tqi.challenge.service;

import br.com.tqi.challenge.dto.response.MessageResponseDTO;
import br.com.tqi.challenge.dto.resquest.LoanDTO;
import br.com.tqi.challenge.dto.resquest.LoanPresentation;
import br.com.tqi.challenge.entities.Loan;
import br.com.tqi.challenge.exceptions.LoanNotFoundException;
import br.com.tqi.challenge.repository.LoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LoanService {

    private LoanRepository loanRepository;


    public MessageResponseDTO create(LoanDTO loanDTO) {
        Loan loanSaved = loanDTO.toLoan();
        loanRepository.save(loanSaved);
        return MessageResponseDTO
                .builder()
                .message("Loan created with ID " + loanSaved.getId())
                .build();
    }

    public MessageResponseDTO updateById(Long id, LoanDTO loanDTO) throws LoanNotFoundException {
        verifyIfIdExist(id);
        Loan loanSaved = loanDTO.toLoan();
        loanRepository.save(loanSaved);
        return MessageResponseDTO
                .builder()
                .message("Loan updated with ID " + loanSaved.getId())
                .build();
    }

    public MessageResponseDTO deleteById(Long id) throws LoanNotFoundException {
        verifyIfIdExist(id);
        loanRepository.deleteById(id);
        return MessageResponseDTO
                .builder()
                .message("Loan successfully deleted")
                .build();
    }

    public List<Loan> getAll() {
        return loanRepository.findAll();
    }

    public Loan getById(Long id) throws LoanNotFoundException {
        verifyIfIdExist(id);
        return loanRepository.getById(id);
    }


    public List<LoanPresentation> loanDetail(){
        List<LoanPresentation> testList = new ArrayList<>();
        loanRepository.findAll().forEach(i -> testList.add(new LoanPresentation().getStatus(i)));
        return testList;
    }

    private void verifyIfIdExist(Long id) throws LoanNotFoundException {
        loanRepository.findById(id)
                .orElseThrow(() -> new LoanNotFoundException(id));
    }
}

