package pe.edu.bikeswap.reportsservice.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.bikeswap.reportsservice.domain.entity.ReportEntity;
import pe.edu.bikeswap.reportsservice.domain.service.ReportService;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/v1/reports")
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    // URL: http://localhost:8080/api/v1/reports
    // Method: GET
    @GetMapping
    public ResponseEntity<List<ReportEntity>> getAllReports() {
        return new ResponseEntity<>(reportService.getAllReports(), HttpStatus.OK);
    }

    // URL: http://localhost:8080/api/v1/reports/{report_id}
    // Method: GET
    @GetMapping("/{report_id}")
    public ResponseEntity<ReportEntity> getReportById(@PathVariable Long report_id) {
        return new ResponseEntity<>(reportService.getReportById(report_id), HttpStatus.OK);
    }

    // URL: http://localhost:8080/api/v1/reports
    // Method: POST
    @PostMapping
    public ResponseEntity<ReportEntity> createReport(@RequestBody ReportEntity report) {
        return new ResponseEntity<>(reportService.createReport(report), HttpStatus.CREATED);
    }

    // URL: http://localhost:8080/api/v1/reports/{report_id}
    // Method: PUT
    @PutMapping("/{report_id}")
    public ResponseEntity<ReportEntity> updateReport(@PathVariable Long report_id, @RequestBody ReportEntity report) {
        report.setId(report_id);
        return new ResponseEntity<>(reportService.updateReport(report), HttpStatus.OK);
    }

    // URL: http://localhost:8080/api/v1/reports/{report_id}
    // Method: DELETE
    @DeleteMapping("/{report_id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long report_id) {
        reportService.deleteReport(report_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
