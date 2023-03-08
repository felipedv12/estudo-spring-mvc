package com.felipe.dev.cobranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipe.dev.cobranca.model.BankSlip;

public interface BankSlips extends JpaRepository<BankSlip, Long> {

}
