package br.com.tqi.challenge.service;

import br.com.tqi.challenge.dto.response.MessageResponseDTO;
import br.com.tqi.challenge.dto.resquest.ClientDTO;
import br.com.tqi.challenge.entities.Client;
import br.com.tqi.challenge.entities.Loan;
import br.com.tqi.challenge.exceptions.EmptyLoanListException;
import br.com.tqi.challenge.exceptions.PersonNotFoundException;
import br.com.tqi.challenge.repository.ClientRepository;
import br.com.tqi.challenge.repository.LoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class ClientService {

    private ClientRepository clientRepository;
    private LoanRepository loanRepository;
    private PasswordEncoder encoder;


    public MessageResponseDTO create(ClientDTO clientDTO) {
        Client clientSaved = clientDTO.toClient();
        clientSaved.setPassword(encoder.encode(clientSaved.getPassword()));
        clientRepository.save(clientSaved);
        return MessageResponseDTO
                .builder()
                .message("Client created with ID " + clientSaved.getId())
                .build();
    }

    public MessageResponseDTO updateById(Long id, ClientDTO clientDTO) throws PersonNotFoundException {
        verifyIfIdExist(id);
        Client clientSaved = clientDTO.toClient();
        clientRepository.save(clientSaved);
        return MessageResponseDTO
                .builder()
                .message("Client updated with ID " + clientSaved.getId())
                .build();
    }

    public MessageResponseDTO deleteById(Long id) throws PersonNotFoundException {
        verifyIfIdExist(id);
        clientRepository.deleteById(id);
        return MessageResponseDTO
                .builder()
                .message("Client successfully deleted")
                .build();
    }

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Client getById(Long id) throws PersonNotFoundException {
        verifyIfIdExist(id);
        return clientRepository.getById(id);

    }

//    public List<Loan> getLoanList() throws EmptyLoanListException {
//        List<Loan> all = loanRepository.findAll();
//        if (all.isEmpty()){
//            throw new EmptyLoanListException();
//        }
//        return loanRepository.findAll();
//    }

    public List<Loan> getLoanById(Long clientId) throws EmptyLoanListException {
        return loanRepository.findLoadsByClientId(clientId);
    }


    private void verifyIfIdExist(Long id) throws PersonNotFoundException {
        clientRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }
}
