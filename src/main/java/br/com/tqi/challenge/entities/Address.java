package br.com.tqi.challenge.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 2)
    private String state;

    @Column(nullable = false)
    @Size(min = 2)
    private String city;

    @Column(nullable = false)
    @Size(min = 2)
    private String district;

    @Column(nullable = false)
    @Size(min = 2)
    private String street;

    @Column(nullable = false)
    private Integer number;

    @Column(nullable = false)
    @Size(min = 8, max = 9)
    private String cep;


}
