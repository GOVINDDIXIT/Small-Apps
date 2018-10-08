package com.chatapp.govind.fragmentsrevision;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentCall extends Fragment {

    View v;

    public FragmentCall(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v =inflater.inflate(R.layout.call_fragment,container,false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }


}
