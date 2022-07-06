package com.BetriebsstelleDaten.Controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.BetriebsstelleDaten.BetriebsstelleDaten;
import com.BetriebsstelleDaten.Exception.BetriebsstelleDatenExceptions;
import com.BetriebsstelleDaten.Service.BetriebsstelleDatenService;

/**
 * Springboot annotations for handling HTTP request is defined
 * @author aswat
 */
@RestController
public class BetriebsstelleDatenController {
	private final BetriebsstelleDatenService betriebsstelleDatenService;
	
	/**
	 * Constructor for BetriebsstelleDatenController class 
	 * @param betriebsstelleDatenService
	 */
	public BetriebsstelleDatenController(BetriebsstelleDatenService betriebsstelleDatenService) {
        this.betriebsstelleDatenService = betriebsstelleDatenService;
    }
	
	/** 
	 * @returns all data in input file in JSON Format
	 * @throws FileNotFoundException
	 */
	@GetMapping("/betriebsstelle")
	@ResponseStatus(code = HttpStatus.OK)
	public List<BetriebsstelleDaten> getAllData() throws FileNotFoundException{
		return betriebsstelleDatenService.getData();	
	}
	
	/**
	 * @param betriebsstelleCode
	 * @returns all details of requested betriebsstelle 
	 * @throws FileNotFoundException
	 * @throws BetriebsstelleDatenExceptions
	 */
	@GetMapping("/betriebsstelle/{RL100-Code}")
	@ResponseStatus(code = HttpStatus.OK)
	public BetriebsstelleDaten getByCode(@PathVariable("RL100-Code") String betriebsstelleCode) throws FileNotFoundException, BetriebsstelleDatenExceptions{
		return betriebsstelleDatenService.getByCode(betriebsstelleCode);
		
	}
}
