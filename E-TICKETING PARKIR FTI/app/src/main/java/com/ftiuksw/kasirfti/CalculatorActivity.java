package com.ftiuksw.kasirfti;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {
    private EditText  edtnopol, edtlamaparkir, edtuangbay;
    private Button btnproses;
    private Button btnhapus;
    private Button btnexit;
    private TextView txtnamapel;
    private TextView txtnamabar;
    private TextView txtjumlahbel;
    private TextView txtharga;
    private TextView txtuangbay;
    private TextView txtbonus;
    private TextView txttotalbelanja;
    private TextView txtuangkembali;
    private TextView txtketerangan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);


        getSupportActionBar().setTitle("BIAYA KELOLA PARKIR FTI");


        edtnopol = (EditText) findViewById(R.id.nomerpolisi);
        edtlamaparkir = (EditText) findViewById(R.id.jumlahbeli);
        edtuangbay = (EditText) findViewById(R.id.uangbayar);
        btnproses = (Button) findViewById(R.id.tombol1);
        btnexit = (Button) findViewById(R.id.tombol3);
        txtnamabar = (TextView) findViewById(R.id.nomerpolisi);
        txtjumlahbel = (TextView) findViewById(R.id.jumlahbeli);
        txtuangbay = (TextView) findViewById(R.id.uangbayar);
        txttotalbelanja = (TextView) findViewById(R.id.totalbelanja);
        txtuangkembali = (TextView) findViewById(R.id.uangkembali);
        txtketerangan = (TextView) findViewById(R.id.keterangan);

        //memberikan action pada tombol proses

        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String platnomer = edtnopol.getText().toString().trim();
                String lamaparkir = edtlamaparkir.getText().toString().trim();
                String uangbayar = edtuangbay.getText().toString().trim();

                double lp = Double.parseDouble(lamaparkir);
                double ub = Double.parseDouble(uangbayar);
                double total = (lp * 1000);
                txttotalbelanja.setText("Total Biaya Parkir Tiap Jam : " + total);

                //pemberian if dan else untuk aturan pemberian bonus

                double uangkembalian = (ub - total);

                if (ub < total) {
                    txtketerangan.setText("Keterangan : uang bayar kurang Rp " + (-uangkembalian));
                    txtuangkembali.setText("Uang Kembali : Rp 0");
                } else {
                    txtuangkembali.setText("Uang Kembali : " + uangkembalian);
                }


                //memberikan action pada tombol reset data
            }
        });

        btnexit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CalculatorActivity.this);
                builder.setMessage("Are you sure you want to exit?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                CalculatorActivity.this.finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        }
        ); }
}
