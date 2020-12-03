package pe.edu.upeu.SISRA.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.SISRA.entity.Documento;
import pe.edu.upeu.SISRA.service.DocumentoService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/documentos")
public class DocumentoController {
@Autowired
private DocumentoService documentoService;

@GetMapping("/req/{id}")
public Map<String, Object> listar_req(@PathVariable int id ) {
	try {
		 return documentoService.listar_req(id);
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("error"+e);
		return null;
	}
}
@GetMapping("/his/man={id_asc}/emp={id_doc}")
public Map<String, Object> historial_doc(@PathVariable int id_asc ,@PathVariable int id_doc) {
	try {
		 return documentoService.historial_doc(id_asc, id_doc);
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("error"+e);
		return null;
	}
}

@PostMapping("/add")
public int create(@RequestBody Documento r) {
	System.out.println("Crear: "+r.getCodigo());
	return documentoService.create(r);
}


}

