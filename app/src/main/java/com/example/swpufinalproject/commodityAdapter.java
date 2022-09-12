package com.example.swpufinalproject;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.List;

public class commodityAdapter extends RecyclerView.Adapter<commodityAdapter.ViewHolder>{

    List<CommodityHelper> commodity;
    Context context;
    MyHelper2 myHelper2;

    public commodityAdapter(List<CommodityHelper> commodity , Context context) {
        this.commodity = commodity;
        this.context = context;
        myHelper2 = new MyHelper2(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.commodity_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final CommodityHelper commodityHelper = commodity.get(position);

        holder.textViewID.setText("cID:"+Integer.toString(commodityHelper.getId()));
        holder.editText_Name.setText(commodityHelper.getName());
        holder.editText_Price.setText("$"+commodityHelper.getPrice());
        holder.editText_Location.setText(commodityHelper.getLocation());

        holder.button_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringName = holder.editText_Name.getText().toString();
                String stringPrice = holder.editText_Price.getText().toString();
                String stringLocation=holder.editText_Location.getText().toString();

                myHelper2.updateCommodity(new CommodityHelper(commodityHelper.getId(), stringName, stringPrice, stringLocation));
                notifyDataSetChanged();
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());
            }
        });

        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myHelper2.deleteCommodity(CommodityHelper.getId());
                commodity.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return commodity.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewID;
        EditText editText_Name;
        EditText editText_Price;
        EditText editText_Location;
        Button button_Edit;
        Button button_delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewID = itemView.findViewById(R.id.text_id);
            editText_Name = itemView.findViewById(R.id.edittext_name);
            editText_Price = itemView.findViewById(R.id.edittext_price);
            editText_Location=itemView.findViewById(R.id.edittext_location);
            button_delete = itemView.findViewById(R.id.button_delete);
            button_Edit = itemView.findViewById(R.id.button_edit);

        }
    }
}
