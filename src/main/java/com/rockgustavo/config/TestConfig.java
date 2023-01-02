package com.rockgustavo.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rockgustavo.model.Patrimonio;
import com.rockgustavo.model.Setor;
import com.rockgustavo.model.Usuario;
import com.rockgustavo.repositories.PatrimonioRepository;
import com.rockgustavo.repositories.SetorRepository;
import com.rockgustavo.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	SetorRepository setorRepository;
	
	@Autowired
	UsuarioRepository userRepository;
	
	@Autowired
	PatrimonioRepository patrimRepository;
	
	@Override
	public void run(String... args) throws Exception{
		Setor setor1 = new Setor(null, true, "Contabilidade", "Administrativo", new Date(), new Date());
		
		Usuario user1 = new Usuario(null, true, "Operador", "Beatriz Alves", "0123", "0123", "balves", "123", new Date(), new Date(), setor1);
		Usuario user2 = new Usuario(null, true, "Operador", "Carlos de Mattos", "0456", "0456", "cmattos", "456", new Date(), new Date(), setor1);
		Usuario user3 = new Usuario(null, true, "Operador", "User03", "0456", "0456", "User03", "456", new Date(), new Date(), setor1);
		Usuario user4 = new Usuario(null, true, "Operador", "User04", "0456", "0456", "User04", "456", new Date(), new Date(), setor1);
		Usuario user5 = new Usuario(null, true, "Operador", "User05", "0456", "0456", "User05", "456", new Date(), new Date(), setor1);
		Usuario user6 = new Usuario(null, true, "Operador", "User06", "0456", "0456", "User06", "456", new Date(), new Date(), setor1);
		Usuario user7 = new Usuario(null, true, "Operador", "User07", "0456", "0456", "User07", "456", new Date(), new Date(), setor1);
		Usuario user8 = new Usuario(null, true, "Operador", "User08", "0456", "0456", "User08", "456", new Date(), new Date(), setor1);
		Usuario user9 = new Usuario(null, true, "Operador", "User09", "0456", "0456", "User09", "456", new Date(), new Date(), setor1);
		Usuario user10 = new Usuario(null, true, "Operador", "User10", "0456", "0456", "User10", "456", new Date(), new Date(), setor1);
		Usuario user11 = new Usuario(null, true, "Operador", "User11", "0456", "0456", "User11", "456", new Date(), new Date(), setor1);
		
		Patrimonio patrim1 = new Patrimonio(null, true, 123456, "https://firebase.google.com/", "Caneta Preta", 2.98, "Caneta Preta Marca BIC", "", null, new Date(), new Date(), user1);
		Patrimonio patrim2 = new Patrimonio(null, true, 456788, "https://firebase.google.com/", "Caneta Azul", 2.98, "Caneta Azul Marca BIC", "", null, new Date(), new Date(), user2);
		Patrimonio patrim3 = new Patrimonio(null, true, 985632, "https://firebase.google.com/", "Lapis", 1.78, "Lápis Marca Fabber Castell", "", null, new Date(), new Date(), user1);
		Patrimonio patrim4 = new Patrimonio(null, true, 452122, "https://firebase.google.com/", "Notebook", 4850.32, "Notebook Marca Dell", "", null, new Date(), new Date(), user2);
		
		setorRepository.saveAll(Arrays.asList(setor1));
		userRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11));
		patrimRepository.saveAll(Arrays.asList(patrim1, patrim2, patrim3, patrim4));
	}

}


/*
JSON

[
{
    "setor_id": 1,
    "situacao": true,
    "nome": "Contabilidade",
    "area": "Administrativo",
    "date_create": "2022-12-28T00:00:00.000+00:00",
    "date_update": "2022-12-28T00:00:00.000+00:00"
}
]
[
{
    "user_id": 1,
    "situacao": true,
    "cargo": "Operador",
    "nome": "Beatriz Alves",
    "rg": "0123",
    "cpf": "0123",
    "login": "balves",
    "senha": "123",
    "date_create": "2022-12-28T00:00:00.000+00:00",
    "date_update": "2022-12-28T00:00:00.000+00:00"
}
]
[
{
    "patrim_id": 1,
    "situacao": true,
    "registro_interno": 123456,
    "foto_url_item": "https://firebase.google.com/",
    "descricao": "Caneta Preta",
    "valor": 2.98,
    "dados_comp": "Caneta Preta Marca BIC",
    "dados_baixa": "",
    "date_baixa": null,
    "date_create": "2022-12-28T00:00:00.000+00:00",
    "date_update": "2022-12-28T00:00:00.000+00:00"
}
]
*/