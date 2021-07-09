package com.geo.controller;

import java.io.IOException;
import java.net.URLEncoder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import okhttp3.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geo.GeocodeResult;

import okhttp3.OkHttpClient;
import okhttp3.Request;

@RestController
public class GeocodeeController 
{
	@GetMapping("/geocode")
	public GeocodeResult getGeocode(@RequestParam String address) 
			throws IOException
			{
		OkHttpClient client=new OkHttpClient();
		String encodedAddress=URLEncoder.encode(address,"UTF-8");
		Request request = new Request.Builder().url("https://google-maps-"
				+ "geocoding.p.rapidapi.com/geocode/json?language=en&address=" + encodedAddress).get()
				.addHeader("x-rapidapi-host", "google-maps-geocoding.p.rapidapi.com")
				.addHeader("x-rapidapi-key","AIzaSyAHDQ_7_w04rwzsWBNXy1pr29XajtBG7Yc"/*  Use your API Key here */)
	               .build();
		ResponseBody responseBody=client.newCall(request).execute().body();
		ObjectMapper objectMapper=new ObjectMapper();
		GeocodeResult result=objectMapper.readValue(responseBody.string(),GeocodeResult.class);
		
		      return result;
			}

}
