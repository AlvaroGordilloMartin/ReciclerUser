package com.example.recicleruser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recicleruser.adapter.RecyclerUserAdapter;
import com.example.recicleruser.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {

    private RecyclerView rvUsers;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private List<User> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inicializar el origen de datos
        initialice();

        rvUsers = findViewById(R.id.rvUsers);
        //Optimizacion RecyclerView si todos los elementos hijos tienen el mismo tamaño
        rvUsers.setHasFixedSize(true);

        //1. Crear el diseño de los elementos (OBLIGATORIO)
        //1.1. LinearLayoutManager
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);

        //2.Asignar el diseño al recyclerView
        rvUsers.setLayoutManager(layoutManager);

        //3. Se crea el adapter
        adapter = new RecyclerUserAdapter(this,list);

        //4. Asignar el adapter al recyclerView
        rvUsers.setAdapter(adapter);

    }
    private void initialice(){
        list = new ArrayList<>();
        list.add(new User("alvaro","gordillo","alvaro@iesportada.com"));
        list.add(new User("pepito","martin","pepito@iesportada.com"));
        list.add(new User("paca","gomez","paca@iesportada.com"));
        list.add(new User("joze","ole","joze@iesportada.com"));
    }
}