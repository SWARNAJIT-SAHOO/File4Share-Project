package com.example.file4share;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class PdfAdapter extends RecyclerView.Adapter<PdfAdapter.PdfViewHolder> {
    private Context context;
    private List<putPdf> list;
    private List<putPdf> filteredList;




    public PdfAdapter(Context context, List<putPdf> list) {
        this.context = context;
        this.list = list;
        this.filteredList = new ArrayList<>(list);
    }



    @NonNull
    @Override
    public PdfViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pdf_item, parent, false);
        return new PdfViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull PdfViewHolder holder, int position) {
        putPdf pdf = list.get(position);
        holder.textView.setText(pdf.getName());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                // Set the data and type of the intent
                // 'pdf.getUri()' should return the Uri of the PDF
                intent.setDataAndType(Uri.parse(pdf.getUrl()), "application/pdf");
                // Add this flag to start a new activity
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                // Use a chooser to let the user select a PDF viewer
                Intent chooser = Intent.createChooser(intent, "Open with");
                // Start the activity
                context.startActivity(chooser);
            }
        });
    }






    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PdfViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        Button button;

        public PdfViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text_view);
            button = itemView.findViewById(R.id.button);
        }
    }
}
