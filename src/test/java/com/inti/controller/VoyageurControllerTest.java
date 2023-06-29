package com.inti.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.inti.model.Voyageur;
import com.inti.repository.IVoyageurRepository;

@WebMvcTest(controllers = VoyageurController.class)
public class VoyageurControllerTest {
	
	@Autowired
	private MockMvc mock;
	
	@MockBean
	private IVoyageurRepository ivr;
	
	@Test
	public void saveVoyageur() throws Exception
	{
		mock.perform(get("/creerVoyageur"))
		.andExpect(status().isOk())
		.andDo(print());
	}
	

	@Test
	public void listeVoyageur() throws Exception
	{
		mock.perform(get("/listeVoyageur"))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	public void deleteVoyageur() throws Exception
	{
		mock.perform(get("/deleteVoyageur/1"))
		.andExpect(status().is3xxRedirection())
		.andExpect(redirectedUrl("/listeVoyageur"))
		.andDo(print());
	}
	
	@Test
	public void saveVoyageurPost() throws Exception
	{
		mock.perform(post("/creerVoyageur").sessionAttr("voyageur", new Voyageur("Masters", "Ken", 30)))
		.andExpect(status().is3xxRedirection())
		.andExpect(redirectedUrl("/listeVoyageur"))
		.andDo(print());
	}
	
	@Test
	public void updateVoyageurPost() throws Exception
	{
		mock.perform(post("/modifierVoyageur/1").sessionAttr("voyageur", new Voyageur("Paul", "Peche", 35)))
		.andExpect(status().is3xxRedirection())
		.andExpect(redirectedUrl("/listeVoyageur"))
		.andDo(print());
	}

}
