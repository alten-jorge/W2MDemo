package com.w2m.demo.infrastructure.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "SHIPS")
public class ShipDTO {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private long id;

  private String name;
}
