package com.taesu.test.pdf;


import java.io.BufferedInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.mchange.io.FileUtils;
import com.taesu.test.pdf.view.PdfTestView;


@Service
public class PdfService {
	@Autowired
	private PdfTestView pdfTestView;
	
	private final Logger logger = Logger.getLogger(PdfService.class);	
	
	public void createPdf(HttpServletResponse response, HttpServletRequest request) 
			throws IOException, DocumentException{
		File inputFile = null;
		File outputFile = null;
		try {
	//		ClassLoader loader = Thread.currentThread().getContextClassLoader();
	//		file = new File(loader.getResource("Getting Started.pdf").getFile());		
			inputFile = new ClassPathResource("pdf/Getting started.pdf").getFile();
			outputFile = new ClassPathResource("pdf/template.pdf").getFile();
			
			PdfReader pdfReader = new PdfReader(new FileInputStream(inputFile));

		    PdfStamper pdfStamper = new PdfStamper(pdfReader,
		          new FileOutputStream(outputFile));
		    
		    URL imgFile = new ClassPathResource("sign/mysign.png").getURL();
		    Image image = Image.getInstance(imgFile);
		    image.scaleAbsolute(250f, 100f);
		    
		    if(pdfReader.getNumberOfPages() > 0){
		    	PdfContentByte contentByte = pdfStamper.getOverContent(1);
		    	image.setAbsolutePosition(320, 600);		    	
		    	contentByte.addImage(image);
		    }
		    
//		    for(int i=1; i<= pdfReader.getNumberOfPages(); i++){
//	
//		       PdfContentByte content = pdfStamper.getOverContent(i);	
//		       image.setAbsolutePosition(100f, 700f);
//	
//		       content.addImage(image);
//		    }

		    pdfStamper.close();
		    
		    
			
			
			response.setContentType("application/pdf");      
			//response.setHeader("Content-Disposition", "attachment; filename=\"pdf-down.pdf\"");	//download
			/*
			 * attachment일 경우 front 쪽에서 X-Form-Allow, Allow-From SAMEORIGIN 에러 발생함
			 * Download일 경우에만 attachement로 
			 */
			response.setHeader("Content-Disposition", "inline; filename=\"pdf-down.pdf\"");
			
	        response.setContentLength((int)outputFile.length());        
	        InputStream is = new BufferedInputStream(new FileInputStream(outputFile));
	 
	        //Copy bytes from source to destination(outputstream in this example), closes both streams.
	        FileCopyUtils.copy(is, response.getOutputStream());        
	        is.close();
		} catch ( Exception e){
			e.printStackTrace();
		}
		
	}
}
