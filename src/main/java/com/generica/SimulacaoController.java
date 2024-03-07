package com.generica;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;

import org.apache.velocity.Template;
import org.apache.velocity.runtime.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@RestController
public class SimulacaoController {
	
	@Autowired
	SimulacaoServiceImpl simulacaoServiceImpl;
	
	@RequestMapping("/simular")
	public Object obterSimulacao() throws ParseException, IOException {
		
		
		//objeto de retorno do server driven
		Object retornoDaAPISimulacao = simulacaoServiceImpl.obterSimulacao();
		
		
		// chamada do server driven ui para mergear o template com o objeto de simulacao
		Template template = ServerDrivenUI.gerarTemplate(obterTemplate("simulacao.json"));
		StringWriter templateMerged = ServerDrivenUI.mergearTemplateComObjeto(template, "simulacao", retornoDaAPISimulacao);
		
		Gson gson = new Gson();
		JsonElement jsonElement = new JsonParser().parse(templateMerged.toString());
		return gson.toJson(jsonElement);
	}
	
	public String obterTemplate(String filename) throws IOException {
		return StreamUtils.copyToString(new ClassPathResource(filename).getInputStream(), Charset.defaultCharset());		
	}

}
