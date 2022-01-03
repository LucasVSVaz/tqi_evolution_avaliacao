package br.com.tqi.challenge.dto.resquest;

import br.com.tqi.challenge.entities.Client;
import br.com.tqi.challenge.entities.Loan;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanDTO {

    private Long id;

    @NotBlank(message = "value starting with 0")
    private BigDecimal value;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate firstInstallmentDate;

    @Min(1)
    @Max(60)
    private Integer numberInstallments;

    private Client client;


    public Loan toLoan() {
        return Loan.builder()
                .value(this.value)
                .firstInstallmentDate(this.firstInstallmentDate)
                .numberInstallments(this.numberInstallments)
                .client(this.client)
                .build();
    }
}
