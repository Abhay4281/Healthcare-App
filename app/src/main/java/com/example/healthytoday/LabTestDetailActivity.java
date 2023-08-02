package com.example.healthytoday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LabTestDetailActivity extends AppCompatActivity {

    TextView tvPackageName,tvTotalCost;
    EditText edDetails;
    Button btnAddtoCart,btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_detail);

        tvPackageName=findViewById(R.id.TextViewBMCartTitle);
        tvTotalCost=findViewById(R.id.textViewBMDTotalCost);
        edDetails=findViewById(R.id.editTextBMDMultiLine);
        btnAddtoCart=findViewById(R.id.buttonBMBack);
        btnBack=findViewById(R.id.buttonBMDBack);
        edDetails.setKeyListener(null);

        Intent intent= getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        tvTotalCost.setText(intent.getStringExtra("text2"));
        edDetails.setText("Total Cost:"+intent.getStringExtra("text3")+"/-");

         btnBack.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(new Intent(LabTestDetailActivity.this,LabTestActivity.class));
             }
         });

         btnAddtoCart.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                 String username = sharedPreferences.getString("username","").toString();
                 String product = tvPackageName.getText().toString();
                 float price = Float.parseFloat(intent.getStringExtra("text3").toString());

                 Database db = new Database(getApplicationContext(),"healthcare",null,1);

                 if(db.checkCart(username,product)==1)
                 {
                     Toast.makeText(getApplicationContext(),"Product Already Added",Toast.LENGTH_SHORT).show();
                 }else {
                     db.addCart(username,product,price,"lab");
                     Toast.makeText(getApplicationContext(),"Record inserted into cart",Toast.LENGTH_SHORT).show();
                     startActivity(new Intent(LabTestDetailActivity.this,LabTestActivity.class));
                 }
             }
         });


    }
}