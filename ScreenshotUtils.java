package commonLibs.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
	
	// create an instance of TakesScreenshot called camera
	private TakesScreenshot camera;
	
	// typecasted it with WebDriver, use the same browser to take sshot.
	public ScreenshotUtils(WebDriver driver) {
		camera = (TakesScreenshot) driver;
	}
	
	// create method
	public void captureAndSaveScreenshot(String filename) throws Exception {
		filename = filename.trim();
		
		// create 2 files
		File imgFile, tmpFile;
		
		// initialize imgFile
		imgFile = new File(filename);
		
		if(imgFile.exists()) {
			throw new Exception("File already exists!");
		}
		
		tmpFile = camera.getScreenshotAs(OutputType.FILE);
		
		FileUtils.moveFile(tmpFile, imgFile);
	}
	
}
