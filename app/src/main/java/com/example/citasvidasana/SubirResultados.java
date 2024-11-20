package com.example.citasvidasana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.example.citasvidasana.databinding.ActivitySubirResultadosBinding;

public class SubirResultados extends DrawerBaseEspecialista {

    private static int REQUEST_CODE_IMAGE_PICK;
    ActivitySubirResultadosBinding activitySubirResultadosBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySubirResultadosBinding = ActivitySubirResultadosBinding.inflate(getLayoutInflater());
        setContentView(activitySubirResultadosBinding.getRoot());
    }

    public void openGallery(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_CODE_IMAGE_PICK);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE_IMAGE_PICK) {
            Uri imageUri = data.getData();
            String imagePath = getImagePath(imageUri);
            insertImageToDatabase(imagePath);
        }
    }

    private String getImagePath(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String imagePath = cursor.getString(column_index);
        cursor.close();
        return imagePath;
    }

    private void insertImageToDatabase(String imagePath) {
        AdminSQLOpenHelper admin = new AdminSQLOpenHelper(this, "basedatos", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ruta", imagePath);
        bd.insert("resultados", null, values);
        bd.close();
    }
    /*public void archivo(View view){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 1);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            // Aquí puedes guardar la ruta de la imagen en la base de datos SQLite
            AdminSQLOpenHelper admin = new AdminSQLOpenHelper(this, "basedatos", null, 1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("ruta", picturePath);
            bd.insert("resultados", null, values);
            bd.close();
        }
    }*/
}