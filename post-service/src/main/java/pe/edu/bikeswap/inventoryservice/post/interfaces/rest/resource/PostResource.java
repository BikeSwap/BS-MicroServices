package pe.edu.bikeswap.inventoryservice.post.interfaces.rest.resource;

public record PostResource(Long postId, String title, String description, Double price) {
}
