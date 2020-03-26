package spring.data.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.data.mongodb.dao.ScoreMongoDAOImpl;
import spring.data.mongodb.dto.ScoreDTO;
@Service
public class ScoreMongoServiceImpl implements ScoreMongoService {
	@Autowired
	ScoreMongoDAOImpl dao;
	
	@Override
	public ScoreDTO findById(String key, String value) {
		// TODO Auto-generated method stub
		return dao.findById(key, value);
	}

	@Override
	public void insertDocument(ScoreDTO doc) {
		dao.insertDocument(doc);

	}

	@Override
	public void insertAllDocument(List<ScoreDTO> docs) {
		dao.insertAllDocument(docs);

	}

	@Override
	public List<ScoreDTO> findCriteria(String key, String value) {
		// TODO Auto-generated method stub
		return dao.findCriteria(key, value);
	}

	@Override
	public List<ScoreDTO> findAll() {
		return dao.findAll();
	}

	@Override
	public List<ScoreDTO> findAll(int pageNo) {
		return dao.findAll(pageNo);
	}

	@Override
	public void update(ScoreDTO document) {
		dao.update(document);

	}

}
