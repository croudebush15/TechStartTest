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
public class Manufacturer {
    @Id
    private String Id;
    private String name;
    private String Address;
    private String Contact;
}
