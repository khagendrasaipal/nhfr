package com.saipal.Health_Facility_Registry.files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileRepo {
//	public String addFile(MultipartFile file) throws IOException {
//		DBObject metaData = new BasicDBObject();
//		ObjectId id = gridFsTemplate.store(file.getInputStream(), file.getOriginalFilename(), file.getContentType(),
//				metaData);
////		System.out.println(id.toString());
////		return id.toString();
//	}
	
	public ResponseEntity<Map<String, Object>> addFile(MultipartFile file) {
		try {
			   String uniqueID = UUID.randomUUID().toString();
//			File resizedFile = resizeImage(file);
			String fPath = "images/"+uniqueID+file.getOriginalFilename();
//			String fileLocation = new File("src\\main\\resources\\static\\images").getAbsolutePath() + "\\" +uniqueID+file.getOriginalFilename();
			// for linux
			String fileLocation = "/var/lib/tomcat8/webapps/ROOT/WEB-INF/classes/static/images/" + uniqueID + file.getOriginalFilename();
			//for windows
//			String fileLocation = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "static" + File.separator + "images").getAbsolutePath() + File.separator + uniqueID + file.getOriginalFilename();

			System.out.println(fileLocation);
			File convFile = new File(fileLocation);
			convFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(convFile);
	        fos.write(file.getBytes());
	        fos.close();
	        Map<String, Object> response = new HashMap<>();
	        response.put("path", fPath);
	        response.put("status", "1");
	        return ResponseEntity.ok(response);
//	        return ResponseEntity.ok(Map.of("path",fPath,"status","1"));
		} catch (IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Map<String, Object> response = new HashMap<>();
//	        response.put("path", fPath);
	        response.put("status", "0");
	        return ResponseEntity.ok(response);
//			return ResponseEntity.ok(Map.of("path","","status","0"));
		}
	}
	
//	private File resizeImage(MultipartFile file) throws IOException {
//        // Read the original image
//        byte[] bytes = file.getBytes();
//        
//        // Resize the image to 1280x768 pixels
//        byte[] resizedBytes = Imaging.scaleImage(bytes, ImageFormats.PNG, 1280, 768, null);
//        
//        // Create a temporary file for the resized image
//        File resizedFile = File.createTempFile("resized", ".png");
//        
//        // Write the resized image bytes to the temporary file
//        FileUtils.writeByteArrayToFile(resizedFile, resizedBytes);
//        
//        return resizedFile;
//    }
	

	public MediaFile getFile(String id) throws IllegalStateException, IOException {
		return null;
	}

	public boolean deleteFile(String id) {
		return true;
	}

	public String replaceFile(String id, MultipartFile file) {
		return null;
	}
}
