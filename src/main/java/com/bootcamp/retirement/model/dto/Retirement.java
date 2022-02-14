package com.bootcamp.retirement.model.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection="retirement")
public class Retirement {
    @Id
    private String _id;
    private String numAccount;
    private double amount;
    private String date;
}
