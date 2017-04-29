package com.andura.campina.image;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andura.campina.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by amaro on 29/04/17.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private Context context;
    private List<Image> mImage;

    public ImageAdapter(Context ctx){
        context = ctx;
    }

    public ImageAdapter(Context ctx, List<Image> itens){
        context = ctx;
        mImage = itens;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final Image obj = mImage.get(position);

        holder.title.setText( obj.getTitle() );
        holder.count.setText( "45%" );
        holder.data = obj;

        Picasso
                .with(context)
                .load(obj.getUrl())
                .placeholder(R.drawable.progress_animation)
                .error(android.R.drawable.stat_notify_error)
                .fit() // will explain later
                .into(holder.thumbnail);


    }

    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.image_list_item,parent,false);

        ViewHolder holder = new ViewHolder(v);
        v.setTag(holder);

        return holder;
    }

    public Image getItemAtPosition(int position) {
        return mImage.get(position);
    }

    @Override
    public int getItemCount() {
        return mImage != null ? mImage.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView title;
        TextView count;
        ImageView thumbnail;
        Image data;

        public ViewHolder(View parent){
            super(parent);
            title = (TextView) parent.findViewById(R.id.title);
            count = (TextView) parent.findViewById(R.id.count);
            thumbnail = (ImageView) parent.findViewById(R.id.thumbnail);

            parent.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {



        }

    }
}