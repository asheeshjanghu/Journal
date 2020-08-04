package com.memory.Journal.util;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.memory.Journal.model.MemoryImageData;
import com.memory.Journal.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class AmazonStorageService implements StorageService {

    private AmazonS3 s3client;

    @Value("${amazonProperties.endpointUrl}")
    private String endpointUrl;

    @Value("${amazonProperties.bucketName}")
    private String bucketName;

    @Value("${amazonProperties.accessKey}")
    private String accessKey;

    @Value("${amazonProperties.secretKey}")
    private String secretKey;

    @PostConstruct
    private void initialize() {
        s3client = new AmazonS3Client(new BasicAWSCredentials(accessKey, secretKey));
    }

    @Override
    public boolean saveFile(MemoryImageData memoryImageData) {
        try {
            File convertedFile = getConvertedFile(memoryImageData.getMultipartFile());
            String fileName = memoryImageData.getImageName();
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            String userName;
            if (principal instanceof UserDetails) {
                userName = ((UserDetails) principal).getUsername();
            } else {
                userName = principal.toString();
            }
            String fullFileName = userName+ "/"+memoryImageData.getFormattedDateString()+"/"+fileName;
            System.out.println("Full Name = " + fullFileName);
            s3client.putObject(new PutObjectRequest(bucketName, fullFileName, convertedFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private File getConvertedFile(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(multipartFile.getBytes());
        fos.close();
        return file;
    }

    @Override
    public boolean deleteFile(String fileName) {
        return false;
    }

    @Override
    public void getFile(String fileName) {

    }
}
