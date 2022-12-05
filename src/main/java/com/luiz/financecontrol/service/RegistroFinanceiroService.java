package com.luiz.financecontrol.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luiz.financecontrol.domain.RegistroFinanceiro;
import com.luiz.financecontrol.repositories.RegistroFinanceiroRepository;

@Service
public class RegistroFinanceiroService {

	@Autowired
	private RegistroFinanceiroRepository repository;
	
	public RegistroFinanceiro findById(Integer id) throws Exception {
		Optional<RegistroFinanceiro> registro =  repository.findById(id);
		return registro.orElseThrow(() -> new Exception());
	}
	
	public List<RegistroFinanceiro> findAll() {
		return repository.findAll();
	}

	public RegistroFinanceiro create(RegistroFinanceiro obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public RegistroFinanceiro update(Integer id, RegistroFinanceiro registroFinanceiro) throws Exception {
		RegistroFinanceiro obj = findById(id);
		obj.setDescricao(registroFinanceiro.getDescricao());
		obj.setTipoRegistro(registroFinanceiro.getTipoRegistro());
		obj.setValor(registroFinanceiro.getValor());
		return repository.save(obj);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
