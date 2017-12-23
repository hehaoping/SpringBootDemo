package com.naruto.platform.ui;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2017年12月18日
 */
@RestController
public class RESTfulUI {

	@RequestMapping(value = "/api/infos", method = RequestMethod.GET)
	public String list(@RequestParam(defaultValue = "15") int pageSize, @RequestParam(defaultValue = "") String key) {
		return key + " a get list request " + pageSize;
	}

	@RequestMapping(value = "/api/infos/{id}", method = RequestMethod.GET)
	public String get(@PathVariable long id) {
		return "a get " + id + " request";
	}

	@RequestMapping(value = "/api/infos", method = RequestMethod.POST)
	public String post(@RequestParam(required = false, defaultValue = "") String name) {
		return "a post request " + name;
	}

	@RequestMapping(value = "/api/infos", method = RequestMethod.PUT)
	public String put() {
		return "a put request";
	}

	@RequestMapping(value = "/api/infos", method = RequestMethod.DELETE)
	public String delete() {
		return "a delete request";
	}

	@RequestMapping(value = "/api/getOrPost", method = { RequestMethod.GET, RequestMethod.POST })
	public String getOrPost() {
		return "a getOrPost request";
	}
	
	
	@RequestMapping(value = "/api/json", method = RequestMethod.GET)
	public JSONObject getJson() {
		JSONObject jo=new JSONObject();
		jo.put("status", 1);
		jo.put("message", "返回json对象");
		return jo;
	}
	
	@RequestMapping(value = "/api/jsonarray", method = RequestMethod.GET)
	public JSONArray getJSONArray() {
		JSONArray ja=new JSONArray();
		JSONObject jo=new JSONObject();
		jo.put("name", "hhp");
		jo.put("age", 23);
		ja.add(jo);
		return ja;
	}

}
