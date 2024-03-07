package com.generica;

import org.springframework.stereotype.Service;

@Service
public class SimulacaoServiceImpl {
	
	public Object obterSimulacao() {
		
		//simulando o retorno de uma api
		SimulacaoDTO simulacaoDTO = new SimulacaoDTO();
		
		return simulacaoDTO;
	}
}
