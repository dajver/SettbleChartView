package com.project.chartview;

import android.os.Bundle;
import android.widget.Toast;

import com.project.chartview.etc.SharedPrefs;
import com.project.chartview.view.BasePieChartView;
import com.project.chartview.view.PreviewPieChartView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.project.chartview.view.PreviewPieChartView.ARC_SIZE;

/**
 * Created by gleb on 5/27/17.
 */

public class PreviewPieChartActivity extends BaseChartViewActivity implements BasePieChartView.IOnClickListener {

    @BindView(R.id.preview)
    PreviewPieChartView previewPieChartView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        ButterKnife.bind(this);

        previewPieChartView.setOnIClickListener(this);
        previewPieChartView.setFirstPieChartSize(SharedPrefs.getPieCharts(this)[0] / ARC_SIZE);
        previewPieChartView.setSecondPieChartSize(SharedPrefs.getPieCharts(this)[1] / ARC_SIZE);
        previewPieChartView.setThirdPieChartSize(SharedPrefs.getPieCharts(this)[2] / ARC_SIZE);
        previewPieChartView.setFourthPieChartSize(SharedPrefs.getPieCharts(this)[3] / ARC_SIZE);
        previewPieChartView.setFifthPieChartSize(SharedPrefs.getPieCharts(this)[4] / ARC_SIZE);
        previewPieChartView.setSixthPieChartSize(SharedPrefs.getPieCharts(this)[5] / ARC_SIZE);
        previewPieChartView.setSeventhPieChartSize(SharedPrefs.getPieCharts(this)[6] / ARC_SIZE);
        previewPieChartView.setEighthPieChartSize(SharedPrefs.getPieCharts(this)[7] / ARC_SIZE);
        previewPieChartView.invalidate();
    }

    @Override
    public void iWasClicked() {
        Toast.makeText(this, getString(R.string.button_i_clicked), Toast.LENGTH_LONG).show();
    }
}
