package com.example.prueba.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.example.prueba.alertdialog.DeleteDialog;
import com.example.prueba.R;
import com.example.prueba.adapters.ResultsAdapter;
import com.example.prueba.utils.FileUtils;

public class ResultsListActivity extends Activity implements OnClickListener{
    private FileUtils fileUtils;
    private ListView listView;
    private Button button;
    public ResultsAdapter resultsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_list);
        fileUtils = new FileUtils(this);
        getView();
        showList();
    }

    private void getView() {
        listView = (ListView) findViewById(R.id.result_list);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(this);
    }

    private void showList() {
        if (null == fileUtils.readFile2JsonArray("SolitarioResults")){
            Toast.makeText(this, "no hay resultados",Toast.LENGTH_SHORT).show();
        }
        else{
            resultsAdapter = new ResultsAdapter(this, fileUtils.readFile2JsonArray("SolitarioResults"));
            listView.setAdapter(resultsAdapter);
        }
    }


    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.button){
            new DeleteDialog().show(getFragmentManager(), "DELETE");
        }
    }
}