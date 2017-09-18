package com.gdev.tes.invert.color;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.content.*;
import android.os.*;
import android.view.*;
/*18/09/2017 created by Hendriyawan @GDEV
*/
public class MainActivity extends AppCompatActivity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //CreateTheme
        ThemeUtils.createTheme(this);
        setContentView(R.layout.main);
        //Toobar
        setupToolbar(R.id.toolbar);
    } 
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
    	getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
    	switch(item.getItemId())
        {
        	case R.id.button_invert_color:
            if(ThemeUtils.isThemeLight(this))
            {
            	ThemeUtils.setTheme(this, false, 1);
                recreateActivity();
            }
            else {
            	ThemeUtils.setTheme(this, true, 0);
                recreateActivity();
            }
        }
        return super.onOptionsItemSelected(item);
    }
    //setupToolbar
    private void setupToolbar(int id)
    {
    	Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Invert Colors");
        getSupportActionBar().setSubtitle("18/09/2017 by Hendriyawan");
    }
    //recreateActivity
    private void recreateActivity()
    {
    	Intent i = getIntent();
        this.finish();
        this.overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        startActivity(i);
    }
}
