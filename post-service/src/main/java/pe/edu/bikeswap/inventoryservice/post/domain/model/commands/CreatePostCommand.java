package pe.edu.bikeswap.inventoryservice.post.domain.model.commands;

public record CreatePostCommand(String title, String description, Double price) {
}
