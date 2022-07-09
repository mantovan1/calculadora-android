package com.example.calculadoraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvExpressao;

    Button btn9;
    Button btn8;
    Button btn7;
    Button btn6;
    Button btn5;
    Button btn4;
    Button btn3;
    Button btn2;
    Button btn1;
    Button btn0;
    Button btnPonto;

    Button btnDivisao;
    Button btnMultiplicacao;
    Button btnSubtracao;
    Button btnAdicao;

    Button btnPotencia;

    Button btnLimpar;
    Button btnCalcular;

    Button btnDeletar;

    ArrayList <Double> numeros = new ArrayList<Double>();
    ArrayList <Character> operadores = new ArrayList<Character>();

    String ultimoDigito = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        carregarComponentes();

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarDigito('9');
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarDigito('8');
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarDigito('7');
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarDigito('6');
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarDigito('5');
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarDigito('4');
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarDigito('3');
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarDigito('2');
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarDigito('1');
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarDigito('0');
            }
        });

        btnPonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarDigito('.');
            }
        });

        btnPotencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarDigito('^');
            }
        });

        btnDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarDigito('÷');
            }
        });

        btnMultiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarDigito('×');
            }
        });

        btnSubtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarDigito('-');
            }
        });

        btnAdicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarDigito('+');
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tvExpressao.setText("");
                ultimoDigito = "";
                
                numeros.clear();
                operadores.clear();
            }
        });

        btnDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ainda irei implementar
            }
        });

    }

    public void carregarComponentes() {

        tvExpressao = (TextView) findViewById(R.id.tvExpressao);

        btn9 = (Button) findViewById(R.id.btn9);
        btn8 = (Button) findViewById(R.id.btn8);
        btn7 = (Button) findViewById(R.id.btn7);
        btn6 = (Button) findViewById(R.id.btn6);
        btn5 = (Button) findViewById(R.id.btn5);
        btn4 = (Button) findViewById(R.id.btn4);
        btn3 = (Button) findViewById(R.id.btn3);
        btn2 = (Button) findViewById(R.id.btn2);
        btn1 = (Button) findViewById(R.id.btn1);
        btn0 = (Button) findViewById(R.id.btn0);

        btnDivisao = (Button) findViewById(R.id.btnDivisao);
        btnMultiplicacao = (Button) findViewById(R.id.btnMultiplicacao);
        btnSubtracao = (Button) findViewById(R.id.btnSubtracao);
        btnAdicao = (Button) findViewById(R.id.btnAdicao);

        btnPotencia = (Button) findViewById(R.id.btnPotencia);

        btnPonto = (Button) findViewById(R.id.btnPonto);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);

        btnDeletar = (Button) findViewById(R.id.btnDeletar);

    }

    public void validarDigito(char digito) {

        char ultimoCaractere = ' ';

        try {
            ultimoCaractere = tvExpressao.getText().toString().charAt(tvExpressao.getText().toString().length()-1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (
                (digito != '+') &&
                (digito != '-') &&
                (digito != '×') &&
                (digito != '÷') &&
                (digito != '^')
        ) {

            ultimoDigito += digito;
            tvExpressao.setText(tvExpressao.getText().toString() + digito);
            
        } else if (ultimoDigito == "" && digito == '-'){

            if(ultimoCaractere != '-') {
                ultimoDigito += digito;
                tvExpressao.setText(tvExpressao.getText().toString() + digito);
            } else {
                return;
            }

        } else if (ultimoCaractere == '-' && digito == '+') {

            String text = tvExpressao.getText().toString();

            tvExpressao.setText(text.substring(0, text.length()-1));

            operadores.remove(operadores.size()-1);
            operadores.add('+');

            tvExpressao.setText(tvExpressao.getText().toString() + '+');

        } else if (ultimoDigito != ""){

            if(ultimoCaractere != '-') {

                numeros.add(Double.parseDouble(ultimoDigito));
                ultimoDigito = "";

                validarOperador(digito);

            } else {
                return;
            }

        }
    }

    public void validarOperador(char operador) {

        char ultimoCaractere;

        if (tvExpressao.getText().toString() != "") {

            ultimoCaractere = tvExpressao.getText().toString().charAt(tvExpressao.getText().toString().length()-1);

            if (
                    (ultimoCaractere != '+') &&
                    (ultimoCaractere != '-') &&
                    (ultimoCaractere != '×') &&
                    (ultimoCaractere != '÷') &&
                    (ultimoCaractere != '^')
            ) {

                tvExpressao.setText(tvExpressao.getText().toString() + operador);

                operadores.add(operador);

            }

        }

    }

    public void calcular() {

        if(tvExpressao.getText().toString().length() > 1) {
            numeros.add(Double.parseDouble(ultimoDigito));
            ultimoDigito = "";

            char ultimoCaractere = tvExpressao.getText().toString().charAt(tvExpressao.getText().toString().length() - 1);

            if (
                    (ultimoCaractere == '+') ||
                            (ultimoCaractere == '-') ||
                            (ultimoCaractere == '×') ||
                            (ultimoCaractere == '÷') ||
                            (ultimoCaractere == '^')
            ) {
                return;
            } else {
                while (operadores.size() > 0) {

                    for (int i = 0; i < operadores.size(); i++) {

                        double agregado = 0;

                        switch (operadores.get(i)) {
                            case '^':
                                agregado += Math.pow(numeros.get(i), numeros.get(i + 1));
                                break;
                            default:
                                continue;
                        }

                        numeros.set(i, agregado);
                        numeros.remove(i + 1);
                        operadores.remove(i);

                        i = 0;

                    }

                    for (int i = 0; i < operadores.size(); i++) {

                        double agregado = 0;

                        switch (operadores.get(i)) {
                            case '×':
                                agregado += numeros.get(i) * numeros.get(i + 1);
                                break;
                            case '÷':
                                agregado += numeros.get(i) / numeros.get(i + 1);
                                break;
                            default:
                                continue;
                        }

                        numeros.set(i, agregado);
                        numeros.remove(i + 1);
                        operadores.remove(i);

                        i = 0;

                    }

                    for (int i = 0; i < operadores.size(); i++) {

                        double agregado = 0;

                        switch (operadores.get(i)) {
                            case '+':
                                agregado += numeros.get(i) + numeros.get(i + 1);
                                break;
                            case '-':
                                agregado += numeros.get(i) - numeros.get(i + 1);
                                break;
                            default:
                                continue;
                        }

                        numeros.set(i, agregado);
                        numeros.remove(i + 1);
                        operadores.remove(i);

                        i = 0;

                    }

                }

                ultimoDigito = numeros.get(0).toString();
                tvExpressao.setText(Double.toString(numeros.get(0)));

                operadores.clear();
                numeros.clear();

            }
        }
    }
}