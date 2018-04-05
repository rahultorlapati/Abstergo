package com.capstone.rahul.exity10;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DietFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DietFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DietFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public DietFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DietFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DietFragment newInstance(String param1, String param2) {
        DietFragment fragment = new DietFragment();
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


    private ArrayList<DietPlanModel>dietplansList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_diet, container, false);

        dietplansList=new ArrayList<>();

        dietplansList.add(
                new DietPlanModel(
                        "Muscle Builder",
                        "Ideal if you live an active lifestyle and want to gain lean muscle.",
                        R.drawable.rajma));

        dietplansList.add(
                new DietPlanModel(
                        "Vegan",
                        "Ideal if you want to eat foods that do not come from animals.",
                        R.drawable.fruits));
        dietplansList.add(
                new DietPlanModel(
                        "Clean Eating",
                        "Ideal if you are looking to make a healthy change in your eating habits.",
                        R.drawable.clean));
        dietplansList.add(
                new DietPlanModel(
                        "Keto",
                        "Ideal if your Struggle with Weight loss and get hungry easily.",
                        R.drawable.cheesecake));
        dietplansList.add(
                new DietPlanModel(
                        "Diabetic",
                        "Ideal for people suffering from diabetes",
                        R.drawable.daibetuc));
        RecyclerView recyclerView= view.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RecyclerViewAdapter(getActivity(),dietplansList));

        return view;
    }


    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    List<DietPlanModel> dietList;
    Context mCtx;

    RecyclerViewAdapter(Context mCtx,List<DietPlanModel> dietList) {
        this.mCtx=mCtx;
        this.dietList = dietList;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.diet_cardview, parent, false);
        RecyclerViewHolder rvh = new RecyclerViewHolder(v);
        return rvh;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.texthead.setText(dietList.get(position).getTitle());
        holder.textbody.setText(dietList.get(position).getbody());
        holder.imageView.setImageResource(dietList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return dietList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        CardView mCardView;
        TextView texthead, textbody;
        ImageView imageView;

        RecyclerViewHolder(View itemView) {
            super(itemView);

            mCardView = itemView.findViewById(R.id.card_container);
            texthead = itemView.findViewById(R.id.texthead);
            textbody = itemView.findViewById(R.id.textbod);
            imageView = itemView.findViewById(R.id.imageView);
            }
        }

    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            Toast.makeText(context, "Fragment Attached", Toast.LENGTH_SHORT).show();
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
