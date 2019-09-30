package Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Surat {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nosurat")
    @Expose
    private String nosurat;
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("jenis_surat")
    @Expose
    private Integer jenisSurat;
    @SerializedName("perihal")
    @Expose
    private String perihal;
    @SerializedName("sifat_surat")
    @Expose
    private Integer sifatSurat;
    @SerializedName("pengirim")
    @Expose
    private String pengirim;
    @SerializedName("tujuan")
    @Expose
    private String tujuan;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("lampiran")
    @Expose
    private String lampiran;

    public Surat(){}

    public Surat(String tanggal, Integer jenisSurat, String perihal, Integer sifatSurat, String pengirim, String tujuan, String lampiran) {
        this.tanggal = tanggal;
        this.jenisSurat = jenisSurat;
        this.perihal = perihal;
        this.sifatSurat = sifatSurat;
        this.pengirim = pengirim;
        this.tujuan = tujuan;
        this.lampiran = lampiran;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNosurat() {
        return nosurat;
    }

    public void setNosurat(String nosurat) {
        this.nosurat = nosurat;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public Integer getJenisSurat() {
        return jenisSurat;
    }

    public void setJenisSurat(Integer jenisSurat) {
        this.jenisSurat = jenisSurat;
    }

    public String getPerihal() {
        return perihal;
    }

    public void setPerihal(String perihal) {
        this.perihal = perihal;
    }

    public Integer getSifatSurat() {
        return sifatSurat;
    }

    public void setSifatSurat(Integer sifatSurat) {
        this.sifatSurat = sifatSurat;
    }

    public String getPengirim() {
        return pengirim;
    }

    public void setPengirim(String pengirim) {
        this.pengirim = pengirim;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLampiran() {
        return lampiran;
    }

    public void setLampiran(String lampiran) {
        this.lampiran = lampiran;
    }
}
