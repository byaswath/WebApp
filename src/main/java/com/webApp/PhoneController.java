package com.webApp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/phoneDetails")
@RestController
public class PhoneController {

	@GetMapping(value = "/getPhone")
	public List<String> getPhone(@RequestBody List<Phone> p) {
		List<String> s4 = new ArrayList<>();
		
		for(Phone x : p) {
			if(x.getPrice()>2500) {
				s4.add(x.getBrand());
			}
		}
		return s4;
	}
//---------------------------------------------------------------------------

@GetMapping(value = "/getBrandStarts")
public List<String> getBrandsStarts(@RequestBody List<Phone> p) {
	List<String> results = new ArrayList<>();
	
	for(Phone x : p) {
		if(x.getBrand().startsWith("S")) {
			results.add(x.getColour()+":"+x.getModelYear());
		}
	}
	return results;
}

//---------------------------------------------------------------------------

@GetMapping(value = "/getPhonePrice")
public String getPrices(@RequestBody List<Phone> p) {
	String a = "";
	int b = 0;
	for(Phone i : p) {
		if(i.getPrice() > 2500) {
			a = i.getBrand();
			b = i.getPrice();
		}
	}
	return a + " " + b;
}

//---------------------------------------------------------------------------

@GetMapping(value = "/getOnlyBrand")
public Phone getOnlyBrand(@RequestBody List<Phone> p) {
	Phone s1 = null;
	for(int i=0 ; i<p.size() ; i++) {
		if(p.get(i).getColour().equals("B")) {
			s1 = p.get(i);
		}
	}
	return s1;
}

//---------------------------------------------------------------------------

@GetMapping(value = "/getModel")
public List<String> getModel(@RequestBody List<Phone> p) {
	
	List<String> sm = p.stream().filter(x -> x.getModelYear()>2020 && x.getModelYear()<2024).map(x -> x.getBrand()).collect(Collectors.toList());		
	return sm;
}

//---------------------------------------------------------------------------


@GetMapping(value = "/getMax")
public int getMax(@RequestBody List<Phone> p) {
	int i1 = 0;
	for(Phone x : p) {
		if(x.getPrice()>i1) {
			i1 = x.getPrice();
		}
	}
	return i1;
}

//---------------------------------------------------------------------------


@GetMapping(value = "/getMinBrand")
public String getMinBrand(@RequestBody List<Phone> p) {
	
	Phone min = p.get(0);
	for(int i=0 ; i<p.size() ; i++) {
		if(p.get(i).getPrice()<min.getPrice()) {
			min = p.get(i);
		}
	}
	return min.getBrand()+"-"+min.getColour();
		
}

//---------------------------------------------------------------------



}