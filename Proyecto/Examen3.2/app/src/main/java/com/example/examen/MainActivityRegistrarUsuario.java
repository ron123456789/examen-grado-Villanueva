package com.example.examen;

import android.content.Intent;
import android.graphics.Color;
import android.provider.Contacts;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.examen.modelo.Usuario;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.wouterhabets.slidingcontentdrawer.widget.SlidingDrawerLayout;
import com.wouterhabets.slidingcontentdrawer.widget.SlidingDrawerToggle;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivityRegistrarUsuario extends AppCompatActivity {

    EditText nomp,correop;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Usuario usuarioSelect;

    private  List<Usuario> listUsuario = new ArrayList<Usuario>();
    ArrayAdapter<Usuario> arrayAdapterUsuario;
    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registrar_usuario);

        nomp=(EditText)findViewById(R.id.nombre);
Button agregar=(Button)findViewById(R.id.nuevo);
        correop=(EditText)findViewById(R.id.Correo);
        lista=(ListView)findViewById(R.id.lista);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.parseColor( "#1a237a"));
        inicializarfirebase();
        listaDatos();

        SlidingDrawerLayout drawer = (SlidingDrawerLayout) findViewById(R.id.drawer_layout1);
        SlidingDrawerToggle toggle = new SlidingDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        Button as=(Button)findViewById(R.id.button1);
        as.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d=new Intent(MainActivityRegistrarUsuario.this,MainActivity.class);
                startActivity(d);
            }
        });

        Button asi=(Button)findViewById(R.id.button2);
        asi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d=new Intent(MainActivityRegistrarUsuario.this,MainActivityRegistrarUsuario.class);
                startActivity(d);
            }
        });


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                usuarioSelect =(Usuario)parent.getItemAtPosition(position);
                nomp.setText(usuarioSelect.getNombre());
                correop.setText(usuarioSelect.getCorreo());

            }
        });
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregar();
            }
        });
    }

    private void listaDatos() {

        databaseReference.child("Persona").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listUsuario.clear();
                for(DataSnapshot objSnaptshot : dataSnapshot.getChildren()){

                    Usuario u= objSnaptshot.getValue(Usuario.class);
                    listUsuario.add(u);
                    arrayAdapterUsuario = new ArrayAdapter<Usuario>(MainActivityRegistrarUsuario.this,
                            android.R.layout.simple_list_item_1,listUsuario);
                    lista.setAdapter(arrayAdapterUsuario);

                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

    private void inicializarfirebase() {

        FirebaseApp.initializeApp(this);
        firebaseDatabase= FirebaseDatabase.getInstance();
//        firebaseDatabase.setPersistenceEnabled(true);
        databaseReference=firebaseDatabase.getReference();
    }

    public void agregar() {

        String nombre = nomp.getText().toString();

        String correo = correop.getText().toString();

        if (nombre.equals("") || correo.equals("")) {
            validacion();

        } else {

            Usuario u = new Usuario();
            u.setUid(UUID.randomUUID().toString());
            u.setNombre(nombre);
            u.setCorreo(correo);
            databaseReference.child("Persona").child(u.getUid()).setValue(u);

            Toast.makeText(this, "AGREGAR", Toast.LENGTH_SHORT).show();
            limpiar();
        }
    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String nombre =nomp.getText().toString();

        String correo =correop.getText().toString();


        switch (item.getItemId()){

            case R.id.icon_add:{
                    if(nombre.equals("") ||correo.equals("")){
                        validacion();

                    }else {

                        Usuario u= new Usuario();
                        u.setUid(UUID.randomUUID().toString());
                        u.setNombre(nombre);
                        u.setCorreo(correo);
                        databaseReference.child("Persona").child(u.getUid()).setValue(u);

                        Toast.makeText(this, "AGREGAR", Toast.LENGTH_SHORT).show();
                        limpiar();

                    }
                break;
            }
            case R.id.editar:{
                Toast.makeText(this, "editar", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.eliminar:{
                Usuario u= new Usuario();
                u.setUid(usuarioSelect.getUid());
                databaseReference.child("Persona").child(u.getUid()).removeValue();
                Toast.makeText(this, "eliminar", Toast.LENGTH_SHORT).show();
                limpiar();
                break;
            }
            default:
        }

        return true;
    }
*/
    private void limpiar() {

        nomp.setText("");

        correop.setText("");
    }

    private void validacion() {

        String nombres =nomp.getText().toString();

        String correos =correop.getText().toString();


        if (nombres.equals("")){
            nomp.setError("Required");
        }

        else if(correos.equals("")){
            correop .setError("Required");
        }

    }
}

