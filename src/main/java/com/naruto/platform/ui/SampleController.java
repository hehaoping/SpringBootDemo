package com.naruto.platform.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2017年12月14日
 */
@Controller
public class SampleController {

	@RequestMapping("/")
	@ResponseBody
	public String home(){
		return "hello SpringBoot";
	}
	
	
	@RequestMapping("/devtools")
	@ResponseBody
	public String devtools(){
		return "hello SpringBoot devtools";
	}
	
}
