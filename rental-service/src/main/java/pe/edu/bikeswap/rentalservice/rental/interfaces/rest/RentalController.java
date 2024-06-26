package pe.edu.bikeswap.rentalservice.rental.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PutExchange;
import pe.edu.bikeswap.rentalservice.infraestructure.persistence.jpa.repositories.RentalRepository;
import pe.edu.bikeswap.rentalservice.rental.domain.model.aggregates.Rental;
import pe.edu.bikeswap.rentalservice.rental.domain.model.querys.GetRentalById;
import pe.edu.bikeswap.rentalservice.rental.domain.services.RentalCommandService;
import pe.edu.bikeswap.rentalservice.rental.domain.services.RentalQueryService;
import pe.edu.bikeswap.rentalservice.rental.interfaces.rest.resource.CreateRentalResource;
import pe.edu.bikeswap.rentalservice.rental.interfaces.rest.resource.RentalResource;
import pe.edu.bikeswap.rentalservice.rental.interfaces.rest.resource.UpdateRentalResource;
import pe.edu.bikeswap.rentalservice.rental.interfaces.rest.transform.CreateRentalCommandFromResourceAsembler;
import pe.edu.bikeswap.rentalservice.rental.interfaces.rest.transform.RentalResourceFromEntityAssembler;
import pe.edu.bikeswap.rentalservice.rental.interfaces.rest.transform.UpdateRentalCommandFronResourceAssembler;

import java.util.List;
@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping(value = "/api/v1/rentals", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@Tag(name = "Rentals", description = "Rentals")
public class RentalController {
    private final RentalQueryService rentalQueryService;
    private final RentalCommandService rentalCommandService;
    private final RentalRepository rentalRepository;

    public RentalController(RentalQueryService rentalQueryService, RentalCommandService rentalCommandService, RentalRepository rentalRepository) {
        this.rentalQueryService = rentalQueryService;
        this.rentalCommandService = rentalCommandService;
        this.rentalRepository = rentalRepository;
    }
    @PostMapping
    public ResponseEntity<RentalResource> createRental(@RequestBody CreateRentalResource createRentalResource){
        var createRentalCommand = CreateRentalCommandFromResourceAsembler.toCommandFromResource(createRentalResource);
        var rentalId = rentalCommandService.handle(createRentalCommand);
        if (rentalId == 0L) return ResponseEntity.badRequest().build();
        var getRentalsByIdQuery = new GetRentalById(rentalId);
        var rental = rentalQueryService.handle(getRentalsByIdQuery);
        if (rental.isEmpty()) return ResponseEntity.notFound().build();
        var rentalResource = RentalResourceFromEntityAssembler.toResourceFromEntity(rental.get());
        return new ResponseEntity<>(rentalResource, HttpStatus.CREATED);
    }
    @GetMapping("/{rentalId}")
    public ResponseEntity<RentalResource> getRentalById(@PathVariable Long rentalId){
        var getRentalByIdQuery = new GetRentalById(rentalId);
        var rental = rentalQueryService.handle(getRentalByIdQuery);

        if(rental.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var rentalResource = RentalResourceFromEntityAssembler.toResourceFromEntity(rental.get());
        return ResponseEntity.ok(rentalResource);
    }
    @GetMapping
    public List<Rental> getAll() {
        return rentalQueryService.getAllRentals();
    }
    @PutMapping("/{rentalId}")
    public ResponseEntity<RentalResource> updateRental(@PathVariable Long rentalId, @RequestBody UpdateRentalResource updateRentalResource){
        var updateRentalCommand = UpdateRentalCommandFronResourceAssembler.toCommandFromResource(rentalId, updateRentalResource);
        rentalCommandService.update(updateRentalCommand);

        var getRentalByIdQuery = new GetRentalById(rentalId);
        var updateRental = rentalQueryService.handle(getRentalByIdQuery);

        if(updateRental.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var rentalResource = RentalResourceFromEntityAssembler.toResourceFromEntity(updateRental.get());
        return ResponseEntity.ok(rentalResource);
    }
    @DeleteMapping("/{rentalId}")
    public ResponseEntity<RentalResource> deleteRental(@PathVariable Long rentalId){
        var rental = rentalRepository.findById(rentalId);
        if(rental.isPresent()){
            rentalRepository.deleteById(rentalId);
            rentalRepository.flush();
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
            /*try {
            rentalRepository.deleteById(rentalId);
            rentalRepository.flush();
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            // Si no se encuentra la entidad con el ID proporcionado
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            // Para otros errores internos, puedes devolver un estado 500 (Internal Server Error)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }*/

    }

}
