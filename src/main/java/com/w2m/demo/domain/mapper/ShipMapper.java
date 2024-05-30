package com.w2m.demo.domain.mapper;

import com.w2m.demo.api.model.Ship;
import com.w2m.demo.infrastructure.model.ShipDTO;
import org.springframework.stereotype.Component;

@Component
public class ShipMapper {

  public Ship map(ShipDTO src){
    return new Ship(src.getId(), src.getName());
  };

}
