package com.w2m.demo.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.w2m.demo.api.model.Ship;
import com.w2m.demo.domain.ShipsService;
import com.w2m.demo.domain.mapper.ShipMapper;
import com.w2m.demo.infrastructure.ShipsRepository;
import com.w2m.demo.infrastructure.model.ShipDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ShipsServiceTest {

  private ShipsService service;

  @Mock
  private ShipsRepository repository;

  @Mock
  private ShipMapper mapper;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    service = new ShipsService(repository, mapper);
  }

  @Test
  public void getShipById() {
    List<ShipDTO> ships = new ArrayList<>();
    ShipDTO ship = new ShipDTO();
    ship.setId(1);
    ship.setName("Test ship");
    ships.add(ship);
    when(repository.findAllById(any()))
        .thenReturn(ships);
    when(mapper.map(any()))
        .thenReturn(new Ship(1L, "Test ship"));

    assertTrue(service.getShipById(1L).get(0).getId() == 1L);
  }

  @Test
  public void getShipByName() {
    List<ShipDTO> ships = new ArrayList<>();
    ShipDTO ship = new ShipDTO();
    ship.setId(1);
    ship.setName("Test ship");
    ships.add(ship);
    when(repository.findByNameContainingIgnoreCase(any()))
        .thenReturn(ships);
    when(mapper.map(any()))
        .thenReturn(new Ship(1L, "Test ship"));

    assertTrue(service.getShipByName("test").get(0).getName().equals("Test ship"));
  }

  @Test
  public void createShip() {
    ShipDTO ship = new ShipDTO();
    ship.setId(1);
    ship.setName("New ship");
    when(repository.save(any()))
        .thenReturn(ship);
    when(mapper.map(any()))
        .thenReturn(new Ship(1L, "New ship"));

    assertTrue(service.createShip("New Ship").getName().equals("New ship"));
  }

  @Test
  public void updateShip() {
    List<ShipDTO> ships = new ArrayList<>();
    ShipDTO ship = new ShipDTO();
    ship.setId(1);
    ship.setName("Updated ship");
    ships.add(ship);
    when(repository.findAllById(any()))
        .thenReturn(ships);
    when(repository.save(any()))
        .thenReturn(ship);
    when(mapper.map(any()))
        .thenReturn(new Ship(1L, "Updated ship"));

    assertTrue(service.createShip("Updated Ship").getName().equals("Updated ship"));
  }

  @Test
  public void deleteShip() {
      service.deleteShip(1L);
      verify(repository, times(1)).deleteById(any());
  }
}
