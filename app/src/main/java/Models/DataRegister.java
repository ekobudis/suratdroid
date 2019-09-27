package Models;

import com.google.gson.annotations.SerializedName;

public class DataRegister{

	@SerializedName("name")
	private String name;

	@SerializedName("token")
	private String token;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	@Override
 	public String toString(){
		return 
			"DataRegister{" +
			"name = '" + name + '\'' + 
			",token = '" + token + '\'' + 
			"}";
		}
}