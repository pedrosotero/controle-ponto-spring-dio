package com.dio.projetocontroleponto.Ids;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class MovimentacaoId implements Serializable {
    private long idMovimento;
    private long idUsuario;
}
