package com.project.jarvece.GUI.Parametre;

import android.view.View;
import android.widget.Button;

import com.project.jarvece.GUI.EcranPairing.F_EcranPairing;
import com.project.jarvece.R;
import com.project.jarvece.GUI.Accueil.F_Accueil;
import com.project.jarvece.PARAM.CC_Fragment;

public class F_Parametre extends CC_Fragment implements View.OnClickListener {

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.buttonRetourP:
				changeFragment(new F_EcranPairing());
			break;

			case R.id.buttonOui:
				changeFragment(new F_Accueil());
			break;

		}

	}

	@Override
	public void onCreateView(View convertView) {
		Button buttonRetour;
		buttonRetour = (Button) convertView.findViewById(R.id.buttonRetourP);
		buttonRetour.setOnClickListener(this);
		Button ButtonOui;
		ButtonOui = (Button) convertView.findViewById(R.id.buttonOui);
		ButtonOui.setOnClickListener(this);

	}

	// useless
	@Override
	public void onClick(View view, Integer id) {}

	@Override
	public void refresh() {

	}

	@Override
	public Integer getLayoutId() {
		return R.layout.f_parametre;
	}

	@Override
	public void onBackPressed() {
	//	changeFragment(new F_EcranPairing());
	}

}
