package kr.multi.bigdataShop.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ProductController {
	@Autowired
	ProductService service;
	

	//전체상품보기,카테고리별 보기
	@RequestMapping("/product/list.do")
	public ModelAndView list(String category){
		System.out.println("category=>"+category);
		ModelAndView mav = new ModelAndView();
		List<ProductDTO> list = service.productlist(category);
		mav.addObject("prdlist", list);//db에서 조회한 결과 
		                               //- 서블릿에서 request.setAttribute
		mav.setViewName("product/list");
		return mav;
	}
	//상품상세보기
		@RequestMapping("/product/read.do")
		public String showProduct(String prd_no,String category,
					Model model,HttpServletRequest req) {
			
			ProductDTO product = service.read(prd_no);
			List<ProductCommentDTO> commentlist = service.comm(prd_no);
			model.addAttribute("commentlist", commentlist);
			model.addAttribute("product", product);
			return "product/read";
		}
}









