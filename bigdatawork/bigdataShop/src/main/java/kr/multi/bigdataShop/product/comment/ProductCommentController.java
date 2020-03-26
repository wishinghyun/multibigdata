package kr.multi.bigdataShop.product.comment;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ProductCommentController {
	@Autowired
	ProductCommentService service;
	
	@RequestMapping(value = "/comment/write.do", method = RequestMethod.POST)
	public String writeComment(ProductCommentDTO comment) {
		System.out.println(comment);
		service.write(comment);
		return "redirect:/product/read.do?prd_no="+comment.getPrd_no();
		
	}
	
	@RequestMapping("/comment/result.do")
	public ModelAndView commCount(ProductCommentDTO result, ProductCommentDTO word) {
		ModelAndView mav = new ModelAndView();
		List<ProductCommentDTO> commcount = service.count(result);
		List<ProductCommentDTO> wordview = service.word(word);
		mav.addObject("commcount", commcount);
		mav.addObject("wordview", wordview);
		mav.setViewName("comment/result");
		return mav;
	}
	
}
