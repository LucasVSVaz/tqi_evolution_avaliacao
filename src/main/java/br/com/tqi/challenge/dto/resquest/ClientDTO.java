package br.com.tqi.challenge.dto.resquest;

import br.com.tqi.challenge.entities.Address;
import br.com.tqi.challenge.entities.Client;
import br.com.tqi.challenge.entities.Loan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.DecimalMin;
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

    @DecimalMin(value = "0.0")
    private BigDecimal income;

    @NotEmpty
    private List<Address> address = new ArrayList<>();

    private List<Loan> loan = new ArrayList<>();


    public Client toClient() {
        return Client.builder()
                .name(this.name)
                .cpf(this.cpf)
                .rg(this.rg)
                .address(this.address)
                .email(this.email)
                .password(this.password)
                .income(this.income)
                .loan(this.loan)
                .build();
    }
}
