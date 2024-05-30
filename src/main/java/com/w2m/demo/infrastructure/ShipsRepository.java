package com.w2m.demo.infrastructure;

import java.util.List;

import com.w2m.demo.infrastructure.model.ShipDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipsRepository extends JpaRepository<ShipDTO, Long> {

  List<ShipDTO> findByNameContainingIgnoreCase(@Param("name") String name);

}
