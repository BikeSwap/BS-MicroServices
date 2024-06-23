package com.tp.bike.platform.bike.bycicle.interfaces.rest.resource;

import java.util.Date;

public record CreateBikeResource(String name,
                                 String description,
                                 double price,
                                 String model,
                                 String image) {
}