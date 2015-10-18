package dam.pmdm.parametres;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class subActivity extends Activity {
    String nom;  //per guardar les dades rebudes de l'Activity principal
    String sexe;  //per guardar les dades rebudes de l'Activity principal
    String carnet; //per guardar les dades rebudes del switch de l'Activity principal
    String valora; //per guardar les dades rebudes del ratingbar de l'Activity principal
    String punts;//per guardar les dades rebudes del seekbar de l'Activity principal
    String missatge;//per guardar les dades rebudes de l'Activity principal

    TextView tv_benvinguda, tVValor,tVNumValor,tVPunt, tVNumPunt, tVCarnet, tVCoch;
    Button acabar;
    EditText edat;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        //Enllacem el TextView de l'XML (activity_sub.xml) amb un Objecte TextView de Java
        tv_benvinguda = (TextView) findViewById(R.id.tv_benvinguda);
        // Enllacem el botó acabar de l'XML amb un objecte Botó de Java
        acabar = (Button) findViewById(R.id.b_acabar);
        //Enllacem el EditText de l'xml amb un objecte EditText de Java
        edat = (EditText) findViewById(R.id.etedat);

        //Enllacem els TextView de l'xml amb objectes TextView de Java
        tVValor = (TextView) findViewById(R.id.tVValor);
        tVPunt = (TextView) findViewById(R.id.tVPunt);
        tVNumValor = (TextView) findViewById(R.id.tVNumvalor);
        tVNumPunt = (TextView) findViewById(R.id.tVNumPunt);
        tVCarnet = (TextView) findViewById(R.id.tVCarnet);
        tVCoch = (TextView) findViewById(R.id.tVCoch);


        // Recollim els paràmatres que venen de l'Activity principal (si en ve algun)
        Bundle b = getIntent().getExtras();
        if (b!=null){
            nom = b.getString("Nom");

            carnet = b.getString("Carnet");
            tVCoch.setText(carnet.toString());

            punts = b.getString("Puntos");
            tVNumPunt.setText(punts.toString());

            valora=b.getString("Valoración");
            tVNumValor.setText(valora.toString());

            sexe = b.getString("Sexe");
            if(sexe.compareTo("Mascle")==0){
                missatge="Hola en "+nom+", indica'ns les següents dades:";
            }else{
                missatge="Hola na "+nom+", indica'ns les següents dades:";
            }
            tv_benvinguda.setText(missatge.toString());
        }else{
            tv_benvinguda.setText("Lamentablement no he rebut dades!!");
        }

        // Li afegim un Listener al botó acabar
        acabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edat.getText().length()<=0){
                    Toast.makeText(getApplicationContext(),"Has d'omplir el camp edat!!",Toast.LENGTH_LONG).show();
                }else{  //tot esta correcte
                    Intent i = getIntent();
                    i.putExtra("Edat",Integer.parseInt(edat.getText().toString()));  // Afegim un paràmetre més al bundle
                    setResult(RESULT_OK, i);  //Establim El resultat del subActivity, coma a que ha anat tot be
                    finish();   // Indiquem que es deu tancar el subActivity
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sub, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
