package com.deitel.twittersearches;

import android.app.Activity;
import android.app.ListFragment;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.deitel.twittersearches.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link twitterListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class twitterListFragment extends ListFragment {

    private OnFragmentInteractionListener mListener;
    private ArrayAdapter<String> listAdapter;

    public twitterListFragment() {
        // Required empty public constructor
    }

    public twitterListFragment(ArrayAdapter<String> adapter){
        listAdapter = adapter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View myView = inflater.inflate(R.layout.fragment_twitter_list, container, false);

        setListAdapter(listAdapter);
        return myView;
    }

    @Override
    // TODO: Rename method, update argument and hook method into UI event
    public void onListItemClick(ListView l,View v,int position,long id) {

        String tag = ((TextView) v).getText().toString();
        if (mListener != null) {
            mListener.passPositionToWebViewFragment(tag);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getListView().setOnItemLongClickListener(mListener.getOnItemLongClickListener());
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void passPositionToWebViewFragment(String tag);
        public AdapterView.OnItemLongClickListener getOnItemLongClickListener();
    }

}
