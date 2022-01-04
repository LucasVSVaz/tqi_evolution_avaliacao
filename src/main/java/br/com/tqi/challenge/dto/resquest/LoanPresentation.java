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


//    public void fromLoan(Loan loan){
//        this.id = loan.getId(),
//        this.value = loan.getValue(),
//        this.firstInstallmentDate = loan.getFirstInstallmentDate(),
//        this.numberInstallments = loan.getNumberInstallments(),
//        this.email = loan.getClient().getEmail(),
//        this.income = loan.getClient().getIncome();
//    }


    public LoanPresentation getStatus(Loan loan) {
        LoanPresentation loanPresentationTest = new LoanPresentation();
        loanPresentationTest.setId(loan.getId());
        loanPresentationTest.setValue(loan.getValue());
        loanPresentationTest.setFirstInstallmentDate(loan.getFirstInstallmentDate());
        loanPresentationTest.setNumberInstallments(loan.getNumberInstallments());
        loanPresentationTest.setEmail(loan.getClient().getEmail());
        loanPresentationTest.setIncome(loan.getClient().getIncome());
        return loanPresentationTest;
    }

}
