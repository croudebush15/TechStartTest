package com.test.techstarttestapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Invoice {

    @Id
    private String id;
    private Integer invoiceNumber;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date purchaseDate;
    private Integer totalPurchases;
    private CustomerLocation CustomerLocation;
    private DistributorLocation DistributorLocation;

    public void addTotalPurchases(){
        this.totalPurchases = getTotalPurchases() + 1;
    }
}
