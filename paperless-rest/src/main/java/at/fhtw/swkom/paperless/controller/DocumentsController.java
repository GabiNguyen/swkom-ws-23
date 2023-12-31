package at.fhtw.swkom.paperless.controller;

import at.fhtw.swkom.paperless.persistence.entity.Document;
import at.fhtw.swkom.paperless.services.DocumentService;
import at.fhtw.swkom.paperless.services.dto.GetDocuments200Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocumentsController {

    public DocumentService documentService;

    public DocumentsController(DocumentService documentService) {
        this.documentService = documentService;
    }
    @Operation(
            operationId = "getDocuments",
            tags = { "Documents" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = GetDocuments200Response.class))
                    })
            }
    )
    @GetMapping
    public List<Document> getDocuments() {
        return documentService.getAllDocuments();
    }

    @PostMapping("/post_document")
    public Document postDocuments(@RequestBody Document document) {
        return documentService.postDocument(document);
    }

}
