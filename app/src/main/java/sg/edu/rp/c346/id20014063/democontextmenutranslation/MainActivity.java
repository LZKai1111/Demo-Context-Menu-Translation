package sg.edu.rp.c346.id20014063.democontextmenutranslation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView translatedtext, translatedbye;
    String wordclicked ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        translatedtext = findViewById(R.id.textViewTranslated);
        translatedbye = findViewById(R.id.textViewTranslated2);
        registerForContextMenu(translatedtext);
        registerForContextMenu(translatedbye);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "English");
        menu.add(0,1,1,"Italian");

        if(v==translatedtext){
            wordclicked = "hello";
        }
        else if( v == translatedbye){
            wordclicked = "bye";
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(wordclicked.equalsIgnoreCase("hello")) {
            if (item.getItemId() == 0) {
                Toast.makeText(MainActivity.this, "English Selected", Toast.LENGTH_LONG).show();
                translatedtext.setText("Hello");
                return true;
            } else if (item.getItemId() == 1) {
                Toast.makeText(MainActivity.this, "Italian Selected", Toast.LENGTH_LONG).show();
                translatedtext.setText("Ciao");
                return true;
            }
        }
        else if(wordclicked.equalsIgnoreCase("bye")){
            if(item.getItemId() == 0){
                translatedbye.setText("Bye");
                return true;
            }
            else if(item.getItemId() == 1) {
                translatedbye.setText("Addio");
            }
        }
        return super.onContextItemSelected(item);
    }
}