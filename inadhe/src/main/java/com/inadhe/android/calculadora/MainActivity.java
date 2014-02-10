package com.inadhe.android.calculadora;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnKeyListener;
import android.view.KeyEvent;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView display;
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnDividir,
            btnMultiplicar, btnRestar, btnSumar, btnIgual, btnC;

    private int operador = 1;
    // 0 = nada
    // 1 = suma
    // 2 = resta
    // 3 = multiplica
    // 4 = divide
    private int num = 0;
    private boolean readyToClear = false;
    private boolean hasChanged = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

      /*  if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    */

        initCaluladora();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

    /**
     * Inicializa la calculadora
     */
    private void initCaluladora(){

        // relacionando variables - layout
        display = (TextView)findViewById(R.id.display);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);
        btn0 = (Button)findViewById(R.id.btn0);
        btnDividir = (Button)findViewById(R.id.btnDividir);
        btnMultiplicar = (Button)findViewById(R.id.btnMultiplicar);
        btnRestar = (Button)findViewById(R.id.btnRestar);
        btnSumar = (Button)findViewById(R.id.btnSumar);
        btnIgual = (Button)findViewById(R.id.btnIgual);
        btnC = (Button)findViewById(R.id.btnC);

        //activando Botones

        btn0.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                handleNumber(0);
            }
        });
        btn1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                handleNumber(1);
            }

        });
        btn2.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                handleNumber(2);
            }

        });
        btn3.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                handleNumber(3);
            }

        });
        btn4.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                handleNumber(4);
            }

        });
        btn5.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                handleNumber(5);
            }

        });
        btn6.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                handleNumber(6);
            }

        });
        btn7.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                handleNumber(7);
            }

        });
        btn8.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                handleNumber(8);
            }

        });
        btn9.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                handleNumber(9);
            }

        });
        btnSumar.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                handleEquals(1);
            }

        });
        btnRestar.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                handleEquals(2);
            }

        });
        btnMultiplicar.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                handleEquals(3);
            }

        });
        btnDividir.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                handleEquals(4);
            }

        });
        btnIgual.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                handleEquals(0);
            }

        });
        btnC.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                reset();
            }

        });


    }

    /**
     *
     * @param num numero a manejar
     */
    private void handleNumber(int num) {
        if (operador == 0)
            reset();

        String texto = display.getText().toString();
        if (readyToClear) {
            texto = "";
            readyToClear = false;
        } else if (texto.equals("0"))
            texto = "";

        texto = texto + Integer.toString(num);

        display.setText(texto);
      //  display.setSelection(texto.length());

        hasChanged = true;
    }

    /**
     * resetea la Calculadora
     */
    private void reset() {
        num = 0;
        display.setText("0");
       // display.setSelection(1);
        operador = 1;
    }

    /**
     *
     * @param newOperator
     * Manejador de Operadores + - * /
     */
    private void handleEquals(int newOperator) {
        if (hasChanged) {
            switch (operador) {
                case 1:
                    num = num + Integer.parseInt(display.getText().toString());
                    break;
                case 2:
                    num = num - Integer.parseInt(display.getText().toString());
                    break;
                case 3:
                    num = num * Integer.parseInt(display.getText().toString());
                    break;
                case 4:
                    num = num / Integer.parseInt(display.getText().toString());
                    break;
            }

            String txt = Integer.toString(num);
            display.setText(txt);
          //  display.setSelection(txt.length());

            readyToClear = true;
            hasChanged = false;
        }

        operador = newOperator;
    }

}
