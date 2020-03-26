package spring.data.mongodb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.data.mongodb.dto.ScoreDTO;
import spring.data.mongodb.service.ScoreMongoService;

@Controller
public class ScoreController {
	@Autowired
	ScoreMongoService service;
	
	@RequestMapping("/score/paginglist")
	public ModelAndView showPagingMongolist(String pageNo) {
		ModelAndView mav = new ModelAndView();
		List<ScoreDTO> mongolist = service.findAll(Integer.parseInt(pageNo));
		mav.addObject("mongolist", mongolist);
		mav.setViewName("list");
		return mav;
	}
	
	@RequestMapping("/score/list")
	public ModelAndView showMongolist() {
		ModelAndView mav = new ModelAndView();
		List<ScoreDTO> mongolist = service.findAll();
		mav.addObject("mongolist", mongolist);
		mav.setViewName("list");
		return mav;
	}
	
	@RequestMapping(value="/score/insert", method=RequestMethod.GET)
	public String insertPage() {
		return "mongo_insert";
	}
	
	@RequestMapping(value="/score/insert", method=RequestMethod.POST)
	public String insert(ScoreDTO document) {
		service.insertDocument(document);
		return "redirect:/score/paginglist?pageNo=0";
	}
	
	@RequestMapping("/score/multiInsert")
	public String multiInsert() {
		List<ScoreDTO> doclist = new ArrayList<ScoreDTO>();
		ScoreDTO doc = null;
		for (int i = 0; i < 10; i++) {
			doc = new ScoreDTO();
			doc.setId("multi"+i);
			doc.setDept("multi"+10+i);
			doc.setAddr("부산");
			doc.setJava(100);
			doclist.add(doc);
		}
		service.insertAllDocument(doclist);
		return "redirect:/score/paginglist?pageNo=0";
	}
	
	@RequestMapping(value="/score/update",method=RequestMethod.POST)
	public String update(ScoreDTO document) {
		service.update(document);
		return "redirect:/score/paginglist?pageNo=0";
	}
	
}
