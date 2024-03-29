package com.example.barcprototype;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link selectShows} interface
 * to handle interaction events.
 * Use the {@link selectShows#newInstance} factory method to
 * create an instance of this fragment.
 */
public class selectShows extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    protected RecyclerView recyclerView;
    protected MyAdapter mAdapter;
    protected RecyclerView.LayoutManager layoutManager;
    protected String[] mDataset;

    public selectShows() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment selectShows.
     */
    // TODO: Rename and change types and number of parameters
    public static selectShows newInstance(String param1, String param2) {
        selectShows fragment = new selectShows();
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
        initDataset();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_select_shows, container,false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.listOfShows);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



        //mAdapter = new MyAdapter(getActivity(), mDataset);

        recyclerView.setAdapter(mAdapter);
       // recyclerView.setItemAnimator(new DefaultItemAnimator());

        return rootView;
    }

    private void initDataset() {
        mDataset = new String[20];
        for (int i = 0; i < 20; i++) {
            mDataset[i] = "This is element #" + i;
        }
    }





    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

}
