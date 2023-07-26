package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping("/test2/abc??")
	@ResponseBody
	public String test2_a() {
		return "?";
	}

	@RequestMapping("/test2/abc{p}")
	@ResponseBody
	public String test2_b(@PathVariable String p) {
		return "p";
	}

	@RequestMapping("/test2/abc*")
	@ResponseBody
	public String test2_c() {
		return "*";
	}



	@RequestMapping("/test2/**")
	@ResponseBody
	public String test2_d() {
		return "**";
	}

	@RequestMapping("/test3/mv")
	public String test3() {
		return "redirect:https://www.4399.com";
	}
}
