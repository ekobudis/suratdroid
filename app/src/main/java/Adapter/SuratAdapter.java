package Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.vimasolusi.surat.R;
import java.util.List;
import java.util.Random;
import Models.Surat;

public class SuratAdapter extends RecyclerView.Adapter<SuratAdapter.SuratHolder> {

    Context mContext;
    List<Surat> semuaSurat;

    public String[] mColors = {
            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#51b46d", // green
            "#e0ab18", // mustard
            "#637a91", // dark gray
            "#f092b0", // pink
            "#b7c0c7"  // light gray
    };

    public SuratAdapter(Context context, List<Surat> listSurat){
        this.mContext = context;
        semuaSurat = listSurat;
    }

    //@Override
    /*public SuratAdapter.SuratHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.caleg_list,parent,false);
        return  new SuratAdapter.SuratHolder(itemView);
    }*/

    @Override
    public void onBindViewHolder(@NonNull SuratHolder holder, int position) {
        /*holder.tvNamaCaleg.setText("Nama : " + semuaCaleg.get(position).getLegislatifName());
        holder.tvJmlSuara.setText("Perolehan Suara : " + semuaCaleg.get(position).getJumlahSuara());
        holder.tvNoCaleg.setText("No Urut : " + semuaCaleg.get(position).getNocaleg());

        String namaKota = semuaCaleg.get(position).getLegislatifName();
        String firstCharNamaDosen = namaKota.substring(0,1);
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(firstCharNamaDosen, getColor());
        holder.ivTextDrawable.setImageDrawable(drawable);*/

    }

    @Override
    public int getItemCount() {
        return semuaSurat.size();
    }


    public class SuratHolder extends RecyclerView.ViewHolder {
        public TextView tvNoSurat, tvPerihal, tvTanggal, tvTujuan,tvStatusSurat;
        public ImageView ivTextDrawable;

        public SuratHolder(View  itemView){
            super(itemView);

            /*tvNoSurat = (TextView) itemView.findViewById(R.id.tv_nourut);
            tvPerihal = (TextView) itemView.findViewById(R.id.tv_namaCaleg);
            tvTanggal = (TextView) itemView.findViewById(R.id.tv_jmlSuara);
            ivTextDrawable = (ImageView) itemView.findViewById(R.id.ivTextDrawable);*/
        }

    }

    public int getColor() {
        String color;

        // Randomly select a fact
        Random randomGenerator = new Random(); // Construct a new Random number generator
        int randomNumber = randomGenerator.nextInt(mColors.length);

        color = mColors[randomNumber];
        int colorAsInt = Color.parseColor(color);

        return colorAsInt;
    }

}
