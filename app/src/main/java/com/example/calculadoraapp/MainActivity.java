package com.example.calculadoraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tv_expressao;

    Button btn_9;
    Button btn_8;
    Button btn_7;
    Button btn_6;
    Button btn_5;
    Button btn_4;
    Button btn_3;
    Button btn_2;
    Button btn_1;
    Button btn_0;
    Button btnPoint;

    Button btn_divisao;
    Button btn_multiplicacao;
    Button btn_subtracao;
    Button btn_adicao;

    Button btn_clear;
    Button btn_calculo;

    ImageButton ibBackspace;

    ArrayList <Double> numbers = new ArrayList<Double>();
    ArrayList <Character> operators = new ArrayList<Character>();

    String lastDigit = "";

    //char operator;

    Calcs calcs = new Calcs();

    double resultado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        setRequestedOrientation(1);

        carregarComponentes();

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateDigit('9');
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateDigit('8');
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateDigit('7');
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateDigit('6');
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateDigit('5');
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateDigit('4');
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateDigit('3');
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateDigit('2');
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateDigit('1');
            }
        });

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateDigit('0');
            }
        });

        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateDigit('.');
            }
        });

        btn_divisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateDigit('÷');
            }
        });

        btn_multiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateDigit('×');
            }
        });

        btn_subtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateDigit('-');
            }
        });

        btn_adicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateDigit('+');
            }
        });

        btn_calculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_expressao.setText("");
                resultado = 0;
                numbers.clear();
                operators.clear();
            }
        });

        ibBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = tv_expressao.getText().toString();
                if (text.length() > 0) tv_expressao.setText(text.substring(0, text.length() - 1));
            }
        });

    }

    public void carregarComponentes() {

        tv_expressao = (TextView) findViewById(R.id.tv_expressao);

        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_0 = (Button) findViewById(R.id.btn_0);

        btn_divisao = (Button) findViewById(R.id.btn_divisao);
        btn_multiplicacao = (Button) findViewById(R.id.btn_multiplicacao);
        btn_subtracao = (Button) findViewById(R.id.btn_subtracao);
        btn_adicao = (Button) findViewById(R.id.btn_adicao);
        btnPoint = (Button) findViewById(R.id.btnPoint);

        btn_calculo = (Button) findViewById(R.id.btn_calcular);
        btn_clear = (Button) findViewById(R.id.btn_clear);

        ibBackspace = (ImageButton) findViewById(R.id.ibBackspace);

    }

    public void validateDigit(char digit) {

        if (
                (digit != '+') &&
                (digit != '-') &&
                (digit != '×') &&
                (digit != '÷')
        ) {

            lastDigit += digit;
            tv_expressao.setText(tv_expressao.getText().toString() + digit);
            
        } else {

                if(lastDigit!="") {
                    numbers.add(Double.parseDouble(lastDigit));
                    lastDigit = "";
                }

                validateOperator(digit);

                //System.out.println(numbers.toString());



        }
    }

    public void validateOperator(char operator) {

        char last_char;

        if (tv_expressao.getText().toString() != "") {

            last_char = tv_expressao.getText().toString().charAt(tv_expressao.getText().toString().length()-1);

            if (
                    (last_char != '+') &&
                    (last_char != '-') &&
                    (last_char != '×') &&
                    (last_char != '÷')
            ) {

                tv_expressao.setText(tv_expressao.getText().toString() + operator);

                operators.add(operator);

                //System.out.println(operators.toString());

            }

        }

    }

    public void calcular() {

        if(tv_expressao.getText().toString().length() > 1) {
            numbers.add(Double.parseDouble(lastDigit));
            lastDigit = "";

            System.out.println(numbers.toString());
            System.out.println(operators.toString());

            char last_char = tv_expressao.getText().toString().charAt(tv_expressao.getText().toString().length() - 1);

            if (
                    (last_char == '+') ||
                            (last_char == '-') ||
                            (last_char == '×') ||
                            (last_char == '÷')
            ) {
                return;
            } else {
                while (operators.size() > 0) {
                    for (int i = 0; i < operators.size(); i++) {

                        double agregado = 0;

                        switch (operators.get(i)) {
                            case '×':
                                agregado += calcs.multiplication(numbers.get(i), numbers.get(i + 1));
                                break;
                            case '÷':
                                agregado += calcs.division(numbers.get(i), numbers.get(i + 1));
                                break;
                            default:
                                continue;
                        }

                        numbers.set(i, agregado);
                        numbers.remove(i + 1);
                        operators.remove(i);

                        System.out.println(numbers.toString());
                        System.out.println(operators.toString());

                    }

                    for (int i = 0; i < operators.size(); i++) {

                        double agregado = 0;

                        switch (operators.get(i)) {
                            case '+':
                                agregado += calcs.addition(numbers.get(i), numbers.get(i + 1));
                                break;
                            case '-':
                                agregado += calcs.subtraction(numbers.get(i), numbers.get(i + 1));
                                break;
                            default:
                                continue;
                        }

                        numbers.set(i, agregado);
                        numbers.remove(i + 1);
                        operators.remove(i);

                        System.out.println(numbers.toString());
                        System.out.println(operators.toString());

                    }

                }

                tv_expressao.setText(Double.toString(numbers.get(0)));

            }
        }
    }
}