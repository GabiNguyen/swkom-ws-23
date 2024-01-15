package at.fhtw.swkom.paperless.controller;

import at.fhtw.swkom.paperless.services.StorageFileNotFoundException;
import at.fhtw.swkom.paperless.services.StorageService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

@Controller
public class StorageController {

    private final String fileUploadDirectory;
    private final StorageService storageService;

    @Autowired
    public StorageController(StorageService storageService, @Value("${filestorageservice.path}") String path) {
        this.storageService = storageService;
        this.fileUploadDirectory = path;
    }

    // HTML-UI to test the StorageService directly in the web-browser
    @GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", storageService.loadAll().map(
                    path -> MvcUriComponentsBuilder.fromController(StorageController.class).path(path.toString().replace('\\','/')).build().toUri().toString())
                .collect(Collectors.toList()));

        return "uploadForm";
    }

    // HTML-UI to test the StorageService directly in the web-browser
    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }

    // REST-Service for Storage
    @GetMapping("/**")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(HttpServletRequest rq) {

        String filePath = getFilePath(rq);
        Resource file = storageService.loadAsResource(filePath);
        if ( file==null )
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping(value = "/**", consumes = MediaType.APPLICATION_OCTET_STREAM_VALUE )
    public ResponseEntity<Void> uploadFile(@RequestBody byte[] buffer, HttpServletRequest rq) throws IOException {
        String path = getSecureFullPath(fileUploadDirectory, rq.getServletPath());

        File directory = new File(path).getParentFile();
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (OutputStream outputStream = new FileOutputStream(path)) {
            outputStream.write(buffer);
        }

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/**")
    public ResponseEntity<Void> deleteFile(HttpServletRequest rq) {
        String path = getSecureFullPath(fileUploadDirectory, getFilePath(rq));

        File file = new File(path);
        if (file.exists()) {
            file.delete();

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/**")
    public ResponseEntity<Void> renameFile(@RequestBody String newFilePath, HttpServletRequest rq) {
        String oldPath = getSecureFullPath(fileUploadDirectory, getFilePath(rq));
        String newPath = getSecureFullPath(fileUploadDirectory, newFilePath);

        File oldFile = new File(oldPath);
        File newFile = new File(newPath);
        if (oldFile.exists() && !newFile.exists()) {
            oldFile.renameTo(newFile);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }


    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }



    private static String getFilePath(HttpServletRequest rq) {
        String servletPath = rq.getServletPath();
        if ( servletPath == null || servletPath.isEmpty() || servletPath.isBlank() )
            return servletPath;
        if ( servletPath.startsWith("/") )
            return servletPath.substring(1);
        return servletPath;
    }

    private String getSecureFullPath(String fileUploadDirectory, String filePath) {
        filePath = filePath.replaceFirst("^(/|\\\\)", "");

        Path path = Paths.get(fileUploadDirectory, filePath)/*.toAbsolutePath()*/.normalize();

        if (!path.startsWith(Paths.get(fileUploadDirectory))) {
            throw new IllegalArgumentException("Not a valid path");
        } else {
            return path.toString();
        }
    }
}