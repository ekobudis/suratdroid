package Models;

public class DataDivisi {
	private String nama;
	private int userId;
	private int id;

    public  DataDivisi( int id, String nama){
        this.id = id;
        this.nama = nama;
    }

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"DataDivisi{" +
			"nama = '" + nama + '\'' + 
			",user_id = '" + userId + '\'' +
			",id = '" + id + '\'' +
			"}";
		}
}
