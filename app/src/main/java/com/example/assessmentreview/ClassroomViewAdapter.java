package com.example.assessmentreview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ClassroomViewAdapter extends RecyclerView.Adapter<ClassroomViewAdapter.ViewHolder>{

    private static final String TAG = "ClassroomViewAdapter";
    private ArrayList<String> mClassrooms;
    private Context mContext;

    public ClassroomViewAdapter(ArrayList<String> mClassrooms, Context mContext) {
        Log.d(TAG, "ClassroomViewAdapter: data size: "+mClassrooms.size());
        this.mClassrooms = mClassrooms;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.classroom_view, parent, false);
        ViewHolder viewHolder =  new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");
        int posn = position;
        holder.txtClassroomName.setText(mClassrooms.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on "+ mClassrooms.get(posn));
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: data size: "+mClassrooms.size());
        return mClassrooms.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{

        TextView txtClassroomName;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtClassroomName = itemView.findViewById(R.id.txtClassroomName);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }
}
