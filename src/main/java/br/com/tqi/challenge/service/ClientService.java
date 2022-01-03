package br.com.tqi.challenge.service;

import br.com.tqi.challenge.dto.response.MessageResponseDTO;
import br.com.tqi.challenge.dto.resquest.ClientDTO;
import br.com.tqi.challenge.entities.Client;
import br.com.tqi.challenge.entities.Loan;
import br.com.tqi.challenge.exceptions.PersonNotFoundException;
import br.com.tqi.challenge.repository.ClientRepository;
import br.com.tqi.challenge.repository.LoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    private ClientRepository clientRepository;
    private LoanRepository loanRepository;


    public MessageResponseDTO create(ClientDTO clientDTO) {
        Client clientSaved = clientDTO.toClient();
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

    public List<Loan> getLoanList(){
        return loanRepository.findAll();
    }


    private void verifyIfIdExist(Long id) throws PersonNotFoundException {
        clientRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }
}
