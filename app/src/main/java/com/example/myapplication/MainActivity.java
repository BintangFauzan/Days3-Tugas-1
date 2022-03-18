package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText etKodeBarang, etJumlahBarang;
    private Button btnTotal, btnHapus, btnKeluar;
    private TextView tvJenisBarang, tvHargaBarang, tvTotalHarga, tvDiskon, tvJumlahBayar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faktur);
        etKodeBarang = findViewById(R.id.etKodeBarang);
        etJumlahBarang = findViewById(R.id.etJumlahBarang);
        btnTotal = findViewById(R.id.btnTotal);
        tvDiskon = findViewById(R.id.tvDiskon);
        tvJenisBarang = findViewById(R.id.tvJenisBarang);
        tvHargaBarang = findViewById(R.id.tvHargaBarang);
        tvTotalHarga = findViewById(R.id.tvTotalHarga);
        tvJumlahBayar = findViewById(R.id.tvJumlahBayar);


        btnTotal.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.btnTotal) {

                    String kodeBarang = etKodeBarang.getText().toString().trim().toUpperCase();
                    String kode = kodeBarang.substring(0, 3);
                    String diskon = kodeBarang.substring(kodeBarang.length() - 2);
                    int disc = Integer.parseInt(diskon);
                    String jumlahBarang = etJumlahBarang.getText().toString().trim();
                    int jb = Integer.parseInt(jumlahBarang);

                    int hargaAND = 1000000, hargaIOS = 2000000, hargaBLB = 1750000, hargaWNP = 2500000;

                    DecimalFormat harga = new DecimalFormat("#,###,###");
                    int th1 = jb * hargaAND, th2 = jb * hargaIOS, th3 = jb * hargaBLB, th4 = jb * hargaWNP;
                    String thh1 = harga.format(th1), thh2 = harga.format(th2), thh3 = harga.format(th3), thh4 = harga.format(th4);

                    int diskon1 = th1 * disc / 100, diskon2 = th2 * disc / 100, diskon3 = th3 * disc / 100, diskon4 = th4 * disc / 100;
                    String diskonn1 = harga.format(diskon1), diskonn2 = harga.format(diskon2), diskonn3 = harga.format(diskon3), diskonn4 = harga.format(diskon4);

                    int jb1 = th1 - diskon1, jb2 = th2 = diskon2, jb3 = th3 - diskon3, jb4 = th4 - diskon4;
                    String jbb1 = harga.format(jb1), jbb2 = harga.format(jb2), jbb3 = harga.format(jb3), jbb4 = harga.format(jb4);

                    String hargaAnd = harga.format(hargaAND), hargaIos = harga.format(hargaIOS), hargaBlb = harga.format(hargaBLB), hargaWnp = harga.format(hargaWNP);

                    switch (kode) {
                        case "AND":
                            tvJenisBarang.setText("Android");
                            tvHargaBarang.setText(hargaAnd);
                            tvTotalHarga.setText(thh1);
                            tvDiskon.setText(diskonn1);
                            tvJumlahBayar.setText(jbb1);
                            break;

                        case "IOS":
                            tvJenisBarang.setText("Apple");
                            tvHargaBarang.setText(hargaIos);
                            tvTotalHarga.setText(thh2);
                            tvDiskon.setText(diskonn2);
                            tvJumlahBayar.setText(jbb2);
                            break;

                        case "BLB":
                            tvJenisBarang.setText("BlackBerry");
                            tvHargaBarang.setText(hargaBlb);
                            tvTotalHarga.setText(thh3);
                            tvDiskon.setText(diskonn3);
                            tvJumlahBayar.setText(jbb3);
                            break;

                        case "WNP":
                            tvJenisBarang.setText("Windows Phone");
                            tvHargaBarang.setText(hargaWnp);
                            tvTotalHarga.setText(thh4);
                            tvDiskon.setText(diskonn4);
                            tvJumlahBayar.setText(jbb4);
                            break;
                        default:
                            System.out.print("Kode Barang Tidak Di temukan");

                    }


                }
            }
        }));
    }
}