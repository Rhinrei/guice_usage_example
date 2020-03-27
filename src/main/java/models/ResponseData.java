package models;

import com.google.gson.annotations.SerializedName;

public class ResponseData {

	@SerializedName("ad")
	private Ad ad;

	@SerializedName("data")
	private User user;

	public void setAd(Ad ad){
		this.ad = ad;
	}

	public Ad getAd(){
		return ad;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	@Override
 	public String toString(){
		return 
			"Data{" +
			"ad = '" + ad + '\'' + 
			",data = '" + user + '\'' +
			"}";
		}
}