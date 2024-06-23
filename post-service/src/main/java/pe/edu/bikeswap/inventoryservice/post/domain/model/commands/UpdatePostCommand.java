package pe.edu.bikeswap.inventoryservice.post.domain.model.commands;

public record UpdatePostCommand(Long postId, String title, String description, Double price) {
}
