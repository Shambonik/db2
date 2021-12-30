package com.example.db2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddSportsmanDto {
    private String firstName;
    private String lastName;
    private String middleName;
    private Long trainerId;
    private Long categoryId;
    private Long competitionCategoryId;
}
