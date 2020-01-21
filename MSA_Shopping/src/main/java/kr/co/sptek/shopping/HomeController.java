package kr.co.sptek.shopping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, HttpSession session, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
    	Map<String, String> user;
		String redirPage;
		
		if(session.getAttribute("ClientUserInfo") != null){
			
			user = (Map)session.getAttribute("ClientUserInfo");
			
			if(user.get("UserId") != null && !"".equals(user.get("UserId"))){				
				
				redirPage = "redirect:summaryInfo";
			}else {
				redirPage = "jsp/login";
			}
			
		}else {
			
			redirPage = "jsp/login";
		}
				
		return redirPage;
	}
	
}
