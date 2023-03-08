package com.felipe.dev.cobranca.controller;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.felipe.dev.cobranca.model.BankSlip;
import com.felipe.dev.cobranca.model.Status;
import com.felipe.dev.cobranca.repository.BankSlips;

@Controller
@RequestMapping("/bankslip")
public class BankSlipController {

	@Autowired
	private BankSlips bankSlips;
	
	/**
	 * Método responsável por retornar a view de cadastro de título
	 * 
	 * @return ModelAndView
	 */
	@GetMapping("/new")
	public ModelAndView newRegister() {
		ModelAndView mv = new ModelAndView("BankSlipRegister");
		return mv;
	}

	/**
	 * Método responsável por persistir os dados no banco
	 * 
	 * @param bankSlip
	 * @return ModelAndView
	 */
	@PostMapping("/save")
	public ModelAndView save(BankSlip bankSlip) {	
		ModelAndView mv = new ModelAndView("BankSlipRegister");
		try {
			BankSlip returnObject = this.bankSlips.save(bankSlip);
			mv.addObject("message", "Título cadastrado com sucesso!");
			mv.addObject("class", "alert-success");
			mv.addObject("returnObject", returnObject);
		
		} catch (Exception e) {
			mv.addObject("message", "Falha ao cadastrar o título! Tente novamente mais tarde!");
			mv.addObject("class", "alert-danger");
		}
		return mv;
	}
	
	@GetMapping("/list")
	public String list() {
		return "BankSlipList";
	}
	
	@ModelAttribute("statusBankSlip")
	public List<Status> allStatus () {
		return Arrays.asList(Status.values());
	}
}

