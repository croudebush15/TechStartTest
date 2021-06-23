package com.test.techstarttestapi.model;

import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class InvoiceLine {
    @Id
    private String Id;
    @Nullable
    private Integer Qty;
    @Nullable
    private Integer Weight;
    private String UnitOfMeasure;
    //maybe use BigDecimal for money value?
    private Double UnitPrice;
    private String ProductId;
    private String InvoiceId;
}
