package com.erecyclerview_demo.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.erecyclerview_demo.R;

public class GridView_Holder extends RecyclerView.ViewHolder implements
		OnClickListener {
	// View holder for gridview recycler view as we used in listview
	public TextView grid_title, grid_location, grid_date;
	public ImageView grid_imageView, grid_delete;
	public RelativeLayout gridLayout;

	private RecyclerView_OnClickListener.OnClickListener onClickListener;

	public GridView_Holder(View view) {
		super(view);
		// Find all views ids
		this.grid_title = (TextView) view.findViewById(R.id.grid_title);
		this.grid_location = (TextView) view.findViewById(R.id.grid_location);
		this.grid_date = (TextView) view
				.findViewById(R.id.grid_dateconstructed);
		this.grid_imageView = (ImageView) view
				.findViewById(R.id.grid_imageview);
		this.grid_delete = (ImageView) view.findViewById(R.id.grid_delete);
		this.gridLayout = (RelativeLayout) view.findViewById(R.id.grid_layout);

		// Implement click listener over views that we want
		this.gridLayout.setOnClickListener(this);
		this.grid_delete.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		// set custom listener
		if (onClickListener != null) {
			onClickListener.OnItemClick(v, getAdapterPosition());

		}

	}

	// Setter for listener
	public void setClickListener(
			RecyclerView_OnClickListener.OnClickListener onClickListener) {
		this.onClickListener = onClickListener;
	}

}