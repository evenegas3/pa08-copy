//package com.example.sketcher;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.fragment.app.Fragment;
//
//public class websiteInfoFragment extends Fragment {
//    public Activity containerActivity = null;
//    private View inflatedView = null;
//    private String webTitle = "";
//    private String contentText = "";
//    private String contentString;
//
//    public websiteInfoFragment() { }
//
//    public void setContainerActivity(Activity containerActivity) {
//        this.containerActivity = containerActivity;
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater,
//                             ViewGroup container,
//                             Bundle savedInstanceState) {
//
//        inflatedView = inflater.inflate(R.layout.activity_website_info, container, false);
//
////        webTitle = getArguments().getString("title");
////        String webViewLink = getArguments().getString("webViewLink");
////        contentString = getArguments().getString("content");
////
////
////        TextView title = inflatedView.findViewById(R.id.title_text);
////        title.setText(webTitle);
////
////        TextView contentTv = inflatedView.findViewById(R.id.content);
////        contentTv.setText(contentString);
//
//        return inflatedView;
//    }
//}
