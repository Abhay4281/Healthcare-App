package com.example.healthytoday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {

    private String[][] packages =
            {
                    {"Uprise-D3 1000IU Capsule","","","","50"},
                    {"HealthVit Chromium Picolonate 200mcg Capsule","","","","305"},
                    {"Vitamin B complex Capsule","","","","488"},
                    {"InLife Vitamin E","","","","539"},
                    {"Dolo 650 Tablet","","","","30"},
                    {"Crocin 650 Advanced","","","","50"},
                    {"Strepsils medicated","","","","40"},
                    {"Tata 1mg capsule + vitamin D3","","","","30"},
                    {"Ferona - XT Tablet","","","","130"},
            };
    private String[] package_details =
            {
                   "Building and keeping the bones and teeth strong\n"+
                           "Reducing Fatigue and muscular pain\n"+
                           "Boosting immunity and increasing resistance against infection",
                    "Chromium is an essential trace mineral that plays important role in helping insulin resulate",
                    "Provide relief from Vitamin B deficiencies\n"+
                            "Helps in formation of red blood cells\n"+
                            "Maintain healthy nervous system",
                    "It provides health as well as skin beinifits\n"+
                            "It helps in reduce skin blemish and pigmentation\n"+
                            "It acts as a safeguard for skin from harsh UV rays",
                    "Dolo 650 helps in reducing pain and fever ",
                    "Helps relive fever and brings down high temprature\n"+
                            "suitable for people with heart condition and high blood pressure",
                    "Relieves the symptom of bacterial throat infection and soothes recovery process\n"+
                            "provide a warm and comforting feeling during a sore throat ",
                    "Reduces risk of calcium deficiency , rickets \n "+
                            "Promotes mobility and flexiblity of joints",
                    "Helps to reduce iron deficiency due to chronic blood loss"
            };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack,btnGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.listViewBMCart);
        btnBack =  findViewById(R.id.buttonBMCartCheckout);
        btnGoToCart =  findViewById(R.id.buttonBMGoToCart);


        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });


        list=new ArrayList<>();

        for(int i=0;i<packages.length;i++)
        {
            item=new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Total Cost:"+packages[i][4]+"/-");
            list.add(item);
        }

        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this,BuyMedicineDetailActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });
    }
}