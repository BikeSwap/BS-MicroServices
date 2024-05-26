package pe.edu.bikeswap.reportsservice.application.service;

import org.springframework.stereotype.Service;
import pe.edu.bikeswap.reportsservice.domain.entity.ReportEntity;
import pe.edu.bikeswap.reportsservice.domain.repository.ReportRepository;
import pe.edu.bikeswap.reportsservice.domain.service.ReportService;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public ReportEntity createReport(ReportEntity report) {
        return reportRepository.save(report);
    }

    @Override
    public ReportEntity getReportById(Long report_id) {
        return reportRepository.findById(report_id).
                orElseThrow(() -> new RuntimeException("Report not found"));
    }

    @Override
    public ReportEntity updateReport(ReportEntity report) {
        return reportRepository.save(report);
    }

    @Override
    public void deleteReport(Long report_id) {
        reportRepository.deleteById(report_id);
    }

    @Override
    public List<ReportEntity> getAllReports() {
        return reportRepository.findAll();
    }
}
