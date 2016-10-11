package fr.anclient;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DeputyAdapter extends RecyclerView.Adapter<DeputyAdapter.ViewHolder> {
    private List<Deputy> deputies = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_deputy, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        Deputy deputy = deputies.get(position);
        holder.nameView.setText(context.getString(R.string.deputy_name, deputy.firstName, deputy.lastName));
    }

    @Override
    public int getItemCount() {
        return deputies.size();
    }

    public void setDeputies(List<Deputy> deputies) {
        this.deputies = deputies;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameView;

        ViewHolder(View itemView) {
            super(itemView);
            nameView = (TextView) itemView.findViewById(R.id.name);
        }
    }
}
