package com.erecyclerview_demo;

import java.util.ArrayList;
import java.util.Random;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;

import com.erecyclerview_demo.adapter.ListView_Recycler_Adapter;

public class LinearLayout_Fragment extends Fragment {
	private static View view;
	private static RecyclerView listRecyclerView;
	private static ArrayList<Data_Model> listArrayList;
	private static ListView_Recycler_Adapter adapter;

	// Images array for images
	private static final int[] images = { R.drawable.tajmahal,
			R.drawable.hawamahal, R.drawable.golden, R.drawable.shore,
			R.drawable.shivaji, R.drawable.lotus, R.drawable.victoria,
			R.drawable.brihadishwara, R.drawable.mahabodhi };

	// String array for title, location, year
	String[] getTitle, getLocation, getYear;

	public LinearLayout_Fragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.linearlayout_fragment, container,
				false);
		init();
		populatRecyclerView();
		setHasOptionsMenu(true);// this method used to set option menu on
								// fragment
		return view;
	}

	// Initialize the view
	private void init() {

		// Getting the string array from strings.xml
		getTitle = getActivity().getResources().getStringArray(R.array.title);
		getLocation = getActivity().getResources().getStringArray(
				R.array.location);
		getYear = getActivity().getResources().getStringArray(
				R.array.constructed_year);
		listArrayList = new ArrayList<Data_Model>();

		listRecyclerView = (RecyclerView) view
				.findViewById(R.id.linear_recyclerview);
		listRecyclerView.setHasFixedSize(true);
		listRecyclerView
				.setLayoutManager(new LinearLayoutManager(getActivity()));// for
																			// linear
																			// data
																			// display
																			// we
																			// use
																			// linear
																			// layoutmanager

	}

	// populate the list view by adding data to arraylist
	private void populatRecyclerView() {

		for (int i = 0; i < getTitle.length; i++) {
			listArrayList.add(new Data_Model(getTitle[i], getLocation[i],
					getYear[i], images[i]));
		}
		adapter = new ListView_Recycler_Adapter(getActivity(), listArrayList);
		listRecyclerView.setAdapter(adapter);// set adapter on recyclerview
		adapter.notifyDataSetChanged();// Notify the adapter

	}

	// random generator method for generating data in int nos.
	private int RandomGenerator() {
		Random random = new Random();
		int randomNum = random.nextInt(9);

		return randomNum;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		getActivity().getMenuInflater().inflate(R.menu.main, menu);
		MenuItem add = menu.findItem(R.id.add);

		add.setOnMenuItemClickListener(new OnMenuItemClickListener() {

			@Override
			public boolean onMenuItemClick(MenuItem arg0) {
				int value = RandomGenerator();// get random value from random
												// method

				// add random data to arraylist
				listArrayList.add(new Data_Model(getTitle[value],
						getLocation[value], getYear[value], images[value]));
				adapter.notifyDataSetChanged();// finally notify adapter
				return false;
			}
		});

		super.onCreateOptionsMenu(menu, inflater);
	}
}
