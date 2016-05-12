package capizzidev.projectuno;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    int contatore=0;

    int windowwidth;
    int windowheight;

    private LayoutParams layoutParams ;
    



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Cancello...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FloatingActionButton frb = (FloatingActionButton) findViewById(R.id.frb);
        frb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Flow-Chart...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent flowchart=new Intent(MainActivity.this, FlowChart.class) ;
                startActivity(flowchart);
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.flowchart) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override

    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.drive) {

        } else if (id == R.id.led) { contatore++;
            final RelativeLayout grafica=(RelativeLayout) findViewById(R.id.grafica);
            final ImageView componente=new ImageView(MainActivity.this);
            componente.setImageResource(R.drawable.ledd);
            grafica.addView(componente);


            windowwidth = getWindowManager().getDefaultDisplay().getWidth();
            windowheight = getWindowManager().getDefaultDisplay().getHeight();
            componente.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    LayoutParams layoutParams = (LayoutParams) componente.getLayoutParams();
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            break;
                        case MotionEvent.ACTION_MOVE:
                            int x_cord = (int) event.getRawX();
                            int y_cord = (int) event.getRawY();

                            if (x_cord > windowwidth) {
                                x_cord = windowwidth;
                            }
                            if (y_cord > windowheight) {
                                y_cord = windowheight;
                            }

                            layoutParams.leftMargin = x_cord - 25;
                            layoutParams.topMargin = y_cord - 25;

                            componente.setLayoutParams(layoutParams);
                            break;
                        default:
                            break;
                    }
                    return true;
                }
            });
            final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Cancello...", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    componente.setAlpha(00);

                }
            });
            TextView tinfo=(TextView) findViewById(R.id.tinfo);
            tinfo.setText("Led");
            TextView info=(TextView) findViewById(R.id.info);
            info.setText("Diodo a semiconduttore che  al passaggio \n di corrente elettrica emette luce");



        } else if (id == R.id.ldr) { contatore++;
            final RelativeLayout grafica=(RelativeLayout) findViewById(R.id.grafica);
            final ImageView componente=new ImageView(MainActivity.this);
            componente.setImageResource(R.drawable.ldr);
            grafica.addView(componente);

            windowwidth = getWindowManager().getDefaultDisplay().getWidth();
            windowheight = getWindowManager().getDefaultDisplay().getHeight();
            componente.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    LayoutParams layoutParams = (LayoutParams) componente.getLayoutParams();
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            break;
                        case MotionEvent.ACTION_MOVE:
                            int x_cord = (int) event.getRawX();
                            int y_cord = (int) event.getRawY();

                            if (x_cord > windowwidth) {
                                x_cord = windowwidth;
                            }
                            if (y_cord > windowheight) {
                                y_cord = windowheight;
                            }

                            layoutParams.leftMargin = x_cord - 25;
                            layoutParams.topMargin = y_cord - 75;

                            componente.setLayoutParams(layoutParams);
                            break;
                        default:
                            break;
                    }
                    return true;
                }
            });
            final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Cancello...", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    componente.setAlpha(00);

                }
            });





        }
        else if (id == R.id.microfono) {contatore++;
            final RelativeLayout grafica=(RelativeLayout) findViewById(R.id.grafica);
            final ImageView componente=new ImageView(MainActivity.this);
            componente.setImageResource(R.drawable.microfonoo);
            grafica.addView(componente);
            windowwidth = getWindowManager().getDefaultDisplay().getWidth();
            windowheight = getWindowManager().getDefaultDisplay().getHeight();
            componente.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    LayoutParams layoutParams = (LayoutParams) componente.getLayoutParams();
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            break;
                        case MotionEvent.ACTION_MOVE:
                            int x_cord = (int) event.getRawX();
                            int y_cord = (int) event.getRawY();

                            if (x_cord > windowwidth) {
                                x_cord = windowwidth;
                            }
                            if (y_cord > windowheight) {
                                y_cord = windowheight;
                            }

                            layoutParams.leftMargin = x_cord - 25;
                            layoutParams.topMargin = y_cord - 75;

                            componente.setLayoutParams(layoutParams);
                            break;
                        default:
                            break;
                    }
                    return true;
                }
            });
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Cancello...", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    componente.setAlpha(00);
                }
            });


        } else if (id == R.id.resistenza) {contatore++;
            final RelativeLayout grafica=(RelativeLayout) findViewById(R.id.grafica);
            final ImageView componente=new ImageView(MainActivity.this);
            componente.setImageResource(R.drawable.ress);
            grafica.addView(componente);
            windowwidth = getWindowManager().getDefaultDisplay().getWidth();
            windowheight = getWindowManager().getDefaultDisplay().getHeight();
            componente.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    LayoutParams layoutParams = (LayoutParams) componente.getLayoutParams();
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            break;
                        case MotionEvent.ACTION_MOVE:
                            int x_cord = (int) event.getRawX();
                            int y_cord = (int) event.getRawY();

                            if (x_cord > windowwidth) {
                                x_cord = windowwidth;
                            }
                            if (y_cord > windowheight) {
                                y_cord = windowheight;
                            }

                            layoutParams.leftMargin = x_cord - 25;
                            layoutParams.topMargin = y_cord - 75;

                            componente.setLayoutParams(layoutParams);
                            break;
                        default:
                            break;
                    }
                    return true;
                }
            });
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Cancello...", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    componente.setAlpha(00);
                }
            });



        } else if (id == R.id.ceramica) {contatore++;
            final RelativeLayout grafica=(RelativeLayout) findViewById(R.id.grafica);
            final ImageView componente=new ImageView(MainActivity.this);
            componente.setImageResource(R.drawable.ceramicaa);
            grafica.addView(componente);
            windowwidth = getWindowManager().getDefaultDisplay().getWidth();
            windowheight = getWindowManager().getDefaultDisplay().getHeight();
            componente.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    LayoutParams layoutParams = (LayoutParams) componente.getLayoutParams();
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            break;
                        case MotionEvent.ACTION_MOVE:
                            int x_cord = (int) event.getRawX();
                            int y_cord = (int) event.getRawY();

                            if (x_cord > windowwidth) {
                                x_cord = windowwidth;
                            }
                            if (y_cord > windowheight) {
                                y_cord = windowheight;
                            }

                            layoutParams.leftMargin = x_cord - 25;
                            layoutParams.topMargin = y_cord - 75;

                            componente.setLayoutParams(layoutParams);
                            break;
                        default:
                            break;
                    }
                    return true;
                }
            });
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Cancello...", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    componente.setAlpha(00);
                }
            });


        } else if (id == R.id.bottone) {contatore++;
            final RelativeLayout grafica=(RelativeLayout) findViewById(R.id.grafica);
            final ImageView componente=new ImageView(MainActivity.this);
            componente.setImageResource(R.drawable.pulsantee);
            grafica.addView(componente);
            windowwidth = getWindowManager().getDefaultDisplay().getWidth();
            windowheight = getWindowManager().getDefaultDisplay().getHeight();
            componente.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    LayoutParams layoutParams = (LayoutParams) componente.getLayoutParams();
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            break;
                        case MotionEvent.ACTION_MOVE:
                            int x_cord = (int) event.getRawX();
                            int y_cord = (int) event.getRawY();

                            if (x_cord > windowwidth) {
                                x_cord = windowwidth;
                            }
                            if (y_cord > windowheight) {
                                y_cord = windowheight;
                            }

                            layoutParams.leftMargin = x_cord - 25;
                            layoutParams.topMargin = y_cord - 75;

                            componente.setLayoutParams(layoutParams);
                            break;
                        default:
                            break;
                    }
                    return true;
                }
            });
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Cancello...", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    componente.setAlpha(00);
                }
            });


        } else if (id == R.id.cavo) {contatore++;
            final RelativeLayout grafica=(RelativeLayout) findViewById(R.id.grafica);
            final ImageView componente = new ImageView(MainActivity.this);
            componente.setImageResource(R.drawable.wire);
            grafica.addView(componente);

            windowwidth = getWindowManager().getDefaultDisplay().getWidth();
            windowheight = getWindowManager().getDefaultDisplay().getHeight();
            componente.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    LayoutParams layoutParams = (LayoutParams) componente.getLayoutParams();
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            break;
                        case MotionEvent.ACTION_MOVE:
                            int x_cord = (int) event.getRawX();
                            int y_cord = (int) event.getRawY();

                            if (x_cord > windowwidth) {
                                x_cord = windowwidth;
                            }
                            if (y_cord > windowheight) {
                                y_cord = windowheight;
                            }

                            layoutParams.leftMargin = x_cord - 25;
                            layoutParams.topMargin = y_cord - 75;

                            componente.setLayoutParams(layoutParams);
                            break;
                        default:
                            break;
                    }
                    return true;
                }
            });
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Cancello...", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    componente.setAlpha(00);
                }
            });



        } else if (id == R.id.or) {

        } else if (id == R.id.xor) {

        } else if (id == R.id.and) {

        } else if (id == R.id.not) {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
