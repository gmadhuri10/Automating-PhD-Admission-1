package com.winash.uniapp.ui.mycourse;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.winash.uniapp.databinding.FragmentMycourseBinding;

public class MycourseFragment extends Fragment {
    private FragmentMycourseBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentMycourseBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;

    }
}
