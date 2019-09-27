package Models;

public class DivisiResponse{
	private DataDivisi dataDivisi;
	private boolean success;
	private String message;

	public void setDataDivisi(DataDivisi dataDivisi){
		this.dataDivisi = dataDivisi;
	}

	public DataDivisi getDataDivisi(){
		return dataDivisi;
	}

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"DivisiResponse{" + 
			"dataDivisi = '" + dataDivisi + '\'' +
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}
