package kr.multi.bigdataShop.product;

import java.util.List;

public interface ProductDAO {
	List<ProductDTO> productlist (String category);
	List<ProductDTO> hitproduct();
	List<ProductDTO> newproduct();
	ProductDTO read(String prd_no);
	List<ProductCommentDTO> comm(String prd_no);
}