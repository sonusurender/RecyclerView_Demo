package com.erecyclerview_demo.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.erecyclerview_demo.R;

public class ListView_Holder extends RecyclerView.ViewHolder implements
		OnClickListener {
	// View holder for list recycler view as we used in listview
	public TextView list_title, list_location, list_date;
	public ImageView list_imageView, list_delete;
	public RelativeLayout listLayout;

	private RecyclerView_OnClickListener.OnClickListener onClickListener;

	public ListView_Holder(View view) {
		super(view);

		// Find all views ids
		this.list_title = (TextView) view.findViewById(R.id.list_title);
		this.list_location = (TextView) view.findViewById(R.id.list_location);
		this.list_date = (TextView) view
				.findViewById(R.id.list_dateconstructed);
		this.list_imageView = (ImageView) view
				.findViewById(R.id.list_imageview);
		this.list_delete = (ImageView) view.findViewById(R.id.list_delete);
		this.listLayout = (RelativeLayout) view.findViewById(R.id.list_layout);

		// Implement click listener over views that we need
		this.list_delete.setOnClickListener(this);
		this.listLayout.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		// setting custom listener
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