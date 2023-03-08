package com.example.jsp_practice.models;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class User {
    private String fio;
    private Long phone;
    private String email;
    private Long age;
}
