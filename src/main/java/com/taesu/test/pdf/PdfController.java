package com.taesu.test.pdf;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.lowagie.text.DocumentException;

@Controller
public class PdfController implements ApplicationContextAware{
	@Autowired
	private PdfService pdfService;
	
	private WebApplicationContext context = null;
	
	@RequestMapping(value = "/pdf-down", method = RequestMethod.GET)
	public void pdfDownload(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, DocumentException{
		
//		Map<String, String> revenueData 
//			= pdfService.pdfDownload(request, response);
		
		try {
			response.addHeader("X-Frame-Options", "SAMEORIGIN"); 
			pdfService.createPdf(response, request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.context = (WebApplicationContext) applicationContext;
	}
}
