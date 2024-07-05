package com.distribuida.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
 
import com.distribuida.dao.AutorDAO;
import com.distribuida.entities.Autor;
 

@Controller
@RequestMapping("/autores")     //path Principal
public class AutorController {
	//JSP - Java server Page, son las paginas web ded tecnologias java
	@Autowired
	private AutorDAO autorDAO;
	@GetMapping("/findAll")      // path secundario
	public String finAll(Model  model) {
		//try {
			List<Autor> autores = autorDAO.findAll();
			model.addAttribute("keyAutores",autores);    //EJ : Clave = KeyClientes , valor = clientes

			return "listar-autores";  //nombre del formulario EJ.listar-clientes.html o listar-clientes.jsp
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//	   }
	}

	@GetMapping("/finOne")
	public String findOne(@RequestParam("idAutor")@Nullable Integer idAutor
			             ,@RequestParam("opcion")@Nullable Integer opcion
			             ,Model model
			) {
	//	try {
			if(idAutor !=null) {
				Autor autor = autorDAO.findOne(idAutor);
				model.addAttribute("autor", autor);
			}
			if(opcion == 1) return "add-autores";  //Actualizacion
			else return "del-autores";             //Eliminación
	//	} catch (Exception e) {
	//		// TODO: handle exception
	//	}

	}
	@PostMapping("/add")
	public String add(@RequestParam("idAutor") @Nullable Integer idAutor
			      ,@RequestParam("nombre") @Nullable String nombre
			      ,@RequestParam("apellido") @Nullable String apellido
			      ,@RequestParam("pais") @Nullable String pais
			      ,@RequestParam("dirección") @Nullable String direccion
			      ,@RequestParam("telefono") @Nullable String telefono
			      ,@RequestParam("correo") @Nullable String correo
			      ,Model model
			) {
	//	try {
			if(idAutor == null) {
				Autor autor = new Autor(0, nombre, apellido, pais,  direccion, telefono, correo);
				autorDAO.add(autor);
			}else {
				Autor autor2 = new Autor(idAutor, nombre, apellido,pais,  direccion, telefono, correo);
				autorDAO.up(autor2);

	//	} catch (Exception e) {
	//		// TODO: handle exception
	//	}

		}
		return "redirect:/autores/finAll";    //ir a formulario web por path o url.
	}
	@GetMapping("/del")
	public String del(@RequestParam("idAutor") @Nullable Integer idAutor) {
		//try {
			autorDAO.del(idAutor);
			return "redirect:/autores/finAll";
	//	} catch (Exception e) {
	//		// TODO: handle exception
	//	}

	}
}















