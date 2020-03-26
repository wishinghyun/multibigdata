package kr.multi.bigdataShop.product.comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("commentdao")
public class ProductCommentDAOImpl implements ProductCommentDAO{
	@Autowired
	SqlSession sqlSession;

	@Override
	public int write(ProductCommentDTO comment) {
		return sqlSession.insert("bigdatashop.product.comment.insertcomment", comment);
	}

	@Override
	public List<ProductCommentDTO> count(ProductCommentDTO result) {
		return sqlSession.selectList("bigdatashop.product.comment.commcount", result);
	}
	@Override
	public List<ProductCommentDTO> word(ProductCommentDTO word) {
		return sqlSession.selectList("bigdatashop.product.comment.wordview", word);
	}
	
	
}
