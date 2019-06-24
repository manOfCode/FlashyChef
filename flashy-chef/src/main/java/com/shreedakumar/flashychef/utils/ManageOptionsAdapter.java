package com.shreedakumar.flashychef.utils;


import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.shreedakumar.flashychef.R;

import java.util.ArrayList;
import java.util.List;

public class ManageOptionsAdapter extends RecyclerView.Adapter<ManageOptionsAdapter.OptionViewHolder> {

    private List<String> options = new ArrayList<String>();

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class OptionViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;
        public OptionViewHolder(TextView v) {
            super(v);
            textView = (TextView) v.findViewById(R.id.option_name);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ManageOptionsAdapter(List<String> options) {
        //this.options = options;
        this.options.addAll(options);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public OptionViewHolder onCreateViewHolder(ViewGroup viewGroup,
                                               int viewType) {
        // ***** Review this ***** create a new view
        // https://medium.com/@relferreira/goodbye-listview-recyclerview-f83dc1133850
        TextView v = (TextView) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.options_list, viewGroup, false);
        OptionViewHolder vh = new OptionViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(OptionViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.setText(options.get(position));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return options.size();
    }
}