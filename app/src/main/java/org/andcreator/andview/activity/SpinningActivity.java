package org.andcreator.andview.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.andcreator.andview.R;
import org.andcreator.andview.adapter.SpinningAdapter;
import org.andcreator.andview.uilt.SetTheme;
import org.andcreator.andview.view.SpinningView;

public class SpinningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SetTheme.setTheme(this);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR|View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
        setContentView(R.layout.activity_spinning);
        final TextView tv_position = findViewById(R.id.tv_position);
        final SpinningView spinningView = findViewById(R.id.spinningview);
        spinningView.setAdapter(new SpinningAdapter() {
            @Override
            public View onCreateItemView(ViewGroup parent, final int position) {
                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.spinning_item, parent, false);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SpinningActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                    }
                });
                TextView tv_label = (TextView) itemView.findViewById(R.id.tv_label);
                tv_label.setText("" + position);
                return itemView;
            }

            @Override
            public int getItemCount() {
                return 8;
            }
        });
        spinningView.setSize(200);
        spinningView.setOnScrollListener(new SpinningView.OnScrollListener() {
            @Override
            public void onItemChecked(int position) {
                tv_position.setText("当前位置:"+position);
            }
        });
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(180);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                spinningView.setAngdegX(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SeekBar seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        seekBar2.setMax(180);
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                spinningView.setAngdegZ(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SeekBar seekBar3 = (SeekBar) findViewById(R.id.seekBar3);
        seekBar3.setMax(800);
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                spinningView.setDist(400 + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
