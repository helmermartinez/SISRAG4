package pe.edu.upeu.SISRA.serviceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.SISRA.dao.DocumentoDao;
import pe.edu.upeu.SISRA.entity.Documento;
import pe.edu.upeu.SISRA.service.DocumentoService;

@Service
public class DocumentoServiceImpl implements DocumentoService {
	@Autowired
	private DocumentoDao documentoDao;
	@Override
	public Map<String, Object> listar_req(int id) {
		// TODO Auto-generated method stub
		return documentoDao.listar_req(id) ;
	}
	@Override
	public Map<String, Object> historial_doc(int id_asc, int id_doc) {
		// TODO Auto-generated method stub
		return documentoDao.historial_doc(id_asc, id_doc);
	}

	@Override
	public int create(Documento r) {
		// TODO Auto-generated method stub
		return documentoDao.create(r);
	}
	}

