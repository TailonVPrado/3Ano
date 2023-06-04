package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.trabalhobimestral2bi.R;

import java.util.ArrayList;

public class MediaAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> lista;

    public MediaAdapter(Context context, ArrayList<String> lista) {
        this.context = context;
        this.lista = lista;
    }


    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).
                    inflate(R.layout.activity_item_media,
                            viewGroup, false);
        }

        String media = lista.get(i);
        TextView tvMedia = view.findViewById(R.id.tvMedia);

        tvMedia.setText(media);

        return view;
    }

}
