package kr.multi.bigdataShop.product.comment;

import java.util.List;

public interface ProductCommentService {
	int write(ProductCommentDTO comment);
	List<ProductCommentDTO> count(ProductCommentDTO result);
	List<ProductCommentDTO> word(ProductCommentDTO word);
}
