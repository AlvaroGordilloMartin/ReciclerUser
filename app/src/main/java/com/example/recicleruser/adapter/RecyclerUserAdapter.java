package com.example.recicleruser.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recicleruser.R;
import com.example.recicleruser.model.User;

import java.util.List;

public class RecyclerUserAdapter extends RecyclerView.Adapter<RecyclerUserAdapter.UserHolder> {

    private List<User> list;

    public RecyclerUserAdapter(Context context, List<User> list) {
        this.list = list;
    }

    /**
     * Este metodo crea tantos objetos UserHolder como elementos existan en el origen de datos.
     * Para ello infla los elementos desde el XML que defina cada item
     *
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        holder.tvName.setText(list.get(position).getName());
        holder.tvEmail.setText(list.get(position).getEmail());
    }

    //OBLIGATORIO implementar, si devuelve 0 NO dibuja ningun elemento
    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     * Se encarga de almacenar los items del recyclerView y son los elementos que se reciclan cuando se realiza un scroll dentro del recyclerView
     */
    class UserHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvEmail;

        public UserHolder(@NonNull View itemView) {
            super(itemView);
            //Inicializar los elementos en el constructor
            tvName = itemView.findViewById(R.id.tvName);
            tvEmail = itemView.findViewById(R.id.tvEmail);

        }
    }
}
