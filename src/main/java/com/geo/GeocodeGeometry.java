package com.geo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class GeocodeGeometry {
	
	@JsonProperty("location")
	GeocodeLocation geocodeLocation;
	
	public GeocodeGeometry()
	{
		
	}
	
	public GeocodeLocation getGeocodeLocation()
	{
		return geocodeLocation;
	}
	
	public void setGeocodeLocation(GeocodeLocation geocodeLoaction)
	{
		this.geocodeLocation=geocodeLocation;
	}

}
