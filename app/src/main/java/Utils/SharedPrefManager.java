package Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    public static final String SP_LHP_APP = "spSuratApp";

    public static final String SP_NAMA = "nama";
    public static final String SP_USERID = "uid";
    public static final String SP_IDKOTA = "idkota";
    public static final String SP_KESATUAN = "kesatuan";
    public static final String SP_PHOTO= "photo";
    public static final String SP_PANGKAT = "pangkat";
    public static final String SP_PHONE= "phone";
    public static final String SP_NIK = "nrp";

    public static final String SP_SUDAH_LOGIN = "spSudahLogin";

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public SharedPrefManager(Context context){
        sp = context.getSharedPreferences(SP_LHP_APP, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void saveSPString(String keySP, String value){
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public void saveSPInt(String keySP, int value){
        spEditor.putInt(keySP, value);
        spEditor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }

    public String getSPNama(){
        return sp.getString(SP_NAMA, "");
    }

    public String getSPIDKota(){
        return sp.getString(SP_IDKOTA, "");
    }

    public String getSPUserId(){
        return sp.getString(SP_USERID, "");
    }

    public String getSPKesatuan(){
        return sp.getString(SP_KESATUAN, "");
    }

    public String getSPPhone(){
        return sp.getString(SP_PHONE, "");
    }

    public String getSPPhoto(){
        return sp.getString(SP_PHOTO, "");
    }

    public Boolean getSPSudahLogin(){
        return sp.getBoolean(SP_SUDAH_LOGIN, false);
    }

    public String getSPPangkat(){
        return sp.getString(SP_PANGKAT, "");
    }

    public String getSPNik(){
        return sp.getString(SP_NIK, "");
    }
}
