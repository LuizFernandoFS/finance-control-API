package com.luiz.financecontrol.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luiz.financecontrol.domain.RegistroFinanceiro;
import com.luiz.financecontrol.domain.TipoRegistro;
import com.luiz.financecontrol.repositories.RegistroFinanceiroRepository;

@Service
public class DBService {

	@Autowired
	private RegistroFinanceiroRepository repository;
	
	public void iniciaBaseDeDados() {
		
		ArrayList<RegistroFinanceiro> array = new ArrayList<>();
		
		RegistroFinanceiro r1 = new RegistroFinanceiro(null, "Pagamento Da Água", 164.00, TipoRegistro.DESPESA);
		RegistroFinanceiro r2 = new RegistroFinanceiro(null, "Pagamento Da Luz", 197.00, TipoRegistro.DESPESA);
		RegistroFinanceiro r3 = new RegistroFinanceiro(null, "Pagamento Da Internet", 75.00, TipoRegistro.DESPESA);
		RegistroFinanceiro r4 = new RegistroFinanceiro(null, "Salário", 3800.00, TipoRegistro.RECEITA);
		RegistroFinanceiro r5 = new RegistroFinanceiro(null, "Aluguel", 2000.00, TipoRegistro.DESPESA);
		
		array.add(r1);
		array.add(r2);
		array.add(r3);
		array.add(r4);
		array.add(r5);
		
		this.repository.saveAll(array);
	}
}