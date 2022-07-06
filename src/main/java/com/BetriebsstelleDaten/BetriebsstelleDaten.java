package com.BetriebsstelleDaten;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Modal class that describes the structure of the JSON output
 * @author aswat
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, 
				getterVisibility=JsonAutoDetect.Visibility.NONE, 
				setterVisibility=JsonAutoDetect.Visibility.NONE,
				creatorVisibility=JsonAutoDetect.Visibility.NONE)

public class BetriebsstelleDaten {
	private String PLC;
    private String Code;
	private String Name;
	private String Kurzname;
	private String TypKurz;
    private String Typ;
	private String Betriebszustand;
	private String Datumab;
	private String Datumbis;
	private String Niederlassung;
	private String Regionalbereich;
	private String LetzteAnderung;
	
	/**
	 * Constructor for class BetriebsstelleDaten
	 */
	public BetriebsstelleDaten(){
	}

	/**
	 * defining getters and setters for instance variables of the class BetriebsstelleDaten
	 * 
	 */
	public String getPLC(){
		return PLC;
	}
	
	public void setPLC(String PLC){
		this.PLC = PLC;
	}
	
	public String getCode(){
		return Code;
	}

	public void setCode(String Code){
		this.Code = Code;
	}

	public String getname(){
		return Name;
	}

	public void setName(String Name){
		this.Name = Name;
	}

	public String getKurzname(){
		return Kurzname;
	}

	public void setKurzname(String Kurzname){
		this.Kurzname = Kurzname;
	}
	
	public String getTypKurz(){
		return TypKurz;
	}
	
	public void setTypKurz(String TypKurz){
		this.TypKurz = TypKurz;
	}
	
	public String getTyp(){
		return Typ;
	}

	public void setTyp(String Typ){
		this.Typ = Typ;
	}
	
	public String getBetriebszustand(){
		return Betriebszustand;
	}
	
	public void setBetriebszustand(String Betriebszustand){
		this.Betriebszustand = Betriebszustand;
	}
	
	public String getDatumab(){
		return Datumab;
	}
	
	public void setDatumab(String Datumab){
		this.Datumab = Datumab;
	}
	
	public String getDatumbis(){
		return Datumbis;
	}
	
	public void setDatumbis(String Datumbis){
		this.Datumbis = Datumbis;
	}
	
	public String getNiederlassung(){
		return Niederlassung;
	}
	
	public void setNiederlassung(String Niederlassung){
		this.Niederlassung = Niederlassung;
	}
	
	public String getRegionalbereich(){
		return Regionalbereich;
	}
	
	public void setRegionalbereich(String Regionalbereich){
		this.Regionalbereich = Regionalbereich;
	}
	
	public String getLetzteAnderung(){
		return LetzteAnderung;
	}
	
	public void setLetzteAnderung(String LetzteAnderung){
		this.LetzteAnderung = LetzteAnderung;
	}
}
