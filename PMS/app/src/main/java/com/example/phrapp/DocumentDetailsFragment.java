package com.example.phrapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DocumentDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DocumentDetailsFragment extends Fragment {

    TextView viewdocname,viewdate, viewdecs,viewcategory,viewtag,viewdoctorname;
    ImageView viewImage;
    View view;
    ImageInfo imageInfoObj;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DocumentDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DocumentDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DocumentDetailsFragment newInstance(String param1, String param2) {
        DocumentDetailsFragment fragment = new DocumentDetailsFragment();
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
            imageInfoObj = (ImageInfo) getArguments().getSerializable("imageInfoObj");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_document_details, container, false);
        viewdocname=(TextView)view.findViewById(R.id.viewDocName);
        viewdate=(TextView)view.findViewById(R.id.viewDate);
        viewdecs=(TextView)view.findViewById(R.id.viewDesc);
        viewcategory=(TextView)view.findViewById(R.id.viewCategory);
        viewtag=(TextView)view.findViewById(R.id.viewTag);
        viewdoctorname=(TextView)view.findViewById(R.id.viewDoctorName);
        viewImage = (ImageView)view.findViewById(R.id.viewImage);
        viewdocname.setText(imageInfoObj.getPatientName());
        viewdecs.setText(imageInfoObj.getDescription());
        viewcategory.setText(imageInfoObj.getCategory());
        viewtag.setText(imageInfoObj.getReportType());
        viewdoctorname.setText(imageInfoObj.getDoctorName());
        viewImage.setImageBitmap(imageInfoObj.getImage());
        viewdate.setText(imageInfoObj.getDate().toString());
        return view;
    }
}