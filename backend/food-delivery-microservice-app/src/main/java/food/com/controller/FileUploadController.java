package food.com.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/menu/images")
@CrossOrigin

public class FileUploadController {

    private static final String UPLOAD_DIR = "uploads/";

    @PostMapping("upload")
    public ResponseEntity<Map<String, String>> uploadFile(@RequestParam("image") MultipartFile image) {
        if (image.isEmpty()) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "No file selected"));
        }

        // Clean the file name to prevent path traversal attacks
        String fileName = StringUtils.cleanPath(image.getOriginalFilename());

        try {
            // Ensure the directory exists
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.createDirectories(path.getParent());

            // Transfer the file to the path
            image.transferTo(path.toFile());

            // Return the URL of the uploaded file
            String imageUrl = "http://localhost:9090/" + UPLOAD_DIR + fileName;
            return ResponseEntity.ok(Collections.singletonMap("imageUrl", imageUrl));
        } catch (IOException e) {
            // Log the exception (or print the stack trace) to debug
            e.printStackTrace();
            return ResponseEntity.status(500).body(Collections.singletonMap("error", "Failed to upload the file"));
        }
    }
}

/*public class FileUploadController {

    // Define the path to store the uploaded images
    private final String uploadDirectory = "uploads/";

    // Endpoint to upload an image
    @PostMapping("upload")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile file) {
        // Validate if the file is not empty
        if (file.isEmpty()) {
            return new ResponseEntity<>("Please select a file to upload", HttpStatus.BAD_REQUEST);
        }

        // Get the original file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        System.err.println("uploaded image filename  "+fileName);

        try {
            // Normalize the file path
            Path path = Paths.get(uploadDirectory + fileName);
            
            // Create the upload directory if it doesn't exist
            Files.createDirectories(path.getParent());

            // Copy the file to the target location (overwrite existing file with the same name)
            file.transferTo(path.toFile());

            return new ResponseEntity<>("File uploaded successfully: " + fileName, HttpStatus.OK);

        } catch (IOException e) {
            return new ResponseEntity<>("Failed to upload the file: " + fileName, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Endpoint to get uploaded image (optional)
    @GetMapping("/image/{fileName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String fileName) {
        try {
            Path path = Paths.get(uploadDirectory + fileName);
            byte[] image = Files.readAllBytes(path);
            return ResponseEntity.ok(image);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}*/