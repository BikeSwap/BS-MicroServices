package pe.edu.bikeswap.reportsservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.bikeswap.reportsservice.domain.entity.ReportEntity;

import java.util.List;

public interface ReportRepository extends JpaRepository<ReportEntity, Long> {
}
