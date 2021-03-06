package capizzidev.projectuno;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.MotionEvent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FlowChart extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    int contatore=0;
    int altezza=0;
    int windowwidth;
    int windowheight;
    String code="//Created with Electruino by CapizziDev";

    TextView tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_chart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Cancello...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                ;
            }
        });


        FloatingActionButton frb = (FloatingActionButton) findViewById(R.id.frb);
        frb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Arduino...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent Arduinoo=new Intent(FlowChart.this, Arduino.class) ;
                startActivity(Arduinoo);
            }
        });




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.flow_chart, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.arduino) {
            Intent arduino=new Intent(FlowChart.this,Arduino.class);
            startActivity(arduino);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        final Intent mRNA=new Intent(FlowChart.this,Arduino.class);
        mRNA.putExtra("tran",code);

        if (id == R.id.If) {
            // Handle the if action
            contatore++;
            final RelativeLayout FC = (RelativeLayout) findViewById(R.id.FC);
            final ImageView componente = new ImageView(FlowChart.this);
            componente.setImageResource(R.drawable.if_else);
            componente.setX(windowheight/2);
            altezza=altezza+200;
            FC.addView(componente);
            componente.setY(altezza);

            AlertDialog.Builder msgbox=new AlertDialog.Builder(this);
            msgbox.setTitle("If Builder");
            msgbox.setMessage("Settare l'if");
            msgbox.setIcon(R.drawable.ifico);
            msgbox.setCancelable(false);
            Context context = FC.getContext();
            LinearLayout layout = new LinearLayout(context);
            layout.setOrientation(LinearLayout.VERTICAL);

            final EditText condizione = new EditText(context);
            condizione.setHint("Condizioni");
            layout.addView(condizione);
            final EditText input = new EditText(context);
            input.setHint("Vero");
            layout.addView(input);
            final EditText El = new EditText(context);
            El.setHint("Falso");
            layout.addView(El);


            msgbox.setView(layout);


            msgbox.setPositiveButton("Crea", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                 code = code + "\n if("+condizione.getText().toString()+") {\n"+input.getText().toString()+
                         "}\n"+"else{\n"+ El.getText().toString() +"\n}";
                 mRNA.putExtra("tran",code);

                 }
            });
            msgbox.setNegativeButton("Annulla", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            AlertDialog alert=msgbox.create();
            alert.show();

        } else if (id == R.id.For) {

        } else if (id == R.id.While) {

        } else if (id == R.id.Dow) {

        } else if (id == R.id.or) {

        } else if (id == R.id.xor) {

        }
        else if (id == R.id.and) {

        } else if (id == R.id.not) {

        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
