package multi.android.material_design_pro.tab;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import multi.android.material_design_pro.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChildFragment extends Fragment {
    String title;
    public ChildFragment() {
        // Required empty public constructor
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_child, container, false);
        TextView child_txt = view.findViewById(R.id.child_txt);
        child_txt.setText(title);
        return view;
    }
}
