package pe.edu.upeu.SISRA.daoImpl;

import java.sql.Types;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import pe.edu.upeu.SISRA.dao.AsociacionDao;

@Component
public class AsociacionDaoImpl implements AsociacionDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;

	@Override
	public Map<String, Object> read(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("pk_asociacion")
				.withProcedureName("sp_read_asociacion")
				.declareParameters(new SqlOutParameter("cursor_asociacion", Types.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("idasociacion", Types.NUMERIC));                           
				SqlParameterSource in = new MapSqlParameterSource().addValue("id", id);
				Map<String, Object> map = simpleJdbcCall.execute(in);
		return map;
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return null;
	}


}
