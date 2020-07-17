package com.example.vitapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class ViewPageFragmentAdapter extends RecyclerView.Adapter<ViewPageFragmentAdapter.onboardingViewholder>{
    List<sliderclass> sliderclasses1;

    public ViewPageFragmentAdapter(List<sliderclass> sliderclasses1) {
        this.sliderclasses1 = sliderclasses1;
    }

    @NonNull
    @Override
    public onboardingViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new onboardingViewholder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.slideritems,parent,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull onboardingViewholder holder, int position) {
      holder.setonboarding(sliderclasses1.get(position));
    }

    @Override
    public int getItemCount() {
        return sliderclasses1.size();
    }

    class onboardingViewholder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView decrip;
        private ImageView image;

        public onboardingViewholder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            decrip=itemView.findViewById(R.id.descrip);
            image=itemView.findViewById(R.id.imageView);

        }
       void setonboarding(sliderclass sliderclass){
            title.setText(sliderclass.getTitle());
            decrip.setText(sliderclass.getDescription());
            image.setImageResource(sliderclass.getImage());
       }
    }
}

