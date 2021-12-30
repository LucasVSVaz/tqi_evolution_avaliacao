package br.com.tqi.challenge.dto.resquest;

import br.com.tqi.challenge.entities.Address;
import br.com.tqi.challenge.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String name;

    @NotEmpty
    @CPF
    private String cpf;

    @NotEmpty
    private String rg;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Size(min = 5)
    private String password;

    private BigDecimal income;

    @NotEmpty
    private List<Address> address = new ArrayList<>();


    public Client toClient() {
        Client client = new Client();
        client.setName(this.name);
        client.setCpf(this.cpf);
        client.setRg(this.rg);
        client.setAddress(this.address);
        client.setEmail(this.email);
        client.setPassword(this.password);
        client.setIncome(this.income);
        return client;
    }
}
