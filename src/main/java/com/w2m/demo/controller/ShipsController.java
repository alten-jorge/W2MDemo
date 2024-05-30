package com.w2m.demo.controller;

import java.util.List;
import java.util.Optional;

import com.w2m.demo.api.ShipsApi;
import com.w2m.demo.api.model.Ship;
import com.w2m.demo.domain.ShipsService;
import com.w2m.demo.infrastructure.model.ShipDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ShipsController implements ShipsApi {

  private final ShipsService service;

  @Override
  public ResponseEntity<List<Ship>> findShipById(Long shipId) {
    return ResponseEntity.ok(this.service.getShipById(shipId));
  }

  @Override
  public ResponseEntity<List<Ship>> findShipByName(String shipName) {
    return ResponseEntity.ok(this.service.getShipByName(shipName));
  }

  @Override
  public ResponseEntity<List<Ship>> findAll(Integer page, Integer limit) {
    return ResponseEntity.ok(this.service.getAll(page, limit));
  }

  @Override
  public ResponseEntity<Ship> createShip(String shipName) {
    return ResponseEntity.ok(this.service.createShip(shipName));
  }

  @Override
  public ResponseEntity<ShipDTO> updateShip(ShipDTO shipDTO) {
    return Optional
        .ofNullable(this.service.updateShip(shipDTO))
        .map( ship -> ResponseEntity.ok(ship))
        .orElseGet( () -> ResponseEntity.notFound().build());
  }

  @Override
  public ResponseEntity<ShipDTO> deleteShip(Long shipId) {
    this.service.deleteShip(shipId);
    return ResponseEntity.ok().build();
  }
}

