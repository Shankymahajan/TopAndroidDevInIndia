package shashankmahajan.javadevelopersindia;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import java.util.List;

import shashankmahajan.javadevelopersindia.controller.DetailActivity;
import shashankmahajan.javadevelopersindia.model.Item;

/**
 * Created by shashankmahajan on 27/03/17.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<Item> items;
    private Context context;

    public ItemAdapter(Context applicationContext, List<Item> itemArrayList) {
        this.context = applicationContext;
        this.items = itemArrayList;

    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_user, viewGroup, false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder viewHolder, int i) {
        viewHolder.title.setText(items.get(i).getLogin());
        viewHolder.githubLink1.setText(items.get(i).getHtmlUrl());

        Picasso.with(context)
                .load(items.get(i).getAvatarUrl())
                .placeholder(R.mipmap.ic_launcher)
                .into(viewHolder.imageView);
    }


    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, githubLink1;
        private ImageView imageView;


        public ViewHolder(final View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            githubLink1 = (TextView) view.findViewById(R.id.github_link1);
            imageView = (ImageView) view.findViewById(R.id.cover);


            //on item click
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Item clickedDataItem = items.get(position);
                        Intent intent = new Intent(context, DetailActivity.class);
                        intent.putExtra("login ", items.get(position).getLogin());
                        intent.putExtra("html_url", items.get(position).getHtmlUrl());
                        intent.putExtra("avatar_url", items.get(position).getAvatarUrl());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        Toast.makeText(view.getContext(), "You clicked " + clickedDataItem.getLogin(),
                                Toast.LENGTH_SHORT).show();
                    }
                }

            });

        }

    }
}
