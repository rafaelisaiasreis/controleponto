package com.rafael.controleponto.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TipoData {
    @Id
    private Long id;
    private String descricao;
}
