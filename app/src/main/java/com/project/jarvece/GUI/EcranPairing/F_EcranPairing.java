package com.project.jarvece.GUI.EcranPairing;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import com.project.jarvece.GUI.Accueil.F_Accueil;
import com.project.jarvece.R;
import com.project.jarvece.GUI.Parametre.F_Parametre;
import com.project.jarvece.PARAM.CC_Fragment;

import java.util.ArrayList;
import java.util.Set;

public class F_EcranPairing extends CC_Fragment implements View.OnClickListener {

	ImageButton buttonParametre, buttonBack, buttonSearch;
	ListView listViewDevice;
	ArrayList<String> listDevice = new ArrayList<String>();
	ArrayAdapter<String> arrayAdapterString;
    private BluetoothAdapter BA;
    private Set<BluetoothDevice> pairedDevices;
    ArrayList listDeviceBluetooth = new ArrayList();

	@Override
	public void onCreateView(View convertView) {

        BA = BluetoothAdapter.getDefaultAdapter();

		buttonBack = (ImageButton) convertView.findViewById(R.id.buttonBack);
		buttonBack.setOnClickListener(this);

        buttonSearch = (ImageButton) convertView.findViewById(R.id.buttonSearch);
        buttonSearch.setOnClickListener(this);

		buttonParametre = (ImageButton) convertView.findViewById(R.id.buttonParametre);
		buttonParametre.setOnClickListener(this);

		listViewDevice = (ListView) convertView.findViewById(R.id.listViewBluetooth);
		//For Test, TO DELETE
		listDevice.add("Start research");
		arrayAdapterString = new ArrayAdapter<String>(getActivity(), R.layout.a_textview,R.id.textViewAdapter, listDevice);
		listViewDevice.setAdapter(arrayAdapterString);
	}

	// useless
	@Override
	public void onClick(View view, Integer id) {}

	@Override
	public void refresh() {}

	@Override
	public Integer getLayoutId() {
		return R.layout.f_ecranpairing;
	}

	@Override
	public void onBackPressed() {
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.buttonParametre:
				changeFragment(new F_Parametre());
			break;
			case R.id.buttonBack:
				changeFragment(new F_Accueil());
            case R.id.buttonSearch:
                listDevice.clear();
                listDeviceBluetooth.clear();
                BA = BluetoothAdapter.getDefaultAdapter();
                pairedDevices = BA.getBondedDevices();
                if(pairedDevices.size() != 0)
                {
                    for (BluetoothDevice bt : pairedDevices)
                        listDeviceBluetooth.add(bt.getName());
                    ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.a_textview, R.id.textViewAdapter, listDeviceBluetooth);
                    listViewDevice.setAdapter(adapter);
                }
                else
                {
                    listDevice.add("No device found");
                    arrayAdapterString = new ArrayAdapter<String>(getActivity(), R.layout.a_textview,R.id.textViewAdapter, listDevice);
                    listViewDevice.setAdapter(arrayAdapterString);
                }
		}
	}

}
