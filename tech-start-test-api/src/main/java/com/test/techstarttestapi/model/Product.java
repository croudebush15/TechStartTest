package com.test.techstarttestapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Product {
    @Id
    private String Id;
    private String Description;
    private Integer productCode;
    private DistributorLocation Distributor;
    private Manufacturer Manufacturer;
}
