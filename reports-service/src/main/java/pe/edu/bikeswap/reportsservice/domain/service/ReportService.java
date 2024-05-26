package pe.edu.bikeswap.reportsservice.domain.service;

import pe.edu.bikeswap.reportsservice.domain.entity.ReportEntity;

import java.util.List;

public interface ReportService {
    ReportEntity createReport(ReportEntity report);

    ReportEntity getReportById(Long report_id);

    ReportEntity updateReport(ReportEntity report);

    void deleteReport(Long report_id);

    List<ReportEntity> getAllReports();
}
