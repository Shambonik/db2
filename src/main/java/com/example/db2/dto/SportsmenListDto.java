package com.example.db2.dto;

import com.example.db2.entities.Sportsman;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SportsmenListDto {
    List<Sportsman> list;
}
