package com.project.jarvece.GUI.Accueil;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.project.jarvece.GUI.EcranPairing.F_EcranPairing;
import com.project.jarvece.R;
import com.project.jarvece.PARAM.CC_Fragment;

public class F_Accueil extends CC_Fragment implements View.OnClickListener {

	@Override
	public void onCreateView(View convertView) {
		Button buttonAccueil;
		buttonAccueil = (Button) convertView.findViewById(R.id.buttonAccueil);
		buttonAccueil.setOnClickListener(this);
		TextView textViewCreate;
		textViewCreate = (TextView) convertView.findViewById(R.id.textViewCreate);
		textViewCreate.setOnClickListener(this);
	}

	@Override
	public void onClick(View view, Integer id) {

	}

	@Override
	public void refresh() {

	}

	@Override
	public Integer getLayoutId() {

		return R.layout.f_accueil;
	}

	@Override
	public void onBackPressed() {

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
			case R.id.buttonAccueil:
				Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
				startActivityForResult(turnOn, 0);
				changeFragment(new F_EcranPairing());
			break;
			case R.id.textViewCreate:
				changeFragment(new F_EcranPairing());
		}
	}


}
