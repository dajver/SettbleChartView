package com.project.chartview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.project.chartview.etc.SharedPrefs;
import com.project.chartview.view.BasePieChartView;
import com.project.chartview.view.PieChartView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.project.chartview.view.PreviewPieChartView.ARC_SIZE;

public class SetupPieChartActivity extends BaseChartViewActivity implements SeekBar.OnSeekBarChangeListener,
        View.OnClickListener, BasePieChartView.IOnClickListener {

    @BindView(R.id.firstSeekBar)
    SeekBar firstSeekBar;
    @BindView(R.id.secondSeekBar)
    SeekBar secondSeekBar;
    @BindView(R.id.thirdSeekBar)
    SeekBar thirdSeekBar;
    @BindView(R.id.forthSeekBar)
    SeekBar forthSeekBar;
    @BindView(R.id.fifthSeekBar)
    SeekBar fifthSeekBar;
    @BindView(R.id.sixthSeekBar)
    SeekBar sixthSeekBar;
    @BindView(R.id.seventhSeekBar)
    SeekBar seventhSeekBar;
    @BindView(R.id.eighthSeekBar)
    SeekBar eighthSeekBar;

    @BindView(R.id.firstPercent)
    TextView firstPercent;
    @BindView(R.id.secondPercent)
    TextView secondPercent;
    @BindView(R.id.thirdPercent)
    TextView thirdPercent;
    @BindView(R.id.forthPercent)
    TextView forthPercent;
    @BindView(R.id.fifthPercent)
    TextView fifthPercent;
    @BindView(R.id.sixthPercent)
    TextView sixthPercent;
    @BindView(R.id.seventhPercent)
    TextView seventhPercent;
    @BindView(R.id.eighthPercent)
    TextView eighthPercent;

    @BindView(R.id.round)
    PieChartView pieChartView;

    @BindView(R.id.button)
    Button readyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        firstSeekBar.setOnSeekBarChangeListener(this);
        secondSeekBar.setOnSeekBarChangeListener(this);
        thirdSeekBar.setOnSeekBarChangeListener(this);
        forthSeekBar.setOnSeekBarChangeListener(this);
        fifthSeekBar.setOnSeekBarChangeListener(this);
        sixthSeekBar.setOnSeekBarChangeListener(this);
        seventhSeekBar.setOnSeekBarChangeListener(this);
        eighthSeekBar.setOnSeekBarChangeListener(this);
        readyButton.setOnClickListener(this);
        pieChartView.setOnIClickListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        switch (seekBar.getId()) {
            case R.id.firstSeekBar:
                pieChartView.setFirstPieChartSize(progress / ARC_SIZE);
                firstPercent.setText(String.valueOf(progress));
                break;
            case R.id.secondSeekBar:
                pieChartView.setSecondPieChartSize(progress / ARC_SIZE);
                secondPercent.setText(String.valueOf(progress));
                break;
            case R.id.thirdSeekBar:
                pieChartView.setThirdPieChartSize(progress / ARC_SIZE);
                thirdPercent.setText(String.valueOf(progress));
                break;
            case R.id.forthSeekBar:
                pieChartView.setFourthPieChartSize(progress / ARC_SIZE);
                forthPercent.setText(String.valueOf(progress));
                break;
            case R.id.fifthSeekBar:
                pieChartView.setFifthPieChartSize(progress / ARC_SIZE);
                fifthPercent.setText(String.valueOf(progress));
                break;
            case R.id.sixthSeekBar:
                pieChartView.setSixthPieChartSize(progress / ARC_SIZE);
                sixthPercent.setText(String.valueOf(progress));
                break;
            case R.id.seventhSeekBar:
                pieChartView.setSeventhPieChartSize(progress / ARC_SIZE);
                seventhPercent.setText(String.valueOf(progress));
                break;
            case R.id.eighthSeekBar:
                pieChartView.setEighthPieChartSize(progress / ARC_SIZE);
                eighthPercent.setText(String.valueOf(progress));
                break;
        }
        pieChartView.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) { }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) { }

    @Override
    public void onClick(View view) {
        int[] charts = new int[8];
        charts[0] = firstSeekBar.getProgress();
        charts[1] = secondSeekBar.getProgress();
        charts[2] = thirdSeekBar.getProgress();
        charts[3] = forthSeekBar.getProgress();
        charts[4] = fifthSeekBar.getProgress();
        charts[5] = sixthSeekBar.getProgress();
        charts[6] = seventhSeekBar.getProgress();
        charts[7] = eighthSeekBar.getProgress();
        SharedPrefs.setPieCharts(getApplicationContext(), charts);

        startActivity(new Intent(this, PreviewPieChartActivity.class));
    }

    @Override
    public void iWasClicked() {
        Toast.makeText(this, getString(R.string.button_i_clicked), Toast.LENGTH_LONG).show();
    }
}
