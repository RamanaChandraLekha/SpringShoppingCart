package com.full.shopkeeper;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

@Controller

public class SignUpController {
	
	@RequestMapping(value = "/signIn", method = RequestMethod.GET)
	public String signIn() {
		// ModelAndView model=new ModelAndView("SignUp");
		return "SignUp";

	}

	/*
	 * @RequestMapping(value="/signup" ,method=RequestMethod.POST) public
	 * ModelAndView submit(@RequestParam Map<String,String> reqPar)
	 * 
	 * {
	 * 
	 * 
	 * DatastoreService datastore=DatastoreServiceFactory.getDatastoreService();
	 * Entity user=new Entity("User"); //users.setProperty("user1", user);
	 * user.setProperty("Name", reqPar.get("username"));
	 * user.setProperty("password", reqPar.get("password"));
	 * user.setProperty("CompanyName", reqPar.get("company"));
	 * user.setProperty("Designation", reqPar.get("designation"));
	 * user.setProperty("experience", reqPar.get("exp"));
	 * user.setProperty("city", reqPar.get("city")); user.setProperty("Stream",
	 * reqPar.get("stream"));
	 * 
	 * datastore.put(user); ModelAndView model =new ModelAndView("view");
	 * model.addObject("msg","Registerd sucessfully" ); return model;
	 * 
	 * 
	 * }
	 */
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST, consumes ={"application/json"})
	public ModelAndView submit(@RequestBody User users)

	{

		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Entity user = new Entity("User");
		// users.setProperty("user1", user);
		user.setProperty("Name", users.getUsername());
		user.setProperty("password", users.getPassword());
		user.setProperty("CompanyName", users.getCompanyName());
		user.setProperty("Designation", users.getDesignation());
		user.setProperty("experience", users.getExp());
		user.setProperty("city", users.getCity());
		user.setProperty("Stream", users.getStream());

		datastore.put(user);
		ModelAndView model = new ModelAndView("view");
		model.addObject("msg", "Registerd sucessfully");
		return model;
	

	}

	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String loginDetails() {
		// ModelAndView model= new ModelAndView("Login");
		return "Login";

	}
    
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("uname") String name, @RequestParam("password") String pwd) {
		//ModelAndView model = new ModelAndView("view");
		boolean flag=false;
	
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query q = new Query("User");
		PreparedQuery pq = datastore.prepare(q);
	
User userDetails=new User();
		for (Entity user : pq.asIterable()) {
			
			String uname = user.getProperty("Name").toString();
			String password = user.getProperty("password").toString();
			
			if ((name.equals(uname)) && (pwd.equals(password))) {
				
          /* userDetails.setUsername(uname);
           userDetails.setCompanyName(user.getProperty("CompanyName").toString());
           userDetails.setDesignation(user.getProperty("Designation").toString());
           userDetails.setExp(user.getProperty("experience").toString());
           userDetails.setCity(user.getProperty("city").toString());
           userDetails.setStream(user.getProperty("Stream").toString());
*/
				//model.addObject("msg", "Logged in sucessfully");
				flag=true;
			
			}
			}
		if(flag==true)
			return "Shopkeeper";

		
	else 
		return "error";
	

		
	}

}
