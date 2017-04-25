package com.full.shopkeeper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShopkeeperController {
@RequestMapping(value="/",method=RequestMethod.GET)
public String init()
{

return "index";	
}
/*@RequestMapping(value=)
public String shopkeeperMenu()	
*/

}
