package br.com.tqi.challenge.dto.resquest;

import br.com.tqi.challenge.entities.Loan;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanPresentation {

    private Long id;

    private BigDecimal value;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate firstInstallmentDate;

    private Integer numberInstallments;

    private String email;

    private BigDecimal income;


    public LoanPresentation getStatus(Loan loan) {
        return LoanPresentation.builder()
                .id(loan.getId())
                .value(loan.getValue())
                .firstInstallmentDate(loan.getFirstInstallmentDate())
                .numberInstallments(loan.getNumberInstallments())
                .email(loan.getClient().getEmail())
                .income(loan.getClient().getIncome())
                .build();
    }



}
