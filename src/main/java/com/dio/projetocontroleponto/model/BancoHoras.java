package com.dio.projetocontroleponto.model;

import com.dio.projetocontroleponto.Ids.BancoHorasId;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Audited
@Entity
public class BancoHoras {

    @EmbeddedId
    private BancoHorasId id;
    private LocalDateTime dataTrabalhada;
    private BigDecimal quantidadeHoras;
    private BigDecimal saldoHoras;
}
