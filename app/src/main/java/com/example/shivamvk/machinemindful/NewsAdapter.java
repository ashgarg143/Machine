package com.example.shivamvk.machinemindful;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

    private Context context;
    private List<News> newsList;

    public NewsAdapter(Context context, List<News> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cutomer_item_layout,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        News news = newsList.get(i);

        viewHolder.tvListItem1.setText(news.getTitle());
        viewHolder.tvListItem2.setText(news.getSlug());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvListItem1,tvListItem2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvListItem1 = itemView.findViewById(R.id.tv_list_item_1);
            tvListItem2 = itemView.findViewById(R.id.tv_list_item_2);
        }
    }
}
