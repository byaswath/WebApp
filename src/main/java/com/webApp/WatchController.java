package com.webApp;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/watch")
@RestController
public class WatchController {
//@GetMapping (value = "/getHello")
//public String getHello() {
//	return "Hello";
//}
	

@GetMapping(value = "/getWatch")
public Watch getWatch(@RequestBody Watch w) {
	return w;
}
@GetMapping(value = "/getWatchBrand")
public String getWatchBrand(@RequestBody Watch w) {
	return w.getBrand();
}
@GetMapping(value = "/getWatchBrandandYear")
public String getWatchBrandandYear(@RequestBody Watch w) {
	return w.getBrand()+""+w.getModelYear();
}

	@GetMapping(value = "/getWatches")
	public List<Watch> getWatches(@RequestBody List<Watch> w) {
	return w;
	}
	
	


//@GetMapping(value = "/getOnlyLeather")
//public List<Watch> getOnlyLeather(@RequestBody List<Watch> w) {
//	for(int i=0 ; i<w.size() ; i++) {
//		if(w.get(i).getStrapType().equals("Leather")) {
//			return w.get(i);
//		}
//		else {
//			return "Invalid";
//		}
//	}
//	
//}


	
}
