package com.lh.back.UtilPojo;

import java.util.List;
/**
 * 天气类
 * @author renault
 *
 */
public class WeatherBean {

	  	private int error;
	    private String status;
	    private String date;
	    private List<WeatherResult> results;

	    public int getError() {
	        return error;
	    }

	    public void setError(int error) {
	        this.error = error;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public String getDate() {
	        return date;
	    }

	    public void setDate(String date) {
	        this.date = date;
	    }

	    public List<WeatherResult> getResults() {
	        return results;
	    }

	    public void setResults(List<WeatherResult> results) {
	        this.results = results;
	    }

		@Override
		public String toString() {
			return "WeatherBean [error=" + error + ", status=" + status
					+ ", date=" + date + ", results=" + results + "]";
		}
	    
}
