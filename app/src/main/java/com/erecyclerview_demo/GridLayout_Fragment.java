package com.erecyclerview_demo;

import java.util.ArrayList;
import java.util.Random;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;

import com.erecyclerview_demo.adapter.GridView_Recycler_Adapter;

public class GridLayout_Fragment extends Fragment {
	private static View view;
	private static RecyclerView gridRecyclerView;
	private static GridView_Recycler_Adapter adapter;
	private static ArrayList<Data_Model> gridArrayList;

	// Images int array from drawable folders
	private static final int[] images = { R.drawable.tajmahal,
			R.drawable.hawamahal, R.drawable.golden, R.drawable.shore,
			R.drawable.shivaji, R.drawable.lotus, R.drawable.victoria,
			R.drawable.brihadishwara, R.drawable.mahabodhi };

	// String array for title, location,year
	String[] getTitle, getLocation, getYear;

	public GridLayout_Fragment() {
		// Empty constructor is neccessary
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.gridlayout_fragment, container, false);
		init();
		populatRecyclerView();
		setHasOptionsMenu(true);// This will set option menu on fragment
		return view;
	}

	// Initialize all variables and views
	private void init() {

		// Get the title , location and year from string.xml in array form
		getTitle = getActivity().getResources().getStringArray(R.array.title);
		getLocation = getActivity().getResources().getStringArray(
				R.array.location);
		getYear = getActivity().getResources().getStringArray(
				R.array.constructed_year);

		gridArrayList = new ArrayList<Data_Model>();

		// Find the id of recycler view
		gridRecyclerView = (RecyclerView) view
				.findViewById(R.id.grid_recyclerview);
		gridRecyclerView.setHasFixedSize(true);// set it fixed size
		// Set layout manager, we need grid layout manager here for gridview
		gridRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),
				2));// "2" denotes the no. of spancount i.e. no. of items in a
					// row and setting layout manager is neccessary
	}

	// Populate the listview with data
	private void populatRecyclerView() {

		for (int i = 0; i < getTitle.length; i++) {
			// add the items one by one in arraylist
			gridArrayList.add(new Data_Model(getTitle[i], getLocation[i],
					getYear[i], images[i]));
		}
		adapter = new GridView_Recycler_Adapter(getActivity(), gridArrayList);

		// set adapter over recyclerview
		gridRecyclerView.setAdapter(adapter);
		adapter.notifyDataSetChanged();

	}

	// Random generator method this will generate int nos.
	private int RandomGenerator() {
		Random random = new Random();
		int randomNum = random.nextInt(9);

		return randomNum;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		getActivity().getMenuInflater().inflate(R.menu.main, menu);// Inflate
																	// option
																	// menu

		// Find the id of menu
		MenuItem add = menu.findItem(R.id.add);

		// Implement click listener on menu item
		add.setOnMenuItemClickListener(new OnMenuItemClickListener() {

			@Override
			public boolean onMenuItemClick(MenuItem arg0) {
				int value = RandomGenerator();// Get int value from random
												// generaor method

				// Now add the data to arraylist by random value
				gridArrayList.add(new Data_Model(getTitle[value],
						getLocation[value], getYear[value], images[value]));
				adapter.notifyDataSetChanged();// finally notify adapter
				return false;
			}
		});

		super.onCreateOptionsMenu(menu, inflater);
	}
}
