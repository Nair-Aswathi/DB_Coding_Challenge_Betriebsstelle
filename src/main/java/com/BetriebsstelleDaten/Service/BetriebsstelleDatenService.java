package com.BetriebsstelleDaten.Service;

import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.BetriebsstelleDaten.BetriebsstelleDaten;
import com.BetriebsstelleDaten.Exception.BetriebsstelleDatenExceptions;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;


/**
 * the logic of the project is described the in @Service class
 * @author aswat
 *
 */
@Service
public class BetriebsstelleDatenService {
	private static final String URL = "https://download-data.deutschebahn.com/static/datasets/betriebsstellen/DBNetz-Betriebsstellenverzeichnis-Stand2021-10.csv";
	private static final char Delimiter = ';';
	
	/**
	 * Reads data from CSV FIle and maps it to Bean attributes 
	 * @return
	 * @throws FileNotFoundException
	 */
	public List<BetriebsstelleDaten> getData() throws FileNotFoundException{
		
		/* Converting HashMap to Map to map key-pair values. */
        Map<String, String> map_CSV_to_Bean = new HashMap<String, String>();
        map_CSV_to_Bean.put("PLC", "PLC");
        map_CSV_to_Bean.put("RL100-Code", "Code");
        map_CSV_to_Bean.put("RL100-Langname", "Name");
        map_CSV_to_Bean.put("RL100-Kurzname", "Kurzname");
        map_CSV_to_Bean.put("Typ Kurz", "TypKurz");
        map_CSV_to_Bean.put("Typ Lang", "Typ");
        map_CSV_to_Bean.put("Betriebszustand", "Betriebszustand");
        map_CSV_to_Bean.put("Datum ab", "Datumab");
        map_CSV_to_Bean.put("Datum bis", "Datumbis");
        map_CSV_to_Bean.put("Niederlassung", "Niederlassung");
        map_CSV_to_Bean.put("Regionalbereich", "Regionalbereich");
        map_CSV_to_Bean.put("Letzte Änderung", "LetzteAnderung");
       
        /* Mapping of Data to objects using key-pair values of Map*/
        HeaderColumnNameTranslateMappingStrategy<BetriebsstelleDaten> mapping_Strategy  =
             new HeaderColumnNameTranslateMappingStrategy<BetriebsstelleDaten>();
        
        mapping_Strategy.setType(BetriebsstelleDaten.class);
        mapping_Strategy.setColumnMapping(map_CSV_to_Bean);
        
  
        RestTemplate restTemplate = new RestTemplate();
        
        /* Read CSV FIle and map to Bean*/
        List<BetriebsstelleDaten> records = (List<BetriebsstelleDaten>) restTemplate
        		.execute(URL,HttpMethod.GET, null, clientHttpResponse ->{
        		    InputStreamReader inputFile = new InputStreamReader(clientHttpResponse.getBody());
        			CsvToBean<BetriebsstelleDaten> csv_To_Bean = new CsvToBeanBuilder<BetriebsstelleDaten>(inputFile)
                    .withType(BetriebsstelleDaten.class)
                    .withSeparator(Delimiter)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withMappingStrategy(mapping_Strategy)
                    .build();
        			return csv_To_Bean.stream().collect(Collectors.toList());
        		});

        return records;           
	}
	
	/**
	 * @param code
	 * @returns details of Betriebsstelle on matching it with given RL100Code
	 * @throws FileNotFoundException
	 * @throws BetriebsstelleDatenExceptions
	 */
	public BetriebsstelleDaten getByCode(String code) throws FileNotFoundException, BetriebsstelleDatenExceptions{
		
		BetriebsstelleDaten read_By_RL100Code = (BetriebsstelleDaten) getData()
				.stream()
				.filter(BetriebsstelleDaten -> BetriebsstelleDaten.getCode().equalsIgnoreCase(code))
				.findFirst()
				.orElseThrow(() -> new BetriebsstelleDatenExceptions("Code Not Found"));
				
		read_By_RL100Code.setCode(null);
		read_By_RL100Code.setPLC(null);
		read_By_RL100Code.setBetriebszustand(null);
		read_By_RL100Code.setDatumab(null);
		read_By_RL100Code.setDatumbis(null);
		read_By_RL100Code.setLetzteAnderung(null);
		read_By_RL100Code.setNiederlassung(null);
		read_By_RL100Code.setRegionalbereich(null);
		read_By_RL100Code.setTypKurz(null);

		return read_By_RL100Code;	
	}
}
