package com.example.listadapterdemo;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

	private ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Toast.makeText(this, adapter.getItem(position).toString(), Toast.LENGTH_SHORT).show();
		super.onListItemClick(l, v, position, id);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		String[] game = getResources().getStringArray(R.array.game);
		String[] language = getResources().getStringArray(R.array.language);
		if (id == R.id.list1)
			adapter = new ArrayAdapter<String>(this, R.layout.activity_main, game);
		if (id == R.id.list2)
			adapter = new ArrayAdapter<String>(this, R.layout.activity_main, language);
		setListAdapter(adapter);
		return super.onOptionsItemSelected(item);
	}
}
