package com.tp.bike.platform.bike.bycicle.interfaces.rest;

import com.tp.bike.platform.bike.bycicle.domain.model.aggregates.Bike;
import com.tp.bike.platform.bike.bycicle.domain.model.querys.GetBikeById;
import com.tp.bike.platform.bike.bycicle.domain.services.BikeCommandService;
import com.tp.bike.platform.bike.bycicle.domain.services.BikeQueryService;
import com.tp.bike.platform.bike.bycicle.interfaces.rest.resource.BikeResource;
import com.tp.bike.platform.bike.bycicle.interfaces.rest.resource.CreateBikeResource;
import com.tp.bike.platform.bike.bycicle.interfaces.rest.transform.BikeResourceFromEntityAssembler;
import com.tp.bike.platform.bike.bycicle.interfaces.rest.transform.CreateBikeCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/bikes", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@Tag(name = "Bikes", description = "Bikes")
public class BikeController {
    private final BikeQueryService bikeQueryService;
    private final BikeCommandService bikeCommandService;

    public BikeController(BikeCommandService bikeCommandService, BikeQueryService bikeQueryService) {
        this.bikeCommandService=bikeCommandService;

        this.bikeQueryService = bikeQueryService;
    }

    @PostMapping
    public ResponseEntity<BikeResource> createSalesAgent(@RequestBody CreateBikeResource createBikeResource){
        var createBikeCommand = CreateBikeCommandFromResourceAssembler.toCommandFromResource(createBikeResource);
        var bikeId = bikeCommandService.handle(createBikeCommand);
        if (bikeId == 0L) return ResponseEntity.badRequest().build();
        var getSalesAgentByIdQuery = new GetBikeById(bikeId);
        var bike = bikeQueryService.handle(getSalesAgentByIdQuery);
        if (bike.isEmpty()) return ResponseEntity.notFound().build();
        var bikeResource = BikeResourceFromEntityAssembler.toResourceFromEntity(bike.get());
        return new ResponseEntity<>(bikeResource, HttpStatus.CREATED);
    }
    @GetMapping("/{bikeId}")
    public ResponseEntity<BikeResource> getSongById(@PathVariable Long bikeId){
        var getBikeByIdQuery = new GetBikeById(bikeId);
        var bike = bikeQueryService.handle(getBikeByIdQuery);

        if(bike.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var bikeResource = BikeResourceFromEntityAssembler.toResourceFromEntity(bike.get());
        return ResponseEntity.ok(bikeResource);
    }
    @GetMapping
    public List<Bike> getAll() {
        return bikeQueryService.getAllBikes();
    }
}
