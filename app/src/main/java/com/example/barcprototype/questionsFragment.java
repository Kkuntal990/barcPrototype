package com.example.barcprototype;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link questionsFragment} interface
 * to handle interaction events.
 * Use the {@link questionsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class questionsFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private Button nextBtn, takeSurveyBtn;

    public questionsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment questionsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static questionsFragment newInstance(String param1, String param2) {
        questionsFragment fragment = new questionsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (container != null) {
            container.removeAllViews();
        }

        View v =  inflater.inflate(R.layout.fragment_questions, container, false);
        nextBtn = (Button) v.findViewById(R.id.toRemote);
        takeSurveyBtn = (Button) v.findViewById(R.id.linkBtn);
        nextBtn.setOnClickListener(this);
        takeSurveyBtn.setOnClickListener(this);


        return v;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.toRemote:
                startActivity(new Intent(getActivity(), Remote.class));
                break;

            case R.id.linkBtn:
              //  Toast.makeText(getContext(), "this is the survey link", Toast.LENGTH_SHORT).show();
                onClickedbtn("https://docs.google.com/forms/d/e/1FAIpQLSfYTw9kfVLkUWzfxq-4Y5skzuL82YUUZ0qZ4SEtHvUNYnXsbg/viewform?usp=sf_link");
                break;
        }
    }

    public void onClickedbtn(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
