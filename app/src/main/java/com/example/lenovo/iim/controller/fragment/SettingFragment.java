package com.example.lenovo.iim.controller.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.iim.R;

public class SettingFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View.inflate(getActivity(), R.layout.fragment_setting,null);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
