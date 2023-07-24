package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xinLin.huang
 * @date 2023/7/24 16:49
 */
@Controller
public class MvcController {

	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		return "a";
	}

}
