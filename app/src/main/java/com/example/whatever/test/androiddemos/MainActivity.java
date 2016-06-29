package com.example.whatever.test.androiddemos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textview = (TextView) findViewById(R.id.txv_filepath);
        try {
            textview.setText(getFilesDir().getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param folderName O nome da pasta local compartilhada
     * @param fileName O nome do arquivo a ser compartilhado
     * @return A uri do arquivo, que pode ser passada para outro app via Intent
     * */
    private Uri getSharedFileUri(String folderName, String fileName){
        File imagePath = new File(getFilesDir(), folderName);
        File newFile = new File(imagePath, fileName);
        Uri contentUri = FileProvider.getUriForFile(this, "br.org.reconcavo.fileprovider", newFile);
        return contentUri;
    }
}
