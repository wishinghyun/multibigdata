package kr.multi.bigdataShop.product.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductCommentServiceImpl implements ProductCommentService{
	@Autowired
	@Qualifier("commentdao")
	ProductCommentDAO dao;

	@Override
	public int write(ProductCommentDTO comment) {
		return dao.write(comment);
	}

	@Override
	public List<ProductCommentDTO> count(ProductCommentDTO result) {
		return dao.count(result);
	}
	@Override
	public List<ProductCommentDTO> word(ProductCommentDTO word) {
		return dao.word(word);
	}

	
	
	
}
