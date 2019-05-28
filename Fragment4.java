package com.licona.loginandregister2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Fragment4 extends Fragment {
    private Button btn_login0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg4, container,false);
        btn_login0 = view.findViewById(R.id.btn_login0);
        return view;
    }


    @Override

    public void onActivityCreated(Bundle savedInstanceState) {

        // TODO Auto-generated method stub

        super.onActivityCreated(savedInstanceState);

        btn_login0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivityForResult(intent, 1);
            }
        });


    }
}
