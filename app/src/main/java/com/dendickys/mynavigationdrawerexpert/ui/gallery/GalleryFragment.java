package com.dendickys.mynavigationdrawerexpert.ui.gallery;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.dendickys.mynavigationdrawerexpert.R;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    static final String TAG = GalleryFragment.class.getSimpleName();
    public static final String EXTRAS = "extras";

    public GalleryFragment() {
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        /*final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textView = view.findViewById(R.id.text_gallery);
        if (getArguments() != null) {
            String page = getArguments().getString(EXTRAS);
            textView.setText(page);

            Log.e(TAG, "onCreateView: halaman fragment " + page);
        }
    }
}