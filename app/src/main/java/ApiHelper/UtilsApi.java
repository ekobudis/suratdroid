package ApiHelper;

public class UtilsApi {
    public static final String BASE_URL_API = "http://app.vimasolusi.id/api/v1/"; //"http://103.252.100.123/api/"
    //public static final String BASE_URL_API = "http://127.0.0.1:8000/api/"; //"http://103.252.100.123/api/"

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
