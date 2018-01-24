package com.biyardimapp.biyardimv1;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ahmetersoz on 19.12.2017.
 */

public class YardimClass extends ArrayAdapter<String> {

    private final ArrayList<String> baslik;
    private final ArrayList<String> icerik;
    private final ArrayList<String> sehir;
    private final ArrayList<String> tarih;
    private final ArrayList<String> iletisim;

    private final Activity context;

    public YardimClass(ArrayList<String> baslik, ArrayList<String> icerik, ArrayList<String> sehir, ArrayList<String> tarih, ArrayList<String> iletisim, Activity context) {
        super(context, R.layout.custom_view,baslik);
        this.baslik = baslik;
        this.icerik = icerik;
        this.sehir = sehir;
        this.tarih = tarih;
        this.iletisim = iletisim;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View customView = layoutInflater.inflate(R.layout.custom_view,null,true);

        TextView baslikText = (TextView) customView.findViewById(R.id.baslik);
        TextView icerikText = (TextView) customView.findViewById(R.id.icerik);
        TextView sehirText = (TextView) customView.findViewById(R.id.sehir);
        TextView tarihText = (TextView) customView.findViewById(R.id.tarih);
        TextView iletisimText = (TextView) customView.findViewById(R.id.iletisim);

        baslikText.setText(baslik.get(position));
        icerikText.setText(icerik.get(position));
        sehirText.setText(sehir.get(position));
        tarihText.setText(tarih.get(position));
        iletisimText.setText(iletisim.get(position));



        return customView;
    }
}
