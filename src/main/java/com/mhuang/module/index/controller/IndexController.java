package com.mhuang.module.index.controller;

import java.util.HashMap;
import java.util.Map;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mhuang.common.exception.BusinessException;
import com.mhuang.common.frame.controller.BaseController;
import com.mhuang.common.frame.factorybean.MongoFacotry;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DBObject;

@Controller
@RequestMapping("/welcome")
public class IndexController extends BaseController{
	
	@Autowired
	private MongoFacotry mongoFactory;
	
	@RequestMapping(value="/error",method = RequestMethod.GET)
	public void error() throws Exception{
		mongoFactory.getDBCollection("Test").find().forEach(new Block<Document>() {
			@Override
			public void apply(Document t) {
				throw new BusinessException(t.get("EXCEPTION").toString());
			}
		});
	}
	
	@RequestMapping("/indexs/{id}")
	public String index(@PathVariable("id") String id,Model model){
		model.addAttribute("id",id);
		DBObject obObject=  new BasicDBObject("EXCEPTION","业务异常");
		mongoFactory.getDBCollection("Test").insertOne(new Document(obObject.toMap()));;
		return "index";
	}
	
	@ResponseBody
	@RequestMapping("/get/${id}")
	public Map<String, String> get(@PathVariable("id") String id){
		Map<String, String> map = new HashMap<String, String>(){/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		{
			put("1", "张三");
			put("2", "李四");
			put("3", "王五");
		}};
		Map<String, String> resultMap = new HashMap<String, String>();
		if(map.containsKey(id)){
			resultMap.put(id,map.get(id));
		}else{
			resultMap.put(id,"其他");
		}
		return resultMap;
	}
}
