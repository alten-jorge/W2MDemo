package com.w2m.demo.api;


import java.util.List;

import com.w2m.demo.api.model.Ship;
import com.w2m.demo.infrastructure.model.ShipDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface ShipsApi {

  /**
   * GET /api/v1/ships/{shipId} : Get ship from id Get the ship from id
   *
   * @param shipId Ship id (required)
   * @return OK (status code 200) or No content (status code 204) or Bad request. One or more parameters has an invalid value. (status code
   *     400) or Resource not found (status code 404) or Internal Server Error (status code 500) or Service Unavailable Error (status code
   *     503) or Gateway Timeout (status code 504)
   */
  @GetMapping(
      value = "/api/v1/ships/{shipId}",
      produces = { "application/json" }
  )
  default ResponseEntity<List<Ship>> findShipById(
      @PathVariable("shipId") Long shipId
  ) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }

  /**
   * GET /api/v1/ships/name/{shipName} : Get ships from name Get ships from name, even if not exact match
   *
   * @param shipName Ship name (required)
   * @return OK (status code 200) or No content (status code 204) or Bad request. One or more parameters has an invalid value. (status code
   *     400) or Resource not found (status code 404) or Internal Server Error (status code 500) or Service Unavailable Error (status code
   *     503) or Gateway Timeout (status code 504)
   */
  @GetMapping(
      value = "/api/v1/ships/name/{shipName}",
      produces = { "application/json" }
  )
  default ResponseEntity<List<Ship>> findShipByName(
      @PathVariable("shipName") String shipName
  ) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }

  /**
   * GET /api/v1/ships: Get all ships paginated
   *
   * @page page Number of page to return. (optional, default to 0)
   * @param limit Max number of products to return for pagination. (optional, default to 15)
   * @return OK (status code 200) or No content (status code 204) or Bad request. One or more parameters has an invalid value. (status code
   *     400) or Resource not found (status code 404) or Internal Server Error (status code 500) or Service Unavailable Error (status code
   *     503) or Gateway Timeout (status code 504)
   */
  @GetMapping(
      value = "/api/v1/ships",
      produces = { "application/json" }
  )
  default ResponseEntity<List<Ship>> findAll(
      @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
      @RequestParam(value = "limit", required = false, defaultValue = "15") Integer limit
  ) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }

  /**
   * POST /api/v1/ships/{shipName} : Create a ship
   * Create a ship
   *
   * @param shipName ship name (required)
   * @return OK (status code 200)
   *         or No content (status code 204)
   *         or Bad request. One or more parameters has an invalid value. (status code 400)
   *         or Unauthorized (status code 401)
   *         or Forbidden (status code 403)
   *         or Resource not found (status code 404)
   *         or Internal Server Error (status code 500)
   *         or Service Unavailable Error (status code 503)
   *         or Gateway Timeout (status code 504)
   */
  @PostMapping(
      value = "/api/v1/ships/{shipName}",
      produces = { "application/json" }
//      consumes = { "application/json" }
  )
  default ResponseEntity<Ship> createShip(
      @PathVariable("shipName") String shipName
  ) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }

  /**
   * PUT /api/v1/ships/{shipId} : Update a ship
   * Update a ship
   *
   * @return OK (status code 200)
   *         or No content (status code 204)
   *         or Bad request. One or more parameters has an invalid value. (status code 400)
   *         or Unauthorized (status code 401)
   *         or Forbidden (status code 403)
   *         or Resource not found (status code 404)
   *         or Internal Server Error (status code 500)
   *         or Service Unavailable Error (status code 503)
   *         or Gateway Timeout (status code 504)
   */
  @PutMapping(
      value = "/api/v1/ships",
      produces = { "application/json" },
      consumes = { "application/json" }
  )
  default ResponseEntity<ShipDTO> updateShip(
      @RequestBody ShipDTO shipDTO
  ) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }

  /**
   * DELETE /api/v1/ships/{shipId} : Delete a ship
   * Delete a ship
   *
   * @return OK (status code 200)
   *         or No content (status code 204)
   *         or Bad request. One or more parameters has an invalid value. (status code 400)
   *         or Unauthorized (status code 401)
   *         or Forbidden (status code 403)
   *         or Resource not found (status code 404)
   *         or Internal Server Error (status code 500)
   *         or Service Unavailable Error (status code 503)
   *         or Gateway Timeout (status code 504)
   */
  @DeleteMapping(
      value = "/api/v1/ships/{shipId}",
      produces = { "application/json" }
  )
  default ResponseEntity<ShipDTO> deleteShip(
      @PathVariable Long shipId
  ) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }
}
