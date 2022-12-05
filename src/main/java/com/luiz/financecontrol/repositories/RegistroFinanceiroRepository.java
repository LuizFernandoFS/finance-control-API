package com.luiz.financecontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luiz.financecontrol.domain.RegistroFinanceiro;

@Repository
public interface RegistroFinanceiroRepository extends JpaRepository<RegistroFinanceiro, Integer> {

}
