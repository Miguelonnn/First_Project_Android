package com.example.mikel.miprimeraaplicacion;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class CustomListAdapter  extends BaseAdapter {

    private List<Car> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter(Context aContext,  List<Car> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_list, null);
            holder = new ViewHolder();
            holder.cocheView = (ImageView) convertView.findViewById(R.id.foto_coche);
            holder.nomCoche = (TextView) convertView.findViewById(R.id.text_coche);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Car coche = this.listData.get(position);
        holder.cocheView = (ImageView) convertView.findViewById(R.id.foto_coche);
        holder.nomCoche.setText(coche.getNom_coche());

        int imageId = this.getMipmapResIdByName(coche.getFoto_coche());

        holder.cocheView.setImageResource(imageId);

        return convertView;
    }

    // Busquem ID que corresponga amb el nom de la image  (en el directory mipmap).
    public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();
        // Retorna 0 si no ho troba
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }

    static class ViewHolder {
        ImageView cocheView;
        TextView nomCoche;

    }

}