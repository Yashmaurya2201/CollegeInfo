package com.example.collegeinfo2;

import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class myviewholder extends RecyclerView.ViewHolder {


    ImageView img;
    TextView txtname1;
    CardView main_card;
    TextView des;
    WebView web;

    public myviewholder(@NonNull View itemView) {
        super(itemView);
        img=(ImageView) itemView.findViewById(R.id.img1);

        txtname1=(TextView) itemView.findViewById(R.id.txtname);
        main_card=(CardView) itemView.findViewById(R.id.mcard);
       des=(TextView) itemView.findViewById(R.id.txtdes);
       web=(WebView) itemView.findViewById(R.id.web1);





    }


}
