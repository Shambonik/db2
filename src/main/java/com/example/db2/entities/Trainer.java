package com.example.db2.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "trainer")
@Getter
@Setter
public class Trainer extends Person{

}
