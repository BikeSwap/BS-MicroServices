package pe.edu.bikeswap.reportsservice.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="issue_reports")
public class ReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title", nullable = false, length = 32)
    private String title;

    @Column(name="description", nullable = false, length = 255)
    private String description;

    @Column(name="proof_image_url", nullable = false)
    private String imageUrl;

    @Column(name="resolution", nullable = false)
    private Long resolution;

    @Column(name="created_at", nullable = false)
    private Date createdAt;

    @Column(name="updated_at", nullable = false)
    private Date updatedAt;

    @Column(name="rents_id", nullable = false)
    private Long rents_id;

    @Column(name="report_status_id", nullable = false)
    private Long report_status_id;
}
