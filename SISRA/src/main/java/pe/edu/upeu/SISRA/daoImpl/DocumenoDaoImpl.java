package pe.edu.upeu.SISRA.daoImpl;

import java.util.Map;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import pe.edu.upeu.SISRA.dao.DocumentoDao;
import pe.edu.upeu.SISRA.entity.Documento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import org.springframework.stereotype.Component;

@Component
public class DocumenoDaoImpl implements DocumentoDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;

	@Override
	public Map<String, Object> listar_req(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("pk_documento") //nombre del paquete
				.withProcedureName("sp_listar_req") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("cursor_req", Types.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("id", Types.NUMERIC));
				SqlParameterSource in = new MapSqlParameterSource().addValue("id", id);
		        Map<String, Object> map= simpleJdbcCall.execute(in);	
				return map;
	}

	@Override
	public Map<String, Object> historial_doc(int id_asc, int id_doc) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("pk_documento") //nombre del paquete
				.withProcedureName("sp_his_doc") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("cursor_req", Types.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("id_asc",Types.NUMERIC), new SqlParameter("id_doc", Types.NUMERIC));
				SqlParameterSource in = new MapSqlParameterSource().addValue("id_asc", id_asc).addValue("id_doc", id_doc);
		        Map<String, Object> map= simpleJdbcCall.execute(in);	
				return map;	
	}
	@Override
	public int create(Documento r) {
		// TODO Auto-generated method stub
		return  jdbcTemplate.update("call pk_documento.sp_create_doc(?,?,?,?,?,?,?,?)", r.getF_registro(),r.getUrl(),r.getEstado(),
				r.getCodigo(),
				r.getTipo_documento_id_doc_tipo(),
			r.getAsociacion_id_asoc(),
			r.getId_ult_rev(),
			r.getCategoria());
	}

}
