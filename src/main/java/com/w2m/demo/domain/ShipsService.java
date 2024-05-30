package com.w2m.demo.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.w2m.demo.api.model.Ship;
import com.w2m.demo.domain.mapper.ShipMapper;
import com.w2m.demo.infrastructure.ShipsRepository;
import com.w2m.demo.infrastructure.model.ShipDTO;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ShipsService {

  private final ShipsRepository repository;

  private final ShipMapper mapper;

  public List<Ship> getShipById (Long id){
    return this.repository.findAllById(Arrays.asList(id)).stream()
        .map(mapper::map)
        .collect(Collectors.toList());
    }

  @Cacheable(value = "shipCache")
  public List<Ship> getAll(Integer page, Integer limit) {
    Pageable pageable = PageRequest.of(page, limit);
    return this.repository.findAll(pageable).stream()
        .map(mapper::map)
        .collect(Collectors.toList());
  }

  public List<Ship> getShipByName(String shipName) {
    return this.repository.findByNameContainingIgnoreCase(shipName).stream()
        .map(mapper::map)
        .collect(Collectors.toList());
  }

  public Ship createShip(String shipName) {
    ShipDTO shipDto = new ShipDTO();
    shipDto.setName(shipName);
    return mapper.map(this.repository.save(shipDto));
  }

  public ShipDTO updateShip(ShipDTO shipDTO) {
    final var isEmpty = this.repository.findAllById(Arrays.asList(shipDTO.getId())).isEmpty();
    if (isEmpty) {
      return null;
    }
    return this.repository.save(shipDTO);
  }

  public void deleteShip(Long shipId) {
    this.repository.deleteById(shipId);
  }
}