package com.rafael.controleponto.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Builder
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class BancoHorasPk implements Serializable {

    private Long idBancoHoras;
    private Long idMovimento;
    private Long idUsuario;

}
