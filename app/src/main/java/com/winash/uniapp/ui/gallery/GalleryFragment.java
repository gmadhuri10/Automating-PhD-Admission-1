//package com.winash.uniapp.ui.gallery;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//import android.widget.SearchView;
//import android.widget.TextView;
//import androidx.annotation.NonNull;
//import androidx.fragment.app.Fragment;
//import androidx.lifecycle.ViewModelProvider;
//
//import com.winash.uniapp.R;
//import com.winash.uniapp.databinding.FragmentGalleryBinding;
//
//public class GalleryFragment extends Fragment {
//
//    ListView listView;
//    String[] name = {"PHD in Computer Science","PHD in Physics","PHD in Mathematics","PHD in Bio Technology","PHD in Economics","PHD in Geography","PHD in physiology","PHD in Zoology","PHD in Chemical Engineering","PHD in Social Science"};
//    ArrayAdapter<String> arrayAdapter;
//
//
//private FragmentGalleryBinding binding;
//
//    public View onCreateView(@NonNull LayoutInflater inflater,
//            ViewGroup container, Bundle savedInstanceState) {
//
//
//    binding = FragmentGalleryBinding.inflate(inflater, container, false);
//    View root = binding.getRoot();
//
//        return root;
//
//        listView = findViewById(R.id.listView);
//        arrayAdapter = new ArrayAdapter<String>(context:this, android.R.layout.simple_list_item_1,name);
//        listView.setAdapter(arrayAdapter);
//
//    }
//
//    @Override
//    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
//        getMenuInflater().inflate(R.menu.searchbar);
//        MenuItem menuItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView)menuItem.getActionView();
//        searchView.setQueryHint("Type here to Search");
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//
//
//                 arrayAdapter.getFilter().filter(newText);
//                return false;
//
//            }
//        });
//
//        super.onCreateOptionsMenu(menu, inflater);
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null;
//    }
//}