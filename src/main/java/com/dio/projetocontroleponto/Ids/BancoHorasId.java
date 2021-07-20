package com.dio.projetocontroleponto.Ids;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Embeddable
public class BancoHorasId implements Serializable {
    private long idBancoHoras;
    private long idMovimentacao;
    private long idUsuario;
}
